package backend.data.usuarios.commands;

import backend.data.Database;
import backend.data.usuarios.UsuarioDTO;

public class AddUsuario {

	private static final String QUERY = "INSERT INTO USUARIO (ID_USUARIO, NOMBRE_USUARIO, CONTRASEÑA) "
			+ "VALUES (?, ?, ?)";
			 
	private UsuarioDTO dto;
	private Database db = new Database();
	
	public AddUsuario(UsuarioDTO dtoUsuario) {
		if (dtoUsuario == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dtoUsuario;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.id, dto.nombreUsuario, dto.password);
	}
	
	

}
