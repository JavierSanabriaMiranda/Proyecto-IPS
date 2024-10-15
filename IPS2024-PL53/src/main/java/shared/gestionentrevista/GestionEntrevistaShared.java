package shared.gestionentrevista;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.EmpleadoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.partidos.PartidoDTO;
import backend.service.empleados.deportivos.Jugador;
import backend.util.FranjaEntrevistaException;
import shared.gestionempleados.GestionEmpleadosShared;
import shared.gestionentrenamientos.GestionEntrenamientoShared;
import shared.gestionpartido.GestionPartidoShared;
import backend.data.entrevistas.FranjaEntrevistaDTO;

public class GestionEntrevistaShared {

	private String idJugador;
	private String idEquipo;
	private Jugador jugador;
	
	private Date fecha;
	private Time horaInicio;
	private Time horaFin;
	
	private List<Jugador> jugadoresProfesionales = new ArrayList<>();
	
	EntrevistaCRUDService servicio = CreadorDataService.getEntrevistaService();
	
	public GestionEntrevistaShared() {
		cargarJugadoresProfesionales();
	}
	
	private void cargarJugadoresProfesionales() {
		List<EmpleadoDTO> jugadoresProfesionalesDTO = GestionEmpleadosShared.getAllJugadoresProfesionales();
		
		for (EmpleadoDTO dto : jugadoresProfesionalesDTO) {
			Jugador j = new Jugador(dto.nombre, dto.apellido, dto.DNI, dto.telefono, dto.fechaNac, dto.salarioAnual);
			j.setIDEmpleado(dto.id);
			jugadoresProfesionales.add(j);
		}
	}
	
	public List<Jugador> getJugadoresProfesionales() {		
		return jugadoresProfesionales;
	}
	
	public void seleccionarJugador(Jugador jugador) {
		this.jugador = jugador;
		this.idJugador = jugador.getIDEmpleado();
		EmpleadosCRUDService servicio = CreadorDataService.getEmpleadosService();
		this.idEquipo = servicio.findIdEquipoByJugadorId(idJugador);
	}
	
	public String seleccionarHora(String fechaString, String horaInicioString, String horaFinString) {
		String res = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
			fecha = dateFormat.parse(fechaString);
		} catch (ParseException e) {
			res = "Formato de fecha incorrecto";
		}
        
        horaInicio = Time.valueOf(horaInicioString);
        horaFin = Time.valueOf(horaFinString);
        
        return res;
	}

	public boolean canBeCreated() {
		GestionPartidoShared gps = new GestionPartidoShared();
		GestionEntrenamientoShared ges = new GestionEntrenamientoShared();
		
		return !gps.checkExistePartidoRangoHora(idEquipo, fecha, horaInicio, horaFin) 
				&& !ges.checkExisteEntrenamientoRangoHora(idEquipo, fecha, horaInicio, horaFin);
		
	}

	public boolean createFranja() {
		FranjaEntrevistaDTO franja = new FranjaEntrevistaDTO();
		franja.id_jugador = idJugador;
		franja.fecha = fecha;
		franja.hora_inicio = horaInicio;
		franja.hora_fin = horaFin;
		try {
			servicio.addFranjaEntrevista(franja);
		} catch (FranjaEntrevistaException e) {
			return false;
		}
		return true;
	}
	
	public String getJugadorNombreYApellidos() {
		return jugador.getNombre() + " " + jugador.getApellido();
	}
}
