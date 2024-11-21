package backend.data.empleados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import shared.gestionempleados.PuestoEmpleado;
import shared.gestionempleados.creadores.CreadorDirectorComunicaciones;
import shared.gestionempleados.creadores.CreadorEmpleadoCocina;
import shared.gestionempleados.creadores.CreadorEmpleadoDeportivo;
import shared.gestionempleados.creadores.CreadorEmpleadoJardineria;
import shared.gestionempleados.creadores.CreadorEmpleadoNoDeportivo;
import shared.gestionempleados.creadores.CreadorEmpleadoTienda;
import shared.gestionempleados.creadores.CreadorEncargadoTienda;
import shared.gestionempleados.creadores.CreadorEntrenador;
import shared.gestionempleados.creadores.CreadorGerente;
import shared.gestionempleados.creadores.CreadorGestorInstalaciones;
import shared.gestionempleados.creadores.CreadorJugador;
import shared.gestionempleados.creadores.CreadorVendedorAbonos;

public class DtoAssembler {

	private static Map<PuestoEmpleado, CreadorEmpleadoDeportivo> creadoresDep = Map.of(
			PuestoEmpleado.ENTRENADOR, new CreadorEntrenador(),
			PuestoEmpleado.JUGADOR, new CreadorJugador()
		);
	private static Map<PuestoEmpleado, CreadorEmpleadoNoDeportivo> creadoresNoDep = Map.of(
			PuestoEmpleado.DIRECTOR_COMUNICACIONES, new CreadorDirectorComunicaciones(),
			PuestoEmpleado.EMPLEADO_COCINA, new CreadorEmpleadoCocina(),
			PuestoEmpleado.EMPLEADO_JARDINERIA, new CreadorEmpleadoJardineria(),
			PuestoEmpleado.EMPLEADO_TIENDA, new CreadorEmpleadoTienda(),
			PuestoEmpleado.ENCARGADO_TIENDA, new CreadorEncargadoTienda(),
			PuestoEmpleado.GERENTE, new CreadorGerente(),
			PuestoEmpleado.GESTOR_INSTALACIONES, new CreadorGestorInstalaciones(),
			PuestoEmpleado.VENDEDOR_ABONOS, new CreadorVendedorAbonos()
		);

	/**
	 * Recibe una lista de DTOs que son empleados deportivos y los convierte en objetos EmpleadoDeportivo
	 */
	public static List<EmpleadoDeportivo> dtoToEmpleadoDeportivo(List<EmpleadoDeportivoDTO> dtos) {
		List<EmpleadoDeportivo> empleados = new ArrayList<>();
		
		try {
			for (EmpleadoDTO dto : dtos) {
				String id = dto.id;
				String nombre = dto.nombre;
				String apellido = dto.apellido;
				String DNI = dto.DNI;
				String telefono = dto.telefono;
				Date nacimiento = dto.fechaNac;
				double salario = dto.salarioAnual;
				PuestoEmpleado puesto = PuestoEmpleado.getPuesto(dto.posicion);
				

				CreadorEmpleadoDeportivo creador = creadoresDep.get(puesto);
				EmpleadoDeportivo emp = creador.getEmpleado(nombre, apellido, DNI, telefono, nacimiento, salario);
				emp.setIDEmpleado(id);
				
				empleados.add(emp);
			}
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("Se ha introducido un valor en la lista de EmpeladoDTO que no es un EmpleadoDeportivo");
		}
		
		
		return empleados;
	}

	/**
	 * Recibe una lista de DTOs que son empleados deportivos y los convierte en
	 * objetos EmpleadoDeportivo
	 */
	public static List<EmpleadoNoDeportivo> dtoToEmpleadoNoDeportivo(List<EmpleadoDTO> dtos) {
		List<EmpleadoNoDeportivo> empleados = new ArrayList<>();

		try {
			for (EmpleadoDTO dto : dtos) {
				EmpleadoNoDeportivo emp = dtoToEmpleadoNoDeportivo(dto);
				empleados.add(emp);
			}
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(
					"Se ha introducido un valor en la lista de EmpeladoDTO que no es un EmpleadoNoDeportivo");
		}

		return empleados;
	}
	
	public static EmpleadoNoDeportivo dtoToEmpleadoNoDeportivo(EmpleadoDTO dto) {
		String id = dto.id;
		String nombre = dto.nombre;
		String apellido = dto.apellido;
		String DNI = dto.DNI;
		String telefono = dto.telefono;
		Date nacimiento = dto.fechaNac;
		double salario = dto.salarioAnual;
		PuestoEmpleado puesto = PuestoEmpleado.getPuesto(dto.posicion);

		CreadorEmpleadoNoDeportivo creador = creadoresNoDep.get(puesto);
		EmpleadoNoDeportivo emp = creador.getEmpleado(nombre, apellido, DNI, telefono, nacimiento, salario);
		emp.setIDEmpleado(id);

		return emp;
	}

	public static EmpleadoDeportivo dtoToEmpleadoDeportivo(EmpleadoDeportivoDTO dto) {
		String id = dto.id;
		String nombre = dto.nombre;
		String apellido = dto.apellido;
		String DNI = dto.DNI;
		String telefono = dto.telefono;
		Date nacimiento = dto.fechaNac;
		double salario = dto.salarioAnual;
		PuestoEmpleado puesto = PuestoEmpleado.getPuesto(dto.posicion);

		CreadorEmpleadoDeportivo creador = creadoresDep.get(puesto);
		EmpleadoDeportivo emp = creador.getEmpleado(nombre, apellido, DNI, telefono, nacimiento, salario);
		emp.setIDEmpleado(id);
		return emp;

	}
}
