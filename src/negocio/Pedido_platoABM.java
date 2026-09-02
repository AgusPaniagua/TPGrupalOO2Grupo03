package negocio;

import dao.Pedido_platoDao;
import datos.Pedido_plato;
import datos.Pedido;
import datos.Plato;

public class Pedido_platoABM {
    Pedido_platoDao dao = new Pedido_platoDao();

    public Pedido_plato traer(long idPedido_plato) {
        return dao.traer(idPedido_plato);
    }

    public int agregar(Pedido pedido, Plato plato, double subTotal) {
        Pedido_plato pp = new Pedido_plato(pedido, plato, subTotal);
        return dao.agregar(pp);
    }

    public void modificar(Pedido_plato pp) {
        dao.actualizar(pp);
    }

    public void eliminar(long idPedido_plato) {
        Pedido_plato pp = dao.traer(idPedido_plato);
        dao.eliminar(pp);
    }
}