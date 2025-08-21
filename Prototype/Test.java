package Prototype;
public class Test {
    public static void main(String[] args){
        Auto auto1 = new Auto(1, "Azul", "Bm 2.0", 4,"Manual",4);
        System.out.println();
        System.out.println(auto1.verRuedas());
       
        Auto[] autos= new Auto[10000];

        for(int i=0; i<10000; i++){
            autos[i] = auto1.clonar();
            autos[i].setModelo(i);
        }
        //Debera devolver 50005000 el paralelismo.

        //Explicar porque es util clonar autos
        //Dar mas contexto de uso
    }
}
