package backend.service.equipos;

import java.util.ArrayList;
import java.util.List;

import backend.service.empleados.deportivos.Entrenador;
import backend.service.empleados.deportivos.Jugador;
import backend.service.eventos.Entrenamiento;
import backend.service.eventos.Partido;

public abstract class EquipoBase implements Equipo{
	
	private String id_Equipo;
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	private List<Entrenador> entrenadores = new ArrayList<Entrenador>();
	private List<Partido> partidos = new ArrayList<Partido>();
	private List<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();
	
	public EquipoBase(String id_equipo){
		this.id_Equipo = id_equipo;
	}
	
	public EquipoBase(List<Jugador> jugadores, List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
		this.jugadores = jugadores;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}
	
	@Override
	public String getIdEquipo() {
		return id_Equipo;
	}

	public void setId_Equipo(String id_Equipo) {
		this.id_Equipo = id_Equipo;
	}
}
