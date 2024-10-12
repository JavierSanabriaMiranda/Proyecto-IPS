package backend.data.empleados.commands;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class ModEmpleado {

	private static final String QUERY_EMP_DEP = "UPDATE EMPLEADO_DEPORTIVO "
			+ "SET NOMBRE = ?, "
			+ "APELLIDO = ?, "
			+ "DNI = ?, "
			+ "FECHA_NACIMIENTO = ?, "
			+ "TELEFONO = ?, "
			+ "SALARIO_ANUAL = ? "
			+ "WHERE ID_EMPLEADO_DEP = ?";
	
	private static final String QUERY_EMP_NO_DEP = "UPDATE EMPLEADO_NO_DEPORTIVO "
			+ "SET NOMBRE = ?, "
			+ "APELLIDO = ?, "
			+ "DNI = ?, "
			+ "FECHA_NACIMIENTO = ?, "
			+ "TELEFONO = ?, "
			+ "SALARIO_ANUAL = ? "
			+ "WHERE ID_EMPLEADO_NO_DEP = ?";
			

	EmpleadoDTO dto;
	private Database db = new Database();
	
	
	public ModEmpleado(EmpleadoDTO dto) {
		this.dto = dto;
	}


	public void execute() {
		// Actualizamos el valor en empleado deportivo si lo hay
		db.executeUpdate(QUERY_EMP_DEP, dto.nombre, dto.apellido, dto.DNI, dto.fechaNac, dto.telefono, dto.salarioAnual, dto.id);
		// Actualizamos el valor en empleado NO deportivo si lo hay
		db.executeUpdate(QUERY_EMP_NO_DEP, dto.nombre, dto.apellido, dto.DNI, dto.fechaNac, dto.telefono, dto.salarioAnual, dto.id);
	}
	
	

}
