package shared.gestionjardineria;

import java.time.LocalDate;
import java.util.List;

import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.horarios.Turno;

public interface GestorJardineros {
	
	List<EmpleadoNoDeportivo> getJardineros();

	void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);

	List<Turno> getHorarioDia(EmpleadoNoDeportivo emp, LocalDate fecha);
	
	EmpleadoNoDeportivo getEmpleadoNoDeportivo(String idEmp);

}
