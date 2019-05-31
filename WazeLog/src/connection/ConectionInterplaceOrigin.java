package connection;
import org.jpl7.Query;

public class ConectionInterplaceOrigin {
	
		public ConectionInterplaceOrigin() {
			
		}
		/*
		 * Recolecta el nombre y la ubicación del lugar inicial en el que se encunetra; seguidamente regresa a la primer función (Connection)
		 * para recolectar la información del destino final
		 */
		
		public java.lang.String connecetion(java.lang.String message, structure.Dirrections dirrections) {	
			
			java.lang.String t1 = "consult('phrase_analyzer.pl')";
			Query q1 = new Query(t1);
			System.out.println(t1+ " " + (q1.hasSolution()?"succes2":"fail"));
			try {
				java.lang.String t2 = "respuesta(establecimiento_nombre(["+ dirrections.getMessage() +"]), origen, "+ message +", N)";
				Query q2 = new Query(t2);
				if (q2.hasSolution()) {
					CorrectAnswer correctAnswer = new CorrectAnswer();
					java.lang.String temporal = correctAnswer.correctAnswer(q2.oneSolution().get("N").toString());
					java.lang.String t3 = "pregunta(establecimiento_nombre, ["+ temporal+ "], X)";
					Query q3 = new Query(t3);
					dirrections.setChange(1);
					CorrectAnswer correctAnswer2 = new CorrectAnswer();
					return correctAnswer2.correctAnswer(q3.oneSolution().get("X").toString());
				}
									
			}catch (Exception e) {
				return "No comprendí";
			}
			return "No comprendí";
			
		}
	}
