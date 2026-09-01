package datos;

import java.time.LocalDate;

public class Cajero extends Staff{
	String turnoDeTrabajo;
	
	public Cajero() {}
	
	public Cajero(String turnoDeTrabajo) {
		this.turnoDeTrabajo = turnoDeTrabajo;
	}
	
	public Cajero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso, int antiguedad, double sueldoBase, UnidadDeVenta unidadDeVenta, String turnoDeTrabajo) {
	super(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, antiguedad, sueldoBase, unidadDeVenta);
	this.turnoDeTrabajo = turnoDeTrabajo;
}

	public String getTurnoDeTrabajo() {
		return turnoDeTrabajo;
	}

	public void setTurnoDeTrabajo(String turnoDeTrabajo) {
		this.turnoDeTrabajo = turnoDeTrabajo;
	}

	@Override
	public String toString() {
		return "Cajero {"+ super.toString() +
				"turnoDeTrabajo=" + turnoDeTrabajo + 
				'}';
	}
	
	
}
