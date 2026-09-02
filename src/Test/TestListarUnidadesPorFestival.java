package Test;

import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

import java.util.List;

public class TestListarUnidadesPorFestival {

    public static void main(String[] args) {

        long idFestival = 1L;

        UnidadDeVentaABM udABM = new UnidadDeVentaABM();

        try {
            List<UnidadDeVenta> unidades = udABM.listarPorFestival(idFestival);

            if (unidades == null || unidades.isEmpty()) {
                System.out.println("No hay unidades de venta cargadas para el festival " + idFestival);
                return;
            }

            int cantidadFoodTrucks = 0;
            int cantidadPuestos = 0;

            System.out.println("=== Unidades de venta del festival " + idFestival + " ===");
            for (UnidadDeVenta u : unidades) {
                String tipo = u.getClass().getSimpleName();

                System.out.printf("[%s] id=%d | nombre=%s | superficie=%.2f | codigo=%s%n",
                        tipo,
                        u.getIdUnidadDeVenta(),
                        u.getNombreComercial(),
                        u.getSuperficie(),
                        u.getCodigoUnico());

                if (u instanceof FoodTruck ft) {
                    System.out.printf("    -> patente=%s | conexionElectrica=%b%n",
                            ft.getPatente(), ft.isConexionElectrica());
                    cantidadFoodTrucks++;
                } else if (u instanceof PuestoDesarmable pd) {
                    System.out.printf("    -> cantidadDeCarpas=%d | tiempo=%d%n",
                            pd.getCantidadDeCarpas(), pd.getTiempo());
                    cantidadPuestos++;
                }
            }

            System.out.println();
            System.out.println("Total unidades: " + unidades.size());
            System.out.println("FoodTrucks: " + cantidadFoodTrucks);
            System.out.println("PuestosDesarmables: " + cantidadPuestos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}