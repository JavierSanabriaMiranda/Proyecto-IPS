package backend.data.asientos;

import backend.data.asientos.commands.AddAsiento;
import backend.data.asientos.commands.FindAsientoEqual;
import backend.data.asientos.commands.FindByIdAsiento;
import backend.data.asientos.commands.IsAsientoOcupadoPorAbono;
import backend.data.asientos.commands.IsAsientoOcupadoPorEntrada;

public class AsientosCRUDImpl implements AsientosCRUDService {

	@Override
	public void addAsiento(AsientoDTO dtoA) {
		new AddAsiento(dtoA).execute();
	}

	@Override
	public AsientoDTO findByIdAsiento(String idAsiento) {
		return new FindByIdAsiento(idAsiento).execute();
	}
	
	@Override
	public AsientoDTO findEqualAsiento(String tribuna,String seccion, String fila, String asiento) {
		return new FindAsientoEqual(tribuna,seccion,fila,asiento).execute();
	}

	@Override
	public boolean isAsientoOcupadoPorAbono(String idAsiento) {
		return new IsAsientoOcupadoPorAbono(idAsiento).execute();
	}

	@Override
	public boolean isAsientoOcupadoPorEntrada(String idAsiento, String idPartido) {
		return new IsAsientoOcupadoPorEntrada(idAsiento,idPartido).execute();
	}

}
