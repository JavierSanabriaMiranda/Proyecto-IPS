package backend.data.empleados.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.data.Database;

public class FindIdEquipoByJugadorId {

	private Database db = new Database();
	private String idJugador;
	
	private static final String QUERY = "SELECT ID_EQUIPO "
			+ "FROM JUGADOR "
			+ "WHERE ID_JUGADOR = ?";
	
	public FindIdEquipoByJugadorId(String idJuagdor) {
		this.idJugador = idJuagdor;
	}
	
	public String execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setString(1, idJugador);
			
			rs = pst.executeQuery();
			
			String idEquipo = null;
			
			if (rs.next()) {
				idEquipo = rs.getString("id_equipo");
			}
			
			return idEquipo;
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
