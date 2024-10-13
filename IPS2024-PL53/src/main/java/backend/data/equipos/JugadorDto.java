package backend.data.equipos;

import java.util.Date;

public class JugadorDto {
	
	public String id_jugador; //es igual al del empleado deportivo
	public String nombre;
	public String apellido;
	public String DNI;
	public String telefono;
	public Date fechaNac;
	public double salario;
	public String idEquipo; //No se usa para cargar, solo para el update
}
