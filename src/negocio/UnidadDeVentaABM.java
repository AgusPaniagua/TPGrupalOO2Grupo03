package negocio;
import dao.UnidadDeVentaDao;
import datos.UnidadDeVenta;
public class UnidadDeVentaABM {
    UnidadDeVentaDao udao = new UnidadDeVentaDao();

    public UnidadDeVenta traer(long idUnidadDeVenta){
        return udao.traer(idUnidadDeVenta);
    }

    public int agregar(String nombreComercial, Staff responsableACargo, double superficie, String codigoUnico,Festival festival, Set<Plato> platosOfrecidos, Set<Staff> personalACargo){
        if(responsableACargo == null){
            throw new RuntimeException("ERROR: debe haber un responsable a cargo");
        }
        if(festival==null){
            throw new RuntimeException("ERROR: debe haber un festival asociado");
        }
        if(codigoUnico == null || codigoUnico.length()!=10){
            throw new RuntimeException("ERROR: el codigo debe de tener 10 caracteres");
        }
        if(udao.traer(codigoUnico)!=null){
            throw new RuntimeException("ERROR: Ya existe una unidad de venta con el código");
        }
        UnidadDeVenta u = new UnidadDeVenta(nombreComercial,responsableACargo,superficie,codigoUnico,festival,platosOfrecidos,personalACargo);
        return udao.agregar(u);
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
}