package backend.data.entradas;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import backend.data.entradas.commands.AddEntrada;
import backend.data.entradas.commands.FindAllEntrada;
import backend.data.entradas.commands.FindByIDPartidoEntrada;
import backend.data.entradas.commands.FindEntradaByAsientoAndPartido;
import backend.util.log.LogManager;

public class EntradasCRUDImpl implements EntradasCRUDService {

	@Override
	public void addEntrada(EntradaDTO entrada) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ENTRADA");
		new AddEntrada(entrada).execute();
	}

	@Override
	public List<EntradaDTO> findAllEntrada() {
		List<EntradaDTO> res = null;
		try {
			LogManager.logAction("Acceso a Base de Datos. Tabla: ENTRADA");
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
			LogManager.logAction("Acceso a Base de Datos. Tabla: ENTRADA");
			res = new FindByIDPartidoEntrada(idPartido).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Optional<EntradaDTO> findEntradaByAsientoAndPartido(String idAsiento, String idPartido) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ENTRADA");
		return new FindEntradaByAsientoAndPartido(idAsiento, idPartido).execute();
	}
	
	

}
