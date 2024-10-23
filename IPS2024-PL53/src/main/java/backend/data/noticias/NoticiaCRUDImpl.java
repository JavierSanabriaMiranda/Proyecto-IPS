package backend.data.noticias;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.noticias.commands.AddNoticia;
import backend.data.noticias.commands.FindNoticias;

public class NoticiaCRUDImpl implements NoticiaCRUDService {
	@Override
	public void addNoticia(NoticiaDTO noticia,  List<ImagenDTO> imagenes) {
        try {
            new AddNoticia(noticia,imagenes).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	@Override
    public List<NoticiaDTO> findNoticias() {
        List<NoticiaDTO> res = new ArrayList<>();
        try {
            res = new FindNoticias().execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
