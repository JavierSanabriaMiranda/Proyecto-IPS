package backend.data.ventas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.entradas.EntradaDTO;
import backend.data.ventas.VentasDTO;

public class FindByCodVentas {
	private static final String QUERY = "SELECT ID_VENTAS, DNI, FECHA, COSTE"
			+ "FROM VENTAS"
			+ "WHERE ID_VENTAS = ?";

	VentasDTO dto;
	private Database db = new Database();
	String id;
	
	public FindByCodVentas(String id) {
		this.id = id;
	}
	
	public VentasDTO execute() {
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
				dto = new VentasDTO();
				dto.id_ventas = rs.getString("id_ventas");
				dto.dni = rs.getString("dni");
				dto.fecha = rs.getDate("fecha");
				dto.coste = rs.getBigDecimal("coste");
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
