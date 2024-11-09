package backend.data.clientes.commands;

import backend.data.Database;
import backend.data.clientes.ClienteDTO;

public class AddCliente {

	private static final String SQL = "INSERT INTO CLIENTE " + 
			"(DNI, NOMBRE) " +
			"VALUES(?, ?)";
	private static final String FIND = "select * from CLIENTE where DNI = ?";

	public ClienteDTO dto;
	private Database db = new Database();
	
	public AddCliente(ClienteDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		if (!clienteNoRepetido())
			db.executeUpdate(SQL,dto.dni, dto.nombre);
	}
	
	/**
	 * @return devuelve true si el cliente esta repetido
	 */
	public boolean clienteNoRepetido() {
		return db.executeQueryDevuelveValor(FIND, dto.dni);
	}

}
