package shared.gestioncampania;

import backend.service.ventas.campanaAccionistas.Accionista;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;

public interface GestorCampania {

	CampaniaAccionistas crearCampania(int numAcciones);
	
	void cargarCampania(CampaniaAccionistas campania);
	
	/**
	 * Añade un accionista que ya tiene id a la lista de accionistas
	 * @param accionista a añadir
	 */
	void addAccionista(Accionista accionista);
	
	/**
	 * Cuando un cliente que no era accionista compra una acción se crea un nuevo objeto accionista sin id
	 * que debe ser añadido a la lista de accionistas tras asignarle un nuevo id único
	 * 
	 * @param accionista sin id
	 * @return nuevo id del accionista
	 */
	String addNuevoAccionista(Accionista accionista);

	int getFaseCampania();

	void avanzarFase();

	boolean isCampaniaFinalizada();

	int getAccionesVendidas();

	CampaniaAccionistas getCampania();

	Accionista getAccionista();

	void setAccionesIniciales(int numAccionesIniciales);

	void setAccionesCompradas(int numAccionesCompradas);

	int getAccionesRestantesCampania();

	int getAccionesInicialesAccionista();

	int getNumAccionesCompradasAccionista();

	double getPrecioAcciones();
}
