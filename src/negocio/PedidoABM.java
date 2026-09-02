package negocio;

import dao.PedidoDao;
import datos.Pedido;
import datos.UnidadDeVenta;
import datos.Pedido_plato;
import java.time.LocalDate;
import java.util.Set;

public class PedidoABM {
    PedidoDao dao = new PedidoDao();

    public Pedido traer(long idPedido) {
        return dao.traer(idPedido);
    }

    public int agregar(LocalDate fechaDeTransaccion, UnidadDeVenta unidadDeVenta, Set<Pedido_plato> pedidosPlato) {
        Pedido p = new Pedido(fechaDeTransaccion, unidadDeVenta, pedidosPlato);
        return dao.agregar(p);
    }

    public void modificar(Pedido p) {
        dao.actualizar(p);
    }

    public void eliminar(long idPedido) {
        Pedido p = dao.traer(idPedido);
        dao.eliminar(p);
    }
}