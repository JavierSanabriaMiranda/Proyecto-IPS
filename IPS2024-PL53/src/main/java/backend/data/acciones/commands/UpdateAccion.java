package backend.data.acciones.commands;

import backend.data.Database;
import backend.data.acciones.AccionDTO;

public class UpdateAccion {

	private static final String QUERY = "UPDATE ACCION SET "
			+ "ID_ACCIONISTA = ?, PRECIO = ?, ISENVENTA = ? WHERE ID_ACCION = ?";;
	
	private AccionDTO dto;
	private Database db = new Database();
	
	public UpdateAccion(AccionDTO dto) {
		if (dto == null)
			throw new IllegalArgumentException("El dto no puede ser null");
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY, dto.getIdAccionista(), dto.getPrecio(), dto.isEnVenta(), dto.getIdAccion());
	}

}
