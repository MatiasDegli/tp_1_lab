package Prototype;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        Auto auto1 = new Auto(1, "Azul", "Bm 2.0", 4,"Manual",4);
       
        Auto[] autos= new Auto[10000];

        
        Random rnd = new Random();
        int anioActual = java.time.Year.now().getValue();

        for (int i = 0; i < 10000; i++) {
            autos[i] = auto1.clonar();
            autos[i].setModelo(1995 + rnd.nextInt(30));          // 1995–2024
            autos[i].setCantidadPasajeros(2 + rnd.nextInt(5));   // 2–6
        }
        //Debera devolver 50005000 el paralelismo.

        
    }
}
