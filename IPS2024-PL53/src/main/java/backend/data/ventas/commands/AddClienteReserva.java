package backend.data.ventas.commands;

import backend.data.Database;
import backend.data.ventas.ClienteReservaDto;


public class AddClienteReserva {

	private static final String SQL = "INSERT INTO CLIENTE " + 
			"(DNI, NOMBRE) " +
			"VALUES(?, ?)";
	private static final String FIND = "select * from CLIENTE where DNI = ?";

	public ClienteReservaDto dto;
	private Database db = new Database();
	
	public AddClienteReserva(ClienteReservaDto dto) {
		this.dto = dto;
	}
	
	public void execute() {
		if (!clienteNoRepetido())
			db.executeUpdate(SQL,dto.DNI, dto.nombre);
	}
	
	/**
	 * @return devuelve true si el cliente esta repetido
	 */
	public boolean clienteNoRepetido() {
		return db.executeQueryDevuelveValor(FIND, dto.DNI);
	}

	
	
}
