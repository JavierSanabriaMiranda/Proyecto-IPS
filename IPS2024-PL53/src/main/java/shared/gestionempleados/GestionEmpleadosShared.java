package shared.gestionempleados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.CreadorDataService;
import backend.data.empleados.EmpleadoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.service.empleados.Empleado;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
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

public class GestionEmpleadosShared {
	
	EmpleadosCRUDService service = CreadorDataService.getEmpleadosService();
	private GestorEmpleados gestor = new Gerente();
	private CreadorEmpleadoDeportivo creadorDep;
	private CreadorEmpleadoNoDeportivo creadorNoDep;
	private Map<PuestoEmpleado, CreadorEmpleadoDeportivo> creadoresDep = Map.of(
				PuestoEmpleado.ENTRENADOR, new CreadorEntrenador(),
				PuestoEmpleado.JUGADOR, new CreadorJugador()
			);
	private Map<PuestoEmpleado, CreadorEmpleadoNoDeportivo> creadoresNoDep = Map.of(
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
	 * Por medio de la información del empleado, crea un empleado y lo añade a la lista del gestor correspondiente
	 */
	public void addEmpleado(String nombre, String apellido, String DNI, String telefono, 
			Date fechaNac, double salario, TipoEmpleado tipo, PuestoEmpleado puesto)  {
		
		if (tipo.equals(TipoEmpleado.DEPORTIVO))
			addEmpleadoDeportivo(nombre, apellido, DNI, telefono, fechaNac, salario, puesto);
		else
			addEmpleadoNoDeportivo(nombre, apellido, DNI, telefono, fechaNac, salario, puesto);
	}
	
	/**
	 * Modifica el empleado cuyo ID es el introducido como primer parámetro y le establece
	 * el resto de valores recibidos
	 * @param id del empleado a modificar
	 * @param nombre nuevo
	 * @param apellido nuevo
	 * @param dni nuevo
	 * @param telefono nuevo
	 * @param nacimiento nuevo
	 * @param salario nuevo
	 */
	public void modEmpleado(String id, String nombre, String apellido, String dni, String telefono, Date nacimiento,
			double salario) {
		// Obtenemos el empleado y modificamos sus valores
		Empleado emp = gestor.getEmpleado(id);
		emp.setNombre(nombre);
		emp.setApellido(apellido);
		emp.setDNI(dni);
		emp.setTelefono(telefono);
		emp.setFechaNac(nacimiento);
		emp.setSalarioAnual(salario);
		
		// Modificamos los valores tambien en la BBDD
		modEmpleadoBBDD(id, nombre, apellido, dni, telefono, nacimiento, salario);
	}
	
	public void cargarEmpleadosDeLaBBDD() {
		List<EmpleadoDTO> empleadosDeportivos = service.cargarEmpleadosDeportivos();
		cargarEmpleadosDeportivosEnGestor(empleadosDeportivos);
		
		List<EmpleadoDTO> empleadosNoDeportivos = service.cargarEmpleadosNoDeportivos();
		cargarEmpleadosNoDeportivosEnGestor(empleadosNoDeportivos);
	}

	public List<Empleado> getEmpleadosFromGestor() {
		List<EmpleadoDeportivo> empDep = gestor.getEmpleadosDeportivos();
		List<EmpleadoNoDeportivo> empNoDep = gestor.getEmpleadosNoDeportivos();
		
		List<Empleado> empleados = new ArrayList<>();
		empleados.addAll(empDep);
		empleados.addAll(empNoDep);
		
		return empleados;
	}

	/**
	 * Añade al empleado deportivo a la lista del gestor correcta así como a la base de datos
	 */
	private void addEmpleadoDeportivo(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario, PuestoEmpleado puesto) {
		creadorDep = creadoresDep.get(puesto);
		String id = gestor.addEmpleadoDeportivo(creadorDep.getEmpleado(nombre, apellido, DNI, telefono, fechaNac, salario));
		
		addEmpleadoDeportivoBBDD(id, nombre, apellido, DNI, telefono, fechaNac, salario, puesto);
	}
	
	private void addEmpleadoDeportivoBBDD(String id, String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario, PuestoEmpleado puesto) {
		
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.id = id;
		dto.nombre = nombre;
		dto.apellido = apellido;
		dto.DNI = DNI;
		dto.telefono = telefono;
		dto.fechaNac = fechaNac;
		dto.salarioAnual = salario;
		dto.posicion = puesto.toString();
				
		service.addEmpleadoDeportivo(dto);
	}

	/**
	 * Añade al empleado NO deportivo a la lista del gestor correcta así como a la base de datos
	 */
	private void addEmpleadoNoDeportivo(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario, PuestoEmpleado puesto) {
		creadorNoDep = creadoresNoDep.get(puesto);
		String id = gestor.addEmpleadoNoDeportivo(creadorNoDep.getEmpleado(nombre, apellido, DNI, telefono, fechaNac, salario));
		
		addEmpleadoNoDeportivoBBDD(id, nombre, apellido, DNI, telefono, fechaNac, salario, puesto);
	}

	private void addEmpleadoNoDeportivoBBDD(String id, String nombre, String apellido, String DNI, String telefono,
			Date fechaNac, double salario, PuestoEmpleado puesto) {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.id = id;
		dto.nombre = nombre;
		dto.apellido = apellido;
		dto.DNI = DNI;
		dto.telefono = telefono;
		dto.fechaNac = fechaNac;
		dto.salarioAnual = salario;
		dto.posicion = puesto.toString();
		
		service.addEmpleadoNoDeportivo(dto);
	}
	
	private void modEmpleadoBBDD(String id, String nombre, String apellido, String dni, String telefono,
			Date nacimiento, double salario) {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.id = id;
		dto.nombre = nombre;
		dto.apellido = apellido;
		dto.DNI = dni;
		dto.telefono = telefono;
		dto.fechaNac = nacimiento;
		dto.salarioAnual = salario;
		
		service.modEmpleado(dto);
	}
	
	/**
	 * Carga todos los empleados deportivos y crea los objetos del tipo correspondiente (jugador o entrenador)
	 * por medio de los creadores, para luego añadir cada uno de ellos a la lista del gestor
	 * @param empleadosDeportivos lista con todos los empleados en forma de EmpleadoDTO
	 */
	private void cargarEmpleadosDeportivosEnGestor(List<EmpleadoDTO> empleadosDeportivos) {
		for (EmpleadoDTO dto : empleadosDeportivos) {
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
			
			gestor.addEmpleadoDeportivo(emp);
		}
	}
	
	private void cargarEmpleadosNoDeportivosEnGestor(List<EmpleadoDTO> empleadosNoDeportivos) {
		for (EmpleadoDTO dto : empleadosNoDeportivos) {
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
			
			gestor.addEmpleadoNoDeportivo(emp);
		}
	}

}
