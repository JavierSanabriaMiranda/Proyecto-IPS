package backend.data.campaniaaccionistas.commands;

import backend.data.Database;
import backend.data.campaniaaccionistas.AccionistaEnCampaniaDTO;

public class UpdateAccionistaEnCampania {
	
	private static final String QUERY = "UPDATE PARTICIPA_EN_CAMPANIA "
			+ "SET NUM_ACCIONES_COMPRADAS = ? WHERE COD_CAMPANIA = ? AND ID_ACCIONISTA = ?";
	
	private AccionistaEnCampaniaDTO dto;
	private Database db = new Database();

	public UpdateAccionistaEnCampania(AccionistaEnCampaniaDTO dtoAccCamp) {
		if (dtoAccCamp == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dtoAccCamp;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.numAccionesCompradas, dto.codCampania, dto.idAccionista);
	}
	

}
