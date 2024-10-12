package backend.data.clientes.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.clientes.ClienteDTO;

public class FindByDniCliente {

	private static final String QUERY = "SELECT DNI, NOMBRE "
            + "FROM CLIENTE "
            + "WHERE DNI = ?";

	private Database db = new Database();
	String dni;
	
	public FindByDniCliente(String dni) {
		this.dni = dni;
	}
	
	public ClienteDTO execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ClienteDTO dto = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			pst.setString(1, dni);
			
			rs = pst.executeQuery();

			if (rs.next()) {
				dto = new ClienteDTO();
				dto.dni = rs.getString("dni");
				dto.nombre = rs.getString("nombre");
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
