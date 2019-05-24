package application.view;

import javafx.fxml.FXML;

public class MessageViewController implements javafx.fxml.Initializable {
	
	@FXML
	 private javafx.scene.layout.AnchorPane messageBotton;
	
	@FXML
	 private javafx.scene.control.TextField textBubble;
	
	//Panel del WazeLog
	@FXML
	 private javafx.scene.layout.AnchorPane paneWazeLog;
	
	//Imagen del WazeLog
	@FXML
	 private javafx.scene.layout.AnchorPane imageWazeLog;
	
	//vBox del WazeLog
	@FXML
	 private javafx.scene.layout.AnchorPane vBoxWazeLog;
	
	//Texto del WazeLog
	@FXML
	 private javafx.scene.layout.AnchorPane wazeLogText;
	
	//Panel del Usuario
	@FXML
	 private javafx.scene.layout.AnchorPane paneUser;
	
	//vBox del usuario
	@FXML
	 private javafx.scene.layout.AnchorPane vBoxUser;
	
	//Texto del usuario
	@FXML
	 private javafx.scene.layout.AnchorPane userText;
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	
	@FXML
	private void sendText() {
	       if(textBubble.getText().trim().equals(""))return;
	       System.out.println(textBubble.getText().trim());
	       textBubble.setText("Type your message here");
	       textBubble.requestFocus();
		 
    }
	

}
