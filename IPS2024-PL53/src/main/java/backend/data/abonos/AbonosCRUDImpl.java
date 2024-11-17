package backend.data.abonos;

import java.util.Optional;

import backend.data.abonos.commands.FindAbonoByCode;

public class AbonosCRUDImpl implements AbonosCRUDService{

	@Override
	public Optional<AbonoDTO> findAbonoByCode(String cod) {
		return new FindAbonoByCode(cod).execute();
	}

	
	
}
