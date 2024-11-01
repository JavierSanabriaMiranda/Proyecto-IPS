package backend.data.reservaJardineria.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.reservaJardineria.ReservaJardineriaDTO;
import backend.service.empleados.nodeportivos.EmpleadoJardineria;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.reservaJardineria.ReservaJardineria;
import backend.service.ventas.reservas.Instalacion;
import shared.gestioninstalaciones.GestorReserva;
import shared.gestionjardineria.GestorJardineros;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class DtoAssemblerJardineros {
	
	public DtoAssemblerJardineros(GestorReserva gestor, GestorJardineros gestorJar) {
		this.ges = gestor;
		this.gestorJardineros = gestorJar;
	}
	
	private GestorReserva ges;
	private GestorJardineros gestorJardineros;
	
	public List<ReservaJardineria> dtoToReservaJardineria(List<ReservaJardineriaDTO> listDto){
		List<ReservaJardineria> reservas = new ArrayList<>();
		for(ReservaJardineriaDTO dto: listDto) {
			Instalacion inst = ges.buscaInstalacion(dto.codInstalacion);
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA_JARDINERIA, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFin), DateToLocalDate.convertToLocalDate(dto.fecha));
			EmpleadoJardineria empleado = (EmpleadoJardineria) gestorJardineros.getEmpleadoNoDeportivo(dto.idJardinero);
			ReservaJardineria reserva = new ReservaJardineria(franja, inst, empleado, dto.codReservaJardineria);
			
			reservas.add(reserva);
		}
		return reservas;
	}
	
	
	
	
}
