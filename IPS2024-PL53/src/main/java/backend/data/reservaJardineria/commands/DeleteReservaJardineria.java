package backend.data.reservaJardineria.commands;

import backend.data.Database;

public class DeleteReservaJardineria {
	
	private final static String QUERY = "DELETE FROM RESERVA_JARDINERIA WHERE COD_RESERVA_JARDINERIA = ?";
	
	private Database db = new Database();
	private String codReserva;
	
	public DeleteReservaJardineria(String codReserva) {
		this.codReserva = codReserva;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, this.codReserva);
	}
}
