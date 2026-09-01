package Test;

import java.time.LocalDate;

import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarFestivalYCosto {

    public static void main(String[] args) {

        FestivalABM abmFestival = new FestivalABM();

        try {

            long ultimoIdFestival = abmFestival.agregar("lollapalooza",LocalDate.of(2026, 12, 17),
            		LocalDate.of(2026, 12, 20), LocalDate.of(2026, 12, 23) );

            System.out.printf("Id Festival: %d%n", ultimoIdFestival);

            
            Festival festival = abmFestival.traer(ultimoIdFestival);

            System.out.println(festival);

            CostoABM abmCosto = new CostoABM();

            abmCosto.agregar(1100.00, 3500.00, true, 550000.00, festival );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}

