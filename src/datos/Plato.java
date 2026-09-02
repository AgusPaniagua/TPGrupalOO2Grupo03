package datos;

import java.util.List;

public class Plato {

	private long idPlato;
	private String nombre;
	private double precio;
	private double costoDeProduccion;
	private List<Pedido> pedidos;

	// siempre hay que implementar el constructor vacío
	public Plato() {} 


	// no va el id en el constructor por ser autoincrementable
	public Plato(String nombre, double precio, double costoDeProduccion, List<Pedido> pedidos) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costoDeProduccion = costoDeProduccion;
		this.pedidos = pedidos;
	}


	public long getIdPlato() {
		return idPlato;
	}

	// siempre va protected, para que no sea modificado
	protected void setIdPlato(long idCliente) {
		this.idPlato = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCostoDeProduccion() {
		return costoDeProduccion;
	}

	public void setCostoDeProduccion(double costoDeProduccion) {
		this.costoDeProduccion = costoDeProduccion;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costoDeProduccion="
				+ costoDeProduccion + ", pedidos=" + pedidos + "]";
	}

}




