package backend.data.productos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import backend.data.Database;
import backend.data.productos.dtos.VentaDto;

public class AddVenta {
    private static final String QUERY = "INSERT INTO VENTAS VALUES (?, ?, ?, ?)";
    private Database db = new Database();
    private String codVenta;
    private String dni;
    private Date fecha;
    private Float precio;

    public AddVenta(VentaDto ventaDTO) {
		this.codVenta=ventaDTO.getIdVenta();
		this.dni=ventaDTO.getDNI();
		this.fecha=ventaDTO.getFecha();
		this.precio=ventaDTO.getCoste();
	}

	public void execute() throws SQLException {
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {

            pst.setString(1, codVenta);
            
            // Verificar si dni es nulo
            if (dni != null) {
                pst.setString(2, dni);
            } else {
                pst.setNull(2, java.sql.Types.VARCHAR);
            }
            
            pst.setDate(3, new java.sql.Date(fecha.getTime()));
            pst.setFloat(4, precio);
            pst.executeUpdate();
        }
    }
}
