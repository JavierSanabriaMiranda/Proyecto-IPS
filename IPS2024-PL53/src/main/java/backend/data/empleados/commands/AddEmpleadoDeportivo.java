package backend.data.empleados.commands;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class AddEmpleadoDeportivo {
	
	private static final String QUERY = "INSERT INTO EMPLEADO_DEPORTIVO "
			+ "(ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String QUERY_JUGADOR = "INSERT INTO JUGADOR "
			+ "(ID_JUGADOR, ID_EQUIPO) "
			+ "VALUES (?, ?)";
	private static final String QUERY_ENTRENADOR = "INSERT INTO ENTRENADOR "
			+ "(ID_ENTRENADOR, ID_EQUIPO, POSICION_ENTRENADOR) "
			+ "VALUES (?, ?, ?)";
			

	EmpleadoDTO dto;
	private Database db = new Database();
	
	public AddEmpleadoDeportivo(EmpleadoDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, dto.id, dto.DNI, dto.nombre, dto.apellido, dto.fechaNac, dto.telefono, dto.salarioAnual);
		if (dto.posicion.equals("jugador"))
			db.executeUpdate(QUERY_JUGADOR, dto.id, null);
		else if (dto.posicion.equals("entrenador"))
			db.executeUpdate(QUERY_ENTRENADOR, dto.id, null, null);;
	}
}
