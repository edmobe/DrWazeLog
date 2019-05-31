package structure;


public class LabelFactory {
	
	public LabelFactory() {
		
	}
	
	public javafx.scene.control.Label cretaMessage(java.lang.String message, java.lang.Integer x, java.lang.Integer y){
		
		connection.CorrectAnswer correcctAnswer = new connection.CorrectAnswer();
		
		message = correcctAnswer.correctAnswer(message);
		
		javafx.scene.control.Label messageLabel = new javafx.scene.control.Label();
		
		messageLabel.setId(message);
		messageLabel.setText(message);
		messageLabel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10px;");
		messageLabel.setLayoutX(x);
		messageLabel.setLayoutY(y);
		
		return messageLabel;

	}
}
