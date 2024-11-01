package backend.data.accionistas.commands;

import backend.data.Database;
import backend.data.accionistas.AccionistaDTO;

public class AddAccionista {
	
	private static final String QUERY = "INSERT INTO ACCIONISTA (ID_ACCIONISTA, DNI, NOMBRE) "
			+ "VALUES (?, ?, ?)";
	
	private AccionistaDTO dto;
	private Database db = new Database();
	
	public AddAccionista(AccionistaDTO dto) {
		if (dto == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.idAccionista, dto.dniAccionista, dto.nombreAccionista);
	}

}
