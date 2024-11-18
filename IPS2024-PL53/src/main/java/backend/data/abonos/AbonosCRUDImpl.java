package backend.data.abonos;

import java.util.Optional;

import backend.data.abonos.commands.FindAbonoByCode;
import backend.util.log.LogManager;
import backend.data.abonos.commands.AddAbono;

public class AbonosCRUDImpl implements AbonosCRUDService {

	@Override
	public Optional<AbonoDTO> findAbonoByCode(String cod) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ABONO_TEMPORADA");
		return new FindAbonoByCode(cod).execute();
	}
    @Override
    public void addAbono(AbonoDTO abono) {
    	LogManager.logAction("Modificación en Base de Datos. Tabla: ABONO_TEMPORADA");
        new AddAbono(abono).execute();
    }
}
