package frontend.entrevistaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontend.entrevistaUI.franja.VentanaSeleccionFranjaEntrevista;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalEntrevista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btEntrenadorCrearFranjas;
	private JButton btDirectorComunicacionesCrearEntrevistas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalEntrevista frame = new VentanaPrincipalEntrevista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalEntrevista() {
		setTitle("Entrevista");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(getBtEntrenadorCrearFranjas());
		contentPane.add(getBtDirectorComunicacionesCrearEntrevistas());
		this.setLocationRelativeTo(null);
	}
	private JButton getBtEntrenadorCrearFranjas() {
		if (btEntrenadorCrearFranjas == null) {
			btEntrenadorCrearFranjas = new JButton("Entrenador: Crear Franjas");
			btEntrenadorCrearFranjas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaCrearFranjas();
				}
			});
			btEntrenadorCrearFranjas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btEntrenadorCrearFranjas;
	}
	
	private void mostrarVentanaCrearFranjas() {
		VentanaSeleccionarJugadorFranjasEntrevistas ventanaSeleccionJugador = new VentanaSeleccionarJugadorFranjasEntrevistas();
		ventanaSeleccionJugador.setVisible(true);
		this.dispose();
	}
	
	private JButton getBtDirectorComunicacionesCrearEntrevistas() {
		if (btDirectorComunicacionesCrearEntrevistas == null) {
			btDirectorComunicacionesCrearEntrevistas = new JButton("Director de comunicaciones: Crear Entrevistas");
			btDirectorComunicacionesCrearEntrevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaCrearEntrevistas();
				}
			});
			btDirectorComunicacionesCrearEntrevistas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btDirectorComunicacionesCrearEntrevistas;
	}
	
	private void mostrarVentanaCrearEntrevistas() {
		VentanaSeleccionFranjaEntrevista frame = new VentanaSeleccionFranjaEntrevista();
		frame.setVisible(true);
		this.disable();
	}
}
