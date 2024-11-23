package backend.data.gastos;

import java.util.List;

import backend.data.gastos.commands.FindGastosPeriocidadAnual;

public class GastosCRUDImpl implements GastosCRUDService {

	@Override
	public List<GastoDto> findGastosPeriocidadAnual( ) {
		return new FindGastosPeriocidadAnual().execute();
	}

}
