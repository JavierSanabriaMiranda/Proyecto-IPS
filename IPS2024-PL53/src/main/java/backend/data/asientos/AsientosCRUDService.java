package backend.data.asientos;

public interface AsientosCRUDService {

	void addAsiento(AsientoDTO dtoA);

	AsientoDTO findByIdAsiento(String idAsiento);

}
