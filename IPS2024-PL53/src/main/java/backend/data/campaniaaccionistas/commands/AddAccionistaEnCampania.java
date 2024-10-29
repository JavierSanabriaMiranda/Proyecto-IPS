package backend.data.campaniaaccionistas.commands;

import backend.data.Database;

public class AddAccionistaEnCampania {
	
	private static final String QUERY = "INSERT INTO PARTICIPA_EN_CAMPANIA "
			+ "(COD_CAMPANIA, ID_ACCIONISTA, NUM_ACCIONES_INICIALES, NUM_ACCIONES_COMPRADAS) VALUES (?, ?, ?)";
	
	private Database db = new Database();
	private String idAccionista;
	private String codCampania;
	private int numAcciones;
	
	public AddAccionistaEnCampania(String idAccionista, String codCampania, int numAccionesIniciales) {
		if (idAccionista == null)
			throw new IllegalArgumentException("El id de accionista no puede ser null");
		if (codCampania == null)
			throw new IllegalArgumentException("El código de campaña no puede ser null");
		this.idAccionista = idAccionista;
		this.codCampania = codCampania;
		this.numAcciones = numAccionesIniciales;
	}

	public void execute() {
		db.executeUpdate(QUERY, codCampania, idAccionista, numAcciones, 0);
	}

}
