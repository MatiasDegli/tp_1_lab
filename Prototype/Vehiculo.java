package Prototype;
public abstract class Vehiculo {
    
    public String modelo;
    public String color;
    public String motor;
    public int cantidadRuedas;

    public Vehiculo(String mo, String co, String mot, int r) {
        modelo=mo;
        color=co;
        motor=mot;
        cantidadRuedas=r;
    }

    public Vehiculo(Vehiculo target) {
        if(target != null) {
            this.modelo = target.modelo;
            this.color = target.color;
            this.motor = target.motor;
            this.cantidadRuedas = target.cantidadRuedas;
        }
    }
    
    public int verRuedas(){
        return cantidadRuedas;
    }
    public abstract Vehiculo clonar();

    public boolean equals(Object obj) {
        if(!(obj instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) obj;
        return this.modelo.equals(vehiculo.modelo) &&
               this.color.equals(vehiculo.color) &&
               this.motor.equals(vehiculo.motor) &&
               this.cantidadRuedas == vehiculo.cantidadRuedas;
    }
}