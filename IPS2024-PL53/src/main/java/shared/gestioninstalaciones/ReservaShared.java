package shared.gestioninstalaciones;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDServiceImpl;
import backend.data.entrenamientos.commands.DtoAssemblerEntrenamientos;
import backend.data.ventas.ClienteReservaDto;
import backend.data.ventas.ReservaDto;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.commands.DtoAssemblerVentas;
import backend.service.empleados.GestorInstalaciones;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import util.DateToLocalTimeConverter;

public class ReservaShared {

	
	GestorReserva gestor = new GestorInstalaciones();
	GerenteVentas gerente = new Gerente();
	
	public ReservaShared() {
		cargaBBDD();
	}
	
	private void cargaBBDD() {
		cargaInstalaciones();
		cargarReservaEnInstalaciones();
		cargarEntrenamientosEnInstalaciones();
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
		EntrenamientoCRUDService service = new EntrenamientoCRUDServiceImpl();
		DtoAssemblerEntrenamientos assembler = new DtoAssemblerEntrenamientos(this);
		return assembler.dtoToEntrenamiento(service.cargarEntrenamientos());
	}

	private List<Reserva> cargarReservas() {
		VentasCRUDService service = new VentasCRUDImpl();
		DtoAssemblerVentas assembler = new DtoAssemblerVentas(this);
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
	
	/**
	 * Añade la reserva a la lista de reservas y la base de datos
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
		dtoV.fecha = fecha;
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
