package backend.data.entrevistas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.Database;
import backend.data.entrevistas.FranjaEntrevistaDTO;

public class FindFranjaByJugadorIdAndDate {

	
	private static final String QUERY = "SELECT ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN "
			+ "FROM FRANJA_ENTREVISTA "
			+ "WHERE ID_JUGADOR = ? AND FECHA = ?";
	
	private Database db = new Database();
	private String idJugador;
	private Date fecha;
	
	public FindFranjaByJugadorIdAndDate(String idJugador, Date fecha) {
		this.idJugador = idJugador;
		this.fecha = fecha;
	}
	
	public List<FranjaEntrevistaDTO> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<FranjaEntrevistaDTO> franjas = new ArrayList<>();

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setString(1, idJugador);
			pst.setDate(2, new java.sql.Date(fecha.getTime()));
			
			rs = pst.executeQuery();
			
			franjas = toDtoList(rs);
			
			return franjas;
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
	
	public List<FranjaEntrevistaDTO> toDtoList(ResultSet rs) throws SQLException {
		List<FranjaEntrevistaDTO> res = new ArrayList<>();
		while (rs.next()) {
			res.add(toDto(rs));
		}
		return res;
	}

	public FranjaEntrevistaDTO toDto(ResultSet rs) throws SQLException {
		FranjaEntrevistaDTO res = new FranjaEntrevistaDTO();
		res.id_jugador = rs.getString("id_jugador");
		res.fecha = rs.getDate("fecha");
		res.hora_inicio = rs.getTime("hora_inicio");
		res.hora_fin = rs.getTime("hora_fin");
		return res;
	}
}
