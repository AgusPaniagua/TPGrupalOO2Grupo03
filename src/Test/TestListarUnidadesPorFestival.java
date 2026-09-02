package Test;
import dao.HibernateUtil;
import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
public class TestListarUnidadesPorFestival {
    public static void main(String[] args) {

        long idFestival = 1L; 

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL polimórfica: trae UnidadDeVenta, pero cada fila
            // vuelve como su subtipo real (FoodTruck o PuestoDesarmable)
            Query<UnidadDeVenta> query = session.createQuery(
                    "FROM UnidadDeVenta u WHERE u.festival.idFestival = :idFest ORDER BY u.idUnidadDeVenta",
                    UnidadDeVenta.class
            );
            query.setParameter("idFest", idFestival);

            List<UnidadDeVenta> unidades = query.list();

            if (unidades.isEmpty()) {
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

                // Datos específicos según el tipo real
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

        } finally {
            session.close();
        }
    }
}
