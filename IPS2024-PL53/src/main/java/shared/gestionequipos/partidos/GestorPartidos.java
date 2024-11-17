package shared.gestionequipos.partidos;

import java.util.List;

import backend.service.eventos.Partido;

public interface GestorPartidos {

	void addPartidoConSuplemento(Partido partido);
	
	List<Partido> getPartidosConSuplemento();
}
