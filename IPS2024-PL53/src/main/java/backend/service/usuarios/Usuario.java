package backend.service.usuarios;

public class Usuario {

	private final String idUsuario;
	private final String nombreUsuario;
	private final TipoUsuario tipoUsuario;
	
	public Usuario(String idUsuario, String nombreUsuario, TipoUsuario tipoUsuario) {
		if (idUsuario == null)
			throw new IllegalArgumentException("El id del usuario no puede ser null");
		if (nombreUsuario == null)
			throw new IllegalArgumentException("El nombre del usuario no puede ser null");
		if (tipoUsuario == null)
			throw new IllegalArgumentException("El tipo del usuario no puede ser null");
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.tipoUsuario = tipoUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	
	
}
