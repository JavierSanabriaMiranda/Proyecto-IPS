package backend.data.abonos.commands;

import backend.data.abonos.AbonoDTO;
import backend.service.ventas.abonos.Abono;

public class DtoAssemblerAbonos {
	
	public static Abono toAbono(AbonoDTO dto) {
		String idAsiento = dto.idAsiento;
		String codAbono = dto.codAbono;
		
		return new Abono(codAbono, idAsiento);
	}

}
