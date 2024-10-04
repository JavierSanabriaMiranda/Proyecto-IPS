package backend.service.ventas.reservas;

import java.util.Date;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.VentaBase;

public class Reserva extends VentaBase{
	
	private FranjaTiempo horario;
	private Instalacion instalacion;
	private ClienteReserva cliente;
	
	public Reserva(FranjaTiempo horario, Instalacion instalacion, ClienteReserva cliente, double precio, Date fecha) {
		super(precio, fecha);
		this.horario = horario;
		this.instalacion = instalacion;
		this.cliente = cliente;
	}
	
	public FranjaTiempo getHorario() {
		return horario;
	}

	public void setHorario(FranjaTiempo horario) {
		this.horario = horario;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public ClienteReserva getCliente() {
		return cliente;
	}

	public void setCliente(ClienteReserva cliente) {
		this.cliente = cliente;
	}

	
	
	
	

}
