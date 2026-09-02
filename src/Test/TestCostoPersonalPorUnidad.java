package Test;

import java.util.List;
import datos.Cocinero;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.StaffABM;

public class TestCostoPersonalPorUnidad {

    public static void main(String[] args) {
        StaffABM staffAbm = new StaffABM();
        List<UnidadDeVenta> unidades = staffAbm.traerUnidadesConPersonal();

        if (unidades == null || unidades.isEmpty()) {
            System.out.println("No se encontraron unidades de venta.");
            return;
        }

        System.out.println("Costo de personal por unidad de venta:");
        for (UnidadDeVenta u : unidades) {
            double costoTotal = 0;

            if (u.getPersonalACargo() != null) {
                for (Staff s : u.getPersonalACargo()) {
                    costoTotal += s.getSueldoBase();
                    if (s instanceof Cocinero) {
                        costoTotal += ((Cocinero) s).getPlusFijo();
                    }
                    // Cajero no suma nada extra por encima del sueldo base
                }
            }

            System.out.printf("- %-25s costo total: $%.2f%n", u.getNombreComercial(), costoTotal);
        }
    }
}