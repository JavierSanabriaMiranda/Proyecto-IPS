package frontend.jardineriaUI;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import backend.service.empleados.nodeportivos.horarios.Turno;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import frontend.empleados.horarios.PanelHora;
import util.DateToLocalDate;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class HorarioJardineria extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel pnTitulos;
	private JPanel pnCentral;
	private JLabel lblHorarioEmpleado;
	private JLabel lblHorarioInstalacion;
	private JLabel lblSeleccionHoras;
	private JPanel pnHorarioEmpleado;
	private JPanel pnHorarioInstalacion;
	private JPanel pnSeleccionHoras;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JButton btnAñadir;
	private JButton btnAtras2;
	private VentanaJardineros vj;

	/**
	 * Create the dialog.
	 */
	public HorarioJardineria(VentanaJardineros vj) {
		this.vj = vj;
		setModal(true);
		setBounds(100, 100, 1074, 536);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getPnCentral(), BorderLayout.CENTER);
		contentPanel.add(getPnTitulos(), BorderLayout.NORTH);
		mostrarHorarioEmpleado();
		actualizarPanelHorario();
	}

	private JPanel getPnTitulos() {
		if (pnTitulos == null) {
			pnTitulos = new JPanel();
			pnTitulos.setBackground(new Color(255, 255, 255));
			pnTitulos.setLayout(new GridLayout(0, 3, 0, 0));
			pnTitulos.add(getLblHorarioEmpleado());
			pnTitulos.add(getLblHorarioInstalacion());
			pnTitulos.add(getLblSeleccionHoras());
		}
		return pnTitulos;
	}

	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new GridLayout(0, 3, 0, 0));
			pnCentral.add(getPnHorarioEmpleado());
			pnCentral.add(getPnHorarioInstalacion());
			pnCentral.add(getPnSeleccionHoras());
			
		}
		return pnCentral;
	}

	private JLabel getLblSeleccionHoras() {
		if (lblSeleccionHoras == null) {
			lblSeleccionHoras = new JLabel("SELECCIÓN DE HORAS");
			lblSeleccionHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));

		}
		return lblSeleccionHoras;
	}

	private JLabel getLblHorarioInstalacion() {
		if (lblHorarioInstalacion == null) {
			lblHorarioInstalacion = new JLabel("HORARIO INSTALACIÓN");
			lblHorarioInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorarioInstalacion;
	}
	
	private JLabel getLblHorarioEmpleado() {
		if (lblHorarioEmpleado == null) {
			lblHorarioEmpleado = new JLabel("HORARIO EMPLEADO");
			lblHorarioEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHorarioEmpleado.setBackground(new Color(255, 255, 255));
		}
		return lblHorarioEmpleado;
	}

	private JPanel getPnHorarioEmpleado() {
		if (pnHorarioEmpleado == null) {
			pnHorarioEmpleado = new JPanel();
			pnHorarioEmpleado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnHorarioEmpleado.setBackground(new Color(255, 255, 255));
			pnHorarioEmpleado.setLayout(new GridLayout(24, 1, 0, 0));
		}
		return pnHorarioEmpleado;
	}
	
	private void mostrarHorarioEmpleado() {
		getPnHorarioEmpleado().removeAll();
		
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(vj.getDateChooser().getDate());
		
		List<Turno> turnos = vj.getJardinerosShared().getHorario(vj.getListJardineros().getSelectedValue(), fechaSeleccionada);
		crearTablaHorarioEmpleado(turnos);
	}

	private void crearTablaHorarioEmpleado(List<Turno> turnos) {
		for (int i = 0; i < 24; i++) {
			PanelHora pnHora = new PanelHora();
			LocalTime horaPanel = LocalTime.of(i, 0);
			LocalTime horaSiguiente = horaPanel.plusHours(1);
			pnHora.setHora(horaPanel);
			
			for (Turno turno : turnos) {
				LocalTime inicio = turno.getHoraInicio();
				LocalTime fin = turno.getHoraFin();
				
				if (!inicio.isBefore(horaPanel) && inicio.isBefore(horaSiguiente) || 
						fin.isAfter(horaPanel) && fin.isBefore(horaSiguiente) || 
						inicio.isBefore(horaPanel) && fin.isAfter(horaPanel))
					pnHora.setOcupado(inicio, fin);
			}
			getPnHorarioEmpleado().add(pnHora);
		}
		getPnHorarioEmpleado().revalidate();
		getPnHorarioEmpleado().repaint();
	}
	private JPanel getPnHorarioInstalacion() {
		if (pnHorarioInstalacion == null) {
			pnHorarioInstalacion = new JPanel();
			pnHorarioInstalacion.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnHorarioInstalacion.setBackground(new Color(255, 255, 255));
			pnHorarioInstalacion.setLayout(new GridLayout(24, 1, 0, 0));
		}
		return pnHorarioInstalacion;
	}
	
	private void actualizarPanelHorario() {
		pnHorarioInstalacion.removeAll(); // Limpiamos el panel antes de actualizar

		// Suponemos que obtienes las franjas ocupadas del backend
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(vj.getDateChooser().getDate());

		Instalacion inst = (Instalacion) vj.getCbInstalaciones().getSelectedItem();
		List<FranjaTiempo> eventosDelDia = vj.getJardinerosShared().getEventos(inst, fechaSeleccionada); 

		// Crear 15 intervalos de 1 hora entre las 8:00 y las 22:00
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
					} else {
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
				labelHorario.setBackground(Color.WHITE); // Blanco para disponibilidad
				labelHorario.setText(labelHorario.getText() + "Libre");
			}

			// Añadir la etiqueta al panel
			labelsHorarios.add(labelHorario);
			pnHorarioInstalacion.add(labelHorario);
		}

		pnHorarioInstalacion.revalidate();
		pnHorarioInstalacion.repaint();
	}
	
	
	private JPanel getPnSeleccionHoras() {
		if (pnSeleccionHoras == null) {
			pnSeleccionHoras = new JPanel();
			pnSeleccionHoras.setBackground(new Color(255, 255, 255));
			pnSeleccionHoras.setLayout(null);
			pnSeleccionHoras.add(getSpHoraInicio());
			pnSeleccionHoras.add(getSpHoraFin());
			pnSeleccionHoras.add(getLblHoraInicio());
			pnSeleccionHoras.add(getLblHoraFin());
			pnSeleccionHoras.add(getBtnAñadir());
			pnSeleccionHoras.add(getBtnAtras2());
		}
		return pnSeleccionHoras;
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			SpinnerDateModel spinnerModel = new SpinnerDateModel();
	        spHoraInicio = new JSpinner(spinnerModel);
			spHoraInicio.setBounds(102, 80, 126, 30);
			 // Modelo de spinner con Date
	        
	        Date horaInicial;
	        try {
	        	horaInicial = new SimpleDateFormat("HH:mm").parse("00:00");
            } catch (Exception e) {
                throw new RuntimeException("Error al parsear las horas.", e);
            }
			
			spHoraInicio.setFont(new Font("Arial", Font.PLAIN, 12));
	        // Formatear el spinner para que muestre HH:mm
	        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spHoraInicio, "HH:mm");
	        spHoraInicio.setEditor(timeEditor);
	        spHoraInicio.setValue(horaInicial);
		}
		return spHoraInicio;
	}
	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			SpinnerDateModel spinnerModel = new SpinnerDateModel();
			spHoraFin = new JSpinner(spinnerModel);
			spHoraFin.setBounds(102, 187, 126, 30);
			 // Modelo de spinner con Date
			
			Date horaInicial;
	        try {
	        	horaInicial = new SimpleDateFormat("HH:mm").parse("00:00");
            } catch (Exception e) {
                throw new RuntimeException("Error al parsear las horas.", e);
            }
			spHoraFin.setFont(new Font("Arial", Font.PLAIN, 12));
	        // Formatear el spinner para que muestre HH:mm
	        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spHoraFin, "HH:mm");
	        spHoraFin.setEditor(timeEditor);
	        spHoraFin.setValue(horaInicial);
		}
		return spHoraFin;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio: ");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraInicio.setBounds(62, 49, 100, 20);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraFin.setBounds(62, 156, 100, 20);
		}
		return lblHoraFin;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("Añadir");
			btnAñadir.setBounds(251, 438, 89, 23);
		}
		return btnAñadir;
	}
	private JButton getBtnAtras2() {
		if (btnAtras2 == null) {
			btnAtras2 = new JButton("Atras");
			btnAtras2.setBounds(10, 438, 89, 23);
		}
		return btnAtras2;
	}

	public VentanaJardineros getVj() {
		return vj;
	}
}
