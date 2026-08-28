package negocio;

import dao.FoodTruckDao;
import datos.FoodTruck;
import java.util.Set;

public class FoodTruckABM extends UnidadDeVentaABM{
     FoodTruckDao fdao = new FoodTruckDao();
    public int agregar(String nombreComercial, Staff responsableACargo, double superficie,
                       String codigoUnico, Festival festival, Set<Plato> platosOfrecidos,
                       Set<Staff> personalACargo, String patente, boolean conexionElectrica){
        if(patente == null || patente.isEmpty()){
            throw new RuntimeException("ERROR: el food truck debe tener patente");
        }
        FoodTruck ft = new FoodTruck(nombreComercial,responsableACargo,superficie,codigoUnico,festival,platosOfrecidos,personalACargo,patente,conexionElectrica);
        return super.agregar(ft);
    }
    public void modificar(FoodTruck ft){
        FoodTruck foodTruckConPatente = fdao.traerPorPatente(ft.getPatente());
        if(foodTruckConPatente != null && foodTruckConPatente.getIdUnidadDeVenta() != ft.getIdUnidadDeVenta()){
            throw new RuntimeException("Ya existe una food truck con esa patente");
        }
        super.modificar(ft);
    }

}


