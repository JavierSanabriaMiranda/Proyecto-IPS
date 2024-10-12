package backend.data.entradas;

import java.util.List;

public interface EntradasCRUDService {

	void addEntrada(EntradaDTO entrada);
	
	List<EntradaDTO> findAllEntrada();
	
	List<EntradaDTO> findByIDPartidoEntrada(String idPartido);
}
