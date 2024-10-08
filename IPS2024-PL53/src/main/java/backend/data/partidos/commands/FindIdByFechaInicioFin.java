package backend.data.partidos.commands;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.partidos.PartidoDTO;

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
	
	public FindIdByFechaInicioFin(String fecha, String inicio, String fin) {
		this.fecha = Date.valueOf(fecha); 
		this.inicio = Time.valueOf(inicio);
		this.fin = Time.valueOf(fin);
	}

	public String execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			pst.setDate(1, fecha);
			pst.setTime(2, inicio);
			pst.setTime(3, fin);
			
			rs = pst.executeQuery();
			
			return rs.getString("id_partido");
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
