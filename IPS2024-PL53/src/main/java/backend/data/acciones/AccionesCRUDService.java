package backend.data.acciones;

import java.util.List;

import backend.service.ventas.campanaAccionistas.Accion;

public interface AccionesCRUDService {
	List<AccionDTO> findAccionesByDNI(String DNI);
	void addAcciones(List<AccionDTO> dtosAcc);
	void updateIsEnVenta(AccionDTO accion, boolean estado);
	List<AccionDTO> getAccionesEnVentaParaAccionista(String idAccionista);
}
