package backend.data.asientos;

public interface AsientosCRUDService {

	void addAsiento(AsientoDTO dtoA);

	AsientoDTO findByIdAsiento(String idAsiento);

	AsientoDTO findEqualAsiento(String tribuna,String seccion, String fila, String asiento);
}
