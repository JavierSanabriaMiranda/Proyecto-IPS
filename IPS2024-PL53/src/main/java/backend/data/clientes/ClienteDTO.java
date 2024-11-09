package backend.data.clientes;

public class ClienteDTO {
	public String dni;
	public String nombre;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
}
