package Test;

import datos.*;
import negocio.FestivalABM;
import negocio.FoodTruckABM;
import negocio.StaffABM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestAgregarFoodTruck {
     public static void main(String[] args) {

        FoodTruckABM ftABM = new FoodTruckABM();
        StaffABM sABM = new StaffABM();

        try{
            Festival festival = new FestivalABM().traer(1);
            if(festival == null){
                throw new RuntimeException("No existe Festival con ese id");
            }
            long idFt = ftABM.agregar("Chori al paso",
                    null,
                    15.0,
                    "FT00000001",
                    festival,
                    new HashSet<>(),
                    new HashSet<>(),
                    "AB123CD",
                    true
            );
            System.out.printf("Id FoodTruck creado: %d%n", idFt);
            FoodTruck ft = (FoodTruck) ftABM.traer(idFt);
            System.out.println(ft);

            long idFt2 = ftABM.agregar("Hamburguejas al vapor",
                    null,
                    20.0,
                    "FT00000002",
                    festival,
                    new HashSet<>(),
                    new HashSet<>(),
                    "AB234CD",
                    true
            );
            System.out.printf("Id FoodTruck creado: %d%n", idFt2);
            FoodTruck ft2 = (FoodTruck) ftABM.traer(idFt2);
            System.out.println(ft2);

            long idFt3 = ftABM.agregar("Empanadas criollas",
                    null,
                    10.0,
                    "FT00000003",
                    festival,
                    new HashSet<>(),
                    new HashSet<>(),
                    "AB345CD",
                    true
            );
            System.out.printf("Id FoodTruck creado: %d%n", idFt3);
            FoodTruck ft3 = (FoodTruck) ftABM.traer(idFt3);
            System.out.println(ft3);

            long idS = sABM.agregarCocinero(
                    "Juan",
                    "Lopez",
                    123456789,
                    LocalDate.of(1998,6,4),
                    LocalDate.of(2026,1,1),
                    1,
                    100000.0,
                    ft,
                    "Parrillero",
                    5000
            );
            System.out.printf("Id Staff creado: %d%n",idS);

            Cocinero cocinero = (Cocinero) sABM.traer(idS);

            long idS2 = sABM.agregarCocinero(
                    "Rocio",
                    "Gonzalez",
                    234567890,
                    LocalDate.of(1994,10,4),
                    LocalDate.of(2025,1,1),
                    2,
                    110000.0,
                    ft2,
                    "Parrillero",
                    5000
            );
            System.out.printf("Id Staff creado: %d%n",idS2);

            Cocinero cocinero2 = (Cocinero) sABM.traer(idS2);

            long idS3 = sABM.agregarCocinero(
                    "Gustavo",
                    "Ramirez",
                    345678901,
                    LocalDate.of(1990,8,6),
                    LocalDate.of(2025,3,10),
                    2,
                    101000.0,
                    ft3,
                    "Amasador",
                    2000
            );
            System.out.printf("Id Staff creado: %d%n",idS3);

            Cocinero cocinero3 = (Cocinero) sABM.traer(idS3);

            long idS4 = sABM.agregarCajero(
                    "Ester",
                    "Gimenez",
                    456789012,
                    LocalDate.of(1998,6,4),
                    LocalDate.of(2026,1,1),
                    1,
                    105000.0,
                    ft,
                    "Mañana"
            );
            System.out.printf("Id Staff creado: %d%n",idS4);

            Cajero cajero = (Cajero) sABM.traer(idS4);

            long idS5 = sABM.agregarCajero(
                    "Miguel",
                    "Bermudez",
                    567890123,
                    LocalDate.of(2000,10,20),
                    LocalDate.of(2026,1,1),
                    1,
                    106000.0,
                    ft2,
                    "Mañana"
            );
            System.out.printf("Id Staff creado: %d%n",idS5);

            Cajero cajero2 = (Cajero) sABM.traer(idS5);

            long idS6 = sABM.agregarCajero(
                    "Juana",
                    "Lopez",
                    678901234,
                    LocalDate.of(1900,8,31),
                    LocalDate.of(2025,1,1),
                    2,
                    110080.0,
                    ft3,
                    "Mañana"
            );
            System.out.printf("Id Staff creado: %d%n",idS6);

            Cajero cajero3 = (Cajero) sABM.traer(idS6);

            ft.setResponsableACargo(cocinero);
            ft2.setResponsableACargo(cajero2);
            ft3.setResponsableACargo(cocinero3);
            Set<Staff> personal = new HashSet<>();
            Set<Staff> personal2 = new HashSet<>();
            Set<Staff> personal3 = new HashSet<>();
            personal.add(cocinero);
            personal.add(cajero);
            personal2.add(cocinero2);
            personal2.add(cajero2);
            personal3.add(cocinero3);
            personal3.add(cajero3);
            ft.setPersonalACargo(personal);
            ft2.setPersonalACargo(personal2);
            ft3.setPersonalACargo(personal3);
            ftABM.modificar(ft);
            ftABM.modificar(ft2);
            ftABM.modificar(ft3);

            System.out.println("=== FoodTruck 1 ===");
            System.out.println(ftABM.traer(idFt));
            System.out.println("Personal: " + cocinero + " | " + cajero);

            System.out.println("=== FoodTruck 2 ===");
            System.out.println(ftABM.traer(idFt2));
            System.out.println("Personal: " + cocinero2 + " | " + cajero2);

            System.out.println("=== FoodTruck 3 ===");
            System.out.println(ftABM.traer(idFt3));
            System.out.println("Personal: " + cocinero3 + " | " + cajero3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
