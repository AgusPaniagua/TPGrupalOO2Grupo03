package datos;
import java.util.Set;
public abstract class UnidadDeVenta {
    protected long idUnidadDeVenta;
    private String nombreComercial;
    private Staff responsableACargo;
    private double superficie;
    private String codigoUnico;
    private Festival festival;
    private Set<Plato> platosOfrecidos;
    private Set<Staff> personalACargo;

    public UnidadDeVenta(){}

    public UnidadDeVenta(String nombreComercial, Staff responsableACargo, double superficie, String codigoUnico, Festival festival, Set<Plato> platosOfrecidos, Set<Staff> personalACargo) {
        this.nombreComercial = nombreComercial;
        this.responsableACargo = responsableACargo;
        this.superficie = superficie;
        this.codigoUnico = codigoUnico;
        this.festival = festival;
        this.platosOfrecidos = platosOfrecidos;
        this.personalACargo = personalACargo;
    }

    public long getIdUnidadDeVenta() {
        return idUnidadDeVenta;
    }

    protected void setIdUnidadDeVenta(long idUnidadDeVenta) {
        this.idUnidadDeVenta = idUnidadDeVenta;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public Staff getResponsableACargo() {
        return responsableACargo;
    }

    public void setResponsableACargo(Staff responsableACargo) {
        this.responsableACargo = responsableACargo;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Set<Plato> getPlatosOfrecidos() {
        return platosOfrecidos;
    }

    public void setPlatosOfrecidos(Set<Plato> platosOfrecidos) {
        this.platosOfrecidos = platosOfrecidos;
    }

    public Set<Staff> getPersonalACargo() {
        return personalACargo;
    }

    public void setPersonalACargo(Set<Staff> personalACargo) {
        this.personalACargo = personalACargo;
    }

    @Override
    public String toString() {
        return "UnidadDeVenta{" +
                "idUnidadDeVenta=" + idUnidadDeVenta +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", responsableACargo=" + responsableACargo +
                ", superficie=" + superficie +
                ", codigoUnico='" + codigoUnico + '\'' +
                ", festival=" + festival +
                ", platosOfrecidos=" + platosOfrecidos +
                ", personalACargo=" + personalACargo +
                '}';
    }
}
