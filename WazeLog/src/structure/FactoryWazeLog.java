package structure;

import connection.*;
import javafx.scene.text.Font;

public class FactoryWazeLog {
	
	public java.lang.Integer messagePart = 1;
	
	public FactoryWazeLog() {
		
	}
	
	public javafx.scene.layout.Pane cretaMessage(java.lang.String message, Dirrections directions){
		
		messagePart = directions.getChange();
		
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
		
		
		
		switch(messagePart){
		
		case 1:
			connection.Connection connection = new Connection();
			messageLabel.setText(connection.connecetion(message, directions));
			break;
		case 2:
			connection.ConectionInterplaceOrigin connection2 = new ConectionInterplaceOrigin();
			messageLabel.setText(connection2.connecetion(message, directions));
			break;
		case 3:
			connection.ConnectionDestination connectionDestination = new ConnectionDestination();
			messageLabel.setText(connectionDestination.connecetion(message, directions));
			break;
		case 4:
			connection.ConnectionDestination connectionDestination2 = new ConnectionDestination();
			messageLabel.setText(connectionDestination2.interplace(message, directions));
			break;
		case 5:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal = new ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal.connecetion(message, directions));
			break;
		case 6:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal2 = new ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal2.connecetionInterplace(message, directions));
			break;
		case 7:
			connection.ConnectionInterplaceFinal connectionInterplaceFinal3 = new ConnectionInterplaceFinal();
			messageLabel.setText(connectionInterplaceFinal3.connecetionInterplaceFinal(message, directions));
			break;
			
			
			
		}
		messageLabel.setFont(Font.font("system", 13));
		messageLabel.setPadding(new javafx.geometry.Insets(0,5,0,5));
		
		messageVBox.getChildren().add(messageLabel);
		messagePane.getChildren().addAll(messageImage, messageVBox);
		
		return messagePane;
		
	}

}
