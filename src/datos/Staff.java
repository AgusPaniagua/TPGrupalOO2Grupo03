package datos;

import java.time.LocalDate;

public abstract class Staff {
	protected long idStaff;
	private String nombre;
	private String apellido;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaDeIngreso;
	private int antiguedad;
	private double sueldoBase;
	private UnidadDeVenta unidadDeVenta;
	
	public Staff(){}
	
	public Staff(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso, int antiguedad, double sueldoBase, UnidadDeVenta unidadDeVenta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeIngreso = fechaDeIngreso;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.unidadDeVenta = unidadDeVenta;
	}

	public long getIdStaff() {
		return idStaff;
	}

	protected void setIdStaff(long idStaff) {
		this.idStaff = idStaff;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}
	
	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	@Override
	public String toString() {
		return "Staff{" + 
				"idStaff=" + idStaff + 
				", nombre=" + nombre + 
				", apellido=" + apellido + 
				", dni=" + dni + 
				", fechaDeNacimiento=" + fechaDeNacimiento + 
				", fechaDeIngreso=" + fechaDeIngreso + 
				", antiguedad=" + antiguedad + 
				", sueldoBase=" + sueldoBase + 
				'}';
	}
	
	
	
	
	
}
