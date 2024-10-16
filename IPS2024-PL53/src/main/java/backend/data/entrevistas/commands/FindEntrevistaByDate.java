package backend.data.entrevistas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import backend.data.Database;
import backend.data.entrevistas.EntrevistaDTO;

public class FindEntrevistaByDate {

	private Database db = new Database();
	private EntrevistaDTO entrevista;
	private Date fecha;
	
	private static final String QUERY = "SELECT "
			+ "COD_ENTREVISTA, ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN, MEDIO_COMUNICACION"
			+ " FROM ENTREVISTA WHERE FECHA = ?";
	
	
	public FindEntrevistaByDate(Date fecha) {
		this.fecha = fecha;
	}
	
	public EntrevistaDTO execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setDate(1, new java.sql.Date(fecha.getTime()));
			
			rs = pst.executeQuery();
			
			entrevista = null;
			
			if (rs.next()) {
				entrevista = new EntrevistaDTO();
				entrevista.cod_entrevista = rs.getString("cod_entrevista");
				entrevista.id_jugador = rs.getString("id_jugador");
				entrevista.fecha = rs.getDate("fecha");
				entrevista.hora_inicio = rs.getTime("hora_inicio");
				entrevista.hora_fin = rs.getTime("hora_fin");
				entrevista.medio_comunicacion = rs.getString("medio_comunicacion");
			}
			
			return entrevista;
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
