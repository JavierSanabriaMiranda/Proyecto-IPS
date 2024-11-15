package backend.data.asientos.commands;

import backend.data.Database;
import backend.data.asientos.AsientoDTO;

public class AddAsiento {
	
	private static final String QUERY =  "INSERT INTO ASIENTO "
			+ "(ID_ASIENTO, TRIBUNA, SECCION, N_FILA, N_ASIENTO)"
			+ "VALUES (?, ?, ?, ?, ?)";

	
	private AsientoDTO dto;
	private Database db = new Database();

	public AddAsiento(AsientoDTO dtoA) {
		if (dtoA == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dtoA;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.idAsiento, dto.tribuna, dto.seccion, dto.nFila, dto.nAsiento);
	}

}
