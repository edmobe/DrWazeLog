package apiGoogle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/**
 * Clase que permite hacerle preguntas al API de Google Maps
 * @author edmobe
 *
 */
public class GoogleMapsAPIRequest {
	
	/**
	 * Método que asigna una capitalización correcta a un lugar. Ejemplo: capitalizar_lugar("san antonio de desamparados") -> "San Antonio De Desamparados".
	 * @param lugar String que no necesariamente tiene la capitalización correcta
	 * @return String que cuenta con la capitalización correcta
	 */
	private String capitalizar_lugar(String lugar){  
	    String words[]=lugar.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }  
	    return capitalizeWord.trim();  
	}  
	
	/**
	 * Elimina la unidad de medida de la distancia ya que para motivos del proyecto, se asumen todas las distancias en km por lo que sería redundante.
	 * @param distancia String distancia y unidad de medida
	 * @return String distancia
	 */
	private String peso_distancia(String distancia) {
		return distancia.replace(" km", "");
	}

	/**
	 * Permite encontrar en el API de Google Maps información acerca de un origen y un destino.
	 * @param origen_ingresado String que ingresa el usuario
	 * @param destino_ingresado String que ingresa el usuario.
	 * @return {nombre_google_origen, nombre_google_destino, origen (con buena capitalización), destino (con buena capitalización), distancia, id_origen, id_destino, copyrights}
	 * @throws Exception
	 */
	public String[] busca_ruta(String origen_ingresado, String destino_ingresado) throws Exception {
		
		// Retorna un array vacío en caso de error
		String[] error = {};
		
		// Se realiza la consulta al URL
		// Se necesita tener el origen y el destino que reconozca el URL
		String origen_url = origen_ingresado.replaceAll(" ", "+");
		String destino_url = destino_ingresado.replaceAll(" ", "+");
	
		// Se crea el URL con el origen y el destino
	    String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + origen_url + "+Costa+Rica&destination=" + destino_url + "+Costa+Rica&key=AIzaSyBTG8UwWlo4I02xd-5fNecgzmU6O3-Mn68";
	    URL obj = new URL(url);
	    
	    // Se establece una conección URL
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    // El tipo de conexión con el URL GET ya que solo se va a obtener información
	    con.setRequestMethod("GET");
	    // Se agrega el header de la solicitud
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    
	    // Se procesa la respuesta. El encoding debe ser UTF_8 para manejar tildes
	    BufferedReader in = new BufferedReader(
	    		new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	    	response.append(inputLine);
	    }
	    in.close();
	    
	    // Se convierte la respuesta (String) a un JSONObject
	    JSONObject myResponse = new JSONObject(response.toString());
	    
	    // Se valida que los lugares existan
	    // El API de Google Maps indica que los lugares existen mediante un "status" "OK".	    
	    if(myResponse.getString("status").equals("OK")) {
	    	// Se verifica que origen y destino sean lugares, no establecimientos
	    	boolean origen_lugar = myResponse.getJSONArray("geocoded_waypoints").getJSONObject(0).getJSONArray("types").toString().contains("political");
	    	boolean destino_lugar = myResponse.getJSONArray("geocoded_waypoints").getJSONObject(1).getJSONArray("types").toString().contains("political");
	    	if (origen_lugar && destino_lugar) {
	    		// Se procede a leer los datos del Json
	    		String nombre_google_origen = myResponse.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getString("start_address");
	    		String nombre_google_destino = myResponse.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getString("end_address");
		    	String distancia = myResponse.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text");
		    	String id_origen = myResponse.getJSONArray("geocoded_waypoints").getJSONObject(0).getString("place_id");
		    	String id_destino = myResponse.getJSONArray("geocoded_waypoints").getJSONObject(1).getString("place_id");
		    	String copyrights = myResponse.getJSONArray("routes").getJSONObject(0).getString("copyrights");
		    	String[] respuesta = {nombre_google_origen, nombre_google_destino, capitalizar_lugar(origen_ingresado), capitalizar_lugar(destino_ingresado), peso_distancia(distancia), id_origen, id_destino, copyrights};
		    	return respuesta;
	    	}
	    	else {
	    		return error;
	    	}
	    }
	    else {
	    	return error;
	    }
	}
}