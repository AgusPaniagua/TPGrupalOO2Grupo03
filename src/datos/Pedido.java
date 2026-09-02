package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {
	
	private long idPedido;
	private LocalDate fechaDeTransaccion;
	private UnidadDeVenta unidadDeVenta; 
	private Set<Pedido_plato> pedidosPlato;
	
	public Pedido() {}
	
	public Pedido(LocalDate fechaDeTransaccion, UnidadDeVenta unidadDeVenta, Set<Pedido_plato> pedidosPlato) {
		super();
		this.fechaDeTransaccion = fechaDeTransaccion;
		this.unidadDeVenta = unidadDeVenta;
		this.pedidosPlato = pedidosPlato;
	}
	
	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaDeTransaccion() {
		return fechaDeTransaccion;
	}

	public void setFechaDeTransaccion(LocalDate fechaDeTransaccion) {
		this.fechaDeTransaccion = fechaDeTransaccion;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	public Set<Pedido_plato> getPedidosPlato() {
		return pedidosPlato;
	}

	public void setPedidosPlato(Set<Pedido_plato> pedidosPlato) {
		this.pedidosPlato = pedidosPlato;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaDeTransaccion=" + fechaDeTransaccion + ", unidadDeVenta="
				+ unidadDeVenta + "]";
	}

	
	
	
	
	
}


