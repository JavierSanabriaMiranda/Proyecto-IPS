package backend.data.usuarios.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.usuarios.UsuarioDTO;

public class FindUsuarioByNombreYPassword {

	private static final String QUERY = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = ? AND CONTRASEÑA = ?";
	
	private UsuarioDTO dto;
	private Database db = new Database();
	
	public FindUsuarioByNombreYPassword(UsuarioDTO dto) {
		if (dto == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dto;
	}
	
	public Optional<UsuarioDTO> execute() {
		List<Map<String, Object>> mapsUsuarios = db.executeQueryMap(QUERY, dto.nombreUsuario, dto.password);
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
	        dto.password = (String) fila.get("CONTRASEÑA");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}
}
