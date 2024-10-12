package backend.data.ventas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import backend.data.Database;
import backend.data.ventas.VentaDto;

public class FindByCodVentas {
	private static final String QUERY = "SELECT ID_VENTAS, DNI, FECHA, COSTE "
			+ "FROM VENTAS "
			+ "WHERE ID_VENTAS = ?";

	VentaDto dto;
	private Database db = new Database();
	String id;
	
	public FindByCodVentas(String id) {
		this.id = id;
	}
	
	public VentaDto execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		dto = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				dto = new VentaDto();
				dto.idVenta = rs.getString("id_ventas");
				dto.DNI = rs.getString("dni");
				dto.fecha = rs.getDate("fecha");
				dto.coste = rs.getFloat("coste");
			}
			
			return dto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (rs != null) {
                try { rs.close(); } catch(SQLException e) { /* ignore */ }
            }
			if (pst != null) {
                try { pst.close(); } catch(SQLException e) { /* ignore */ }
            }
			if (c != null) {
                try { c.close(); } catch(SQLException e) { /* ignore */ }
            }
		}
	}

}
