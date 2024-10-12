package shared.gestionhorarios;

import java.time.LocalDate;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadosCRUDService;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.empleados.nodeportivos.horarios.Turno;
import shared.gestionempleados.GestionEmpleadosShared;

public class GestionHorariosShared {

	private GestorHorarios gestor = new Gerente();
	EmpleadosCRUDService service = CreadorDataService.getEmpleadosService();

	public GestionHorariosShared() {
		cargarEmpleadosNoDeportivosDeBBDD();
	}

	public List<Turno> getHorario(EmpleadoDeportivo emp, LocalDate fecha) {
		
	}
	
	private void cargarEmpleadosNoDeportivosDeBBDD() {
		List<EmpleadoNoDeportivo> empleados = DtoAssembler.dtoToEmpleadoNoDeportivo(service.cargarEmpleadosDeportivos());
		for (EmpleadoNoDeportivo emp : empleados)
			gestor.addEmpleadoNoDeportivo(emp);
	}
	
}
