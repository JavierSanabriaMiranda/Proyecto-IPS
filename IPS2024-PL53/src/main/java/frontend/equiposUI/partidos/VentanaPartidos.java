package frontend.equiposUI.partidos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import backend.service.equipos.Equipo;
import shared.gestionequipos.partidos.GestionPartidosShared;

import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaPartidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblEquipoLocal;
	private JLabel lblEquipoVisitante;
	private JComboBox<Equipo> cbEquiposLocales;
	private JTextField txtEquipoVisitante;
	private JLabel lblVersus;
	private JDateChooser dateChooser;
	private JLabel lblFecha;
	private JLabel lblHoraInicio;
	private JSpinner spHoraInicio;
	private JButton btnCrearPartido;
	private JButton btnAtras;
	private GestionPartidosShared gps;
	private JCheckBox chckbxPartidoEspecial;

	/**
	 * Create the frame.
	 */
	public VentanaPartidos(GestionPartidosShared gps) {
		this.gps = gps;
		setTitle("Creación de Partidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 489);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblEquipoLocal());
		contentPane.add(getLblEquipoVisitante());
		contentPane.add(getCbEquiposLocales());
		contentPane.add(getTxtEquipoVisitante());
		contentPane.add(getLblVersus());
		contentPane.add(getDateChooser());
		contentPane.add(getLblFecha());
		contentPane.add(getLblHoraInicio());
		contentPane.add(getSpHoraInicio());
		contentPane.add(getBtnCrearPartido());
		contentPane.add(getBtnAtras());
		contentPane.add(getChckbxPartidoEspecial());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBounds(10, 11, 122, 100);
			ImageIcon iconoOriginal = new ImageIcon(VentanaPartidos.class.getResource("/img/productos/logo.jpg"));
	        
	        Image imagenOriginal = iconoOriginal.getImage();
	        Image imagenEscalada = imagenOriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 

	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
	        
	        lblLogo.setIcon(iconoEscalado);
		}
		return lblLogo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nuevos Partidos Burgos CF");
			lblNewLabel.setBounds(142, 11, 606, 100);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblNewLabel;
	}
	private JLabel getLblEquipoLocal() {
		if (lblEquipoLocal == null) {
			lblEquipoLocal = new JLabel("Equipo Local:");
			lblEquipoLocal.setLabelFor(getCbEquiposLocales());
			lblEquipoLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEquipoLocal.setBounds(72, 145, 184, 19);
		}
		return lblEquipoLocal;
	}
	private JLabel getLblEquipoVisitante() {
		if (lblEquipoVisitante == null) {
			lblEquipoVisitante = new JLabel("Equipo Visitante:");
			lblEquipoVisitante.setLabelFor(getTxtEquipoVisitante());
			lblEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEquipoVisitante.setBounds(396, 145, 184, 19);
		}
		return lblEquipoVisitante;
	}
	private JComboBox<Equipo> getCbEquiposLocales() {
		if (cbEquiposLocales == null) {
			cbEquiposLocales = new JComboBox<Equipo>();
			cbEquiposLocales.setBounds(72, 179, 202, 34);
		}
		return cbEquiposLocales;
	}
	private JTextField getTxtEquipoVisitante() {
		if (txtEquipoVisitante == null) {
			txtEquipoVisitante = new JTextField();
			txtEquipoVisitante.setBounds(396, 178, 227, 36);
			txtEquipoVisitante.setColumns(10);
		}
		return txtEquipoVisitante;
	}
	private JLabel getLblVersus() {
		if (lblVersus == null) {
			lblVersus = new JLabel("");
			lblVersus.setBounds(291, 172, 65, 41);
			ImageIcon iconoOriginal = new ImageIcon(VentanaPartidos.class.getResource("/img/partidos/versus.jpg"));
	        
	        Image imagenOriginal = iconoOriginal.getImage();
	        Image imagenEscalada = imagenOriginal.getScaledInstance(90, 90, Image.SCALE_SMOOTH); 

	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
	        
	        lblVersus.setIcon(iconoEscalado);
		}
		return lblVersus;
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
	        dateChooser.setLocation(72, 263);
	        dateChooser.setDate(null);
		}
		return dateChooser;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha: ");
			lblFecha.setLabelFor(getDateChooser());
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFecha.setBounds(72, 236, 49, 14);
		}
		return lblFecha;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio: ");
			lblHoraInicio.setLabelFor(getSpHoraInicio());
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblHoraInicio.setBounds(396, 237, 115, 14);
		}
		return lblHoraInicio;
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			SpinnerDateModel spinnerModel = new SpinnerDateModel();
	        spHoraInicio = new JSpinner(spinnerModel);
			spHoraInicio.setBounds(396, 274, 115, 34);
			
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
	private JButton getBtnCrearPartido() {
		if (btnCrearPartido == null) {
			btnCrearPartido = new JButton("Crear Partido");
			btnCrearPartido.setForeground(new Color(255, 255, 255));
			btnCrearPartido.setBackground(new Color(5, 122, 5));
			btnCrearPartido.setBounds(549, 418, 122, 23);
		}
		return btnCrearPartido;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.setForeground(new Color(255, 255, 255));
			btnAtras.setBackground(new Color(231, 50, 24));
			btnAtras.setBounds(10, 418, 122, 23);
		}
		return btnAtras;
	}
	private JCheckBox getChckbxPartidoEspecial() {
		if (chckbxPartidoEspecial == null) {
			chckbxPartidoEspecial = new JCheckBox("Partido Especial");
			chckbxPartidoEspecial.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chckbxPartidoEspecial.setBackground(new Color(255, 255, 255));
			chckbxPartidoEspecial.setBounds(72, 352, 170, 23);
		}
		return chckbxPartidoEspecial;
	}
	public GestionPartidosShared getGps() {
		return gps;
	}
}
