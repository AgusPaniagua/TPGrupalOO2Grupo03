package Test;

import java.time.LocalDate;
import java.util.HashSet;

import datos.Festival;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.FoodTruckABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class TestAgregarStaffYUnidad {

    public static void main(String[] args) {
        try {
            // 1) Festival
            FestivalABM abmFestival = new FestivalABM();
            long idFestival = abmFestival.agregar("Lollapalooza", LocalDate.of(2026, 12, 17),
                    LocalDate.of(2026, 12, 20), LocalDate.of(2026, 12, 23));
            Festival festival = abmFestival.traer(idFestival);
            System.out.println("Festival creado, id: " + idFestival);

            // 2) Unidad de venta SIN responsable todavía
            FoodTruckABM abmFoodTruck = new FoodTruckABM();
            long idUnidad = abmFoodTruck.agregar(
                    "Food Truck Norte", null, 25.5, "FT00000001",
                    festival, new HashSet<>(), new HashSet<>(),
                    "AB123CD", true);
            System.out.println("Unidad de venta creada, id: " + idUnidad);

            // 3) Personal asociado a esa unidad
            StaffABM abmStaff = new StaffABM();
            UnidadDeVentaABM abmUnidad = new UnidadDeVentaABM();
            UnidadDeVenta unidad = abmUnidad.traer(idUnidad);

            int idCocinero = abmStaff.agregarCocinero("Juan", "Perez", 30111222,
                    LocalDate.of(1990, 5, 10), LocalDate.of(2024, 1, 15), 2,
                    450000.00, unidad, "Parrillero", 50000);

            abmStaff.agregarCajero("Ana", "Gomez", 28999111,
                    LocalDate.of(1995, 3, 20), LocalDate.of(2025, 6, 1), 1,
                    380000.00, unidad, "mañana");

            // 4) Recién ahora asignamos el responsable (ya existe en la base)
            Staff responsable = abmStaff.traer(idCocinero);
            unidad.setResponsableACargo(responsable);
            abmUnidad.modificar(unidad);

            System.out.println("Datos de prueba cargados correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}