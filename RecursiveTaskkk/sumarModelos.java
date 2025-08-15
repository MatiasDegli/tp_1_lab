package RecursiveTaskkk;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import Prototype.Vehiculo;


public class sumarModelos extends RecursiveTask <Integer> {
    private List<Vehiculo> lista;
    private int inicio;
    private int fin;
    private static final int UMBRAL = 500;

    public sumarModelos(List<Vehiculo> lista, int inicio, int fin) {
        this.lista = lista;
        this.inicio = inicio;
        this.fin = fin;
    }
    private Integer calcularSuma() {
        int suma = 0;
        for (int i = inicio; i < fin; i++) {
            // Ejemplo: sumar longitud del modelo
            suma += lista.get(i).getModelo();
        }
        return suma;
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
