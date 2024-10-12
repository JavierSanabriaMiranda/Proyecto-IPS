package backend.data.ventas.commands;

import backend.data.Database;
import backend.data.ventas.VentasDTO;

public class AddVentas {
	
	private static final String QUERY = "INSERT INTO VENTAS "
			+ "(ID_VENTAS, DNI, FECHA, COSTE)"
			+ "VALUES (?, ?, ?, ?)";
	
	VentasDTO venta;
	private Database db = new Database();
	
	
	public AddVentas(VentasDTO venta) {
		this.venta = venta;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, venta.id_ventas, venta.dni, venta.fecha, venta.coste);
	}

}
