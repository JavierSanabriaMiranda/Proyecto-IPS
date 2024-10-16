package frontend.entrevistaUI;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.empleados.deportivos.Jugador;
import shared.gestionentrevista.GestionEntrevistaShared;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionarJugadorFranjasEntrevistas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitulo;
	private JScrollPane scpJugadoresProfesionales;
	private JList<Jugador> listJugadoresProfesionales;
	
	private DefaultListModel<Jugador> modeloListLibrary;
	
	private GestionEntrevistaShared ges = new GestionEntrevistaShared();
	private JButton btSeleccionar;

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionarJugadorFranjasEntrevistas() {
		setTitle("Entrevistas: Crear franja entrevistas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitulo());
		contentPane.add(getScpJugadoresProfesionales());
		contentPane.add(getBtSeleccionar());
		this.setLocationRelativeTo(null);
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Seleccione un jugador para crear franjas de entrevistas");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTitulo.setBounds(10, 10, 513, 48);
		}
		return lbTitulo;
	}
	private JScrollPane getScpJugadoresProfesionales() {
		if (scpJugadoresProfesionales == null) {
			scpJugadoresProfesionales = new JScrollPane();
			scpJugadoresProfesionales.setBounds(10, 81, 513, 230);
			scpJugadoresProfesionales.setViewportView(getListJugadoresProfesionales());
		}
		return scpJugadoresProfesionales;
	}
	private JList<Jugador> getListJugadoresProfesionales() {
		if (listJugadoresProfesionales == null) {
			modeloListLibrary = new DefaultListModel<Jugador>();
			listJugadoresProfesionales = new JList<Jugador>(modeloListLibrary);
			cargarModelo();
		}
		return listJugadoresProfesionales;
	}
	
	private void cargarModelo() {
		this.modeloListLibrary.addAll(ges.getJugadoresProfesionales());
	}
	private JButton getBtSeleccionar() {
		if (btSeleccionar == null) {
			btSeleccionar = new JButton("Seleccionar");
			btSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionarJugador();
					mostrarVentanaCreacionFranjas();
				}
			});
			btSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btSeleccionar.setBounds(381, 321, 142, 27);
		}
		return btSeleccionar;
	}
	
	private void seleccionarJugador() {
		ges.seleccionarJugador(this.getListJugadoresProfesionales().getSelectedValue());
	}
	
	private void mostrarVentanaCreacionFranjas() {
		VentanaSeleccionHoraFranjaEntrevista ventanaHora = new VentanaSeleccionHoraFranjaEntrevista(ges);
		ventanaHora.setVisible(true);
		
		this.dispose();
	}
}
