package backend.data.abonos;

import backend.data.abonos.commands.AddAbono;

public class AbonosCRUDImpl implements AbonosCRUDService {

	@Override
	public void addAbono(AbonoDTO abono) {
		new AddAbono(abono).execute();
	}

}
