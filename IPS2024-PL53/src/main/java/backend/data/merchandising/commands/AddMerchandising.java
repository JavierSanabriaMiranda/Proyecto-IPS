package backend.data.merchandising.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.data.Database;
import backend.data.merchandising.MerchandisingDTO;

public class AddMerchandising {
    private static final String QUERY = "INSERT INTO COMPRA_MERCHANDISING VALUES (?)";
    private Database db = new Database();
    private String codCompra;

    public AddMerchandising(MerchandisingDTO merchandisingDTO) {
        this.codCompra = merchandisingDTO.getCodigoCompra();
    }

    public void execute() throws SQLException {
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {

            pst.setString(1, codCompra);
            pst.executeUpdate();
        }
    }
}
