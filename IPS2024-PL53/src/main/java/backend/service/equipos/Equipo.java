package backend.service.equipos;

import java.util.List;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Jugador;
import backend.service.eventos.Entrenamiento;
import backend.service.eventos.Partido;

public interface Equipo {

	boolean esProfesional();
	String getIdEquipo();
	void addEntrenamiento(Entrenamiento entrenamiento);
	List<Jugador> getJugadores();
	void addJugadoresAEquipo(EmpleadoDeportivo emp);
	List<Partido> getPartidos();
}
