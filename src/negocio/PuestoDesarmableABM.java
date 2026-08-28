package negocio;

import dao.PuestoDesarmableDao;
import datos.PuestoDesarmable;
import java.util.Set;

public class PuestoDesarmableABM extends UnidadDeVentaABM {
    PuestoDesarmableDao pdao = new PuestoDesarmableDao();

    public int agregar(String nombreComercial, Staff responsableACargo, double superficie,
                       String codigoUnico, Festival festival, Set<Plato> platosOfrecidos,
                       Set<Staff> personalACargo, int cantidadDeCarpas, int tiempo){
        PuestoDesarmable pd = new PuestoDesarmable(nombreComercial,responsableACargo,superficie,codigoUnico,festival,platosOfrecidos,personalACargo,cantidadDeCarpas,tiempo);
        return super.agregar(pd);
    }

}
