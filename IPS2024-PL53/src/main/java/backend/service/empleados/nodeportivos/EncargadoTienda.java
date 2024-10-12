package backend.service.empleados.nodeportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoNoDeportivoBase;
import shared.gestionempleados.PuestoEmpleado;

public class EncargadoTienda extends EmpleadoNoDeportivoBase {

	public EncargadoTienda(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}

	@Override
	public PuestoEmpleado getPuesto() {
		return PuestoEmpleado.ENCARGADO_TIENDA;
	}

}
