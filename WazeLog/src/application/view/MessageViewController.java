package application.view;



import javafx.fxml.FXML;
import structure.FactoryUser;
import structure.FactoryWazeLog;

public class MessageViewController implements javafx.fxml.Initializable {
	
	@FXML
	 private javafx.scene.layout.AnchorPane messageBotton;
	
	@FXML
	 private javafx.scene.control.TextField textBubble;
	
	@FXML
	private javafx.scene.layout.VBox messageVBox;
		
	@FXML
	private javafx.scene.control.ScrollPane scroll;
	
			
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	
		
	@FXML
	private void sendText() {
	       if(textBubble.getText().trim().equals("") || textBubble.getText().trim().equals("Type your message here")) {
	    	   textBubble.setText("Type your message here");
	    	   textBubble.requestFocus();
	       }
	       else {
	    	   
	    	   structure.FactoryUser newMessageUser = new FactoryUser();
	    	   structure.FactoryWazeLog newMessageWazeLog = new FactoryWazeLog();
	    	   messageVBox.getChildren().addAll(newMessageUser.cretaMessage(textBubble.getText().trim()));
	    	   messageVBox.getChildren().addAll(newMessageWazeLog.cretaMessage(textBubble.getText().trim()));
	    	   
	    	   System.out.println(textBubble.getText().trim());
		       textBubble.setText("");
		       textBubble.requestFocus(); 
		       
	       }
	       
		 
    }
	

}
