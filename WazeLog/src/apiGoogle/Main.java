package apiGoogle;

public class Main {
	public static void main(String[] args) {		
		GoogleMapsAPIRequest request = new GoogleMapsAPIRequest();
		try {
			String[] respuesta = request.busca_ruta("san antonio de desamparados", "san jose");
			if(respuesta.length != 0) {
				System.out.println("Nombre Google Origen: " + respuesta[0]);
		    	System.out.println("Nombre Google Destino: " + respuesta[1]);
		    	System.out.println("Origen: " + respuesta[2]);
		    	System.out.println("Destino: " + respuesta[3]);
		    	System.out.println("Distancia: " + respuesta[4]);
		    	System.out.println("ID origen: " + respuesta[5]);
		    	System.out.println("ID Destino " + respuesta[6]);
		    	System.out.println("Copyrights: " + respuesta[7]);
			} else {
				System.out.println("Error. Favor verifique los lugares ingresados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
