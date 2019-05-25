package application;

import java.io.IOException;

/**Clase principal de java**/

public class Main extends javafx.application.Application {
	private javafx.stage.Stage primaryStage;
	private javafx.scene.layout.AnchorPane mainLayout;
		
/**M�todo start, encargado de inicializar los hilas en javaFx**/	
	
	@Override
	public void start(javafx.stage.Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WazeLog");
		showMainView();
		
	}

/*M�todo encargado de mostrar el men� principal, en este caso el sistema 
 de mesajer�a WazeLog*/
	
	private void showMainView() throws IOException  {
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MessageView.fxml"));
		mainLayout = loader.load();
		javafx.scene.Scene scene = new javafx.scene.Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
/*
 * M�todo de a JavaFx encargado de mantener las ventanas en pantalla
 */
	public static void main(String[] args) {
		launch(args);
	}
}
