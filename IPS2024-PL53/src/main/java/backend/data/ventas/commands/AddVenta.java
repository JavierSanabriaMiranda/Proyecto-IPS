package backend.data.ventas.commands;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class AddVenta {

	private static final String SQL = "INSERT INTO VENTAS " + 
			"(ID_VENTAS, DNI, FECHA, COSTE) " +
			"VALUES(?, ?, ?, ?)";

	public VentaDto dto;
	private Database db = new Database();
	
	public AddVenta(VentaDto dto) {
	this.dto = dto;
	}
	
	public void execute() {
	db.executeUpdate(SQL, dto.idVenta, dto.DNI, dto.fecha, dto.coste);
	}
}
