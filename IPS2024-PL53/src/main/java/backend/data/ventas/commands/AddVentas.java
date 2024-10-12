package backend.data.ventas.commands;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class AddVentas {
	
	private static final String QUERY = "INSERT INTO VENTAS "
			+ "(ID_VENTAS, DNI, FECHA, COSTE)"
			+ "VALUES (?, ?, ?, ?)";
	
	VentaDto venta;
	private Database db = new Database();
	
	
	public AddVentas(VentaDto venta) {
		this.venta = venta;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, venta.idVenta, venta.DNI, venta.fecha, venta.coste);
	}

}
