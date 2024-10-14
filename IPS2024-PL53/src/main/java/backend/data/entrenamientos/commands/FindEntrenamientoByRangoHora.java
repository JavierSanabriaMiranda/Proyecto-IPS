package backend.data.entrenamientos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.Database;
import backend.data.entrenamientos.EntrenamientoDto;

public class FindEntrenamientoByRangoHora {

	private Database db = new Database();
	private Date fecha;
	private Time inicio;
	private Time fin;
	
	private static final String QUERY = "SELECT "
			+ "ID_ENTRENAMIENTO, FECHA, HORA_INICIO, HORA_FIN, COD_INSTALACION, ID_EQUIPO "
			+ "FROM ENTRENAMIENTO WHERE FECHA = ? AND "
			+ "(HORA_INICIO <= ? AND HORA_FIN >= ?) OR "
			+ "(HORA_INICIO >= ? AND HORA_INICIO <= ?) OR "
			+ "(HORA_FIN >= ? AND HORA_FIN <= ?)";
	
	
	public FindEntrenamientoByRangoHora(Date fecha, Time inicio, Time fin) {
		this.fecha = fecha;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public List<EntrenamientoDto> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			pst.setDate(1, new java.sql.Date(fecha.getTime()));
			
            pst.setTime(2, fin);
            pst.setTime(3, inicio);
            pst.setTime(4, inicio);
            pst.setTime(5, fin);
            pst.setTime(6, inicio);
            pst.setTime(7, fin);
			
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
	
	public List<EntrenamientoDto> toDtoList(ResultSet rs) throws SQLException {
		List<EntrenamientoDto> res = new ArrayList<>();
		while (rs.next()) {
			res.add(toDto(rs));
		}
		return res;
	}

	public EntrenamientoDto toDto(ResultSet rs) throws SQLException {
		EntrenamientoDto entrenamiento = new EntrenamientoDto();
		entrenamiento.idEntrenamiento = rs.getString("id_entrenamiento");
		entrenamiento.fecha = rs.getDate("fecha");
		entrenamiento.horaInicio = rs.getTime("hora_inicio");
		entrenamiento.horaFinal = rs.getTime("hora_fin");
		entrenamiento.codInstalacion = rs.getString("cod_instalacion");
		entrenamiento.idEquipo = rs.getString("id_equipo");
		return entrenamiento;
	}
}
