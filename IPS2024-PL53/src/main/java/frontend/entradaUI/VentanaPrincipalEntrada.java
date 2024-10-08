package frontend.entradaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.gestionentrada.GestionEntradaShared;
import shared.gestionpartido.GestionPartidoShared;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalEntrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbPartido;
	private JLabel lbComboPartido;
	private JComboBox<String> cbPartidos;
	private JButton btSeleccionar;
	private JButton btCancelar;
	
	private GestionPartidoShared gps = new GestionPartidoShared();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalEntrada frame = new VentanaPrincipalEntrada();
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
	public VentanaPrincipalEntrada() {
		
		setResizable(false);
		setTitle("Venta de Entradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbPartido());
		contentPane.add(getLbComboPartido());
		contentPane.add(getCbPartidos());
		contentPane.add(getBtSeleccionar());
		contentPane.add(getBtCancelar());
		setLocationRelativeTo(null);
	}

	private JLabel getLbPartido() {
		if (lbPartido == null) {
			lbPartido = new JLabel("Seleccione el partido del que desea comprar entradas");
			lbPartido.setHorizontalAlignment(SwingConstants.CENTER);
			lbPartido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbPartido.setBounds(10, 10, 443, 37);
		}
		return lbPartido;
	}
	private JLabel getLbComboPartido() {
		if (lbComboPartido == null) {
			lbComboPartido = new JLabel("Posibles partidos:");
			lbComboPartido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbComboPartido.setBounds(10, 78, 218, 37);
		}
		return lbComboPartido;
	}
	private JComboBox<String> getCbPartidos() {
		if (cbPartidos == null) {
			cbPartidos = new JComboBox<String>();
			cbPartidos.setModel(new DefaultComboBoxModel<String>(gps.getTodosPartidos()));
			cbPartidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbPartidos.setBounds(10, 125, 443, 37);
		}
		return cbPartidos;
	}
	private JButton getBtSeleccionar() {
		if (btSeleccionar == null) {
			btSeleccionar = new JButton("Seleccionar");
			btSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionEntradaShared ges = seleccionarPartido();
					
					mostrarVentanaSeleccion(ges);
				}
			});
			btSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btSeleccionar.setBounds(322, 224, 131, 37);
		}
		return btSeleccionar;
	}
	
	private void mostrarVentanaSeleccion(GestionEntradaShared ges) {
		VentanaSeleccionEntradas vSE = new VentanaSeleccionEntradas(ges);
		vSE.setVisible(true);
		this.setVisible(false);
	}
	
	private GestionEntradaShared seleccionarPartido() {
		String[] selected = ((String) getCbPartidos().getSelectedItem()).split("/");
		String fecha = selected[0];
		String inicio = selected[1];
		String fin = selected[2];
		String partidoId = gps.getIdPartidoByFechaInicioFin(fecha, inicio, fin);
		return new GestionEntradaShared(partidoId);
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btCancelar.setBounds(167, 224, 131, 37);
		}
		return btCancelar;
	}
}
