package backend.service.empleados;

import java.util.Date;

public interface Empleado {

	String getIDEmpleado();
	String getNombre();
	String getApellido();
	String getDNI(); 
	String getTelefono();
	Date getFechaNac();
	double getSalarioAnual();
	
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
