package backend.data.empleados.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class FindJugadoresProfesionales {

	private List<EmpleadoDTO> jugadores;
	private Database db = new Database();
	
	
	private static final String QUERY = "SELECT ED.ID_EMPLEADO_DEP AS ID_JUGADOR, ED.NOMBRE, "
			+ "ED.APELLIDO, ED.DNI, ED.TELEFONO, ED.FECHA_NACIMIENTO, ED.SALARIO_ANUAL "
			+ "FROM JUGADOR J "
			+ "INNER JOIN EMPLEADO_DEPORTIVO ED ON J.ID_JUGADOR = ED.ID_EMPLEADO_DEP "
			+ "INNER JOIN EQUIPO_PROFESIONAL EP ON J.ID_EQUIPO = EP.ID_EQUIPO;";
	
	public List<EmpleadoDTO> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<EmpleadoDTO> result = new ArrayList<>();

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(QUERY);
			
			rs = pst.executeQuery();
			result = toDtoList(rs);
			return result;
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
	
	public List<EmpleadoDTO> toDtoList(ResultSet rs) throws SQLException {
		List<EmpleadoDTO> res = new ArrayList<>();
		while (rs.next()) {
			res.add(toDto(rs));
		}
		return res;
	}

	public EmpleadoDTO toDto(ResultSet rs) throws SQLException {
		EmpleadoDTO res = new EmpleadoDTO();
		res.id = rs.getString("id_jugador");
		res.nombre = rs.getString("nombre");
		res.apellido = rs.getString("apellido");
		res.DNI = rs.getString("dni");
		res.telefono = rs.getString("telefono");
		res.fechaNac = rs.getDate("fecha_nacimiento");
		res.salarioAnual = rs.getBigDecimal("salario_anual").doubleValue();
		return res;
	}
}
