package connection;

public class CorrectNode {
	
	public CorrectNode() {
		
	}
	/*
	 * Corrige los lugares ingresados cambiando el formado de [San Jose] a [San, Jose]
	 * que es la forma correcta de ver el nombre
	 */
	public String correctAnswer(String message){
		
		message = message.substring(0, message.length()-1);
		message = message.replace(" ", ",");
		return message;
		
	}
	/*
	 * Corrige si existe un nodo con coma de más
	 */
	public String correctAnswer2(String message){
		message = message.replace(" ", ",");
		return message;
	}
}
