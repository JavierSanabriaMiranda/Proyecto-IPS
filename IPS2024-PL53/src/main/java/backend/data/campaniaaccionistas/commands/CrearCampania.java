package backend.data.campaniaaccionistas.commands;

import backend.data.Database;
import backend.data.campaniaaccionistas.CampaniaDTO;

public class CrearCampania {
	
	private static final String QUERY = "INSERT INTO CAMPANIA_ACCIONISTAS "
			+ "(COD_CAMPANIA, NUMERO_ACCIONES_INICIAL, NUMERO_ACCIONES_RESTANTES, FASE, ESTADO) "
			+ "VALUES (?, ?, ?, ?, ?)";

	private Database db = new Database();
	private CampaniaDTO dto;
	
	public CrearCampania(CampaniaDTO dto) {
		if (dto == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.codCampania, dto.accionesIniciales, 
				dto.accionesRestantes, dto.fase, dto.estado);
	}
	
	

}
