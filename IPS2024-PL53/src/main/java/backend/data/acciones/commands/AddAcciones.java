package backend.data.acciones.commands;

import java.util.List;

import backend.data.Database;
import backend.data.acciones.AccionDTO;

public class AddAcciones {
	
	private static final String QUERY = "INSERT INTO ACCION (ID_ACCION, ID_ACCIONISTA, PRECIO) "
			+ "VALUES (?, ?, ?)";

	private List<AccionDTO> acciones;
	private Database db = new Database();
	
	public AddAcciones(List<AccionDTO> dtosAcc) {
		if (dtosAcc == null || dtosAcc.contains(null))
			throw new IllegalArgumentException("La lista no puede ser null ni contener null");
		this.acciones = dtosAcc;
	}

	public void execute() {
		for (AccionDTO dto : acciones) {
			db.executeUpdate(QUERY, dto.getIdAccion(), dto.getIdAccionista(), dto.getPrecio());
		}
	}

}
