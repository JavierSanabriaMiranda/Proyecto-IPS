package backend.data.equipos.command;

import backend.data.Database;
import backend.data.equipos.EquipoEnFormacionDto;

public class AddEquipoEnFormacion {
	private static final String SQL_EQUIPO = "INSERT INTO EQUIPO (ID_EQUIPO) VALUES (?);";

	private static final String SQL_FOR = "INSERT INTO EQUIPO_FORMACION (ID_EQUIPO, CATEGORIA) VALUES (?, ?);";
	
	public EquipoEnFormacionDto dto;
	
	private Database db = new Database();
	
	public AddEquipoEnFormacion(EquipoEnFormacionDto dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(SQL_EQUIPO, dto.idEquipo);
		db.executeUpdate(SQL_FOR, dto.idEquipo, dto.categoria.toLowerCase());
	}
}
