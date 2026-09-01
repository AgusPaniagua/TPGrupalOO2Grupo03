package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Costo;
import datos.Festival;


public class FestivalABM {
	
	FestivalDao dao = new FestivalDao();

	public Festival traer(long idFestival) {
		Festival f = dao.traer(idFestival);
		return f;
	}

	public int agregar( String nombre, LocalDate temporada,LocalDate fechaInicio,LocalDate fechaFin) {
		Festival f = new Festival( nombre, temporada, fechaInicio, fechaFin);
		return dao.agregar(f);
	}
	
	public int agregar( String nombre, LocalDate temporada,LocalDate fechaInicio,LocalDate fechaFin,Costo costo) {
		Festival f = new Festival( nombre, temporada, fechaInicio, fechaFin,costo);
		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		dao.actualizar(f);
	}

	public void eliminar(long idFestival) {
		Festival f = dao.traer(idFestival);
		dao.eliminar(f);
	}
	public Festival traerFestivalYUnidadesDeVenta(long idFestival) {
	    return dao.traerFestivalYUnidadesDeVenta(idFestival);
	}

	public Festival traerFestivalYCosto(long idFestival) {
		return dao.traerFestivalYCostos(idFestival);
	}
}
