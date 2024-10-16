package backend.data.ventas.commands;

import backend.data.Database;
import backend.data.ventas.ReservaDto;

public class AddReserva {

	private static final String SQL = "INSERT INTO RESERVA " + 
									"(COD_RESERVA, HORA_FIN, HORA_INICIO, COD_INSTALACION, FECHA_RESERVA, N_TARJETA) " +
									"VALUES(?, ?, ?, ?, ?, ?)";
	
	public ReservaDto dto;
	private Database db = new Database();

	public AddReserva(ReservaDto dto) {
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(SQL, dto.codReserva, dto.horaFin, dto.horaInicio, dto.codInstalacion, dto.fecha, dto.numTarjeta);
	}
	
}
