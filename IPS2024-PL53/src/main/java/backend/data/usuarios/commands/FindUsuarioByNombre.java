package backend.data.usuarios.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.accionistas.AccionistaDTO;
import backend.data.usuarios.UsuarioDTO;

public class FindUsuarioByNombre {
	
	private static final String QUERY = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = ?";
	
	private String nombreUsuario;
	private Database db = new Database();

	public FindUsuarioByNombre(String nombreUsuario) {
		if (nombreUsuario == null)
			throw new IllegalArgumentException("El nombre de usuario no puede ser null");
		this.nombreUsuario = nombreUsuario;
	}

	public Optional<UsuarioDTO> execute() {
		List<Map<String, Object>> mapsUsuarios = db.executeQueryMap(QUERY, nombreUsuario);
		List<UsuarioDTO> accionistas = mapsToAccionista(mapsUsuarios);
		if (accionistas.isEmpty())
			return Optional.empty();
		return Optional.of(accionistas.get(0));
	}
	
	private List<UsuarioDTO> mapsToAccionista(List<Map<String, Object>> listaMap) {
		List<UsuarioDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	UsuarioDTO dto = new UsuarioDTO(); // Renombrado a dto
	        dto.id = (String) fila.get("ID_USUARIO");
	        dto.nombreUsuario = (String) fila.get("NOMBRE_USUARIO");
	        dto.password = (String) fila.get("CONTRASENIA");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

	
	

}
