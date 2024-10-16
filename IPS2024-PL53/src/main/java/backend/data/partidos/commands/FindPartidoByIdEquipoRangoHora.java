package backend.data.partidos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.Database;
import backend.data.partidos.PartidoDTO;

public class FindPartidoByIdEquipoRangoHora {

	private Database db = new Database();
	private String idEquipo;
	private Date fecha;
	private Time inicio;
	private Time fin;
	
	private static final String QUERY = "SELECT "
			+ "ID_PARTIDO, HORA_FIN, HORA_INICIO, FECHA, ID_EQUIPO "
			+ "FROM PARTIDO WHERE FECHA = ? AND ID_EQUIPO = ? AND "
			+ "((HORA_INICIO <= ? AND HORA_FIN >= ?) OR "
			+ "(HORA_INICIO >= ? AND HORA_INICIO <= ?) OR "
			+ "(HORA_FIN >= ? AND HORA_FIN <= ?))";
	
	public FindPartidoByIdEquipoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		this.idEquipo = idEquipo;
		this.fecha = fecha;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public List<PartidoDTO> execute(){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setDate(1, new java.sql.Date(fecha.getTime()));
			pst.setString(2, idEquipo);
			
            pst.setTime(3, fin);
            pst.setTime(4, inicio);
            pst.setTime(5, inicio);
            pst.setTime(6, fin);
            pst.setTime(7, inicio);
            pst.setTime(8, fin);
			
			rs = pst.executeQuery();
			
			return toDtoList(rs);
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
	
	public List<PartidoDTO> toDtoList(ResultSet rs) throws SQLException {
		List<PartidoDTO> res = new ArrayList<>();
		while (rs.next()) {
			res.add(toDto(rs));
		}
		return res;
	}

	public PartidoDTO toDto(ResultSet rs) throws SQLException {
		PartidoDTO partido = new PartidoDTO();
		
		partido.id = rs.getString("id_partido");
		partido.horaFin = rs.getTime("hora_fin");
		partido.horaInicio= rs.getTime("hora_inicio");
		partido.fecha = rs.getDate("fecha");
		partido.idEquipo = rs.getString("id_equipo");
		
		return partido;
	}
}
