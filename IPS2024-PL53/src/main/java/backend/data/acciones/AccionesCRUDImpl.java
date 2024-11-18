package backend.data.acciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.acciones.commands.AddAcciones;
import backend.data.acciones.commands.FindAccionesByDNI;
import backend.data.acciones.commands.FindAccionesEnVentaDisponiblesParaAccionistaPorDni;
import backend.data.acciones.commands.UpdateAccion;
import backend.data.acciones.commands.UpdateIsEnVenta;
import backend.util.log.LogManager;

public class AccionesCRUDImpl implements AccionesCRUDService {

	@Override
	public void addAcciones(List<AccionDTO> dtosAcc) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ACCION");
		new AddAcciones(dtosAcc).execute();
	}
	
	@Override
	public List<AccionDTO> findAccionesByDNI(String DNI) {
		List<AccionDTO> res = new ArrayList<>();
    	try {
    		LogManager.logAction("Acceso a Base de Datos. Tabla: ACCION");
            res = new FindAccionesByDNI(DNI).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return res;
	}

	@Override
	public void updateIsEnVenta(AccionDTO accion, boolean estado) {
    	try {
    		LogManager.logAction("Modificación en Base de Datos. Tabla: ACCION");
            new UpdateIsEnVenta(accion,estado).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<AccionDTO> getAccionesEnVentaParaAccionista(String idAccionista) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ACCION");
		return new FindAccionesEnVentaDisponiblesParaAccionistaPorDni(idAccionista).execute();
	}

	@Override
	public void updateAccion(AccionDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ACCION");
		new UpdateAccion(dto).execute();
	}

}
