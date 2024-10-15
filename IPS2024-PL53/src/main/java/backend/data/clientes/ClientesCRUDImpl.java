package backend.data.clientes;

import backend.data.clientes.commands.FindByDniCliente;

public class ClientesCRUDImpl implements ClientesCRUDService {

	@Override
	public ClienteDTO findByDniCliente(String dni) {
		return new FindByDniCliente(dni).execute();
	}

}
