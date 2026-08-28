package datos;

public class Costo {
	private long idCosto;
	private double porSuperficie;
	private double porMontaje;
	private boolean plusPorElectricidad;
	private double sueldoBase;
	private Festival festival;
		
	public Costo(){}
	
	public Costo(double porSuperficie,double porMontaje,boolean plusPorElectricidad,double sueldoBase,Festival festival ) {
		this.porSuperficie=porSuperficie;
		this.porMontaje=porMontaje;
		this.plusPorElectricidad=plusPorElectricidad;
		this.sueldoBase=sueldoBase;
		this.festival=festival;
		
	}

	public long getIdCosto() {
		return idCosto;
	}

	public void setIdCosto(long idCosto) {
		this.idCosto = idCosto;
	}

	public double getPorSuperficie() {
		return porSuperficie;
	}

	public void setPorSuperficie(double porSuperficie) {
		this.porSuperficie = porSuperficie;
	}

	public double getPorMontaje() {
		return porMontaje;
	}

	public void setPorMontaje(double porMontaje) {
		this.porMontaje = porMontaje;
	}

	public boolean isPlusPorElectricidad() {
		return plusPorElectricidad;
	}

	public void setPlusPorElectricidad(boolean plusPorElectricidad) {
		this.plusPorElectricidad = plusPorElectricidad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "Costo [idCosto=" + idCosto + ", porSuperficie=" + porSuperficie + ", porMontaje=" + porMontaje
				+ ", plusPorElectricidad=" + plusPorElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}
	
	
	
}