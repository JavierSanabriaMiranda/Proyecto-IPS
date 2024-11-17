package backend.data.asientos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.data.Database;

public class IsAsientoOcupadoPorAbono {

    private static final String QUERY = 
        "SELECT COUNT(*) " +
        "FROM ABONO_TEMPORADA " +
        "WHERE ID_ASIENTO = ?";

    private String idAsiento;
    private Database db = new Database();

    // Constructor para recibir el ID del asiento
    public IsAsientoOcupadoPorAbono(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    // Método para ejecutar la consulta
    public boolean execute() {
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = db.getConnection();
            pst = c.prepareStatement(QUERY);
            pst.setString(1, idAsiento);

            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si hay registros, false si no
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar si el asiento está ocupado por un abono", e);
        } finally {
            // Liberar recursos
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (pst != null) {
                try { pst.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (c != null) {
                try { c.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
}
