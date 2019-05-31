package connection;

public class CorrectAnswer {
	
	public CorrectAnswer() {
		
	}
	/*
	 * Corrige el mensaje vistde de prolog pasandolo de un formato ([['San, Jose']])
	 * a un formato San jose.
	 */
	public String correctAnswer(String message){
		
		message = message.replace("'", "");
		message = message.replace("[", "");
		message = message.replace("[", "");
		message = message.replace("]", "");
		message = message.replace("|", "");
		message = message.replace("(", "");
		message = message.replace(")", "");
		message = message.replace(",", "");
		return message;
		
	}

}


