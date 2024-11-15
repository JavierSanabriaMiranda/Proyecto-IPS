package backend.data.entradas.commands;

import backend.data.Database;
import backend.data.entradas.EntradaDTO;

public class AddEntrada {

	private static final String QUERY = "INSERT INTO ENTRADA "
			+ "(COD_ENTRADA, ID_PARTIDO, ID_ASIENTO)"
			+ "VALUES (?, ?, ?)";

	EntradaDTO dto;
	private Database db = new Database();
	
	public AddEntrada(EntradaDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, dto.cod_entrada, dto.idPartido, dto.idAsiento);
	}
}
