package shared.gestionjardineria;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.horarios.Horario;
import backend.service.empleados.nodeportivos.horarios.Turno;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import frontend.SwingUtil;
import frontend.jardineriaUI.HorarioJardineria;
import frontend.jardineriaUI.VentanaJardineros;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class GestionPanelJardineriaShared {
	private VentanaJardineros view;
	private HorarioJardineria diagJar;

	public GestionPanelJardineriaShared(VentanaJardineros view) {
		this.view = view;
	}

	public VentanaJardineros getView() {
		return view;
	}

	public HorarioJardineria getDiagJar() {
		return diagJar;
	}

	public void initController() {
		view.getBtnSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actionSiguiente()));
	}

	private void actionSiguiente() {
		if (compruebaSeleccion()) {
			creaHorarioJardineria();
		}
	}

	public boolean compruebaSeleccion() {
		// Verificar si se ha seleccionado un empleado en la lista de jardineros
		if (view.getListJardineros().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(view, "Debe seleccionar un empleado de la lista.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		// Verificar si se ha seleccionado una instalación en el comboBox
		if (view.getCbInstalaciones().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(view, "Debe seleccionar una instalación.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		// Verificar si se ha seleccionado una fecha en el dateChooser
		if (view.getDateChooser().getDate() == null) {
			JOptionPane.showMessageDialog(view, "Debe seleccionar un día.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	private void creaHorarioJardineria() {
		try {
			HorarioJardineria dialog = new HorarioJardineria(view);
			this.diagJar = dialog;
			initControllersHorario();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initControllersHorario() {
		diagJar.getBtnAñadir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> validarHorario()));

	}

	// ---------------------------METODOS PARA LA VENTANA DE HORARIO JARDINERIA--------------------------

	private void validarHorario() {
		if (!verificarHoraInicioAnteriorAHoraFin()) {
			JOptionPane.showMessageDialog(null, "La hora de inicio debe ser anterior a la hora de fin.",
					"Error en la selección de horas", JOptionPane.WARNING_MESSAGE);
		} else if (!isValidHorarioEmpleado()) {
			JOptionPane.showMessageDialog(null, "El horario seleccionado no se encuentra dentro del horario del empleado.",
					"Error en la selección de horas", JOptionPane.WARNING_MESSAGE);
		} else if (!isValidHorarioInstalacion()) {
			JOptionPane.showMessageDialog(null, "El horario seleccionado no se encuentra dentro del horario disponible de la instalación.",
					"Error en la selección de horas", JOptionPane.WARNING_MESSAGE);
		} else {
			System.out.println("Añadido");
		}
		
	}


	public boolean verificarHoraInicioAnteriorAHoraFin() {
		Date horaInicio = (Date) diagJar.getSpHoraInicio().getValue();
		Date horaFin = (Date) diagJar.getSpHoraFin().getValue();
		if (horaInicio.before(horaFin) || !horaInicio.equals(horaFin)) {
			return true;
		}
		return false;

	}
	
	private boolean isValidHorarioEmpleado() {
		EmpleadoNoDeportivo empleado = diagJar.getVj().getListJardineros().getSelectedValue();
		Horario horarioEmpleado = empleado.getHorario();
		List<Turno> turnosEmpleado = horarioEmpleado.getHorarioDia(DateToLocalDate.convertToLocalDate(diagJar.getVj().getDateChooser().getDate()));
		Date horaInicioDate = (Date) diagJar.getSpHoraInicio().getValue();
		Date horaFinDate = (Date) diagJar.getSpHoraFin().getValue();
		LocalTime horaInicio = horaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	    LocalTime horaFin = horaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

		// Lista para guardar intervalos combinados de turnos consecutivos
	    List<LocalTime[]> intervalosCombinados = new ArrayList<>();
	    Collections.sort(turnosEmpleado);
	    // Variables para iniciar el intervalo combinado actual
	    LocalTime intervaloInicio = null;
	    LocalTime intervaloFin = null;

	    for (Turno turno : turnosEmpleado) {
	        LocalTime turnoInicio = turno.getHoraInicio();
	        LocalTime turnoFin = turno.getHoraFin();

	        if (intervaloInicio == null) {
	            // Si no hay un intervalo iniciado, iniciar con el turno actual
	            intervaloInicio = turnoInicio;
	            intervaloFin = turnoFin;
	        } else if (intervaloFin.equals(turnoInicio)) {
	            // Si el turno es consecutivo, ampliar el intervalo actual
	            intervaloFin = turnoFin;
	        } else {
	            // Si no es consecutivo, guardar el intervalo actual y empezar uno nuevo
	            intervalosCombinados.add(new LocalTime[] { intervaloInicio, intervaloFin });
	            intervaloInicio = turnoInicio;
	            intervaloFin = turnoFin;
	        }
	    }
	    // Agregar el último intervalo combinado después de salir del bucle
	    if (intervaloInicio != null) {
	        intervalosCombinados.add(new LocalTime[] { intervaloInicio, intervaloFin });
	    }

	    // Verificar si el rango (horaInicio - horaFin) cae dentro de algún intervalo combinado
	    for (LocalTime[] intervalo : intervalosCombinados) {
	        LocalTime inicioIntervalo = intervalo[0];
	        LocalTime finIntervalo = intervalo[1];

	        // Comprobar si el rango seleccionado cae dentro del intervalo combinado
	        if (!horaInicio.isBefore(inicioIntervalo) && !horaFin.isAfter(finIntervalo)) {
	            return true; // El rango está completamente dentro de un intervalo combinado
	        }
	    }
	    // Si no se encontró ningún intervalo combinado que contenga el rango, devolver false
	    return false;
	}
	

	private boolean isValidHorarioInstalacion() {
		Date horaInicio = (Date) diagJar.getSpHoraInicio().getValue();
		Date horaFin = (Date) diagJar.getSpHoraFin().getValue();

		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA, inicio, fin,
				DateToLocalDate.convertToLocalDate(diagJar.getVj().getDateChooser().getDate()));
		Instalacion instalacion = (Instalacion) diagJar.getVj().getCbInstalaciones().getSelectedItem();

		if (diagJar.getVj().getJardinerosShared().isHorarioValidoParaJardinero(instalacion, franja)) {
			return true;
		} else {
			return false;
		}
	}

}
