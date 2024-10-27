package shared.gestioncampania;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import backend.service.ventas.campanaAccionistas.Accionista;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas.EstadoCampania;

public class GestorDeCampanias implements GestorCampania {
	
	private Random random = new Random();
	private Map<String, Accionista> accionistas = new HashMap<>();
	private CampaniaAccionistas campania;

	@Override
	public void addAccionista(Accionista accionista) {
		if (accionista == null)
			throw new IllegalArgumentException("El accionista a añadir no puede ser nulo");
		accionistas.put(accionista.getIdAccionista(), accionista);
	}

	@Override
	public String addNuevoAccionista(Accionista accionista) {
		if (accionista == null)
			throw new IllegalArgumentException("El accionista a añadir no puede ser nulo");
		String newId = generarNuevoIdAccionista();
		accionista.setIdAccionista(newId);
		return newId;
	}
	
	/**
	 * Genera un nuevo id de accionista que no exista con el formato "AXXXXXXXX" 
	 * donde las X son números aleatorios
	 * @return nuevo id de accionista que no existe
	 */
	private String generarNuevoIdAccionista() {
		String newId = "";
		do {
			int numId = random.nextInt(10000000);
			newId = "A" + numId;	
		} while (accionistas.containsKey(newId));
		return newId;
	}

	@Override
	public CampaniaAccionistas crearCampania(int numAcciones) {
		if (numAcciones <= 0)
			throw new IllegalArgumentException("El número de acciones a vender no puede ser 0 o negativo");
		String id = UUID.randomUUID().toString().substring(0, 16);
		
		
		this.campania = new CampaniaAccionistas(id, numAcciones, numAcciones, 1, EstadoCampania.ABIERTA);
		return campania;
	}

	@Override
	public void cargarCampania(CampaniaAccionistas campania) {
		if (campania == null)
			throw new IllegalArgumentException("La campaña no puede ser null");
		this.campania = campania;
	}

	@Override
	public int getFaseCampania() {
		return campania.getFase();
	}

	@Override
	public void avanzarFase() {
		campania.avanzarFase();
	}

	@Override
	public boolean isCampaniaFinalizada() {
		return campania.getEstado().equals(EstadoCampania.FINALIZADA);
	}

	@Override
	public int getAccionesVendidas() {
		return campania.getNumAccionesIniciales() - campania.getNumAccionesRestantes();
	}

	@Override
	public CampaniaAccionistas getCampania() {
		return this.campania;
	}

}
