package negocio;

import dao.PlatoDao;
import datos.Plato;
import java.util.List;

public class PlatoABM {
    PlatoDao dao = new PlatoDao();

    public Plato traer(long idPlato) {
        return dao.traer(idPlato);
    }

    public int agregar(String nombre, double precio, double costoDeProduccion, List<datos.Pedido> pedidos) {
        Plato p = new Plato(nombre, precio, costoDeProduccion, pedidos);
        return dao.agregar(p);
    }

    public void modificar(Plato p) {
        dao.actualizar(p);
    }

    public void eliminar(long idPlato) {
        Plato p = dao.traer(idPlato);
        dao.eliminar(p);
    }
}