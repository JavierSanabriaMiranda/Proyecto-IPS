package backend.data.clientes;

import backend.data.clientes.commands.AddCliente;
import backend.data.clientes.commands.FindByDniCliente;
import backend.util.log.LogManager;

public class ClientesCRUDImpl implements ClientesCRUDService {
	
	public void addCliente(ClienteDTO cliente) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: CLIENTE");
		new AddCliente(cliente).execute();
	}

	@Override
	public ClienteDTO findByDniCliente(String dni) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: CLIENTE");
		return new FindByDniCliente(dni).execute();
	}

}
