package negocio;

import dao.CostoDao;
import datos.Costo;
import datos.Festival;



public class CostoABM {
	CostoDao dao = new CostoDao();

	public Costo traer(long idCosto) {
		Costo c = dao.traer(idCosto);
		return c;
	}
	
	public int agregar(double porSuperficie,double porMontaje,boolean plusPorElectricidad,double sueldoBase,Festival festival) {
		
		Costo c = new Costo(porSuperficie , porMontaje,plusPorElectricidad,sueldoBase,festival);
		return dao.agregar(c);
	}

	public void modificar(Costo c) {
		dao.actualizar(c);
	}

	public void eliminar(long idCosto) {
		Costo c = dao.traer(idCosto);
		dao.eliminar(c);
	}
}
