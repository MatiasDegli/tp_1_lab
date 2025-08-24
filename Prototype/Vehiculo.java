package Prototype;
public abstract class Vehiculo {
    
    public int modelo;
    public String color;
    public String motor;
    public int cantidadRuedas;
    public int cantidadPasajeros;

    public Vehiculo(int mo, String co, String mot, int r, int cp) {
        modelo=mo;
        color=co;
        motor=mot;
        cantidadRuedas=r;
        cantidadPasajeros=cp;
    }

    public Vehiculo(Vehiculo target) {
        if(target != null) {
            this.modelo = target.modelo;
            this.color = target.color;
            this.motor = target.motor;
            this.cantidadRuedas = target.cantidadRuedas;
            this.cantidadPasajeros = target.cantidadPasajeros;
        }
    }
    
    public void setCantidadPasajeros(int cant){
        cantidadPasajeros=cant;
    }
    public int getCantidadPasajeros(){
        return cantidadPasajeros;
    }
    public int getCantidadRuedas(){
        return cantidadRuedas;
    }
    public void setModelo(int m){
        modelo=m;
    }
    public int getModelo(){
        return modelo;
    }
    public abstract Vehiculo clonar();

    public boolean equals(Object obj) {
        if(!(obj instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) obj;
        return this.modelo == vehiculo.modelo &&
               this.color.equals(vehiculo.color) &&
               this.motor.equals(vehiculo.motor) &&
               this.cantidadRuedas == vehiculo.cantidadRuedas;
    }
}