package negocio;
import dao.UnidadDeVentaDao;
import datos.UnidadDeVenta;

import java.util.List;

public class UnidadDeVentaABM {
    UnidadDeVentaDao udao = new UnidadDeVentaDao();

    public UnidadDeVenta traer(long idUnidadDeVenta){
        return udao.traer(idUnidadDeVenta);
    }

    public int agregar(UnidadDeVenta unidad){

        if(unidad.getCodigoUnico() == null || unidad.getCodigoUnico().length()!=10){
            throw new RuntimeException("ERROR: el codigo debe de tener 10 caracteres");
        }
        if(udao.traer(unidad.getCodigoUnico())!=null){
            throw new RuntimeException("ERROR: Ya existe una unidad de venta con el código");
        }
        return udao.agregar(unidad);
    }

    public void modificar(UnidadDeVenta unidad){
        UnidadDeVenta unidadConCodigoUnico = udao.traer(unidad.getCodigoUnico());
        if(unidadConCodigoUnico != null && unidadConCodigoUnico.getIdUnidadDeVenta() != unidad.getIdUnidadDeVenta()){
            throw new RuntimeException("Ya existe otra unidad con ese codigo ");
        }
        udao.actualizar(unidad);
    }

    public void eliminar(long idUnidadDeVenta){
        UnidadDeVenta u = udao.traer(idUnidadDeVenta);
        if(u==null){
            throw new RuntimeException("No existe unidad ");
        }
        if(u.getPlatosOfrecidos()!=null && !u.getPlatosOfrecidos().isEmpty()){
            throw new RuntimeException("No se puede eliminar: la unidad tiene platos ofrecidos asociados");
        }
        if(u.getPersonalACargo()!=null && !u.getPersonalACargo().isEmpty()){
            throw new RuntimeException("No se puede eliminar: la unidad tiene personal asignado");
        }
        udao.eliminar(u);
    }
    public List<UnidadDeVenta> listarPorFestival(long idFestival){
        return udao.listarPorFestival(idFestival);
    }
}