package backend.service.equipos;

import java.util.List;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Entrenador;
import backend.service.empleados.deportivos.Jugador;
import backend.service.eventos.Entrenamiento;

public class EquipoEnFormacion extends EquipoBase{
	
	private CategoriaEquipoFormacion categoria;
	
	public EquipoEnFormacion(CategoriaEquipoFormacion categoria, String idEquipo) {
		super(idEquipo);
		this.categoria = categoria;
	}
	
	public EquipoEnFormacion(List<Jugador> jugadores, List<Entrenador> entrenadores) {
		super(jugadores, entrenadores);
	}
	
	
	public CategoriaEquipoFormacion getCategoria() {
		return categoria;
	}

	@Override
	public boolean esProfesional() {
		return false;
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
