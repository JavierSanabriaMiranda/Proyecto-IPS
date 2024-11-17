package backend.data.entradas;

import java.util.List;
import java.util.Optional;

public interface EntradasCRUDService {

	void addEntrada(EntradaDTO entrada);
	
	List<EntradaDTO> findAllEntrada();
	
	List<EntradaDTO> findByIDPartidoEntrada(String idPartido);
	
	Optional<EntradaDTO> findEntradaByAsientoAndPartido(String idAsiento, String idPartido);
}
