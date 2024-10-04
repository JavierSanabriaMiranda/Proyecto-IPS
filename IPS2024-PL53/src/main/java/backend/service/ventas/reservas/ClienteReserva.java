package backend.service.ventas.reservas;

public class ClienteReserva {
	private String nombre;
	private String numeroTarjeta;
	
	
	public ClienteReserva(String nombre, String numeroTarjeta) {
		super();
		this.nombre = nombre;
		this.numeroTarjeta = numeroTarjeta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
}
