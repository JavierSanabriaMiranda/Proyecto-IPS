package frontend.empleados.horarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.horarios.Turno;
import shared.gestionhorarios.GestionHorariosShared;
import util.DateToLocalDate;
import util.DateToLocalTime;

public class FrameHorariosEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionHorariosShared gesHor = new GestionHorariosShared();
	private JPanel contentPane;
	private JPanel pnEmpleados;
	private JScrollPane scEmpleados;
	private JList<EmpleadoNoDeportivo> listEmpleados;
	private DefaultListModel<EmpleadoNoDeportivo> modeloList;
	private JLabel lbEmpleados;
	private JPanel pnHorarioEmpleado;
	private JPanel pnFecha;
	private JDateChooser clFecha;
	private JLabel lbFecha;
	private JPanel pnHorario;
	private JPanel pnSalir;
	private JButton btSalir;
	private Component horizontalGlue;
	private Component horizontalStrut;
	private JPanel pnModHorario;
	private JPanel pnTablaHorario;
	private JLabel lbHoraInicio;
	private JLabel lbHoraFin;
	private JLabel lbModificarTurnos;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JButton btAddSemanal;
	private JScrollPane scTablaHorario;
	private JRadioButton rdbtSemanal;
	private JRadioButton rdbtPuntual;
	private ButtonGroup grupoBt = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public FrameHorariosEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 621);
		setMinimumSize(new Dimension(850, 500));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnEmpleados(), BorderLayout.WEST);
		contentPane.add(getPnHorarioEmpleado(), BorderLayout.CENTER);
		contentPane.add(getPnSalir(), BorderLayout.SOUTH);
		inicializarPanel();
	}

	private JPanel getPnEmpleados() {
		if (pnEmpleados == null) {
			pnEmpleados = new JPanel();
			pnEmpleados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnEmpleados.setBackground(new Color(255, 255, 255));
			pnEmpleados.setLayout(new BorderLayout(0, 0));
			pnEmpleados.add(getScEmpleados(), BorderLayout.CENTER);
			getScEmpleados().setViewportView(getListEmpleados());
			pnEmpleados.setPreferredSize(new Dimension(400, Integer.MAX_VALUE));
			pnEmpleados.add(getLbEmpleados(), BorderLayout.NORTH);
		}
		return pnEmpleados;
	}

	private JScrollPane getScEmpleados() {
		if (scEmpleados == null) {
			scEmpleados = new JScrollPane();
		}
		return scEmpleados;
	}

	private JList<EmpleadoNoDeportivo> getListEmpleados() {
		if (listEmpleados == null) {
			listEmpleados = new JList<EmpleadoNoDeportivo>();
			listEmpleados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!listEmpleados.isSelectionEmpty() && getClFecha().getDate() != null)
						mostrarHorarioEmpleado();
				}
			});
			listEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listEmpleados.setFont(new Font("Arial", Font.PLAIN, 12));
			modeloList = new DefaultListModel<>();
			listEmpleados.setModel(modeloList);
		}
		return listEmpleados;
	}

	private JLabel getLbEmpleados() {
		if (lbEmpleados == null) {
			lbEmpleados = new JLabel("Empleados");
			lbEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmpleados.setFont(new Font("Arial", Font.PLAIN, 20));
			lbEmpleados.setBackground(new Color(255, 255, 255));
		}
		return lbEmpleados;
	}

	private JPanel getPnHorarioEmpleado() {
		if (pnHorarioEmpleado == null) {
			pnHorarioEmpleado = new JPanel();
			pnHorarioEmpleado.setBackground(new Color(255, 255, 255));
			pnHorarioEmpleado.setLayout(new BorderLayout(0, 0));
			pnHorarioEmpleado.add(getPnFecha(), BorderLayout.NORTH);
			pnHorarioEmpleado.add(getPnHorario(), BorderLayout.CENTER);
		}
		return pnHorarioEmpleado;
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.setBackground(new Color(255, 255, 255));
			GridBagLayout gbl_pnFecha = new GridBagLayout();
			gbl_pnFecha.columnWidths = new int[]{109, 0, 312, 0};
			gbl_pnFecha.rowHeights = new int[]{43, 0};
			gbl_pnFecha.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnFecha.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnFecha.setLayout(gbl_pnFecha);
			GridBagConstraints gbc_lbFecha = new GridBagConstraints();
			gbc_lbFecha.insets = new Insets(0, 0, 0, 5);
			gbc_lbFecha.gridx = 1;
			gbc_lbFecha.gridy = 0;
			pnFecha.add(getLbFecha(), gbc_lbFecha);
			GridBagConstraints gbc_clFecha = new GridBagConstraints();
			gbc_clFecha.fill = GridBagConstraints.HORIZONTAL;
			gbc_clFecha.gridx = 2;
			gbc_clFecha.gridy = 0;
			pnFecha.add(getClFecha(), gbc_clFecha);
		}
		return pnFecha;
	}

	private JDateChooser getClFecha() {
		if (clFecha == null) {
			clFecha = new JDateChooser();
			clFecha.addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!listEmpleados.isSelectionEmpty() && getClFecha().getDate() != null)
						mostrarHorarioEmpleado();
				}
			});
			// Establece el JDateChooser como no editable por teclado y le cambia el color
			JTextField textCalendar = (JTextField) clFecha.getDateEditor().getUiComponent();
			textCalendar.setEnabled(false);
			textCalendar.setBackground(Color.WHITE);
			textCalendar.setDisabledTextColor(Color.BLACK);
			clFecha.getCalendarButton().setPreferredSize(new Dimension(100, 20));
			clFecha.getCalendarButton().setText("Seleccionar");
		}
		return clFecha;

	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha: ");
			lbFecha.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		return lbFecha;
	}
	private JPanel getPnHorario() {
		if (pnHorario == null) {
			pnHorario = new JPanel();
			pnHorario.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnHorario.setBackground(new Color(255, 255, 255));
			pnHorario.setLayout(new BorderLayout(0, 0));
			pnHorario.add(getPnModHorario(), BorderLayout.WEST);
			pnHorario.add(getScTablaHorario(), BorderLayout.CENTER);
		}
		return pnHorario;
	}
	private JPanel getPnSalir() {
		if (pnSalir == null) {
			pnSalir = new JPanel();
			pnSalir.setBackground(new Color(255, 255, 255));
			pnSalir.setLayout(new BoxLayout(pnSalir, BoxLayout.X_AXIS));
			pnSalir.add(getHorizontalGlue());
			pnSalir.add(getBtSalir());
			pnSalir.add(getHorizontalStrut());
		}
		return pnSalir;
	}
	private JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return btSalir;
	}
	private Component getHorizontalGlue() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}
	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
		}
		return horizontalStrut;
	}
	private JPanel getPnModHorario() {
		if (pnModHorario == null) {
			pnModHorario = new JPanel();
			pnModHorario.setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
			pnModHorario.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnModHorario.setBackground(new Color(255, 255, 255));
			GridBagLayout gbl_pnModHorario = new GridBagLayout();
			gbl_pnModHorario.columnWidths = new int[]{21, 0, 46, 0};
			gbl_pnModHorario.rowHeights = new int[]{41, 0, 44, 0, 0, 55, 0, 0, 0, 0};
			gbl_pnModHorario.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnModHorario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnModHorario.setLayout(gbl_pnModHorario);
			GridBagConstraints gbc_lbModificarTurnos = new GridBagConstraints();
			gbc_lbModificarTurnos.insets = new Insets(0, 0, 5, 5);
			gbc_lbModificarTurnos.gridx = 1;
			gbc_lbModificarTurnos.gridy = 0;
			pnModHorario.add(getLbModificarTurnos(), gbc_lbModificarTurnos);
			GridBagConstraints gbc_lbHoraInicio = new GridBagConstraints();
			gbc_lbHoraInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lbHoraInicio.anchor = GridBagConstraints.WEST;
			gbc_lbHoraInicio.gridx = 1;
			gbc_lbHoraInicio.gridy = 3;
			pnModHorario.add(getLbHoraInicio(), gbc_lbHoraInicio);
			GridBagConstraints gbc_spHoraInicio = new GridBagConstraints();
			gbc_spHoraInicio.insets = new Insets(0, 0, 5, 0);
			gbc_spHoraInicio.gridx = 2;
			gbc_spHoraInicio.gridy = 3;
			pnModHorario.add(getSpHoraInicio(), gbc_spHoraInicio);
			GridBagConstraints gbc_lbHoraFin = new GridBagConstraints();
			gbc_lbHoraFin.insets = new Insets(0, 0, 5, 5);
			gbc_lbHoraFin.anchor = GridBagConstraints.WEST;
			gbc_lbHoraFin.gridx = 1;
			gbc_lbHoraFin.gridy = 4;
			pnModHorario.add(getLbHoraFin(), gbc_lbHoraFin);
			GridBagConstraints gbc_spHoraFin = new GridBagConstraints();
			gbc_spHoraFin.insets = new Insets(0, 0, 5, 0);
			gbc_spHoraFin.gridx = 2;
			gbc_spHoraFin.gridy = 4;
			pnModHorario.add(getSpHoraFin(), gbc_spHoraFin);
			GridBagConstraints gbc_rdbtSemanal = new GridBagConstraints();
			gbc_rdbtSemanal.anchor = GridBagConstraints.WEST;
			gbc_rdbtSemanal.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtSemanal.gridx = 1;
			gbc_rdbtSemanal.gridy = 6;
			pnModHorario.add(getRdbtSemanal(), gbc_rdbtSemanal);
			GridBagConstraints gbc_rdbtPuntual = new GridBagConstraints();
			gbc_rdbtPuntual.anchor = GridBagConstraints.WEST;
			gbc_rdbtPuntual.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtPuntual.gridx = 1;
			gbc_rdbtPuntual.gridy = 7;
			pnModHorario.add(getRdbtPuntual(), gbc_rdbtPuntual);
			GridBagConstraints gbc_btAddSemanal = new GridBagConstraints();
			gbc_btAddSemanal.fill = GridBagConstraints.HORIZONTAL;
			gbc_btAddSemanal.insets = new Insets(0, 0, 0, 5);
			gbc_btAddSemanal.gridx = 1;
			gbc_btAddSemanal.gridy = 8;
			pnModHorario.add(getBtAddSemanal(), gbc_btAddSemanal);
		}
		return pnModHorario;
	}
	private JPanel getPnTablaHorario() {
		if (pnTablaHorario == null) {
			pnTablaHorario = new JPanel();
			pnTablaHorario.setBackground(new Color(255, 255, 255));
			pnTablaHorario.setLayout(new GridLayout(24, 1, 0, 0));
		}
		return pnTablaHorario;
	}
	private JLabel getLbHoraInicio() {
		if (lbHoraInicio == null) {
			lbHoraInicio = new JLabel("Hora Inicio:");
			lbHoraInicio.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbHoraInicio;
	}
	private JLabel getLbHoraFin() {
		if (lbHoraFin == null) {
			lbHoraFin = new JLabel("Hora Fin:");
			lbHoraFin.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbHoraFin;
	}
	private JLabel getLbModificarTurnos() {
		if (lbModificarTurnos == null) {
			lbModificarTurnos = new JLabel("Modificar Turnos");
			lbModificarTurnos.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return lbModificarTurnos;
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			 // Modelo de spinner con Date
	        SpinnerDateModel spinnerModel = new SpinnerDateModel();
	        spHoraInicio = new JSpinner(spinnerModel);
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
			 // Modelo de spinner con Date
	        SpinnerDateModel spinnerModel = new SpinnerDateModel();
			spHoraFin = new JSpinner(spinnerModel);
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
	private JButton getBtAddSemanal() {
		if (btAddSemanal == null) {
			btAddSemanal = new JButton("Añadir");
			btAddSemanal.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addTurno();
				}
			});
			btAddSemanal.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return btAddSemanal;
	}
	
	private void addTurno() {
		if (cumpleCondiciones()) {
			EmpleadoNoDeportivo empleado = getListEmpleados().getSelectedValue();
			LocalTime hInicio = DateToLocalTime.convertDateToLocalTime((Date) getSpHoraInicio().getValue());
			LocalTime hFin = DateToLocalTime.convertDateToLocalTime((Date) getSpHoraFin().getValue());
			LocalDate dia = DateToLocalDate.convertToLocalDate(getClFecha().getDate());
			
			boolean adicionCorrecta = false;
			
			if (getRdbtPuntual().isSelected()) {
				adicionCorrecta = gesHor.addTurnoPuntual(empleado, hInicio, hFin, dia);
			}
			else {
				DayOfWeek diaSemana = dia.getDayOfWeek();
				adicionCorrecta = gesHor.addTurnoSemanal(empleado, hInicio, hFin, diaSemana);
			}
			
			if (adicionCorrecta) {
				JOptionPane.showMessageDialog(this, "Se ha añadido el turno correctamente",
						"Éxito al Añadir Turno", JOptionPane.INFORMATION_MESSAGE);
				inicializarPanel();
			}
				
			else
				JOptionPane.showMessageDialog(this, "Se ha superado el límite de horas (8h diarias o 40h semanales)",
						"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private boolean cumpleCondiciones() {
		if (getClFecha().getDate() == null)  {
			JOptionPane.showMessageDialog(this, "Se debe seleccionar la fecha para el turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!getRdbtPuntual().isSelected() && !getRdbtSemanal().isSelected()) {
			JOptionPane.showMessageDialog(this, "Se debe seleccionar el tipo de turno (Semanal o Puntual)",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (getListEmpleados().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Se debe seleccionar al empleado al que asignar el turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		
		Date inicio = (Date) getSpHoraInicio().getValue();
		Date fin = (Date) getSpHoraFin().getValue();
		
		if (inicio.after(fin) || inicio.equals(fin)) {
			JOptionPane.showMessageDialog(this, "La hora de inicio debe ser inferior a la hora de final del turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;	
	}

	private void inicializarPanel() {
		Date horaInicial;
        try {
        	horaInicial = new SimpleDateFormat("HH:mm").parse("00:00");
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear las horas.", e);
        }
		
		// Establecemos los Spinners a 00:00
		getSpHoraInicio().setValue(horaInicial);
		getSpHoraFin().setValue(horaInicial);
		getListEmpleados().clearSelection();
		
		// Llena la lsita con los empleados no deportivos
		modeloList.clear();
		List<EmpleadoNoDeportivo> lista = gesHor.getEmpleadosNoDeportivosFromGestor();
		Collections.sort(lista);
		modeloList.addAll(lista);
		
		
		getClFecha().setDate(null);
	}
	
	private void mostrarHorarioEmpleado() {
		getPnTablaHorario().removeAll();
		
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(getClFecha().getDate());
		
		List<Turno> turnos = gesHor.getHorario(getListEmpleados().getSelectedValue(), fechaSeleccionada);
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
			getPnTablaHorario().add(pnHora);
		}
		getPnTablaHorario().revalidate();
		getPnTablaHorario().repaint();
	}
	
	private JScrollPane getScTablaHorario() {
		if (scTablaHorario == null) {
			scTablaHorario = new JScrollPane();
			scTablaHorario.setViewportView(getPnTablaHorario());
		}
		return scTablaHorario;
	}
	private JRadioButton getRdbtSemanal() {
		if (rdbtSemanal == null) {
			rdbtSemanal = new JRadioButton("Semanal");
			rdbtSemanal.setBackground(new Color(255, 255, 255));
			rdbtSemanal.setFont(new Font("Arial", Font.PLAIN, 12));
			grupoBt.add(rdbtSemanal);
		}
		return rdbtSemanal;
	}
	private JRadioButton getRdbtPuntual() {
		if (rdbtPuntual == null) {
			rdbtPuntual = new JRadioButton("Puntual");
			rdbtPuntual.setBackground(new Color(255, 255, 255));
			rdbtPuntual.setFont(new Font("Arial", Font.PLAIN, 12));
			grupoBt.add(rdbtPuntual);
		}
		return rdbtPuntual;
	}
}
