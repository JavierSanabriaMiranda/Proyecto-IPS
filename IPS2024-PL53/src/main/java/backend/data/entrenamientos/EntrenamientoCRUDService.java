package backend.data.entrenamientos;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface EntrenamientoCRUDService {
	
	public List<EntrenamientoDto> cargarEntrenamientos();
	List<EntrenamientoDto> findEntrenamientoByRangoHora(Date fecha, Time inicio, Time fin);
}
