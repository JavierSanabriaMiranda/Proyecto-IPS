package backend.data.ventas.commands;

import java.sql.Timestamp;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class AddVentas {

    private static final String QUERY = "INSERT INTO VENTAS "
            + "(ID_VENTAS, DNI, FECHA, COSTE) "
            + "VALUES (?, ?, ?, ?)";

    private VentaDto venta;
    private Database db = new Database();

    public AddVentas(VentaDto venta) {
        this.venta = venta;
    }

    public void execute() {
    	// Convertir la fecha a Timestamp para incluir horas y minutos
        Timestamp timestamp = new Timestamp(venta.fecha.getTime());

        // Comprobar si el DNI es nulo
        if (venta.DNI == null) {
            db.executeUpdate(QUERY, venta.idVenta, null, timestamp, venta.coste);
        } else {
            db.executeUpdate(QUERY, venta.idVenta, venta.DNI, timestamp, venta.coste);
        }
    }
}

