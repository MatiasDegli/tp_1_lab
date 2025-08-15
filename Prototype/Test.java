package Prototype;
public class Test {
    public static void main(String[] args){
        Auto auto1 = new Auto("Ford", "Azul", "Bm 2.0", 4,"Manual",4);
        System.out.println();
        System.out.println(auto1.verRuedas());
        Auto auto2 = auto1.clonar();
        System.out.println(auto2.verRuedas());
    }
}
