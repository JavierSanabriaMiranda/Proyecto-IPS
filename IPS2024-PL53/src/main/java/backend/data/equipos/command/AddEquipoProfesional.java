package backend.data.equipos.command;

import backend.data.Database;
import backend.data.equipos.EquipoProfesionalDto;

public class AddEquipoProfesional {

	private static final String SQL_EQUIPO = "INSERT INTO EQUIPO (ID_EQUIPO) VALUES (?);";
	
	private static final String SQL_PRO = "INSERT INTO EQUIPO_PROFESIONAL (ID_EQUIPO, ID_PROFESIONAL) VALUES (?, ?);";
	
	public EquipoProfesionalDto dto;
	Database db = new Database();
	
	public AddEquipoProfesional(EquipoProfesionalDto dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(SQL_EQUIPO, dto.idEquipo);
		db.executeUpdate(SQL_PRO, dto.idEquipo, dto.equipoProfesionalDelQueEsFilial);
	}
}
