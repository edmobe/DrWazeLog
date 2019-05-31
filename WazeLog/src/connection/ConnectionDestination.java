package connection;

import org.jpl7.Query;

import structure.Dirrections;

public class ConnectionDestination {
	
	public ConnectionDestination() {
		
	}
	
	/*
	 * Se registra la respuesta del destino final para desplegar la pregunta si existe algún lugar intermedio 
	 */
	
	public java.lang.String connecetion(java.lang.String message, Dirrections dirrections) {	
		
		java.lang.String t1 = "consult('phrase_analyzer.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1+ " " + (q1.hasSolution()?"succes3":"fail"));
		
		try {
			java.lang.String t2 = "respuesta(destino, "+ message +", X)";
			Query q2 = new Query(t2);
			if(q2.hasSolution() == true) {
				CorrectAnswer correctAnswer = new CorrectAnswer();
				CorrectNode correctNode = new CorrectNode();
				dirrections.setDestination(correctNode.correctAnswer(correctAnswer.correctAnswer(q2.oneSolution().get("X").toString())));
				dirrections.setChange(4);
				java.lang.String t3 = "pregunta(afirmacion1, X)";
				Query q3 = new Query(t3);
				CorrectAnswer correctAnswer2 = new CorrectAnswer();
				return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
				
			}else {
				return "No comprendí";
				
			}
			
		}catch (Exception e) {
			return "No comprendí";
		}
		
		/*
		 * Procesa la informacion si existe al gún lugar intermedio, de ser así realiza la pregún de hacia que lugar se dirije 
		 * y de ser así, envia  al a la clase ConnectionInterplaceFinal; de no ser así envía a pantalla la ruta a seguir y la distancia de los lugares.
		 */
		
	}
	public java.lang.String interplace (java.lang.String message, Dirrections dirrections) {
		
		java.lang.String t3 = "consult('phrase_analyzer.pl')";
		Query q3 = new Query(t3);
		System.out.println(t3+ " " + (q3.hasSolution()?"succes4":"fail"));
		
		try {
			java.lang.String t4 = "respuesta(confirmacion, "+ message +", X)";
			Query q4 = new Query(t4);
			
			if(q4.hasSolution() == true) {
				dirrections.setChange(5);
				return "¿Para dónde se dirije?";
		/*
		 * Retorna las variables finales para mostran en pantalla como sucede sus ejecuciones		
		 */
				
			}else {
				java.lang.String t6 = "consult('phrase_analyzer.pl')";
				
				Query q6 = new Query(t6);
				System.out.println(t6+ " " + (q6.hasSolution()?"succesFinal":"fail"));
				
				
				java.lang.String interplaces = "Origen: " + dirrections.getOrigin();
				java.lang.String t5 = "mejorcamino(["+ dirrections.getOrigin()+"], ["+dirrections.getDestination()+"], P, W)";
				CorrectAnswer answer = new CorrectAnswer();
				
				
				if (dirrections.getLenght() >= 0) {
					java.lang.String temporal= null;
					
					for (java.lang.String pane: dirrections.getInterplace()) {
						
							t5 = "mejorcamino(["+ dirrections.getOrigin()+"], ["+pane+"], P, W)";
							Query q9 = new Query(t5);
							interplaces += "\n"+ "Ruta: " + answer.correctAnswer(q9.oneSolution().get("W").toString()) + "Distancia: " + answer.correctAnswer(q9.oneSolution().get("P").toString()) + "Km";
							temporal = pane;
								
					}
					t5 = "mejorcamino(["+ temporal+"], ["+dirrections.getDestination()+"], P, W)";
					Query q11 = new Query(t5);
					interplaces += "\n"+ "Ruta: " + answer.correctAnswer(q11.oneSolution().get("W").toString()) + "Distancia: " + answer.correctAnswer(q11.oneSolution().get("P").toString()) + "Km";
					interplaces += "\n"+"Destino: "+ dirrections.getDestination();
					return interplaces;
					
				
					
						
				}else {
					Query q5 = new Query(t5);
					interplaces += "\n"+ "Ruta: " + answer.correctAnswer(q5.oneSolution().get("W").toString()) + "Distancia: " + answer.correctAnswer(q5.oneSolution().get("P").toString()) + "Km";
					interplaces += "\n"+"Destino: " +dirrections.getDestination();
					return interplaces;
				}
				
				
			}
			
		}catch (Exception e) {
			return "Error";
		}
	}

}
