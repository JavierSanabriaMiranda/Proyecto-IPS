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
import backend.service.ventas.campanaAccionistas.Accionista;

public class GestionCompraVentaAccionesShared {
	
	private GestorCompraVentaAcciones gestor = new GestorCompraAccionesEntreAccionistas();
	private AccionesCRUDService serviceAcciones = CreadorDataService.getAccionesService();
	private AccionistasCRUDService serviceAccionistas = CreadorDataService.getAccionistasService();
	private String dniAccionista;
	private Accionista accionista;
	
	public GestionCompraVentaAccionesShared(String dniAccionista) {
		this.dniAccionista = dniAccionista;
	}

	/**
	 * Carga el accionista de la base de datos por medio del dni ya guardado, y obtiene las acciones que se encuentran
	 * disponibles para que dicho accionista las compre
	 * @return lista de acciones en venta para el accionista
	 */
	public List<Accion> getAccionesEnVenta() {
		getAccionista();
		
		List<AccionDTO> accionesEnVentaDTOs = serviceAcciones.getAccionesEnVentaParaAccionista(accionista.getIdAccionista());
		return DtoAssembler.toAccionList(accionesEnVentaDTOs);
	}

	private void getAccionista() {
		Optional<AccionistaDTO> optAccionista = serviceAccionistas.findByDniAccionista(dniAccionista);
		if (optAccionista.isEmpty())
			throw new IllegalStateException("El programa se encuentra en un estado inconsistente pues el "
					+ "accionista que ha accedido al portal de compra de acciones, no es un accionista");
		AccionistaDTO dtoAccionista = optAccionista.get();
		accionista = backend.data.accionistas.DtoAssembler.dtoToAccionista(dtoAccionista);
	}

	public void comprarAccion(Accion acc) {
		acc.setEnVenta(false);
		AccionDTO dto = DtoAssembler.toDto(acc, accionista.getIdAccionista());
		dto.setEnVenta(false);
		
		serviceAcciones.updateAccion(dto);
	}

}
