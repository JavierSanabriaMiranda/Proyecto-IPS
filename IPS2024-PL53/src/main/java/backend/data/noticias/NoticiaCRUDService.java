package backend.data.noticias;

import java.util.List;

public interface NoticiaCRUDService {
	
	void addNoticia(NoticiaDTO noticia, List<ImagenDTO> imagenes);
	
	List<NoticiaDTO> findNoticias();

	List<String> findImagenesNoticia(String codNoticia);
}
