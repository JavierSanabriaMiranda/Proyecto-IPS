package shared.gestionequipos.horarios;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import frontend.SwingUtil;
import frontend.equiposUI.horarios.VentanaHorarioEquipos;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class GestionPanelHorarioEquiposShared {

	private VentanaHorarioEquipos view;
	
	public GestionPanelHorarioEquiposShared(VentanaHorarioEquipos view) {
		this.view = view;
	}

	public VentanaHorarioEquipos getView() {
		return view;
	}
	
	public void initControllers() {
		view.getBtnHorario().addActionListener(e -> SwingUtil.exceptionWrapper(() -> compruebaFechaYMuestraHorario()));
		
		view.getBtnAtras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getBtnAñadirEntrenamiento().addActionListener(e -> SwingUtil.exceptionWrapper(() -> resgistrarEntrenamiento()));
		
		view.getCbInstalaciones().addActionListener(e -> SwingUtil.exceptionWrapper(() ->vaciaPanelHorario()));
		
		view.getDateChooser().getDateEditor().addPropertyChangeListener("date", e -> 
        SwingUtil.exceptionWrapper(() -> vaciaPanelHorario()));
	}
	
	private void vaciaPanelHorario() {
		view.getPnHorarioContent().removeAll();
		view.repaint();
		view.revalidate();
	}
	
	
	private void compruebaFechaYMuestraHorario() {
		if (view.getDateChooser().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha para poder ver el horario de la instalación.",
					"Error en la selección de día", JOptionPane.WARNING_MESSAGE);
		} else {
			mostrarHorarioInstalacion();
		}
	}
	
	private void mostrarHorarioInstalacion() {
		view.getPnHorarioContent().removeAll(); // Limpiamos el panel antes de actualizar

		// Suponemos que obtienes las franjas ocupadas del backend
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(view.getDateChooser().getDate());

		Instalacion inst = (Instalacion) view.getCbInstalaciones().getSelectedItem();
		List<FranjaTiempo> eventosDelDia = view.getHorarioEntrenamientoShared().getEventos(inst, fechaSeleccionada); 

		LocalTime horaInicio = LocalTime.of(0, 0);

		List<JLabel> labelsHorarios = new ArrayList<>();

		for (int i = 0; i < 24; i++) {
			LocalTime intervaloInicio = horaInicio.plusHours(i);
			LocalTime intervaloFin = intervaloInicio.plusHours(1);

			// Crear la etiqueta para este intervalo
			JLabel labelHorario = new JLabel(intervaloInicio + " - " + intervaloFin);
			labelHorario.setOpaque(true); // Para permitir el cambio de color de fondo
			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
			labelHorario.setBorder(border);

			// Verificar si esta franja está ocupada por reservas o entrenamientos
			boolean estaReservada = false;
			boolean esEntrenamiento = false;

			for (FranjaTiempo evento : eventosDelDia) {
				if (evento.getHoraInicio().isBefore(intervaloFin) && evento.getHoraFin().isAfter(intervaloInicio)) {
					// Si el evento es un entrenamiento o una reserva
					if (evento.getEvento() == TipoEvento.ENTRENAMIENTO) {
						esEntrenamiento = true;
					} else if(evento.getEvento() == TipoEvento.RESERVA) {
						estaReservada = true;
					}
					break; // No necesitamos seguir buscando si ya encontramos un solapamiento
				}
			}

			// Establecer el color de fondo según el estado
			if (esEntrenamiento) {
				labelHorario.setBackground(Color.GRAY); // Azul para entrenamientos
				labelHorario.setText(labelHorario.getText() + " (Entrenamiento)");
			} else if (estaReservada) {
				labelHorario.setBackground(Color.DARK_GRAY); // Rojo para reservas
				labelHorario.setForeground(Color.WHITE);
				labelHorario.setText(labelHorario.getText() + " (Reservado)");
			} else {
				labelHorario.setBackground(Color.WHITE); // Verde para disponibilidad
				labelHorario.setText(labelHorario.getText() + " (Disponible)");
			}

			// Añadir la etiqueta al panel
			labelsHorarios.add(labelHorario);
			view.getPnHorarioContent().add(labelHorario);
		}

		view.getPnHorarioContent().revalidate();
		view.getPnHorarioContent().repaint();
	}
	
	private void resgistrarEntrenamiento() {
		if (!verificarHoraInicioAnteriorAHoraFin()) {
			JOptionPane.showMessageDialog(null, "La hora de inicio debe ser anterior a la hora de fin.",
					"Error en la selección de horas", JOptionPane.WARNING_MESSAGE);
		} else if (verificarSeleccionDeFecha()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar el día del entrenamiento.",
					"Error en la selección de día", JOptionPane.WARNING_MESSAGE);
		} else if (!isValidHorarioInstalacion()) {
			JOptionPane.showMessageDialog(null, "El horario seleccionado no se encuentra dentro del horario disponible de la instalación.",
					"Error en la selección de horas", JOptionPane.WARNING_MESSAGE);
		}
		else {
			addEntrenamiento();
			JOptionPane.showMessageDialog(null, "El horario del entrenamiento ha sido registrado.",
					"Entrenamiento registrado", JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		}
	}
	
	
	private void addEntrenamiento() {
		Date fecha = view.getDateChooser().getDate();
		
		view.getHorarioEntrenamientoShared().addEntrenamiento(getEntrenador(), getInstalacionReserva(), getFranjaReserva(), fecha);
	}
	
	
	
	public FranjaTiempo getFranjaReserva() {
		Date horaInicio = (Date) view.getSpHoraInicio().getValue();
		Date horaFin = (Date) view.getSpHoraFin().getValue();
		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA, inicio, fin,
				DateToLocalDate.convertToLocalDate(view.getDateChooser().getDate()));
		return franja;
	}

	public Instalacion getInstalacionReserva() {
		Instalacion inst = (Instalacion) view.getCbInstalaciones().getSelectedItem();
		String nombreInstalacion = inst.getNombreInstalacion();
		Instalacion instalacion = view.getHorarioEntrenamientoShared().buscaInstalacion(nombreInstalacion);
		return instalacion;
	}
	
	public EmpleadoDeportivo getEntrenador() {
		EmpleadoDeportivo inst = (EmpleadoDeportivo) view.getCbEntrenadores().getSelectedItem();
		String idEntrenador = inst.getIDEmpleado();
		EmpleadoDeportivo empleado = view.getHorarioEntrenamientoShared().buscaEmpleado(idEntrenador);
		return empleado;
	}
	
	private boolean verificarSeleccionDeFecha() {
		if(view.getDateChooser().getDate() == null)
			return true;
		return false;
	}

	private boolean verificarHoraInicioAnteriorAHoraFin() {
		Date horaInicio = (Date) view.getSpHoraInicio().getValue();
		Date horaFin = (Date) view.getSpHoraFin().getValue();
		if (horaInicio.before(horaFin) || !horaInicio.equals(horaFin)) {
			return true;
		}
		return false;

	}
	
	private boolean isValidHorarioInstalacion() {
		Date horaInicio = (Date) view.getSpHoraInicio().getValue();
		Date horaFin = (Date) view.getSpHoraFin().getValue();

		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.ENTRENAMIENTO, inicio, fin,
				DateToLocalDate.convertToLocalDate(view.getDateChooser().getDate()));
		Instalacion instalacion = (Instalacion) view.getCbInstalaciones().getSelectedItem();

		
		
		if (view.getHorarioEntrenamientoShared().isHorarioValido(instalacion, franja)) {
			return true;
		} else {
			return false;
		}
	}
}
