package backend.data.gastos;

import java.util.List;

import backend.data.gastos.commands.FindGastosPeriocidadAnual;
import backend.util.log.LogManager;

public class GastosCRUDImpl implements GastosCRUDService {

	@Override
	public List<GastoDto> findGastosPeriocidadAnual( ) {
		LogManager.logAction("Acceso en Base de Datos. Tablas: EMPLEADO_DEPORTIVO y EMPLEADO_NO_DEPORTIVO");
		return new FindGastosPeriocidadAnual().execute();
	}

}
