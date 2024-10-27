package frontend.jardineriaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import shared.gestionjardineria.JardinerosShared;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaJardineros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scJardineros;
	private JList listJardineros;
	private JLabel lblJardineros;
	private JComboBox cbInstalaciones;
	private JLabel lblInstalaciones;
	private JLabel lblDia;
	private JDateChooser dateChooser;
	private JButton btnSiguiente;
	private JButton btnAtras;
	private JardinerosShared jardinerosShared;


	/**
	 * Create the frame.
	 */
	public VentanaJardineros(JardinerosShared js) {
		this.jardinerosShared = js;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScJardineros());
		contentPane.add(getLblJardineros());
		contentPane.add(getCbInstalaciones());
		contentPane.add(getLblInstalaciones());
		contentPane.add(getLblDia());
		contentPane.add(getDateChooser());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnAtras());
	}

	private JScrollPane getScJardineros() {
		if (scJardineros == null) {
			scJardineros = new JScrollPane();
			scJardineros.setBounds(120, 97, 476, 247);
			scJardineros.setViewportView(getListJardineros());
		}
		return scJardineros;
	}

	private JList getListJardineros() {
		if (listJardineros == null) {
			listJardineros = new JList();
		}
		return listJardineros;
	}

	private JLabel getLblJardineros() {
		if (lblJardineros == null) {
			lblJardineros = new JLabel("Empleados de Jardinería");
			lblJardineros.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblJardineros.setBounds(211, 24, 385, 43);
		}
		return lblJardineros;
	}
	private JComboBox getCbInstalaciones() {
		if (cbInstalaciones == null) {
			cbInstalaciones = new JComboBox();
			cbInstalaciones.setBounds(120, 408, 476, 22);
		}
		return cbInstalaciones;
	}
	private JLabel getLblInstalaciones() {
		if (lblInstalaciones == null) {
			lblInstalaciones = new JLabel("Instalación:");
			lblInstalaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInstalaciones.setBounds(120, 374, 113, 14);
		}
		return lblInstalaciones;
	}
	private JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("Seleccione día:");
			lblDia.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDia.setBounds(120, 455, 145, 14);
		}
		return lblDia;
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
	        dateChooser.setLocation(120, 480);
	        dateChooser.setDate(null);
		}
		return dateChooser;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(655, 591, 89, 23);
		}
		return btnSiguiente;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.setBounds(10, 591, 89, 23);
		}
		return btnAtras;
	}

	public JardinerosShared getJardinerosShared() {
		return jardinerosShared;
	}
}
