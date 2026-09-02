package Test;
import datos.*;
import negocio.FestivalABM;
import negocio.PuestoDesarmableABM;
import negocio.StaffABM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
public class TestAgregarPuestoDesarmable {
    public static void main(String[] args) {
        PuestoDesarmableABM pdABM = new PuestoDesarmableABM();
        StaffABM sABM = new StaffABM();
        try {
            Festival festival = new FestivalABM().traer(1);
            if (festival == null) {
                throw new RuntimeException("No existe Festival con ese id");
            }

            long idPd = pdABM.agregar("Puesto de artesanías",
                    null,
                    8.0,
                    "PD00000001",
                    festival,
                    new HashSet<>(),
                    new HashSet<>(),
                    2,
                    30
            );
            System.out.printf("Id PuestoDesarmable creado: %d%n", idPd);
            PuestoDesarmable pd = (PuestoDesarmable) pdABM.traer(idPd);
            System.out.println(pd);

            long idPd2 = pdABM.agregar("Puesto de bebidas",
                    null,
                    6.0,
                    "PD00000002",
                    festival,
                    new HashSet<>(),
                    new HashSet<>(),
                    1,
                    20
            );
            System.out.printf("Id PuestoDesarmable creado: %d%n", idPd2);
            PuestoDesarmable pd2 = (PuestoDesarmable) pdABM.traer(idPd2);
            System.out.println(pd2);

            long idS = sABM.agregarCocinero(
                    "Marcos",
                    "Fernandez",
                    111222333,
                    LocalDate.of(1992, 4, 12),
                    LocalDate.of(2026, 1, 1),
                    1,
                    95000.0,
                    pd,
                    "Repostero",
                    3000
            );
            System.out.printf("Id Staff creado: %d%n", idS);

            Cocinero cocinero = (Cocinero) sABM.traer(idS);

            long idS2 = sABM.agregarCajero(
                    "Lucia",
                    "Torres",
                    222333444,
                    LocalDate.of(1997, 11, 2),
                    LocalDate.of(2026, 1, 1),
                    1,
                    90000.0,
                    pd,
                    "Tarde"
            );
            System.out.printf("Id Staff creado: %d%n", idS2);

            Cajero cajero = (Cajero) sABM.traer(idS2);

            long idS3 = sABM.agregarCajero(
                    "Diego",
                    "Molina",
                    333444555,
                    LocalDate.of(1988, 7, 19),
                    LocalDate.of(2025, 6, 1),
                    2,
                    98000.0,
                    pd2,
                    "Mañana"
            );
            System.out.printf("Id Staff creado: %d%n", idS3);

            Cajero cajero2 = (Cajero) sABM.traer(idS3);

            pd.setResponsableACargo(cocinero);
            pd2.setResponsableACargo(cajero2);

            Set<Staff> personal = new HashSet<>();
            Set<Staff> personal2 = new HashSet<>();
            personal.add(cocinero);
            personal.add(cajero);
            personal2.add(cajero2);
            pd.setPersonalACargo(personal);
            pd2.setPersonalACargo(personal2);

            pdABM.modificar(pd);
            pdABM.modificar(pd2);

            System.out.println("=== PuestoDesarmable 1 ===");
            System.out.println(pdABM.traer(idPd));
            System.out.println("Personal: " + cocinero + " | " + cajero);

            System.out.println("=== PuestoDesarmable 2 ===");
            System.out.println(pdABM.traer(idPd2));
            System.out.println("Personal: " + cajero2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
