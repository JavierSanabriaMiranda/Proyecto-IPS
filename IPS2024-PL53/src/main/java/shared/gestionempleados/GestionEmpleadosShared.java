package shared.gestionempleados;

import java.util.Date;
import java.util.Map;

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
	 * Añade al empleado deportivo a la lista del gestor correcta
	 */
	private void addEmpleadoDeportivo(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario, PuestoEmpleado puesto) {
		creadorDep = creadoresDep.get(puesto);
		gestor.addEmpleadoDeportivo(creadorDep.getEmpleado(nombre, apellido, DNI, telefono, fechaNac, salario));
	}
	
	/**
	 * Añade al empleado NO deportivo a la lista del gestor correcta
	 */
	private void addEmpleadoNoDeportivo(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario, PuestoEmpleado puesto) {
		creadorNoDep = creadoresNoDep.get(puesto);
		gestor.addEmpleadoNoDeportivo(creadorNoDep.getEmpleado(nombre, apellido, DNI, telefono, fechaNac, salario));
	}

	

}
