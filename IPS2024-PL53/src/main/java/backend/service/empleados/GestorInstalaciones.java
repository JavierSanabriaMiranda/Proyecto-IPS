package backend.service.empleados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestioninstalaciones.GestorReserva;

public class GestorInstalaciones implements GestorReserva{
	
	List<Instalacion> instalaciones = new ArrayList<Instalacion>();
	
	public GestorInstalaciones() {
		instalaciones = cargarInstalaciones();
	}
	
	/**
	 * @param instalacion Instalacion que se quiere reservar
	 * @param dia Dia en el que se quiere hacer la reserva
	 * @return 
	 */
	public List<FranjaTiempo> consultarDisponibilidad(Instalacion instalacion, Date dia) {
		return instalacion.getEventos(dia); 
	}

	private List<Instalacion> cargarInstalaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}
	
	public void reserva(ClienteReserva cliente, Instalacion instalacion, FranjaTiempo franja, double precio, Date fecha) {
		instalacion.addReserva(new Reserva(franja, instalacion, cliente, precio, fecha));
	}

	@Override
	public boolean isHorarioValido(Instalacion instalacion ,FranjaTiempo franja) {
		return instalacion.esFranjaPosible(franja);
	}
	
	@Override
	public Instalacion buscaInstalacion(String codInstalacion) {
		for (Instalacion inst : instalaciones) {
			if (inst.getNombreInstalacion() == codInstalacion){
				return inst;
			}
		}
		return null;
	}
	

}
