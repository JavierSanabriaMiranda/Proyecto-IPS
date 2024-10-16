package frontend.entrevistaUI.franja;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.empleados.deportivos.Jugador;
import shared.gestionentrevista.GestionEntrevistaShared;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionFranjaEntrevista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scpJugadores;
	private JList<Jugador> listJugadores;
	
	private DefaultListModel<Jugador> modeloListaJugadores;
	
	private JButton btSeleccionJugador;
	private JLabel lbSeleccionJugador;
	private JLabel lbFecha;
	private JTextField txFecha;
	private JButton btContinuar;
	
	private GestionEntrevistaShared ges = new GestionEntrevistaShared();


	/**
	 * Create the frame.
	 */
	public VentanaSeleccionFranjaEntrevista() {
		setTitle("Entrevistas: Creacion entrevista");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScpJugadores());
		contentPane.add(getBtSeleccionJugador());
		contentPane.add(getLbSeleccionJugador());
		contentPane.add(getLbFecha());
		contentPane.add(getTxFecha());
		contentPane.add(getBtContinuar());
		setLocationRelativeTo(null);
	}
	private JScrollPane getScpJugadores() {
		if (scpJugadores == null) {
			scpJugadores = new JScrollPane();
			scpJugadores.setBounds(10, 54, 534, 197);
			scpJugadores.setViewportView(getListJugadores());
		}
		return scpJugadores;
	}
	private JList<Jugador> getListJugadores() {
		if (listJugadores == null) {
			modeloListaJugadores = new DefaultListModel<>();
			listJugadores = new JList<Jugador>(modeloListaJugadores);
			listJugadores.setFont(new Font("Tahoma", Font.PLAIN, 12));
			listJugadores.setLocation(0, 53);
			cargarModelo();
		}
		return listJugadores;
	}
	
	private void cargarModelo() {
		this.modeloListaJugadores.addAll(ges.getJugadoresProfesionales());
	}
	
	private JButton getBtSeleccionJugador() {
		if (btSeleccionJugador == null) {
			btSeleccionJugador = new JButton("Seleccionar jugador");
			btSeleccionJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionarJugador();
				}
			});
			btSeleccionJugador.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btSeleccionJugador.setBounds(553, 215, 147, 33);
		}
		return btSeleccionJugador;
	}
	private JLabel getLbSeleccionJugador() {
		if (lbSeleccionJugador == null) {
			lbSeleccionJugador = new JLabel("Seleccione el jugador al que se le va a crear una entrevista:");
			lbSeleccionJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbSeleccionJugador.setBounds(10, 10, 580, 39);
		}
		return lbSeleccionJugador;
	}
	
	private void seleccionarJugador() {
		if (getListJugadores().getSelectedIndex() != -1) {
			getBtContinuar().setEnabled(true);
			ges.seleccionarJugador(getListJugadores().getSelectedValue());
		}
	}
	
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Escriba la fecha de la entrevista con el formato \"YYYY-MM-DD\":");
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbFecha.setBounds(10, 269, 361, 39);
		}
		return lbFecha;
	}
	private JTextField getTxFecha() {
		if (txFecha == null) {
			txFecha = new JTextField();
			txFecha.setBounds(381, 272, 157, 33);
			txFecha.setColumns(10);
		}
		return txFecha;
	}
	private JButton getBtContinuar() {
		if (btContinuar == null) {
			btContinuar = new JButton("Continuar");
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String res = ges.setFecha(getTxFecha().getText());
					if (res.isBlank())
						continuarConCreacionEntrevista();
					else
						JOptionPane.showMessageDialog(null, res);
				}
			});
			btContinuar.setEnabled(false);
			btContinuar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btContinuar.setBounds(533, 335, 157, 34);
		}
		return btContinuar;
	}
	
	private void continuarConCreacionEntrevista() {
		VentanaCreacionEntrevista frame = new VentanaCreacionEntrevista(ges);
		frame.setVisible(true);
		this.dispose();
	}
}
