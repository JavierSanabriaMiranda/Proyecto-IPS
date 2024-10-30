package shared.gestioncampania;

import java.util.Optional;

import backend.data.CreadorDataService;
import backend.data.accionistas.AccionistaDTO;
import backend.data.accionistas.AccionistasCRUDService;
import backend.data.campaniaaccionistas.AccionistaEnCampaniaDTO;
import backend.data.campaniaaccionistas.CampaniaAccionistasCRUDService;
import backend.data.campaniaaccionistas.CampaniaDTO;
import backend.data.campaniaaccionistas.DtoAssembler;
import backend.service.ventas.campanaAccionistas.Accionista;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;

public class GestionCampaniaShared {

	private GestorCampania gestor = new GestorDeCampanias();
	private CampaniaAccionistasCRUDService serviceCampania = CreadorDataService.getCampaniasService();
	private AccionistasCRUDService serviceAccionista = CreadorDataService.getAccionistasService();
	private String dniClienteNoRegistrado;


	public void crearCampania(int numAcciones) {
		// Crear el objeto campaña
		CampaniaAccionistas newCampania = gestor.crearCampania(numAcciones);
		// Guardar los datos de la campaña en la BBDD
		serviceCampania.crearCampania(DtoAssembler.toDto(newCampania));
	}

	/**
	 * Carga la campania que se estaba llevando a cabo durante la última ejecución de la aplicación si es que
	 * la hay
	 * 
	 * @return true si existia una campaña en curso, false en caso contrario
	 */
	public boolean cargarCampaniaEnCurso() {
		Optional<CampaniaDTO> optDTO = serviceCampania.findEnCurso();
		if (optDTO.isEmpty())
			return false;
		CampaniaDTO dto = optDTO.get();
		CampaniaAccionistas campania = DtoAssembler.dtoToCampania(dto);
		gestor.cargarCampania(campania);
		return true;
	}
	
	public int getFaseCampania() {
		return gestor.getFaseCampania();
	}
	
	public void avanzarFase() {
		gestor.avanzarFase();
		
		actualizarCampaniaEnBBDD();
	}
	
	private void actualizarCampaniaEnBBDD() {
		CampaniaAccionistas c = gestor.getCampania();
		serviceCampania.actualizarCampania(DtoAssembler.toDto(c));
	}

	public boolean isCampaniaFinalizada() {
		return gestor.isCampaniaFinalizada();
	}

	public int getAccionesVendidas() {
		return gestor.getAccionesVendidas();
	}

	/**
	 * Comprueba si el dni introducido pertenece a un accionista y de ser así, lo guarda como atributo de la clase
	 * 
	 * @return true si el dni pertenece a un accionista, false en caso contrario
	 */
	public boolean esAccionista(String dni) {
		Optional<AccionistaDTO> optAccionista = serviceAccionista.findByDniAccionista(dni);
		if (optAccionista.isEmpty()) {
			dniClienteNoRegistrado = dni;
			return false;
		}
			
		// Si hay un accionista se guarda en el gestor
		gestor.addAccionista(backend.data.accionistas.DtoAssembler.dtoToAccionista(optAccionista.get()));
		return true;
	}

	/**
	 * Comprueba si el accionista ya figura en la base de datos como accionista que ha accedido a la campaña actual
	 * y en caso contrario se le registra
	 */
	public void registrarAccionista() {
		Accionista acc = gestor.getAccionista();
		Optional<AccionistaEnCampaniaDTO> optAcc = serviceCampania.getAccionistaEnCampaniaByDni(acc.getIdAccionista());
		if (optAcc.isEmpty()) {
			int numAccionesIniciales = serviceAccionista.getNumAccionesByDniAccionista(acc.getDni());
			
			String idAccionista = acc.getIdAccionista();
			String codCampania = gestor.getCampania().getCodigoCampania();
			gestor.setAccionesIniciales(0);
			gestor.setAccionesCompradas(0);
			// Se registra el primer acceso del accionista en la base de datos
			serviceCampania.addAccionistaEnCampania(idAccionista, codCampania, numAccionesIniciales);
		} else {
			AccionistaEnCampaniaDTO accEnCampania = optAcc.get();
			gestor.setAccionesIniciales(accEnCampania.numAccionesIniciales);
			gestor.setAccionesCompradas(accEnCampania.numAccionesCompradas);
		}
			
			
	}

	public int getAccionesRestantesCampania() {
		return gestor.getAccionesRestantesCampania();
	}

	public int getAccionesInicialesAccionista() {
		return gestor.getAccionesInicialesAccionista();
	}
	
	public int getNumAccionesCompradasAccionista() {
		return gestor.getNumAccionesCompradasAccionista();
	}

	public double getPrecioAcciones() {
		return gestor.getPrecioAcciones();
	}

	/**
	 * @return accionista o null si el cliente no está registrado como accionista
	 */
	public Accionista getAccionista() {
		return gestor.getAccionista();
	}

	public void registrarClienteComoNuevoAccionista(String nombre) {
		Accionista acc = new Accionista(dniClienteNoRegistrado, nombre);
		acc.setIdAccionista(gestor.addNuevoAccionista(acc)); 
		
		AccionistaDTO dtoAcc = backend.data.accionistas.DtoAssembler.toDto(acc);
		serviceAccionista.addNuevoAccionista(dtoAcc);
		
		CampaniaAccionistas campania = gestor.getCampania();
		
		serviceCampania.addAccionistaEnCampania(acc.getIdAccionista(), campania.getCodigoCampania(), 0);
	}

	
}
