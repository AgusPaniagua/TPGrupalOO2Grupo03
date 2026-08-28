package datos;

import java.util.Set;

public class PuestoDesarmable extends UnidadDeVenta{
    private int cantidadDeCarpas;
    private int tiempo;

    public PuestoDesarmable(){}

    public PuestoDesarmable(String nombreComercial, Staff responsableACargo, double superficie, String codigoUnico, Festival festival, Set<Plato> platosOfrecidos, Set<Staff> personalACargo, int cantidadDeCarpas, int tiempo) {
        super(nombreComercial, responsableACargo, superficie, codigoUnico, festival, platosOfrecidos, personalACargo);
        this.cantidadDeCarpas = cantidadDeCarpas;
        this.tiempo = tiempo;
    }

    public int getCantidadDeCarpas() {
        return cantidadDeCarpas;
    }

    public void setCantidadDeCarpas(int cantidadDeCarpas) {
        this.cantidadDeCarpas = cantidadDeCarpas;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "PuestoDesarmable{" + super.toString() +
                ", cantidadDeCarpas=" + cantidadDeCarpas +
                ", tiempo=" + tiempo +
                '}';
    }
}
