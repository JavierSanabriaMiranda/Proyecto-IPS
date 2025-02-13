package shared.gestioncampania;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import backend.service.ventas.campanaAccionistas.Accion;
import backend.service.ventas.campanaAccionistas.Accionista;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas.EstadoCampania;

public class GestorDeCampanias implements GestorCampania {

	// Accionista que ha hecho el ingreso a la campaña
	private Accionista accionista; 
	private int numAccionesInicialesAccionista;
	private int numAccionesCompradasAccionista;
	private CampaniaAccionistas campania;

	@Override
	public void addAccionista(Accionista accionista) {
		if (accionista == null)
			throw new IllegalArgumentException("El accionista a añadir no puede ser nulo");
		this.accionista = accionista;
	}

	@Override
	public String addNuevoAccionista(Accionista accionista) {
		if (accionista == null)
			throw new IllegalArgumentException("El accionista a añadir no puede ser nulo");
		String newId = UUID.randomUUID().toString().substring(0, 17);
		accionista.setIdAccionista(newId);
		
		this.accionista = accionista;
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

	@Override
	public Accionista getAccionista() {
		return accionista;
	}

	@Override
	public void setAccionesIniciales(int numAccionesIniciales) {
		this.numAccionesInicialesAccionista = numAccionesIniciales;
	}

	@Override
	public void setAccionesCompradas(int numAccionesCompradas) {
		this.numAccionesCompradasAccionista = numAccionesCompradas;
	}

	@Override
	public int getAccionesRestantesCampania() {
		return campania.getNumAccionesRestantes();
	}

	@Override
	public int getAccionesInicialesAccionista() {
		return numAccionesInicialesAccionista;
	}

	@Override
	public int getNumAccionesCompradasAccionista() {
		return numAccionesCompradasAccionista;
	}

	@Override
	public double getPrecioAcciones() {
		return campania.getPrecioAcciones();
	}

	@Override
	public void comprarAcciones(int numAcciones) {
		campania.reducirAccionesRestantes(numAcciones);
		numAccionesCompradasAccionista = numAccionesCompradasAccionista + numAcciones;		
	}

	@Override
	public List<Accion> generarAcciones(int numAcciones) {
		List<Accion> nuevasAcciones = new ArrayList<>();
		for (int i = 0; i < numAcciones; i++) {
			String id = UUID.randomUUID().toString().substring(0,10).toUpperCase();
			Accion acc = new Accion(id,false);
			nuevasAcciones.add(acc);
		}
		
		accionista.addAcciones(nuevasAcciones);
		return nuevasAcciones;
	}
	
	

}
