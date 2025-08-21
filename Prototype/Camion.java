package Prototype;
public class Camion extends Vehiculo {

    public int capacidadCarga;

    public Camion(int mo, String co, String mot, int r, int cap) {
        super(mo, co, mot, r);
        capacidadCarga = cap;
    }
    
    public Camion(Camion target) {
        super(target);
        if(target != null) {
            this.capacidadCarga = target.capacidadCarga;
        }
    }
    
    @Override
    public Camion clonar() {
        return new Camion(this);
    }
    
    public boolean equals(Object obj) {
        if(!(obj instanceof Camion)) {
            return false;
        }
        Camion camion = (Camion) obj;
        return super.equals(camion) &&
               this.capacidadCarga == camion.capacidadCarga;
    }
}