package datos;

import java.util.Set;

public class FoodTruck extends UnidadDeVenta{
    private String patente;
    private boolean conexionElectrica;

    public FoodTruck(){}

    public FoodTruck(String nombreComercial, Staff responsableACargo, double superficie, String codigoUnico, Festival festival, Set<Plato> platosOfrecidos, Set<Staff> personalACargo, String patente, boolean conexionElectrica) {
        super(nombreComercial, responsableACargo, superficie, codigoUnico, festival, platosOfrecidos, personalACargo);
        this.patente = patente;
        this.conexionElectrica = conexionElectrica;
    }


    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isConexionElectrica() {
        return conexionElectrica;
    }

    public void setConexionElectrica(boolean conexionElectrica) {
        this.conexionElectrica = conexionElectrica;
    }

    @Override
    public String toString() {
        return "FoodTruck{" + super.toString() +
                ", patente='" + patente + '\'' +
                ", conexionElectrica=" + conexionElectrica +
                '}';
    }
}
