package backend.data.clientes;

import backend.data.clientes.commands.AddCliente;
import backend.data.clientes.commands.FindByDniCliente;

public class ClientesCRUDImpl implements ClientesCRUDService {
	
	public void addCliente(ClienteDTO cliente) {
		new AddCliente(cliente).execute();
	}

	@Override
	public ClienteDTO findByDniCliente(String dni) {
		return new FindByDniCliente(dni).execute();
	}

}
