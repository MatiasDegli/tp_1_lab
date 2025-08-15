package RecursiveTaskkk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import Prototype.*;

public class TestSumarModelos {

    public static void main(String[] args) {
        // 1) Prototype: creo un Auto “plantilla” y luego clono para poblar la flota

        int N = 10000;  // tamaño de la flota
        List<Vehiculo> flota = new ArrayList<>(N);

        Auto prototipo = new Auto(1, "Azul", "Bm 2.0", 4,"Manual",4);

       
        Auto[] autos= new Auto[10001];

        for(int i=0; i<=N; i++){
            autos[i] = prototipo.clonar();
            autos[i].setModelo(i);
            flota.add(autos[i]);
        }
        // 2) Ejecutar en paralelo con Fork/Join
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int totalParalelo = pool.invoke(new sumarModelos(flota, 0, flota.size()));

        // 3) Verificación: suma secuencial (mismo criterio que calcularSuma)

        int totalSecuencial = 0;
        for (Vehiculo v : flota) {
            // Debe usar la MISMA “regla de valor” que tu calcularSuma()
            totalSecuencial += v.getModelo();
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
