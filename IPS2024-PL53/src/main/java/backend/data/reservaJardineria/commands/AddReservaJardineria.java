package backend.data.reservaJardineria.commands;

import backend.data.Database;
import backend.data.reservaJardineria.ReservaJardineriaDTO;

public class AddReservaJardineria {

	private static final String QUERY = "INSERT INTO RESERVA_JARDINERIA " +
		    "(COD_RESERVA_JARDINERIA, ID_JARDINERO, COD_INSTALACION, FECHA, HORA_INICIO, HORA_FIN) " +
		    "VALUES (?, ?, ?, ?, ?, ?)";
	
	private ReservaJardineriaDTO dto;
	private Database db = new Database();
	
	public AddReservaJardineria(ReservaJardineriaDTO dto) {
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.codReservaJardineria, dto.idJardinero, dto.codInstalacion, dto.fecha, dto.horaInicio, dto.horaFin);	
	}

}
