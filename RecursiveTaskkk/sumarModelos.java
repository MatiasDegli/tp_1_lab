package RecursiveTaskkk;

import Prototype.Vehiculo;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class sumarModelos extends RecursiveTask <Integer> {
    private List<Vehiculo> lista;
    private int inicio;
    private int fin;
    private static final int UMBRAL = 5;

    public sumarModelos(List<Vehiculo> lista, int inicio, int fin) {
        this.lista = lista;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    private Integer calcularSuma() {
        int suma = 0;
        final int anioActual = java.time.Year.now().getValue(); // independiente de la clase de test
    
        for (int i = inicio; i < fin; i++) {
            Vehiculo v = lista.get(i);
    
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
            suma += aporte;
        }
    
        return Math.round(suma); // la tarea devuelve Integer
    }

    @Override
    protected Integer compute() {
        if ((fin - inicio) <= UMBRAL) {
            return calcularSuma(); // 🔹 Acá entra el método que suma
        } else {
            int medio = (inicio + fin) / 2;
            sumarModelos izquierda = new sumarModelos(lista, inicio, medio);
            sumarModelos derecha = new sumarModelos(lista, medio, fin);
            izquierda.fork();
            int sumaDerecha = derecha.compute();
            int sumaIzquierda = izquierda.join();
            return sumaIzquierda + sumaDerecha;
        }
    }
}
