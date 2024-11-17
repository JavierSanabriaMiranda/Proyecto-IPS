package backend.data.asientos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.data.Database;

public class IsAsientoOcupadoPorEntrada {

    private static final String QUERY = 
        "SELECT COUNT(*) " +
        "FROM ENTRADA " +
        "WHERE ID_ASIENTO = ? AND ID_PARTIDO = ?";

    private String idAsiento;
    private String idPartido;
    private Database db = new Database();

    // Constructor para recibir el ID del asiento y el ID del partido
    public IsAsientoOcupadoPorEntrada(String idAsiento, String idPartido) {
        this.idAsiento = idAsiento;
        this.idPartido = idPartido;
    }

    public boolean execute() {
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = db.getConnection();
            pst = c.prepareStatement(QUERY);
            pst.setString(1, idAsiento);
            pst.setString(2, idPartido);

            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar si el asiento está ocupado por una entrada", e);
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
