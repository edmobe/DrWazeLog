package application;

import java.io.IOException;

public class Main extends javafx.application.Application {
	private javafx.stage.Stage primaryStage;
	private javafx.scene.layout.AnchorPane mainLayout;
		
	
	@Override
	public void start(javafx.stage.Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WazeLog");
		showMainView();
		
	}
	
	private void showMainView() throws IOException  {
		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MessageView.fxml"));
		mainLayout = loader.load();
		javafx.scene.Scene scene = new javafx.scene.Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
