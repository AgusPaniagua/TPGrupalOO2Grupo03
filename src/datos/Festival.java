package datos;

import java.time.LocalDate;

public class Festival {
	private long idFestival;
	private String nombre;
	private LocalDate temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costo;
	

	public Festival(){}

	public Festival( String nombre, LocalDate temporada,LocalDate fechaInicio,LocalDate fechaFin,Costo costo) {
		super();
		
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo= costo;
	}

	public long getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(long idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getTemporada() {
		return temporada;
	}

	public void setTemporada(LocalDate temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + "]";
	}

	
	
}