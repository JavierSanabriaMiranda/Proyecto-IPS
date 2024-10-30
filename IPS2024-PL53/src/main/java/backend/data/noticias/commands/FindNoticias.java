package backend.data.noticias.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.noticias.NoticiaDTO;

public class FindNoticias {
	private static final String QUERY = "SELECT * FROM NOTICIA";
    private Database db = new Database();

    public List<NoticiaDTO> execute() throws SQLException {
        List<NoticiaDTO> noticias = new ArrayList<>();
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                NoticiaDTO noticia = new NoticiaDTO(
                    rs.getString("COD_NOTICIA"),
                    rs.getString("TITULO"),
                    rs.getString("TEXTO")
                );
                noticias.add(noticia);
            }
        }
        return noticias;
    }

}
