package backend.service.ventas.campanaAccionistas;

public class Accion {
	
	private static final int PRECIO_ESTANDAR = 60;
	
	private String idAccion;
	private float precio;
	private boolean isEnVenta;
	
	public Accion(String id, float precio, boolean isEnVenta) {
		if (id == null)
			throw new IllegalArgumentException("El id de la acción no puede ser nulo");
		if (precio <= 0)
			throw new IllegalArgumentException("El precio de la acción no puede ser negativo o 0");
		this.setIdAccion(id);
		this.setPrecio(precio);
		this.setEnVenta(isEnVenta);
	}
	
	public Accion(String id, boolean isEnVenta) {
		this(id, PRECIO_ESTANDAR,isEnVenta);
	}

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isEnVenta() {
		return isEnVenta;
	}

	public void setEnVenta(boolean isEnVenta) {
		this.isEnVenta = isEnVenta;
	}

}

