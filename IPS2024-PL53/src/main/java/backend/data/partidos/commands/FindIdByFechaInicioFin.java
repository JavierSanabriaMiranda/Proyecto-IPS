package backend.data.partidos.commands;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import backend.data.Database;

public class FindIdByFechaInicioFin {
	
	private static final String QUERY = "SELECT ID_PARTIDO "
			+ "FROM PARTIDO "
			+ "WHERE FECHA = ?"
			+ "AND HORA_INICIO = ? "
			+ "AND HORA_FIN = ?";
	
	private Date fecha;
	private Time inicio;
	private Time fin;
	
	private Database db = new Database();
	
	public FindIdByFechaInicioFin(Date fecha, Time inicio, Time fin) {
		this.fecha = fecha; 
		this.inicio = inicio;
		this.fin = fin;
	}

	public String execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setDate(1, new java.sql.Date(fecha.getTime()));
			pst.setTime(2, inicio);
			pst.setTime(3, fin);
			
			rs = pst.executeQuery();
			
			String id = null;
			
			if (rs.next()) {
				id = rs.getString("id_partido");
			}
			
			return id;
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
