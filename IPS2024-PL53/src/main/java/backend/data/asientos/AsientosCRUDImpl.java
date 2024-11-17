package backend.data.asientos;

import backend.data.asientos.commands.AddAsiento;
import backend.data.asientos.commands.FindAsientoEqual;
import backend.data.asientos.commands.FindByIdAsiento;

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

}
