package backend.data.usuarios;

import java.util.Optional;

import backend.data.usuarios.commands.AddUsuario;
import backend.data.usuarios.commands.FindUsuarioByNombre;
import backend.data.usuarios.commands.FindUsuarioByNombreYPassword;

public class UsuariosCRUDImpl implements UsuariosCRUDService {

	@Override
	public Optional<UsuarioDTO> findUsuarioByNombre(String nombreUsuario) {
		return new FindUsuarioByNombre(nombreUsuario).execute();
	}

	@Override
	public void addUsuario(UsuarioDTO dtoUsuario) {
		new AddUsuario(dtoUsuario).execute();
	}

	@Override
	public Optional<UsuarioDTO> findUsuarioByNombreYPassword(UsuarioDTO dto) {
		return new FindUsuarioByNombreYPassword(dto).execute();
	}

}
