package backend.data.entradas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.entradas.EntradaDTO;

public class FindByIDPartidoEntrada {

	private static final String QUERY = "SELECT COD_ENTRADA, TRIBUNA, SECCION, N_FILA, N_ASIENTO, ID_PARTIDO "
            + "FROM ENTRADA "
            + "WHERE ID_PARTIDO = ?";

	private Database db = new Database();
	String idPartido;
	
	public FindByIDPartidoEntrada(String idPartido) {
		this.idPartido = idPartido;
	}
	
	
	public List<EntradaDTO> execute() throws SQLException{
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			List<EntradaDTO> result = new ArrayList<>();

			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(QUERY);
				pst.setString(1, idPartido);
				
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

	public List<EntradaDTO> toDtoList(ResultSet rs) throws SQLException {
		List<EntradaDTO> res = new ArrayList<>();
		while (rs.next()) {
			res.add(toDto(rs));
		}
		return res;
	}

	public EntradaDTO toDto(ResultSet rs) throws SQLException {
		EntradaDTO res = new EntradaDTO();
		res.cod_entrada = rs.getString("cod_entrada");
		res.tribuna = rs.getString("tribuna");
		res.seccion = rs.getString("seccion");
		
		res.nFila = rs.getInt("n_fila");
		res.nAsiento = rs.getInt("n_asiento");
		
		res.idPartido = rs.getString("id_partido");
		return res;
	}
}
