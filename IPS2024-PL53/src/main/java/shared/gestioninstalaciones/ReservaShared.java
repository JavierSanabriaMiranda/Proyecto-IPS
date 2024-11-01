package shared.gestioninstalaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDImpl;
import backend.data.entrenamientos.commands.DtoAssemblerEntrenamientos;
import backend.data.reservaJardineria.ReservaJardineriaCRUDImpl;
import backend.data.reservaJardineria.ReservaJardineriaCRUDService;
import backend.data.reservaJardineria.ReservaJardineriaDTO;
import backend.data.ventas.ClienteReservaDto;
import backend.data.ventas.ReservaDto;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.commands.DtoAssemblerVentas;
import backend.service.empleados.nodeportivos.EmpleadoJardineria;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.reservaJardineria.ReservaJardineria;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestionjardineria.GestorJardineros;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class ReservaShared {

	
	GestorReserva gestor = new GestorInstalaciones();
	GerenteVentas gerente = new Gerente();
	GestorJardineros gestorJardineros = new Gerente();
	
	public ReservaShared() {
		cargaBBDD();
	}
	
	private void cargaBBDD() {
		cargaInstalaciones();
		cargarReservaEnInstalaciones();
		cargarEntrenamientosEnInstalaciones();
		cargarReservaJardineriaEnInstalaciones();
	}
	
	private void cargarReservaJardineriaEnInstalaciones() {
		List<ReservaJardineria> reservasJardineria = cargarResevasJardineria();
		for (Instalacion inst : gestor.getInstalaciones()) {
			for (ReservaJardineria reserva : reservasJardineria) {
				if (reserva.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addReservaJardineria(reserva);
			}
		}
	}
	
	private List<ReservaJardineria> cargarResevasJardineria() {
		ReservaJardineriaCRUDService service = new ReservaJardineriaCRUDImpl();
		List<ReservaJardineriaDTO> dtos = service.cargarReservasJardineria();
		List<ReservaJardineria> reservas = new ArrayList<>();
		for(ReservaJardineriaDTO dto: dtos) {
			Instalacion inst = gestor.buscaInstalacion(dto.codInstalacion);
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA_JARDINERIA, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFin), DateToLocalDate.convertToLocalDate(dto.fecha));
			//EmpleadoJardineria empleado = (EmpleadoJardineria) gestorJardineros.getEmpleadoNoDeportivo(dto.idJardinero);
			ReservaJardineria reserva = new ReservaJardineria(franja, inst, null, dto.codReservaJardineria);
			
			reservas.add(reserva);
		}
		
		return reservas;
	}
	
	private void cargarReservaEnInstalaciones() {
		List<Reserva> reservas = cargarReservas();
		for (Instalacion inst : gestor.getInstalaciones()) {
			for (Reserva reserva : reservas) {
				if (reserva.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addReserva(reserva);
			}
		}
	}
	
	private void cargarEntrenamientosEnInstalaciones() {
		List<Entrenamiento> entrenamientos = cargarEntrenamientos();
		for (Instalacion inst : gestor.getInstalaciones()) {
			for (Entrenamiento entrenamiento : entrenamientos) {
				if (entrenamiento.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addEntrenamiento(entrenamiento);
			}
		}
	}

	private List<Entrenamiento> cargarEntrenamientos() {
		EntrenamientoCRUDService service = new EntrenamientoCRUDImpl();
		DtoAssemblerEntrenamientos assembler = new DtoAssemblerEntrenamientos(gestor);
		return assembler.dtoToEntrenamiento(service.cargarEntrenamientos());
	}

	private List<Reserva> cargarReservas() {
		VentasCRUDService service = new VentasCRUDImpl();
		DtoAssemblerVentas assembler = new DtoAssemblerVentas(gestor);
		return assembler.dtoToReserva(service.cargarReservas());
	}
	
	public List<Instalacion> cargaInstalaciones(){
		 return gestor.cargarInstalaciones();
	}
	
	
	public List<FranjaTiempo> getEventos(Instalacion instalacion, LocalDate fecha) {
		return gestor.consultarDisponibilidad(instalacion, fecha);
	}

	public List<Instalacion> getInstalaciones(){
		return gestor.getInstalaciones();
	}
	
	public Instalacion buscaInstalacion(String nombreInst) {
		return gestor.buscaInstalacion(nombreInst);
	}
	
	
	public boolean isHorarioValido(Instalacion inst, FranjaTiempo franja) {
		return gestor.isHorarioValido(inst, franja);
	}
	
	private void borrarReservaDeJardineriaDeBBDD(List<ReservaJardineria> reservas) {
		for(ReservaJardineria reserva :reservas) {
			ReservaJardineriaCRUDService service = new ReservaJardineriaCRUDImpl();
			service.deleteReservaJardineria(reserva.getCodReservaJardineria());
		}
	}

	
	/**
	 * Añade la reserva a la lista de reservas y la base de datos
	 * 
	 * Modificación añadida tras Sprint 2:
	 * Ahora, si se hace una reserva en un horario valido. Se debe de comprobar si esta reserva coincide con la asignacion de 
	 * un jardinero a esa misma instalacion. Si es así esa asignacion del jardinero debe desaparecer. (El cliente no debe enterarse
	 *  de que esto ocurre)
	 */
	public void addReserva(FranjaTiempo horario, Instalacion instalacion, ClienteReserva cliente, float precio, Date fecha,
			String DNI, String numTarjeta) {
		String codReserva = gestor.creaCodReserva();
		String codInst = instalacion.getNombreInstalacion();
		//Creo una nueva reserva y se la añado tanto a la lista de ventas del gerente como a la lista de reservas del gestor de instalaciones
		Reserva reserva = new Reserva( codReserva, horario, instalacion, cliente, precio, fecha, numTarjeta);
		gestor.addReservaAInstalacion(reserva, instalacion);
		gerente.addVentaAGerenteVentas(reserva);
		
		addVentaBBDD(codReserva, DNI, fecha, precio, horario, cliente, numTarjeta, codInst);
		
		//Borro la reserva de jardineria si es que coincide con la nueva reserva
		borraReservaJardineriaCoincidente(horario, instalacion, reserva);
	}

	private void borraReservaJardineriaCoincidente(FranjaTiempo horario, Instalacion instalacion, Reserva reserva) {
		List<ReservaJardineria> reservaJardineria = gestor.comprobarCoincidenciaConJardineria(instalacion, horario);
		//Si es != null significa que la reserva coincide con la de un jardinero, asi que hay que borrar esa reserva
		if (!reservaJardineria.isEmpty()) {
			//Borrar reserva de la BBDD
			borrarReservaDeJardineriaDeBBDD(reservaJardineria);
			//Borrar reserva de la lista de reservas de la instalacion
			for(ReservaJardineria reservaJar : reservaJardineria) {
				gestor.getReservasJardineria().remove(reservaJar);
			}
		}
	}
	
	private void addVentaBBDD(String codReserva, String DNI, Date fecha, float coste, FranjaTiempo franja, ClienteReserva cliente,
			String numTarjeta, String codInst) {
		VentasCRUDService service = new VentasCRUDImpl();
		//Add del cliente -> si ya existe, no se añade
		ClienteReservaDto dtoC = new ClienteReservaDto();
		dtoC.DNI = DNI;
		dtoC.nombre = cliente.getNombre();
		service.addCliente(dtoC);
		//Add de la venta
		VentaDto dtoV = new VentaDto();
		dtoV.coste = coste;
		dtoV.DNI = DNI;
		dtoV.fecha = new Date();
		dtoV.idVenta = codReserva;
		service.addVentas(dtoV);
		//Add de la Reserva
		ReservaDto dtoR = new ReservaDto();
		dtoR.codInstalacion = codInst;
		dtoR.codReserva = codReserva;
		dtoR.coste = coste;
		dtoR.DNI = DNI;
		dtoR.fecha = fecha;
		dtoR.horaFin = DateToLocalTimeConverter.combinarFechaYHora(fecha, franja.getHoraFin());
		dtoR.horaInicio = DateToLocalTimeConverter.combinarFechaYHora(fecha, franja.getHoraInicio());
		dtoR.nombreCliente = cliente.getNombre();
		dtoR.numTarjeta = numTarjeta;
		service.addReserva(dtoR);
		
	}
	
	
	
}
