package shared.gestioninstalaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import backend.data.instalaciones.InstalacionCRUDService;
import backend.data.instalaciones.InstalacionCRUDServiceImpl;
import backend.data.instalaciones.commands.DtoAssembler;
import backend.service.horarios.FranjaTiempo;
import backend.service.reservaJardineria.ReservaJardineria;
import backend.service.ventas.reservas.GeneradorCodReserva;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;

public class GestorInstalaciones implements GestorReserva{
	
	List<Instalacion> instalaciones = new ArrayList<Instalacion>();
	
	public GestorInstalaciones() {
		
	}
	
	/**
	 * @param instalacion Instalacion que se quiere reservar
	 * @param dia Dia en el que se quiere hacer la reserva
	 * @return 
	 */
	public List<FranjaTiempo> consultarDisponibilidad(Instalacion instalacion, LocalDate dia) {
		return instalacion.getEventos(dia); 
	}

	@Override
	public List<Instalacion> cargarInstalaciones() {
		InstalacionCRUDService service = new InstalacionCRUDServiceImpl();
		instalaciones = DtoAssembler.dtoToInstalacion(service.cargarInstalaciones());
		return instalaciones;
	}

	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}
	
	@Override
	public String creaCodReserva() {
		GeneradorCodReserva gen = new GeneradorCodReserva();
	    String cod;
	    boolean codDuplicado;

	    // Bucle que continúa generando códigos hasta encontrar uno único
	    do {
	        cod = gen.getNuevoCod();
	        codDuplicado = false;

	        // Recorremos todas las instalaciones y sus reservas para comprobar si el código ya existe
	        for (Instalacion ins : instalaciones) {
	            List<Reserva> listRes = ins.getReservas();
	            for (Reserva res : listRes) {
	                if (res.getCodReserva().equals(cod)) {
	                    codDuplicado = true;  // Si el código existe, marcamos como duplicado
	                    break;  // Salimos del bucle interno para generar un nuevo código
	                }
	            }
	            if (codDuplicado) {
	                break;  // Si el código ya existe, no es necesario seguir buscando
	            }
	        }
	    } while (codDuplicado);  // Si el código es duplicado, volvemos a generar otro

	    return cod;
	}

	@Override
	public boolean isHorarioValido(Instalacion instalacion ,FranjaTiempo franja) {
		return instalacion.esFranjaPosible(franja);
	}
	
	@Override
	public boolean isHorarioValidoParaJardinero(Instalacion instalacion ,FranjaTiempo franja) {
		return instalacion.esFranjaPosibleParaJardinero(franja);
	}
	
	@Override
	public Instalacion buscaInstalacion(String codInstalacion) {
		for (Instalacion inst : instalaciones) {
			if (inst.getNombreInstalacion().equals(codInstalacion)){
				return inst;
			}
		}
		return null;
	}

	@Override
	public void addReservaAInstalacion(Reserva reserva, Instalacion instalacion) {
		instalacion.addReserva(reserva);
	}

	@Override
	public void addReservaJardineriaAInstalacion(ReservaJardineria reserva, Instalacion instalacion) {
		instalacion.addReservaJardineria(reserva);
	}
	
	@Override
	public String creaCodReservaJardineria() {
		GeneradorCodReserva gen = new GeneradorCodReserva();
	    String cod;
	    boolean codDuplicado;

	    // Bucle que continúa generando códigos hasta encontrar uno único
	    do {
	        cod = gen.getNuevoCod();
	        codDuplicado = false;

	        // Recorremos todas las instalaciones y sus reservas para comprobar si el código ya existe
	        for (Instalacion ins : instalaciones) {
	            List<ReservaJardineria> listRes = ins.getReservasJardineria();
	            for (ReservaJardineria res : listRes) {
	                if (res.getCodReservaJardineria().equals(cod)) {
	                    codDuplicado = true;  // Si el código existe, marcamos como duplicado
	                    break;  // Salimos del bucle interno para generar un nuevo código
	                }
	            }
	            if (codDuplicado) {
	                break;  // Si el código ya existe, no es necesario seguir buscando
	            }
	        }
	    } while (codDuplicado);  // Si el código es duplicado, volvemos a generar otro

	    return cod;
	}
	
	

}
