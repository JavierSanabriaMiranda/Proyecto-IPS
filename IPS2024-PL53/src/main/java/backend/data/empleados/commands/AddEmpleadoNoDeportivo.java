package backend.data.empleados.commands;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class AddEmpleadoNoDeportivo {

	private static final String QUERY = "INSERT INTO EMPLEADO_NO_DEPORTIVO "
			+ "(ID_EMPLEADO_NO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			

	EmpleadoDTO dto;
	private Database db = new Database();
	
	public AddEmpleadoNoDeportivo(EmpleadoDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeQueryArray(QUERY, dto.id, dto.nombre, dto.apellido, dto.fechaNac, dto.telefono, dto.posicion ,dto.salarioAnual);
	}
}
