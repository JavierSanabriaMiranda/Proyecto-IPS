package backend.data.campaniaaccionistas.commands;

import backend.data.Database;
import backend.data.campaniaaccionistas.CampaniaDTO;

public class UpdateCampania {
	
	private static final String QUERY_VENTAS = "UPDATE VENTAS "
			+ "SET COSTE = ? WHERE ID_VENTAS = ?";
	
	private static final String QUERY = "UPDATE CAMPANIA_ACCIONISTAS SET NUMERO_ACCIONES_RESTANTES = ?, "
			+ "FASE = ?, ESTADO = ? WHERE COD_CAMPANIA = ?";
	
	private Database db = new Database();
	private CampaniaDTO dto;

	public UpdateCampania(CampaniaDTO dto) {
		if (dto == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(QUERY_VENTAS, dto.precio, dto.codCampania);
		db.executeUpdate(QUERY, dto.accionesRestantes, dto.fase, dto.estado, dto.codCampania);
	}

}
