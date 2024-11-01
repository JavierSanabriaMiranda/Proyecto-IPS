package backend.data.accionistas.commands;

import java.util.List;
import java.util.Map;

import backend.data.Database;

public class GetNumAccionesByDniAccionista {
	
	private static final String QUERY = "SELECT COUNT(ID_ACCION) AS NUM_ACCIONES FROM ACCION A "
			+ "INNER JOIN ACCIONISTA AC ON AC.ID_ACCIONISTA = A.ID_ACCIONISTA WHERE DNI = ?";
	
	private String dni;
	private Database db = new Database();

	public GetNumAccionesByDniAccionista(String dniAccionista) {
		if (dniAccionista == null)
			throw new IllegalArgumentException("El dni no puede ser null");
		this.dni = dniAccionista;
	}

	public int execute() {
		List<Map<String, Object>> acciones = db.executeQueryMap(QUERY, dni);
		int numAcciones = ((Long) acciones.get(0).get("NUM_ACCIONES")).intValue();
		return numAcciones;
	}

}
