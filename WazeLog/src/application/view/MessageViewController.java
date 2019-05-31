package application.view;


import java.io.IOException;
import javafx.fxml.FXML;


public class MessageViewController implements javafx.fxml.Initializable {
	
	/*
	 * Estructuras para reconocimiento de javafx
	 */
	
	public structure.Dirrections dirrections = new structure.Dirrections();
	
	/*
	 * Variable  anchorPane
	 */
	@FXML
	private javafx.scene.layout.AnchorPane messageBotton;
	
	/*
	 * Variable TexField
	 */
	@FXML
	private javafx.scene.control.TextField textBubble;
	
	/*
	 * Variable Vbox
	 */
	
	@FXML
	private javafx.scene.layout.VBox messageVBox;
	
	/*
	 * Variable ScroolPane
	 */
		
	@FXML
	private javafx.scene.control.ScrollPane scroll;
	
	/*
	 * Variable anchorPane
	 */
	
	@FXML
	private javafx.scene.layout.AnchorPane graphPane;
	
	/*
	 * Variable TexField
	 */
	
	@FXML
	private javafx.scene.control.TextField textCity;
	
	/*
	 * Variable  TexField
	 */
	
	@FXML
	private javafx.scene.control.TextField textDestination;
	
	/*
	 * Variable texField
	 */
	
	@FXML
	private javafx.scene.control.TextField textDistance;
	
	/*
	 * Clase que mantiene inicializada la pantalla
	 */
			
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	/*
	 * Muestra la ventana de nodos 
	 */
	
	@FXML
	private void nodeWindow() throws IOException {
		application.Main.showSecondView();
		
	}
	
	/*
	 * Muestra la venta principal cuando se encuentra en otras
	 */
	
	@FXML
	private void messageWindow() throws IOException {
		application.Main.showMainView();
		
	/*
	 * Muestra l ventana donde se pinta el grafo
	 */
		
	}
	@FXML
	private void graphWindow() throws IOException {
		application.Main.showThirdView();
		graphView.GraphView graphView = new graphView.GraphView();
		graphView.createGraphView(graphPane);
	}
	
	/*
	 * Método encargado del texto de la ventana
	 */
		
	@FXML
	private void sendText() {
	       if(textBubble.getText().trim().equals("")) {
	    	   textBubble.setPromptText("Ingrese su mensaje aquí");
	    	   textBubble.requestFocus();
	       }
	       else {
	    	   
	    	   /*
	    	    * Crea los textos correspondientes al usuario y WazeLog
	    	    */
	    	   structure.FactoryUser newMessageUser = new structure.FactoryUser();
	    	   structure.FactoryWazeLog newMessageWazeLog = new structure.FactoryWazeLog();
	    	   messageVBox.getChildren().addAll(newMessageUser.cretaMessage(textBubble.getText().trim()));
	    	   java.lang.String sTiempo = textBubble.getText().trim().toLowerCase();
	    	   java.util.StringTokenizer st = new java.util.StringTokenizer(sTiempo," ");
	    	   java.lang.String phrase = "[";
	    	   while (st.hasMoreTokens()) {
	    		   phrase += st.nextToken();
	    		   if (st.hasMoreTokens() == true) {
	    			   phrase += ",";
	    		   }
	    	   }
	    	   phrase += "]";
	    	   messageVBox.getChildren().addAll(newMessageWazeLog.cretaMessage(phrase, dirrections)); 
		       textBubble.setText("");
		       textBubble.requestFocus(); 
		       
	       }
	       
	/*
	 * Se encarga de añadir un nodo a la base de datos
	 * comprobando de los cuadrso de texto no esten vacios 
	 */
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
			java.lang.String[] respuesta = request.busca_ruta(textCity.getText().trim(), textDestination.getText().trim());
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
