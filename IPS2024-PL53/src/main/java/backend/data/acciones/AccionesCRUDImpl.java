package backend.data.acciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.acciones.commands.AddAcciones;
import backend.data.acciones.commands.FindAccionesByDNI;
import backend.data.acciones.commands.UpdateIsEnVenta;

public class AccionesCRUDImpl implements AccionesCRUDService {

	@Override
	public void addAcciones(List<AccionDTO> dtosAcc) {
		new AddAcciones(dtosAcc).execute();
	}
	
	@Override
	public List<AccionDTO> findAccionesByDNI(String DNI) {
		List<AccionDTO> res = new ArrayList<>();
    	try {
            res = new FindAccionesByDNI(DNI).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return res;
	}

	@Override
	public void updateIsEnVenta(AccionDTO accion, boolean estado) {
    	try {
            new UpdateIsEnVenta(accion,estado).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
