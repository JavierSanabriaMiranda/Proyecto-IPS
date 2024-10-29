package backend.service.instalaciones;

public interface ReservaParaInstalacion {
	/**
	 * La función de esta interfaz es crear una relacion entre todas las clases que pueden reservar una instalacion para 
	 * la actividad que sea. Dichas clases tendran una prioridad para poder reservarla. 
	 * 
	 * Las prioridades son las siguientes (ordenadas de + a - prioridad):
	 * 
	 *  Entrenamientos y Reservas (de clientes) -> Prioridad 1
	 *  Reservas de Jardineros -> Prioridad 2
	 *  
	 *  
	 *  
	 */
	
	int getPrioridad();
	
}
