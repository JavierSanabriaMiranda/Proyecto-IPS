package backend.data.acciones;

public class AccionDTO {
	private String id_accion;
	private String id_accionista;
	private float precio;

	public AccionDTO(String id_accion, String id_accionista, float precio) {
		this.id_accion=id_accion;
		this.id_accionista=id_accionista;
		this.precio=precio;
	}
	
	public AccionDTO(String id_accion) {
		this.id_accion=id_accion;
	}
	
	public AccionDTO() {
	}

    // Getters y Setters
    public String getIdAccion() { return id_accion; }
    public void setIdAccion(String id_accion) { this.id_accion = id_accion; }
    
    public String getIdAccionista() { return id_accionista; }
    public void setIdAccionista(String id_accionista) { this.id_accionista = id_accionista; }
    
    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }
}
