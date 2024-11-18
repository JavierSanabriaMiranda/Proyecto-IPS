package backend.data.noticias;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.noticias.commands.AddNoticia;
import backend.data.noticias.commands.FindImagenesNoticia;
import backend.data.noticias.commands.FindNoticias;
import backend.util.log.LogManager;

public class NoticiaCRUDImpl implements NoticiaCRUDService {
	@Override
	public void addNoticia(NoticiaDTO noticia,  List<ImagenDTO> imagenes) {
        try {
        	LogManager.logAction("Modificación en Base de Datos. Tabla: NOTICIA");
            new AddNoticia(noticia,imagenes).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	@Override
    public List<NoticiaDTO> findNoticias() {
        List<NoticiaDTO> res = new ArrayList<>();
        try {
        	LogManager.logAction("Acceso a Base de Datos. Tabla: NOTICIA");
            res = new FindNoticias().execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

	@Override
	public List<String> findImagenesNoticia(String codNoticia) {
		List<String> res = new ArrayList<>();
        try {
        	LogManager.logAction("Acceso a Base de Datos. Tabla: NOTICIA");
            res = new FindImagenesNoticia(codNoticia).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
	}
}
