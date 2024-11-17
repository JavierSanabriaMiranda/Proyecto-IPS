package backend.data.abonos;

import java.util.Optional;

public interface AbonosCRUDService {

	Optional<AbonoDTO> findAbonoByCode(String cod);
}
