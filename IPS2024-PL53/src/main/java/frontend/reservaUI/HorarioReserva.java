package frontend.reservaUI;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import java.awt.Font;

public class HorarioReserva extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VentanaPrincipalReserva vpr;
	private JScrollPane scrollPanelHorario;
	private JPanel panelSeleccion;
	private JPanel panelHorario;
	private JSpinner spinnerHoraInicio;
	private JSpinner spinnerHoraFin;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JButton btnSiguiente2;
	private JButton btnAtras2;
	private JButton btnValidador;
	private JLabel lblHorarioValido;

	/**
	 * Create the dialog.
	 */
	public HorarioReserva(VentanaPrincipalReserva vpr) {
		setTitle("ReservaHorario");
		setModal(true);
		this.vpr = vpr;
		setBounds(100, 100, 655, 665);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		contentPanel.add(getScrollPanelHorario());
		contentPanel.add(getPanelSeleccion());

		getPanelSeleccion().add(getSpinnerInicio());
		getPanelSeleccion().add(getSpinnerHoraFin());
		actualizarPanelHorario();
	}

	public VentanaPrincipalReserva getVpr() {
		return vpr;
	}

	private JScrollPane getScrollPanelHorario() {
		if (scrollPanelHorario == null) {
			scrollPanelHorario = new JScrollPane();
			scrollPanelHorario.setViewportView(getPanelHorario());
		}
		return scrollPanelHorario;
	}

	private JPanel getPanelSeleccion() {
		if (panelSeleccion == null) {
			panelSeleccion = new JPanel();
			panelSeleccion.setBackground(new Color(255, 255, 255));
			panelSeleccion.setLayout(null);
			panelSeleccion.add(getSpinnerHoraFin());
			panelSeleccion.add(getLblHoraInicio());
			panelSeleccion.add(getLblHoraFin());
			panelSeleccion.add(getBtnSiguiente2());
			panelSeleccion.add(getBtnAtras2());
			panelSeleccion.add(getBtnValidador());
			panelSeleccion.add(getLblHorarioValido());
		}
		return panelSeleccion;
	}

	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			panelHorario.setLayout(new GridLayout(15, 1, 0, 0));
		}
		return panelHorario;
	}

	public JSpinner getSpinnerInicio() {
		if (spinnerHoraInicio == null) {

			SpinnerDateModel dateModel = new SpinnerDateModel();
			spinnerHoraInicio = new JSpinner(dateModel);
			spinnerHoraInicio.setBounds(91, 70, 122, 43);

		}
		return spinnerHoraInicio;
	}

	public JSpinner getSpinnerHoraFin() {
		if (spinnerHoraFin == null) {

			SpinnerDateModel dateModel = new SpinnerDateModel();
			spinnerHoraFin = new JSpinner(dateModel);
			spinnerHoraFin.setBounds(91, 184, 122, 43);

		}
		return spinnerHoraFin;
	}

	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraInicio.setBounds(91, 45, 122, 14);
		}
		return lblHoraInicio;
	}

	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraFin.setBounds(91, 159, 122, 14);
		}
		return lblHoraFin;
	}

	public JButton getBtnSiguiente2() {
		if (btnSiguiente2 == null) {
			btnSiguiente2 = new JButton("Siguiente");
			btnSiguiente2.setEnabled(false);

			btnSiguiente2.setBounds(226, 584, 89, 23);
		}
		return btnSiguiente2;
	}

	public JButton getBtnAtras2() {
		if (btnAtras2 == null) {
			btnAtras2 = new JButton("Atrás");
			btnAtras2.setBounds(108, 584, 89, 23);
		}
		return btnAtras2;
	}

	private void actualizarPanelHorario() {
		panelHorario.removeAll(); // Limpiamos el panel antes de actualizar

		// Suponemos que obtienes las franjas ocupadas del backend
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(vpr.getFechaSeleccionada());

		Instalacion inst = (Instalacion) vpr.getComboBoxInstalaciones().getSelectedItem();
		List<FranjaTiempo> eventosDelDia = vpr.getReservaShared().getEventos(inst, fechaSeleccionada); 

		// Crear 15 intervalos de 1 hora entre las 8:00 y las 22:00
		LocalTime horaInicio = LocalTime.of(8, 0);

		List<JLabel> labelsHorarios = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
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
			panelHorario.add(labelHorario);
		}

		panelHorario.revalidate();
		panelHorario.repaint();
	}

	public JButton getBtnValidador() {
		if (btnValidador == null) {
			btnValidador = new JButton("Validar");
			btnValidador.setBackground(new Color(0, 128, 0));
			btnValidador.setBounds(216, 256, 89, 23);
		}
		return btnValidador;
	}

	public JLabel getLblHorarioValido() {
		if (lblHorarioValido == null) {
			lblHorarioValido = new JLabel("");
			lblHorarioValido.setBounds(91, 291, 200, 14);
			lblHorarioValido.setVisible(false);
		}
		return lblHorarioValido;
	}

	public FranjaTiempo getFranjaReserva() {
		Date horaInicio = (Date) getSpinnerInicio().getValue();
		Date horaFin = (Date) getSpinnerHoraFin().getValue();
		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA, inicio, fin,
				DateToLocalDate.convertToLocalDate(vpr.getDateChooser().getDate()));
		return franja;
	}

	public Instalacion getInstalacionReserva() {
		Instalacion inst = (Instalacion) vpr.getComboBoxInstalaciones().getSelectedItem();
		String nombreInstalacion = inst.getNombreInstalacion();
		Instalacion instalacion = vpr.getReservaShared().buscaInstalacion(nombreInstalacion);
		return instalacion;
	}

	public float getPrecioReserva() {
		// Obtener las horas de inicio y fin desde los spinners
		Date horaInicio = (Date) getSpinnerInicio().getValue();
		Date horaFin = (Date) getSpinnerHoraFin().getValue();

		// Convertir a LocalTime para calcular la duración
		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);

		// Calcular la duración en minutos entre el inicio y el fin
		long duracionEnMinutos = Duration.between(inicio, fin).toMinutes();

		// Convertir los minutos en horas, redondeando hacia arriba cualquier fracción
		float horas = (float) Math.ceil(duracionEnMinutos / 60.0);

		// Precio de la reserva: 50€ por hora
		float precioPorHora = 50.0f;

		// Calcular el total
		return horas * precioPorHora;
	}

	public Date getDateReserva() {
		return getVpr().getDateChooser().getDate();
	}
}
