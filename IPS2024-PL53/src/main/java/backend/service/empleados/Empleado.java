package backend.service.empleados;

import java.util.Date;

import shared.gestionempleados.PuestoEmpleado;

public interface Empleado {

	String getIDEmpleado();
	String getNombre();
	String getApellido();
	String getDNI(); 
	String getTelefono();
	Date getFechaNac();
	double getSalarioAnual();
	PuestoEmpleado getPuesto();
	
	void setIDEmpleado(String id);
	void setNombre(String nombre);
	void setApellido(String apellido);
	void setDNI(String DNI);
	void setTelefono(String telefono);
	void setFechaNac(Date fecha);
	void setSalarioAnual(double salario);
	
	@Override
	String toString();
}
