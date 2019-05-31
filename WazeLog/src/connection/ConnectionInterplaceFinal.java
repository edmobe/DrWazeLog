package connection;

import org.jpl7.Query;

public class ConnectionInterplaceFinal {
	
	public ConnectionInterplaceFinal() {
		
	}
	/*
	 * Esta función, es encragar de realizar la interpretación de si el lugar es un establecimeinto y recolecta la 
	 * información necesaria para identificar el establecimeinto
	 */
	
	public String connecetion(java.lang.String message, structure.Dirrections dirrections){
			
		java.lang.String t1 = "consult('phrase_analyzer.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1+ " " + (q1.hasSolution()?"succes5":"fail"));
		
		java.lang.String t2 = "respuesta(establecimiento, destino, "+ message +", Est)";
		Query q2 = new Query(t2);
		try {
			if(q2.hasSolution() == true) {
				CorrectAnswer correctAnswer = new CorrectAnswer();
				java.lang.String temporal = correctAnswer.correctAnswer(q2.oneSolution().get("Est").toString());
				dirrections.setMessage(temporal);
				dirrections.setChange(6);
				String t3 = "pregunta(establecimiento, destino, [" + temporal +"], X)";
				Query q3 = new Query(t3);
				CorrectAnswer correctAnswer2 = new CorrectAnswer();
				return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
				
			}else {
				try {
					java.lang.String t4 = "respuesta(destino, "+ message +", Destino)";
					Query q4 = new Query(t4);
					dirrections.setChange(4);
					CorrectAnswer correctAnswer = new CorrectAnswer();
					CorrectNode correctNode = new CorrectNode();
					java.lang.String tempo = correctAnswer.correctAnswer(q4.oneSolution().get("Destino").toString());
					dirrections.addInterplace(correctNode.correctAnswer(tempo));
					return "¿Desea agregar otro intermedio?";
				}catch (Exception e) {
					dirrections.setChange(5);
					return "Esa ruta ya es uno de sus puntos de viaje. Ingrese un punto intermedio válido.";
				}
				
				
			}
			
		}catch (Exception e) {
			return "No comprendí";
		}
	}
	/*
	 * Verifica que se guarde un nombre de un establecimineto y de ser así realiza la pregunta de dónde esta ubicado
	 */
	public java.lang.String connecetionInterplace(java.lang.String message, structure.Dirrections dirrections) {	
		
		java.lang.String t1 = "consult('phrase_analyzer.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1+ " " + (q1.hasSolution()?"succes6":"fail"));
		try {
			java.lang.String t2 = "respuesta(establecimiento_nombre(["+ dirrections.getMessage() +"]), destino, "+ message +", N)";
			Query q2 = new Query(t2);
			if (q2.hasSolution()) {
				CorrectAnswer correctAnswer = new CorrectAnswer();
				java.lang.String temporal = correctAnswer.correctAnswer(q2.oneSolution().get("N").toString());
				java.lang.String t3 = "pregunta(establecimiento_nombre, ["+ temporal+ "], X)";
				Query q3 = new Query(t3);
				dirrections.setChange(7);
				CorrectAnswer correctAnswer2 = new CorrectAnswer();
				return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
				
			}
								
		}catch (Exception e) {
			return "No comprendí";
		}
		return "No comprendí";
		
	}
	
	/*
	 * Realiza la conexión con los nodos para agregar u intermedio, eso lo realiza con el Query
	 * Seguidamente mediante la clase Query con sulta a prolog el mejor camino
	 */
	
	public java.lang.String connecetionInterplaceFinal (java.lang.String message, structure.Dirrections dirrections) {
		java.lang.String t1 = "consult('phrase_analyzer.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1+ " " + (q1.hasSolution()?"succes7":"fail"));
		try {
			java.lang.String t4 = "respuesta(origen, "+ message +", Destino)";
			Query q4 = new Query(t4);
			CorrectAnswer correctAnswer = new CorrectAnswer();
			correctAnswer.correctAnswer(q4.oneSolution().get("Destino").toString());
			java.lang.String t3 = "pregunta(afirmacion1, X)";
			Query q3 = new Query(t3);
			dirrections.setChange(4);
			CorrectAnswer correctAnswer2 = new CorrectAnswer();
			return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
		}catch (Exception e) {
			return "No comprendí";
		}
		
		
	}
}
