package backend.data.abonos;

import java.util.Optional;

import backend.data.abonos.commands.FindAbonoByCode;
import backend.data.abonos.commands.AddAbono;

public class AbonosCRUDImpl implements AbonosCRUDService {

	@Override
	public Optional<AbonoDTO> findAbonoByCode(String cod) {
		return new FindAbonoByCode(cod).execute();
	}
    @Override
    public void addAbono(AbonoDTO abono) {
        new AddAbono(abono).execute();
    }
}
