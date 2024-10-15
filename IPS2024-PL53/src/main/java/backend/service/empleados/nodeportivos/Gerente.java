package backend.service.empleados.nodeportivos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.service.empleados.Empleado;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivoBase;
import backend.service.empleados.GeneradorIDEmpleado;
import backend.service.equipos.Equipo;
import backend.service.equipos.GeneradorIDEquipo;
import backend.service.ventas.Venta;
import backend.service.ventas.Venta;
import backend.service.empleados.nodeportivos.horarios.Turno;
import backend.service.empleados.nodeportivos.horarios.TurnoPuntual;
import backend.service.empleados.nodeportivos.horarios.TurnoSemanal;
import shared.gestionempleados.GestorEmpleados;
import shared.gestionempleados.PuestoEmpleado;
import shared.gestionequipos.GestorEquipos;
import shared.gestioninstalaciones.GerenteVentas;
import shared.gestioninstalaciones.GerenteVentas;
import shared.gestionhorarios.GestorHorarios;

public class Gerente extends EmpleadoNoDeportivoBase implements GestorEmpleados, GerenteVentas, GestorEquipos, GestorHorarios {

	/**
	 * Diccionario de empleados no deportivos cuya clave es el ID del empleado
	 */
	private Map<String, EmpleadoDeportivo> empDeportivos;
	/**
	 * Diccionario de NO empleados no deportivos cuya clave es el ID del empleado
	 */
	private Map<String, EmpleadoNoDeportivo> empNoDeportivos;
	/**
	 * Generador aleatorio de IDs para la creación de nuevos empleados
	 */
	private GeneradorIDEmpleado generadorID = new GeneradorIDEmpleado();

	private GeneradorIDEquipo generadorIDEquipo = new GeneradorIDEquipo();
    /**
     * Lista de las ventas realizadas
     */
	private List<Venta> ventas = new ArrayList<Venta>();

	private List<Equipo> equipos = new ArrayList<Equipo>();

	/**
	 * Constructor que sirve para instanciar gerentes utilizados como almacenamiento de datos
	 * @param nombre
	 * @param apellido
	 * @param DNI
	 * @param telefono
	 * @param fechaNac
	 */
	public Gerente(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		empDeportivos = new HashMap<>();
		empNoDeportivos = new HashMap<>();
	}

	public Gerente() {
		super();
		empDeportivos = new HashMap<>();
		empNoDeportivos = new HashMap<>();
	}
	

	public List<Venta> getVentas() {
		return this.ventas;
	}

	@Override
	public PuestoEmpleado getPuesto() {
		return PuestoEmpleado.GERENTE;
	}

	@Override
	public String addNuevoEmpleadoDeportivo(EmpleadoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		
		String idNuevo = generarIDEmpleado();
		emp.setIDEmpleado(idNuevo);
		empDeportivos.put(emp.getIDEmpleado(), emp);
		
		return idNuevo;
	}

	@Override
	public String addNuevoEmpleadoNoDeportivo(EmpleadoNoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		
		String idNuevo = generarIDEmpleado();
		emp.setIDEmpleado(idNuevo);
		empNoDeportivos.put(emp.getIDEmpleado(), emp);
		
		return idNuevo;
	}
	
	@Override
	public void addEmpleadoDeportivo(EmpleadoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		empDeportivos.put(emp.getIDEmpleado(), emp);
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		empNoDeportivos.put(emp.getIDEmpleado(), emp);
	}
	
	/**
	 * Genera un ID de empleado único de la forma EXXXXXXX donde las X son números aleatorios
	 * @return
	 */
	private String generarIDEmpleado() {
		int numeroID;
		do {
			numeroID = generadorID.getNuevoID();
		} while(empDeportivos.containsKey("E" + numeroID) || empNoDeportivos.containsKey("E" + numeroID));
		
		return "E" + numeroID;
	}

	@Override
	public Empleado getEmpleado(String id) {
		if (empDeportivos.containsKey(id))
			return empDeportivos.get(id);
		else if (empNoDeportivos.containsKey(id))
			return empNoDeportivos.get(id);
		throw new IllegalArgumentException("No hay ningun empleado almacenado con el id introducido");
	}

	@Override
	public List<EmpleadoDeportivo> getEmpleadosDeportivos() {
		List<EmpleadoDeportivo> empleados = new ArrayList<>();
		empleados.addAll(empDeportivos.values());
		
		return empleados;
	}

	@Override
	public List<EmpleadoNoDeportivo> getEmpleadosNoDeportivos() {
		List<EmpleadoNoDeportivo> empleados = new ArrayList<>();
		empleados.addAll(empNoDeportivos.values());
		
		return empleados;
	}

	@Override
	public void eliminarEmpleado(String idEmpleado) {
		if (empDeportivos.containsKey(idEmpleado))
			empDeportivos.remove(idEmpleado);
		else if (empNoDeportivos.containsKey(idEmpleado))
			empNoDeportivos.remove(idEmpleado);
	}

	/**
	 * Método que implementa la interfaz GerenteVentas
	 */
	@Override
	public void addVentaAGerenteVentas(Venta venta) {
		ventas.add(venta);
	}

	@Override
	public List<Turno> getHorarioDia(EmpleadoNoDeportivo emp, LocalDate fecha) {
		return emp.getHorario().getHorarioDia(fecha);
	}

	@Override
	public EmpleadoNoDeportivo getEmpleadoNoDeportivo(String idEmp) {
		if (!empNoDeportivos.containsKey(idEmp))
			throw new IllegalArgumentException("No hay un empleado no deportivo con dicho id");
		return empNoDeportivos.get(idEmp);
	}

	@Override
	public TurnoSemanal addTurnoSemanal(String idEmp, LocalTime hInicio, LocalTime hFin, DayOfWeek diaSemana) {
		EmpleadoNoDeportivo emp = getEmpleadoNoDeportivo(idEmp);
		return emp.getHorario().addAHorarioSemanal(hInicio, hFin, diaSemana);
	}

	@Override
	public TurnoPuntual addTurnoPuntual(String idEmp, LocalTime hInicio, LocalTime hFin, LocalDate dia) {
		EmpleadoNoDeportivo emp = getEmpleadoNoDeportivo(idEmp);
		return emp.getHorario().addAHorarioPuntual(hInicio, hFin, dia);
	}


	@Override
	public void addVentaAGerenteVentas(Venta venta) {
		ventas.add(venta);
	}

	@Override
	public List<EmpleadoDeportivo> getJugadoresSinEquipo() {
		List<EmpleadoDeportivo> jugadoresSinEquipo = new ArrayList<EmpleadoDeportivo>();
		for (EmpleadoDeportivo emp : empDeportivos.values()) {
			if (!emp.tieneEquipo() && emp.getPuesto().equals(PuestoEmpleado.JUGADOR))
				jugadoresSinEquipo.add(emp);
		}
		return jugadoresSinEquipo;
	}

	@Override
	public List<EmpleadoDeportivo> getEntrenadoresSinEquipo() {
		List<EmpleadoDeportivo> jugadoresSinEquipo = new ArrayList<EmpleadoDeportivo>();
		for (EmpleadoDeportivo emp : empDeportivos.values()) {
			if (!emp.tieneEquipo() && emp.getPuesto().equals(PuestoEmpleado.ENTRENADOR))
				jugadoresSinEquipo.add(emp);
		}
		return jugadoresSinEquipo;
	}

	@Override
	public void addEquipo(Equipo equipo) {
		equipos.add(equipo);
	}

	@Override
	public Equipo getEquipoByID(String idEquipo) {
		for(Equipo equi : equipos) {
			if (equi.getIdEquipo().equals(idEquipo)) {
				return equi;
			}
		}
		return null;
	}

	@Override
	public List<Equipo> getEquiposPimerosEquipos() {
		List<Equipo> equiposPros = new ArrayList<Equipo>();
		for (Equipo equi : equipos) {
			if (equi.esProfesional())
				equiposPros.add(equi);
		}
		return equiposPros;
	}

	@Override
	public String generarIDEquipo() {
	    int numeroID;
	    do {
	        numeroID = generadorIDEquipo.getNuevoID();
	    } while (existeIDEquipo("EQU" + numeroID));

	    return "EQU" + numeroID;
	}

	private boolean existeIDEquipo(String idEquipo) {
	    for (Equipo equipo : equipos) {
	        if (equipo.getIdEquipo().equals(idEquipo)) {
	            return true;
	        }
	    }
	    return false;
	}


}
