package shared.gestionequipos.horarios;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import frontend.SwingUtil;
import frontend.equiposUI.horarios.VentanaHorarioEquipos;
import util.DateToLocalDate;

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
}
