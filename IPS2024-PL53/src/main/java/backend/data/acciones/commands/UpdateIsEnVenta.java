package backend.data.acciones.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.data.Database;
import backend.data.acciones.AccionDTO;

public class UpdateIsEnVenta {
    private static final String QUERY = "UPDATE ACCION SET isEnVenta = ? WHERE ID_ACCION = ?";

    private Database db = new Database();
    private AccionDTO accion;
    private boolean estado;

    public UpdateIsEnVenta(AccionDTO accion, boolean estado) {
        this.accion = accion;
        this.estado = estado;
    }

    public void execute() throws SQLException {
        try (Connection connection = db.getConnection();
             PreparedStatement pst = connection.prepareStatement(QUERY)) {
            pst.setBoolean(1, estado);
            pst.setString(2, accion.getIdAccion());

            pst.executeUpdate();
        }
    }
}

