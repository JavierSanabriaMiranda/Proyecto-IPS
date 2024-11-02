package shared.gestionAcciones;

import java.util.List;
import java.util.Optional;

import backend.data.CreadorDataService;
import backend.data.acciones.AccionDTO;
import backend.data.acciones.AccionesCRUDService;
import backend.data.acciones.DtoAssembler;
import backend.data.accionistas.AccionistaDTO;
import backend.data.accionistas.AccionistasCRUDService;
import backend.service.ventas.campanaAccionistas.Accion;

public class GestionCompraVentaAccionesShared {
	
	private String dniAccionista;
	private GestorCompraVentaAcciones gestor = new GestorCompraAccionesEntreAccionistas();
	private AccionesCRUDService serviceAcciones = CreadorDataService.getAccionesService();
	private AccionistasCRUDService serviceAccionistas = CreadorDataService.getAccionistasService();
	
	public GestionCompraVentaAccionesShared(String dniAccionista) {
		this.dniAccionista = dniAccionista;
	}

	public List<Accion> getAccionesEnVenta() {
		Optional<AccionistaDTO> optAccionista = serviceAccionistas.findByDniAccionista(dniAccionista);
		if (optAccionista.isEmpty())
			throw new IllegalStateException("El programa se encuentra en un estado inconsistente pues el "
					+ "accionista que ha accedido al portal de compra de acciones, no es un accionista");
		AccionistaDTO dtoAccionista = optAccionista.get();
		
		List<AccionDTO> accionesEnVentaDTOs = serviceAcciones.getAccionesEnVentaParaAccionista(dtoAccionista.idAccionista);
		return DtoAssembler.toAccionList(accionesEnVentaDTOs);
	}

}
