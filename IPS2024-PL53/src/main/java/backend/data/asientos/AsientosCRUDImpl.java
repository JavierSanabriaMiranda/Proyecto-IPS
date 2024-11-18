package backend.data.asientos;

import backend.data.asientos.commands.AddAsiento;
import backend.data.asientos.commands.FindAsientoEqual;
import backend.data.asientos.commands.FindByIdAsiento;
import backend.data.asientos.commands.IsAsientoOcupadoPorAbono;
import backend.data.asientos.commands.IsAsientoOcupadoPorEntrada;
import backend.util.log.LogManager;

public class AsientosCRUDImpl implements AsientosCRUDService {

	@Override
	public void addAsiento(AsientoDTO dtoA) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ASIENTO");
		new AddAsiento(dtoA).execute();
	}

	@Override
	public AsientoDTO findByIdAsiento(String idAsiento) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ASIENTO");
		return new FindByIdAsiento(idAsiento).execute();
	}
	
	@Override
	public AsientoDTO findEqualAsiento(String tribuna,String seccion, String fila, String asiento) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ASIENTO");
		return new FindAsientoEqual(tribuna,seccion,fila,asiento).execute();
	}

	@Override
	public boolean isAsientoOcupadoPorAbono(String idAsiento) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ASIENTO");
		return new IsAsientoOcupadoPorAbono(idAsiento).execute();
	}

	@Override
	public boolean isAsientoOcupadoPorEntrada(String idAsiento, String idPartido) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ASIENTO");
		return new IsAsientoOcupadoPorEntrada(idAsiento,idPartido).execute();
	}

}
