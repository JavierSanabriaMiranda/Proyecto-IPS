package backend.service.equipos;

import java.util.List;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Entrenador;
import backend.service.empleados.deportivos.Jugador;
import backend.service.eventos.Entrenamiento;

public class EquipoProfesional extends EquipoBase{

	private NivelEquipoProfesional tipo;

	public EquipoProfesional(NivelEquipoProfesional tipo, String idEquipo) {
		super(idEquipo);
		this.tipo = tipo;
	}
	
	public EquipoProfesional(List<Jugador> jugadores, List<Entrenador> entrenadores, NivelEquipoProfesional tipo) {
		super(jugadores, entrenadores);
		this.tipo = tipo;
	}
	
	
	public NivelEquipoProfesional getTipo() {
		return tipo;
	}



	@Override
	public boolean esProfesional() {
		return true;
	}
	
	@Override
	public String toString() {
		return getIdEquipo();
	}

	@Override
	public void addEntrenamiento(Entrenamiento entrenamiento) {
		this.getEntrenamientos().add(entrenamiento);
		
	}
	
	@Override
	public void addJugadoresAEquipo(EmpleadoDeportivo emp) {
		this.getJugadores().add((Jugador)emp);
	}
	
	
}
