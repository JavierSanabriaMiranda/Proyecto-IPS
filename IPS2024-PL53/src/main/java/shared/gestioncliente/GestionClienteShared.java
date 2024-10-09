package shared.gestioncliente;

import java.util.List;

import backend.data.CreadorDataService;
import backend.data.clientes.ClienteDTO;
import backend.data.clientes.ClientesCRUDService;

public class GestionClienteShared {

	ClientesCRUDService service = CreadorDataService.getClientesService();
	
	public boolean checkIfClientExistsByDni(String dni) {
		ClienteDTO cliente = service.findByDniCliente(dni);
		return cliente != null;
	}
}
