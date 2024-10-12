package backend.data.entradas.commands;

import backend.data.Database;
import backend.data.entradas.EntradaDTO;

public class AddEntrada {

	private static final String QUERY = "INSERT INTO ENTRADA "
			+ "(COD_ENTRADA, TRIBUNA, SECCION, N_FILA, N_ASIENTO, ID_PARTIDO)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	EntradaDTO dto;
	private Database db = new Database();
	
	public AddEntrada(EntradaDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, dto.cod_entrada, dto.tribuna, dto.seccion, dto.nFila, dto.nAsiento, dto.idPartido);
	}
}
