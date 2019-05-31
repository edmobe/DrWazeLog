package structure;

public class FactoryWazeLog {
	
	public java.lang.Integer messagePart = 1;
	
	public FactoryWazeLog() {
		
	}
	/*
	 * Crea cada una de las burbujas que enviar� el WazeLog
	 */
	
	public javafx.scene.layout.Pane cretaMessage(java.lang.String message, Dirrections directions){
		
		messagePart = directions.getChange();
		
		/*
		 * Se crea cada uno de los componentes de la interfaz
		 */
		
		javafx.scene.layout.Pane messagePane = new javafx.scene.layout.Pane();
		javafx.scene.layout.VBox messageVBox = new javafx.scene.layout.VBox();
		javafx.scene.control.Label messageLabel = new javafx.scene.control.Label();
		javafx.scene.image.ImageView messageImage = new javafx.scene.image.ImageView();
		javafx.scene.image.Image imagen = new javafx.scene.image.Image("WAZELOG.png");
		
		/*
		 * Se a�aden al panel de mensaje las especificaciones para su creaci�n
		 */
		
		messagePane.setId("paneWazeLog");
		messagePane.setPrefWidth(701.0);
		messagePane.setMaxHeight(200);
		
		/*
		 * Se crea el cuadro Vbox que ordena cada uno de los mensajes
		 */
		
		messageVBox.setId("vBoxWazeLog");
		messageVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
		messageVBox.setLayoutX(75);
		messageVBox.setMaxHeight(200);
		
		/*
		 * Se a�ade la imagen que se agrega al WazeLog
		 */
		
		messageImage.setImage(imagen);
		messageImage.setFitWidth(50);
		messageImage.setFitHeight(50);
		messageImage.setLayoutX(14);
		messageImage.setLayoutY(15);
		
		/*
		 * Se crea el mensaje de dialogo que se mostrar� en pantalla
		 */
		
		messageLabel.setId("userText");
		messageLabel.setAlignment(javafx.geometry.Pos.CENTER);
		messageLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		messageLabel.setMaxHeight(200);
		messageLabel.setPadding(new javafx.geometry.Insets(25,0,0,0));
		messageLabel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10px;");
		
		/*
		 * Se inicia el panel que identificar� que tipo de estructura debe mostrarse
		 */
		
		switch(messagePart){
		
		/*
		 * Estructura de inicio, compruba si se ingresa un primer lugar y si este es punto(supermercado, universidad) o un destino
		 */
		
		case 1:
			connection.Connection connection = new connection.Connection();
			messageLabel.setText(connection.connecetion(message, directions));
			break;
			
		/*
		 * De ser el punto anterior una universidad o supermercado, recolecta la informaci�n y pregunta el lugar donde se
		 * ubica
		 */
			
		case 2:
			connection.ConectionInterplaceOrigin connection2 = new connection.ConectionInterplaceOrigin();
			messageLabel.setText(connection2.connecetion(message, directions));
			break;
			
		/*
		 * Agrega el destino al cual uno se dirige	
		 */
		
		case 3:
			connection.ConnectionDestination connectionDestination = new connection.ConnectionDestination();
			messageLabel.setText(connectionDestination.connecetion(message, directions));
			break;
			
		/*
		 * Consulta si existe alg�n destino intermedio; de ser as� continua la l�gica para a�adirse
		 * de no ser as� imprime en pantalla la ruta
		 */
			
		case 4:
			connection.ConnectionDestination connectionDestination2 = new connection.ConnectionDestination();
			messageLabel.setText(connectionDestination2.interplace(message, directions));
			break;
		/*
		 * Revisa si el destino final es un punto(supermercado o universidad) o un lugar, si es un lugar lo guarda y de ser 
		 * u punto continua la l�gica para saber que tipo de punto es
		 */
			
		case 5:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal = new connection.ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal.connecetion(message, directions));
			break;
		/*
		* Guarda los datos del establecimiento al que se quire dirigir(supermercado o universidad)
		*/
			
		case 6:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal2 = new connection.ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal2.connecetionInterplace(message, directions));
			break;
			
		/*
		 * Guarda el ulltimo intermedio, y pregunta si se encuentra alg�n otro
		 */
			
		case 7:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal3 = new connection.ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal3.connecetionInterplaceFinal(message, directions));
			break;
			
			
			
		}
		/*
		 * A�ade en pantalla el d�alogo mostrado 
		 */
		messageLabel.setFont(javafx.scene.text.Font.font("system", 13));
		messageLabel.setPadding(new javafx.geometry.Insets(0,5,0,5));
		
		messageVBox.getChildren().add(messageLabel);
		messagePane.getChildren().addAll(messageImage, messageVBox);
		
		return messagePane;
		
	}

}
