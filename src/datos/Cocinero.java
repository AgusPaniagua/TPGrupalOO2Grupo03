package datos;

import java.time.LocalDate;

public class Cocinero extends Staff{
	String especialidad;
	int plusFijo;
	
	public Cocinero(){}
	
	public Cocinero(String especialidad, int plusFijo) {
		this.especialidad = especialidad;
		this.plusFijo = plusFijo;
	}
	
	public Cocinero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso, int antiguedad, double sueldoBase, UnidadDeVenta unidadDeVenta, String especialidad, int plusFijo) {
		super(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, antiguedad, sueldoBase, unidadDeVenta);
		this.especialidad = especialidad;
		this.plusFijo = plusFijo;
}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getPlusFijo() {
		return plusFijo;
	}

	public void setPlusFijo(int plusFijo) {
		this.plusFijo = plusFijo;
	}

	@Override
	public String toString() {
		return "Cocinero {"+ super.toString() +
				"especialidad=" + especialidad + 
				", plusFijo=" + plusFijo + 
				'}';
		
	}
	
	
	
}
