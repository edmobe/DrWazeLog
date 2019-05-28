package structure;

import javafx.scene.text.Font;

public class FactoryWazeLog {
	
	public FactoryWazeLog() {
		
	}
	
	public javafx.scene.layout.Pane cretaMessage(java.lang.String message){
			
		javafx.scene.layout.Pane messagePane = new javafx.scene.layout.Pane();
		javafx.scene.layout.VBox messageVBox = new javafx.scene.layout.VBox();
		javafx.scene.control.Label messageLabel = new javafx.scene.control.Label();
		javafx.scene.image.ImageView messageImage = new javafx.scene.image.ImageView();
		javafx.scene.image.Image imagen = new javafx.scene.image.Image("WAZELOG.png");
		
		messagePane.setId("paneWazeLog");
		messagePane.setMaxHeight(100.0);
		messagePane.setPrefWidth(701.0);
		messagePane.setPrefHeight(100.0);
		
		
		messageVBox.setId("vBoxWazeLog");
		messageVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
		messageVBox.setPrefHeight(100.0);
		messageVBox.setLayoutX(75);
		
		
		
		
		messageImage.setImage(imagen);
		messageImage.setFitWidth(50);
		messageImage.setFitHeight(50);
		messageImage.setLayoutX(14);
		messageImage.setLayoutY(27);
		
		messageLabel.setId("userText");
		messageLabel.setAlignment(javafx.geometry.Pos.CENTER);
		messageLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		messageLabel.setPrefHeight(55.0);
		messageLabel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10px;");
		messageLabel.setText("HolaMundo");
		messageLabel.setFont(Font.font("system", 13));
		messageLabel.setPadding(new javafx.geometry.Insets(0,5,0,5));
		
		messageVBox.getChildren().add(messageLabel);
		messagePane.getChildren().addAll(messageImage, messageVBox);
		
		return messagePane;
		
	}

}
