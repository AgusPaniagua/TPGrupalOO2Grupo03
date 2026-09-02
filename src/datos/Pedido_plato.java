
package datos;

public class Pedido_plato {
   
	private long idPedido_plato;    
	private Pedido pedido;
    private Plato plato;
    private double subTotal;

   
	public Pedido_plato() {}
	
	
	public Pedido_plato(Pedido pedido, Plato plato, double subTotal) {
		super();
		this.pedido = pedido;
		this.plato = plato;
		this.subTotal = subTotal;
	}
	
	public long getIdPedido_plato() {
		return idPedido_plato;
	}
	
	public void setIdPedido_plato(long idPedido_plato) {
		this.idPedido_plato = idPedido_plato;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Plato getPlato() {
		return plato;
	}
	
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
    @Override
	public String toString() {
		return "Pedido_plato [idPedido_plato=" + idPedido_plato + ", pedido=" + pedido + ", plato=" + plato
				+ ", subTotal=" + subTotal + "]";
	}
    
}