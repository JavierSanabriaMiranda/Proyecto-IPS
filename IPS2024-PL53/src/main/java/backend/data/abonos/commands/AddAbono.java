package backend.data.abonos.commands;

import backend.data.Database;
import backend.data.abonos.AbonoDTO;

public class AddAbono {
	private static final String QUERY = "INSERT INTO ABONO_TEMPORADA VALUES (?, ?)";
	private AbonoDTO abono;
	private Database db = new Database();

	public AddAbono(AbonoDTO abono) {
		this.abono = abono;
	}

	public void execute() {
		db.executeUpdate(QUERY, abono.codAbono, abono.idAsiento);
	}

}
