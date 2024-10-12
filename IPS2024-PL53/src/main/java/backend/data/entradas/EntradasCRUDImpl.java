package backend.data.entradas;

import java.sql.SQLException;
import java.util.List;

import backend.data.entradas.commands.AddEntrada;
import backend.data.entradas.commands.FindAllEntrada;
import backend.data.entradas.commands.FindByIDPartidoEntrada;

public class EntradasCRUDImpl implements EntradasCRUDService {

	@Override
	public void addEntrada(EntradaDTO entrada) {
		new AddEntrada(entrada).execute();
	}

	@Override
	public List<EntradaDTO> findAllEntrada() {
		List<EntradaDTO> res = null;
		try {
			res = new FindAllEntrada().execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<EntradaDTO> findByIDPartidoEntrada(String idPartido) {
		List<EntradaDTO> res = null;
		try {
			res = new FindByIDPartidoEntrada(idPartido).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	

}
