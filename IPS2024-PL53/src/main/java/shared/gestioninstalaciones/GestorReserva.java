package shared.gestioninstalaciones;

import java.util.Date;
import java.util.List;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;

public interface GestorReserva {
	
	public List<FranjaTiempo> consultarDisponibilidad(Instalacion instalacion, Date dia);
	
	public boolean isHorarioValido(Instalacion instalacion ,FranjaTiempo franja);

	public Instalacion buscaInstalacion(String codInstalacion);

}
