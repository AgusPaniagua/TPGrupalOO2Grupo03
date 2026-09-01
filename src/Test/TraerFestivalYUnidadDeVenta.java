package Test;

import datos.Festival;
import negocio.FestivalABM;

public class TraerFestivalYUnidadDeVenta {
	
	public static void main(String[] args) {
		
		  long idFestival=1;
		  FestivalABM festivalAbm=new FestivalABM();
		
		  Festival festival = festivalAbm.traerFestivalYUnidadesDeVenta(idFestival);
		  if (festival != null) {
		        System.out.printf("\nFestival: %s\n", festival);
		        System.out.printf("\nUnidades de Venta: %s\n", festival.getUnidadDeVenta());
		    } else {
		        System.out.println("No se encontró el festival.");
		    }
	  }
}
