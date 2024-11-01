package frontend.equiposUI.horarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.ventas.reservas.Instalacion;
import shared.gestionequipos.horarios.HorariosEntrenamientosShared;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;

public class VentanaHorarioEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnSelecionContent;
	private JPanel pnHorarioContent;
	private JPanel pnSeleccionHorario;
	private JPanel pnSeleccionEquipo;
	private JComboBox<EmpleadoDeportivo> cbEntrenadores;
	private JLabel lblEntrenadores;
	private JLabel lblFecha;
	private JDateChooser dateChooser;
	private JButton btnHorario;
	private JLabel lblSeleccionHoras;
	private JSpinner spHoraInicio;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JSpinner spHoraFin;
	private JButton btnAtras;
	private JButton btnAñadirEntrenamiento;
	private JComboBox<Instalacion> cbInstalaciones;
	private JLabel lblInstalaciones;
	private HorariosEntrenamientosShared hes;

	/**
	 * Create the frame.
	 */
	public VentanaHorarioEquipos(HorariosEntrenamientosShared hes) {
		this.hes = hes;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 710);
		this.setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getPnSelecionContent());
		contentPane.add(getPnHorarioContent());
	}

	private JPanel getPnSelecionContent() {
		if (pnSelecionContent == null) {
			pnSelecionContent = new JPanel();
			pnSelecionContent.setLayout(new GridLayout(2, 0, 0, 0));
			pnSelecionContent.add(getPnSeleccionEquipo());
			pnSelecionContent.add(getPnSeleccionHorario());
		}
		return pnSelecionContent;
	}
	public JPanel getPnHorarioContent() {
		if (pnHorarioContent == null) {
			pnHorarioContent = new JPanel();
			pnHorarioContent.setBackground(new Color(255, 255, 255));
			pnHorarioContent.setLayout(new GridLayout(24, 1, 0, 0));
		}
		return pnHorarioContent;
	}
	private JPanel getPnSeleccionHorario() {
		if (pnSeleccionHorario == null) {
			pnSeleccionHorario = new JPanel();
			pnSeleccionHorario.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnSeleccionHorario.setBackground(new Color(255, 255, 255));
			pnSeleccionHorario.setLayout(null);
			pnSeleccionHorario.add(getLblSeleccionHoras());
			pnSeleccionHorario.add(getSpHoraInicio());
			pnSeleccionHorario.add(getLblHoraInicio());
			pnSeleccionHorario.add(getLblHoraFin());
			pnSeleccionHorario.add(getSpHoraFin());
			pnSeleccionHorario.add(getBtnAtras());
			pnSeleccionHorario.add(getBtnAñadirEntrenamiento());
		}
		return pnSeleccionHorario;
	}
	private JPanel getPnSeleccionEquipo() {
		if (pnSeleccionEquipo == null) {
			pnSeleccionEquipo = new JPanel();
			pnSeleccionEquipo.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnSeleccionEquipo.setBackground(new Color(255, 255, 255));
			pnSeleccionEquipo.setLayout(null);
			pnSeleccionEquipo.add(getCbEntrenadores());
			pnSeleccionEquipo.add(getLblEntrenadores());
			pnSeleccionEquipo.add(getLblFecha());
			pnSeleccionEquipo.add(getDateChooser());
			pnSeleccionEquipo.add(getBtnHorario());
			pnSeleccionEquipo.add(getCbInstalaciones());
			pnSeleccionEquipo.add(getLblInstalaciones());
		}
		return pnSeleccionEquipo;
	}
	private JComboBox<EmpleadoDeportivo> getCbEntrenadores() {
		if (cbEntrenadores == null) {
			cbEntrenadores = new JComboBox<EmpleadoDeportivo>();
			cbEntrenadores.setBounds(34, 70, 278, 22);
			
			// Crear el modelo basado en la lista de instalaciones
	        DefaultComboBoxModel<EmpleadoDeportivo> model = new DefaultComboBoxModel<>();
	        List<EmpleadoDeportivo> entrenadores = hes.getEntrenadores();
	        for (EmpleadoDeportivo entrenador : entrenadores) {
	            model.addElement(entrenador);  // Añadir cada instalación al modelo
	        }
	        
	        // Establecer el modelo en el comboBox
	        cbEntrenadores.setModel(model);
		}
		return cbEntrenadores;
	}
	private JLabel getLblEntrenadores() {
		if (lblEntrenadores == null) {
			lblEntrenadores = new JLabel("Seleccione el Entrenador: ");
			lblEntrenadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEntrenadores.setBounds(34, 42, 168, 17);
		}
		return lblEntrenadores;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Seleccione la Fecha: ");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setBounds(34, 194, 168, 17);
		}
		return lblFecha;
	}
	
	public JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBackground(new Color(255, 255, 255));
	        dateChooser.setDateFormatString("dd/MM/yyyy");
	        Calendar cal = Calendar.getInstance();
	        Date hoy = cal.getTime();
	        dateChooser.setMinSelectableDate(hoy); // No permite seleccionar fechas anteriores a hoy
	        dateChooser.getDateEditor().setEnabled(false);
	        dateChooser.getDateEditor().getUiComponent().setBackground(Color.WHITE); // Fondo deshabilitado
	        dateChooser.getDateEditor().getUiComponent().setForeground(Color.BLUE); // Color del texto
	        ((JTextField) dateChooser.getDateEditor().getUiComponent()).setDisabledTextColor(Color.BLACK); // Texto cuando está deshabilitado
	        dateChooser.setSize(148, 57);
	        dateChooser.setLocation(35, 222);
	        dateChooser.setDate(null);
		}
		return dateChooser;
	}
	public JButton getBtnHorario() {
		if (btnHorario == null) {
			btnHorario = new JButton("Ver Horario");
			btnHorario.setBounds(268, 291, 107, 29);
		}
		return btnHorario;
	}
	private JLabel getLblSeleccionHoras() {
		if (lblSeleccionHoras == null) {
			lblSeleccionHoras = new JLabel("Seleccione el Horario: ");
			lblSeleccionHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSeleccionHoras.setBounds(23, 26, 187, 19);
		}
		return lblSeleccionHoras;
	}
	public JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			SpinnerDateModel spinnerModel = new SpinnerDateModel();
	        spHoraInicio = new JSpinner(spinnerModel);
			spHoraInicio.setBounds(127, 97, 109, 38);
			
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
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraInicio.setBounds(49, 67, 187, 19);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraFin.setBounds(49, 171, 187, 19);
		}
		return lblHoraFin;
	}
	public JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			SpinnerDateModel spinnerModel = new SpinnerDateModel();
			spHoraFin = new JSpinner(spinnerModel);
			spHoraFin.setBounds(127, 201, 109, 38);
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
	public JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.setBounds(23, 297, 89, 23);
		}
		return btnAtras;
	}
	public JButton getBtnAñadirEntrenamiento() {
		if (btnAñadirEntrenamiento == null) {
			btnAñadirEntrenamiento = new JButton("Añadir Entrenamiento");
			btnAñadirEntrenamiento.setBounds(220, 297, 155, 23);
		}
		return btnAñadirEntrenamiento;
	}
	public JComboBox<Instalacion> getCbInstalaciones() {
		if (cbInstalaciones == null) {
			cbInstalaciones = new JComboBox<Instalacion>();
			cbInstalaciones.setBounds(34, 131, 278, 22);
			
			// Crear el modelo basado en la lista de instalaciones
	        DefaultComboBoxModel<Instalacion> model = new DefaultComboBoxModel<>();
	        List<Instalacion> instalaciones = hes.getInstalaciones();
	        for (Instalacion instalacion : instalaciones) {
	            model.addElement(instalacion);  // Añadir cada instalación al modelo
	        }
	        
	        // Establecer el modelo en el comboBox
	        cbInstalaciones.setModel(model);
		}
		return cbInstalaciones;
	}
	private JLabel getLblInstalaciones() {
		if (lblInstalaciones == null) {
			lblInstalaciones = new JLabel("Seleccione la Instalacion: ");
			lblInstalaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblInstalaciones.setBounds(34, 103, 168, 17);
		}
		return lblInstalaciones;
	}

	public HorariosEntrenamientosShared getHorarioEntrenamientoShared() {
		return hes;
	}
}
