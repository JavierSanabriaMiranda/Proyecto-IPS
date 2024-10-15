package frontend.entrevistaUI;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.gestionentrevista.GestionEntrevistaShared;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionHoraFranjaEntrevista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestionEntrevistaShared ges;
	private JLabel lbFecha;
	private JTextField txFecha;
	private JLabel lbInicioFranja;
	private JTextField txInicioFranja;
	private JLabel lbFinFranja;
	private JTextField txFinFranja;
	private JLabel lbNombreJugador;
	private JButton btCrear;

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionHoraFranjaEntrevista(GestionEntrevistaShared ges) {
		setResizable(false);
		setTitle("Entrevistas: Franja Entrevista");
		this.ges = ges;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbFecha());
		contentPane.add(getTxFecha());
		contentPane.add(getLbInicioFranja());
		contentPane.add(getTxInicioFranja());
		contentPane.add(getLbFinFranja());
		contentPane.add(getTxFinFranja());
		contentPane.add(getLbNombreJugador());
		contentPane.add(getBtCrear());
		this.setLocationRelativeTo(null);
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Introduzca la fecha con el formato \"YYYY-MM-DD\":");
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbFecha.setBounds(10, 57, 279, 31);
		}
		return lbFecha;
	}
	private JTextField getTxFecha() {
		if (txFecha == null) {
			txFecha = new JTextField();
			txFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txFecha.setBounds(10, 94, 142, 31);
			txFecha.setColumns(10);
		}
		return txFecha;
	}
	private JLabel getLbInicioFranja() {
		if (lbInicioFranja == null) {
			lbInicioFranja = new JLabel("Introduzca la hora inicial con el formato \"HH:mm:ss\":");
			lbInicioFranja.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbInicioFranja.setBounds(10, 134, 279, 31);
		}
		return lbInicioFranja;
	}
	private JTextField getTxInicioFranja() {
		if (txInicioFranja == null) {
			txInicioFranja = new JTextField();
			txInicioFranja.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txInicioFranja.setColumns(10);
			txInicioFranja.setBounds(10, 171, 142, 31);
		}
		return txInicioFranja;
	}
	private JLabel getLbFinFranja() {
		if (lbFinFranja == null) {
			lbFinFranja = new JLabel("Introduzca la hora final con el formato \"HH:mm:ss\":");
			lbFinFranja.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbFinFranja.setBounds(10, 212, 279, 31);
		}
		return lbFinFranja;
	}
	private JTextField getTxFinFranja() {
		if (txFinFranja == null) {
			txFinFranja = new JTextField();
			txFinFranja.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txFinFranja.setColumns(10);
			txFinFranja.setBounds(10, 249, 142, 31);
		}
		return txFinFranja;
	}
	private JLabel getLbNombreJugador() {
		if (lbNombreJugador == null) {
			lbNombreJugador = new JLabel("Crear franja para: " + ges.getJugadorNombreYApellidos());
			lbNombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbNombreJugador.setBounds(10, 10, 497, 39);
		}
		return lbNombreJugador;
	}
	private JButton getBtCrear() {
		if (btCrear == null) {
			btCrear = new JButton("Crear");
			btCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (canBeCreated()) {
						crearFranja();
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido crear la franja ya que"
								+ " el jugador ya tiene un partido o entrenamiento para ese dia"
								+ "a esas horas.");
					}
				}
			});
			btCrear.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btCrear.setBounds(335, 280, 149, 36);
		}
		return btCrear;
	}
	
	private boolean canBeCreated() {
		String fecha = getTxFecha().getText();
		String horaInicio = getTxInicioFranja().getText();
		String horaFin = getTxFinFranja().getText();
		String res = ges.seleccionarHora(fecha, horaInicio, horaFin);
		if (!res.isBlank()) {
			JOptionPane.showMessageDialog(null, res);
			return false;
		}
		return ges.canBeCreated();
	}
	
	private void crearFranja() {
		if (ges.createFranja()) {
			JOptionPane.showMessageDialog(null, "Ha creado correctamente la franja de entrevista.");
		} else {
			JOptionPane.showMessageDialog(null, "No se ha podido crear la franja ya que"
					+ " el jugador ya tiene entrevista una entrevista para ese dia.");
		}
	}
}
