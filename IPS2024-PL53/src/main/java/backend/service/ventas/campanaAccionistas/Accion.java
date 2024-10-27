package backend.service.ventas.campanaAccionistas;

public class Accion {
	
	private static final int PRECIO_ESTANDAR = 60;
	
	private String idAccion;
	private double precio;
	
	public Accion(String id, double precio) {
		if (id == null)
			throw new IllegalArgumentException("El id de la acción no puede ser nulo");
		if (precio <= 0)
			throw new IllegalArgumentException("El precio de la acción no puede ser negativo o 0");
		this.idAccion = id;
		this.precio = precio;
	}
	
	public Accion(String id) {
		this(id, PRECIO_ESTANDAR);
	}

}
