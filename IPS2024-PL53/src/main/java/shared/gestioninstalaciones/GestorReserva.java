package shared.gestioninstalaciones;

import java.time.LocalDate;
import java.util.List;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;

public interface GestorReserva {
	
	public List<FranjaTiempo> consultarDisponibilidad(Instalacion instalacion, LocalDate dia);
	
	public boolean isHorarioValido(Instalacion instalacion ,FranjaTiempo franja);

	public Instalacion buscaInstalacion(String codInstalacion);
	
	public void addReservaAInstalacion(Reserva reserva, Instalacion instalacio);
	
	public String creaCodReserva();
	
	public List<Instalacion> cargarInstalaciones();
	
	public List<Instalacion> getInstalaciones();

	boolean isHorarioValidoParaJardinero(Instalacion instalacion, FranjaTiempo franja);

}
