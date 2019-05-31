package application;

import java.io.IOException;

/**Clase principal de java**/

public class Main extends javafx.application.Application {
	private javafx.stage.Stage primaryStage;
	private static javafx.scene.layout.BorderPane mainLayout;
		
/**Método start, encargado de inicializar los hilas en javaFx**/	
	
	@Override
	public void start(javafx.stage.Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WazeLog");
		showMainWindow();
		showMainView();
		
		
	}
	private void showMainWindow() throws IOException {
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/PrincipalView.fxml"));
		mainLayout = loader.load();
		javafx.scene.Scene scene = new javafx.scene.Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

/*Método encargado de mostrar el menú principal, en este caso el sistema 
 de mesajería WazeLog*/
	
	public static void showMainView() throws IOException  {
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MessageView.fxml"));
		javafx.scene.layout.AnchorPane mainView = loader.load();
		mainLayout.setCenter(mainView);
		
	}
	public static void showSecondView() throws IOException{
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddGrafoView.fxml"));
		javafx.scene.layout.AnchorPane secondView = loader.load();
		mainLayout.setCenter(secondView);
	}
	public static void showThirdView() throws IOException{
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/GraphWindow.fxml"));
		javafx.scene.layout.AnchorPane thirdView = loader.load();
		mainLayout.setCenter(thirdView);
	}
/*
 * Método de a JavaFx encargado de mantener las ventanas en pantalla
 */
	public static void main(String[] args) {
		launch(args);
	}
}
