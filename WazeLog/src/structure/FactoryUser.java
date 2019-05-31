package structure;

import javafx.scene.text.Font;

public class FactoryUser {
	
	public FactoryUser() {
		
	}

	/*
	 * Crea una fabrica de messagePane agregando el texto acada uno de los mensajes
	 */
	public javafx.scene.layout.Pane cretaMessage(java.lang.String message){
		
		javafx.scene.layout.Pane messagePane = new javafx.scene.layout.Pane();
		javafx.scene.layout.VBox messageVBox = new javafx.scene.layout.VBox();
		javafx.scene.control.Label messageLabel = new javafx.scene.control.Label();
		
		messagePane.setId("paneUser");
		messagePane.setMaxHeight(100.0);
		messagePane.setPrefWidth(750.0);
		messagePane.setPrefHeight(100.0);
		
		
		messageVBox.setId("vBoxUser");
		messageVBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
		messageVBox.setPrefHeight(100.0);
		messageVBox.setPrefWidth(750.0);
		messageVBox.setPadding(new javafx.geometry.Insets(0,10,0,0));
		javafx.scene.layout.VBox.setMargin(messageLabel, new javafx.geometry.Insets(0,15,0,0));
	
		
		messageLabel.setId("userText");
		messageLabel.setAlignment(javafx.geometry.Pos.CENTER);
		messageLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		messageLabel.setPrefHeight(55.0);
		messageLabel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10px;");
		messageLabel.setText(message);
		messageLabel.setTextFill(javafx.scene.paint.Color.web("#40b24b"));
		messageLabel.setFont(Font.font("system" , 13));
		messageLabel.setPadding(new javafx.geometry.Insets(0,5,0,5));
		
		messageVBox.getChildren().add(messageLabel);
		messagePane.getChildren().add(messageVBox);
		
		return messagePane;
		
	}
}
