package backend.data.partidos.commands;

import java.sql.Connection;
import java.sql.Date; // Asegúrate de usar java.sql.Date
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.partidos.PartidoDTO;

public class FindAllPartidos {

    private static final String QUERY = "SELECT ID_PARTIDO, HORA_INICIO, HORA_FIN, FECHA, ID_EQUIPO "
            + "FROM PARTIDO WHERE FECHA > ? ORDER BY FECHA ASC";

    private Database db = new Database();

    public List<PartidoDTO> execute() {
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PartidoDTO> result = new ArrayList<>();

        try {
            c = db.getConnection();

<<<<<<< HEAD
            pst = c.prepareStatement(QUERY);
            // Establecer la fecha actual como parámetro
            pst.setDate(1, Date.valueOf(LocalDate.now()));

            rs = pst.executeQuery();
            result = toDtoList(rs);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    /* ignore */
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    /* ignore */
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    /* ignore */
                }
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
        PartidoDTO res = new PartidoDTO();
        res.id = rs.getString("id_partido");

        res.horaInicio = rs.getTime("hora_inicio");
        res.horaFin = rs.getTime("hora_fin");

        res.fecha = rs.getDate("fecha");

        res.idEquipo = rs.getString("id_equipo");
        return res;
    }
=======
	public PartidoDTO toDto(ResultSet rs) throws SQLException {
		PartidoDTO res = new PartidoDTO(); 
		res.id = rs.getString("id_partido");
		
		res.horaInicio = rs.getTime("hora_inicio");
		res.horaFin = rs.getTime("hora_fin");
		
		res.fecha = rs.getDate("fecha");
		
		res.idEquipo = rs.getString("id_equipo");
		return res;
	}
>>>>>>> refs/heads/master
}
