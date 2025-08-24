package RecursiveTaskkk;

import Prototype.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class TestSumarModelos {

    public static void main(String[] args) {
        // 1) Prototype: creo un Auto “plantilla” y luego clono para poblar la flota

        int N = 10000;  // tamaño de la flota
        List<Vehiculo> flota = new ArrayList<>(N);

        Auto prototipo = new Auto(1, "Azul", "Bm 2.0", 4,"Manual",5);

       
        Auto[] autos= new Auto[10001];
         
        Random rnd = new Random();
        int anioActual = java.time.Year.now().getValue();


        for(int i=0; i<=N; i++){
            autos[i] = prototipo.clonar();
            autos[i].setModelo(1995 + rnd.nextInt(30));          // 1995–2024
            autos[i].setCantidadPasajeros(2 + rnd.nextInt(5));   // 2–6
            flota.add(autos[i]);
        }

        // 2) Ejecutar en paralelo con Fork/Join
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int totalParalelo = pool.invoke(new sumarModelos(flota, 0, flota.size()));

        // 3) Verificación: suma secuencial (mismo criterio que calcularSuma)

        int totalSecuencial = 0;
            for (int i = 0; i <= N; i++) {
                Vehiculo v = flota.get(i);
        
                // Penalización por antigüedad (tope 60%)
                int modelo = v.getModelo(); // año del vehículo
                int edad = Math.max(0, anioActual - modelo);
                int penalEdad = 100 - Math.min(60, 6 * edad);
        
                // Factor por cantidad de pasajeros
                int pasajeros = v.getCantidadPasajeros();
                int factorPasajeros =
                        (pasajeros <= 2) ? 80 :
                        (pasajeros <= 4) ? 100 : 120;
        
                // Aporte final (base simple = 10)
                int aporte = 10 * penalEdad * factorPasajeros;
            totalSecuencial += aporte;
        }

        // 4) Resultados
        System.out.println("Resultado Fork/Join: " + totalParalelo);
        System.out.println("Resultado Secuencial: " + totalSecuencial);

        if (totalParalelo == totalSecuencial) {
            System.out.println("✅ Coinciden los resultados.");
        } else {
            System.out.println("❌ No coinciden: revisar la regla de suma o el rango.");
        }
    }
}
