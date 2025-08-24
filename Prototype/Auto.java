package Prototype;
public class Auto extends Vehiculo {

    public String tipoCaja;
    
    
    public Auto(int mo, String co, String mot, int r, String tc,int cp) {
        super(mo, co, mot, r, cp);
        tipoCaja=tc;
        
    }

    public Auto(Auto target) {
        super(target);
        if(target != null) {
            this.tipoCaja = target.tipoCaja;
            
        }
    }
    
    @Override
    public Auto clonar() {
        return new Auto(this);
    }
    

    public boolean equals(Object obj) {
        if(!(obj instanceof Auto)) {
            return false;
        }
        Auto auto = (Auto) obj;
        return super.equals(auto) &&
               this.tipoCaja.equals(auto.tipoCaja) &&
               this.cantidadPasajeros == auto.cantidadPasajeros;
    }
}
