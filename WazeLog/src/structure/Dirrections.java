package structure;

import java.util.LinkedList;

public class Dirrections {
	private java.lang.String message = null;
	private java.lang.String origin = null;
	private java.lang.Integer change = 1;
	private java.lang.Integer lenght = -1;
	private java.lang.String destination = null;
	private LinkedList<java.lang.String> interplace = new LinkedList<String>();

	
	/*
	 * Se encarga de almacenar la información de las direciones
	 */
	public void Directions() {
		
	}
	/*
	 * Se utiliza para enviar el mensaje resibido por el usuario a las diferentes clases de conexión
	 */
	public String getMessage() {
		return message;
	}
	/*
	 * Retorna el valor del origen
	 */
	public String getOrigin() {
		return origin;
	}
	/*
	 * Retorna el valor de la clase cambio, es utilizado para saber la clase de conexión que debe de 
	 * seguir según la lógica del analizador sintactico
	 */
	public java.lang.Integer getChange() {
		return change;
	}
	/*
	 * Retorna el valor de destino
	 */
	public java.lang.String getDestination() {
		return destination;
	}
	/*
	 * Cambia el valor del mensaje 
	 */
	public void setMessage(java.lang.String message) {
		this.message = message;
	}
	/*
	 * 
	 */
	public void setOrigin(java.lang.String origin) {
		this.origin = origin;
	}
	/*
	 * Cambia el valor del cambio
	 */
	public void setChange(java.lang.Integer change) {
		this.change = change;
	}
	/*
	 * Cambia el valor del destino
	 */
	public void setDestination(java.lang.String destination) {
		this.destination = destination;
	}
	/*
	 * Crea agrega a la lista un nuevo lugar intermedio
	 */
	public void addInterplace(java.lang.String place) {
		interplace.add(place);
		lenght++;
	}
	/*
	 * Regresa la lista de los lugares intermedios
	 */
	public LinkedList<String> getInterplace() {
		return interplace;
		
	}
	public java.lang.Integer getLenght() {
		return lenght;
		
	}

}
