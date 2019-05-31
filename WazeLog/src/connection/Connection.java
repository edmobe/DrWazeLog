package connection;

import org.jpl7.Query;

import structure.Dirrections;

public class Connection {
	
	public Connection() {
		
	}
	
	/*Es la primer función qu espara WazeLog para iniciar la inteción con Prolog
	 * En ella, se identifican el lugar en que me encuentro, además; existen dos opciones
	 * la primer que el lugar sea un establecimieno, dado este caso me lleva a la función
	 * ConectionInterplaceOrigen, sino pasaría a la clase ConnectionDestinatio
	 */
	
	public java.lang.String connecetion(java.lang.String message, Dirrections dirrections) {	
		
		java.lang.String t1 = "consult('phrase_analyzer.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1+ " " + (q1.hasSolution()?"succes1":"fail"));
		
		java.lang.String t2 = "respuesta(establecimiento, origen, "+ message +", Est)";
		Query q2 = new Query(t2);
		/*
		 * Primer caso: es un establecimiento.
		 */
		try {
			if(q2.hasSolution() == true) {
				CorrectAnswer correctAnswer = new CorrectAnswer();
				java.lang.String temporal = correctAnswer.correctAnswer(q2.oneSolution().get("Est").toString());
				dirrections.setMessage(temporal);
				dirrections.setChange(2);
				java.lang.String t3 = "pregunta(establecimiento, origen, [" + temporal +"], X)";
				Query q3 = new Query(t3);
				CorrectAnswer correctAnswer2 = new CorrectAnswer();
				return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
		/*
		 * Sedundo caso: Es una ubicación de lugar.	
		 */
			}else {
				java.lang.String t4 = "respuesta(origen, "+ message +", Origen)";
				Query q4 = new Query(t4);
				CorrectAnswer correctAnswer = new CorrectAnswer();
				CorrectNode correctNode = new CorrectNode();
				java.lang.String tem = correctAnswer.correctAnswer(q4.oneSolution().get("Origen").toString()); 
				System.out.println(correctNode.correctAnswer(tem));
				dirrections.setOrigin(correctNode.correctAnswer(correctAnswer.correctAnswer(q4.oneSolution().get("Origen").toString())));
				java.lang.String t5 = "pregunta(destino, X)";
				Query q5 = new Query(t5);
				dirrections.setChange(3);
				CorrectAnswer correctAnswer2 = new CorrectAnswer();
				return correctAnswer2.correctAnswer(q5.oneSolution().get("X").toString());
				
			}
			
		}catch (Exception e) {
			return "No comprendí";
		}
	}
}
