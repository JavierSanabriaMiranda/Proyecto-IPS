package backend.data.noticias.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;

public class FindImagenesNoticia {
    private static final String QUERY = "SELECT NOMBRE FROM IMAGEN WHERE COD_NOTICIA = ?";
    private Database db = new Database();
    private String codNoticia;

    public FindImagenesNoticia(String codigoNoticia) {
        this.codNoticia = codigoNoticia;
    }

    public List<String> execute() throws SQLException {
        List<String> imagenes = new ArrayList<>();

        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {
            
            pst.setString(1, codNoticia);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    imagenes.add(rs.getString("NOMBRE"));
                }
            }
        }

        return imagenes;
    }
}
