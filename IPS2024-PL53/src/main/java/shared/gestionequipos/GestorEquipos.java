package shared.gestionequipos;

import java.util.List;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.equipos.Equipo;

/**
 * Interfaz que contendrá los métodos necesarios para gestionar la adición de nuevos equipos
 */
public interface GestorEquipos {

	List<EmpleadoDeportivo> getJugadoresSinEquipo();
	List<EmpleadoDeportivo> getEntrenadoresSinEquipo();
	
	void addEquipo(Equipo equipo);
	
	void addEmpleadoDeportivo(EmpleadoDeportivo emp);
	
	Equipo getEquipoByID(String idEquipo);
	
	List<Equipo> getEquiposPimerosEquipos();
	
	String generarIDEquipo();
	
	List<EmpleadoDeportivo> getEntrenadoresConEquipo();
	
	EmpleadoDeportivo buscaEmpleado(String idEntrenador);
	
	List<Equipo> getEquipos();
	
	
}
