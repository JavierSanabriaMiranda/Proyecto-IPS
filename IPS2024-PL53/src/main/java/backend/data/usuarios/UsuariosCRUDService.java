package backend.data.usuarios;

import java.util.Optional;

public interface UsuariosCRUDService {

	Optional<UsuarioDTO> findUsuarioByNombre(String nombreUsuario);

	void addUsuario(UsuarioDTO dtoUsuario);

}
