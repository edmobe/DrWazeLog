package application.view;


import java.io.IOException;
import java.util.StringTokenizer;
import graphView.GraphView;
import javafx.fxml.FXML;
import structure.Dirrections;
import structure.FactoryUser;
import structure.FactoryWazeLog;

public class MessageViewController implements javafx.fxml.Initializable {
	
	/*
	 * Estructuras para reconocimiento de javafx
	 */
	
	public structure.Dirrections dirrections = new Dirrections();
	
	/*
	 * Variable par un anchorPane
	 */
	@FXML
	private javafx.scene.layout.AnchorPane messageBotton;
	
	
	@FXML
	private javafx.scene.control.TextField textBubble;
	
	@FXML
	private javafx.scene.layout.VBox messageVBox;
		
	@FXML
	private javafx.scene.control.ScrollPane scroll;
	
	@FXML
	private javafx.scene.layout.AnchorPane graphPane;
	
	@FXML
	private javafx.scene.control.TextField textCity;
	
	@FXML
	private javafx.scene.control.TextField textDestination;
	
	@FXML
	private javafx.scene.control.TextField textDistance;
			
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	
	@FXML
	private void nodeWindow() throws IOException {
		application.Main.showSecondView();
		
	}
	@FXML
	private void messageWindow() throws IOException {
		application.Main.showMainView();
	}
	@FXML
	private void graphWindow() throws IOException {
		application.Main.showThirdView();
		GraphView graphView = new GraphView();
		graphView.createGraphView(graphPane);
	}
	
	
		
	@FXML
	private void sendText() {
	       if(textBubble.getText().trim().equals("")) {
	    	   textBubble.setPromptText("Ingrese su mensaje aquí");
	    	   textBubble.requestFocus();
	       }
	       else {
	    	   
	    	   structure.FactoryUser newMessageUser = new FactoryUser();
	    	   structure.FactoryWazeLog newMessageWazeLog = new FactoryWazeLog();
	    	   messageVBox.getChildren().addAll(newMessageUser.cretaMessage(textBubble.getText().trim()));
	    	   
	    	   System.out.println(textBubble.getText().trim());
	    	   
	    	   String sTiempo = textBubble.getText().trim().toLowerCase();
	    	   StringTokenizer st = new StringTokenizer(sTiempo," ");
	    	   String phrase = "[";
	    	   while (st.hasMoreTokens()) {
	    		   phrase += st.nextToken();
	    		   if (st.hasMoreTokens() == true) {
	    			   phrase += ",";
	    		   }
	    	   }
	    	   phrase += "]";
	    	   System.out.println(phrase);
	    	   messageVBox.getChildren().addAll(newMessageWazeLog.cretaMessage(phrase, dirrections)); 
		       textBubble.setText("");
		       textBubble.requestFocus(); 
		       
	       }
	       
		 
    }
	@FXML
	private void addNode() throws IOException {
		if(textCity.getText().trim().equals("")) {
		 	textCity.setPromptText("Complete este espacio");
		 	textCity.requestFocus();
		 	
		 	   
		}else if(textDestination.getText().trim().equals("")) {
		    textDestination.setPromptText("Complete este espacio");
		    textDestination.requestFocus();
			
		}else if(textDistance.getText().trim().equals("")) {
			textDistance.setPromptText("Complete este espacio");
			textDistance.requestFocus();
						
		}else {
			try {
			connection.Archivo archivo = new connection.Archivo();
			java.lang.Double temporal = Double.parseDouble(textDistance.getText());
			java.lang.Integer distance = (int) Math.round (temporal);
			System.out.println(distance);
			archivo.añadir(textCity.getText().trim(), textDestination.getText().trim(), distance, "id-de-siquirres", "id-de-desampa-pra-pra");
			System.out.println("correcto");
			messageWindow();
			
			}catch (Exception e) {
				textDistance.setText("Digite un número");
				textDistance.requestFocus();
			}
			
		}
		
	}
	/*
	 * Cosulta el api de google para averguar la distancia entre dos puntos agregados al garafo
	 */
	@FXML
	private void googleBoton (){
		apiGoogle.GoogleMapsAPIRequest request = new apiGoogle.GoogleMapsAPIRequest();
		try {
			//Ingresa a la clase GoogleMapsAPIRequest para consultar la distancia y los agrega en un Array
			String[] respuesta = request.busca_ruta(textCity.getText().trim(), textDestination.getText().trim());
			if(respuesta.length != 0) {
				System.out.println("Nombre Google Origen: " + respuesta[0]);
		    	System.out.println("Nombre Google Destino: " + respuesta[1]);
		    	System.out.println("Origen: " + respuesta[2]);
		    	System.out.println("Destino: " + respuesta[3]);
		    	System.out.println("Distancia: " + respuesta[4]);
		    	System.out.println("ID origen: " + respuesta[5]);
		    	System.out.println("ID Destino " + respuesta[6]);
		    	System.out.println("Copyrights: " + respuesta[7]);
		    	System.out.println();
		    	textDistance.setText(respuesta[4]);
			} else {
				System.out.println("Error. Favor verifique los lugares ingresados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	

	
}
