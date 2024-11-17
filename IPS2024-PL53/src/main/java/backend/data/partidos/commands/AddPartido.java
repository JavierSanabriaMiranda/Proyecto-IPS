package backend.data.partidos.commands;

import backend.data.Database;
import backend.data.partidos.PartidoDTO;

public class AddPartido {
	
	private static final String QUERY = "INSERT INTO PARTIDO "
			+ "(ID_PARTIDO, HORA_FIN, HORA_INICIO, FECHA, ID_EQUIPO, VISITANTE, TIENESUPLEMENTO) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private PartidoDTO dto;
	private Database db = new Database();

	public AddPartido(PartidoDTO dto) {
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.id, dto.horaFin, dto.horaInicio, dto.fecha, dto.idEquipo, dto.visitante, dto.tieneSuplemento);
	}

}
