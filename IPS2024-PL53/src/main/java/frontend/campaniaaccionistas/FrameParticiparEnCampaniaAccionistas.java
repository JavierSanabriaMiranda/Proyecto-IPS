package frontend.campaniaaccionistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrameParticiparEnCampaniaAccionistas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbFase;
	private JButton btInfo;
	private JLabel lbLimiteAcciones;
	private JSpinner spAcciones;
	private JLabel lbAcciones;
	private JLabel lbPrecio;
	private JButton btComprar;
	private JButton btSalir;


	/**
	 * Create the frame.
	 */
	public FrameParticiparEnCampaniaAccionistas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 385);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbFase());
		contentPane.add(getBtInfo());
		contentPane.add(getLbLimiteAcciones());
		contentPane.add(getSpAcciones());
		contentPane.add(getLbAcciones());
		contentPane.add(getLbPrecio());
		contentPane.add(getBtComprar());
		contentPane.add(getBtSalir());
	}
	private JLabel getLbFase() {
		if (lbFase == null) {
			lbFase = new JLabel("Fase Actual: ");
			lbFase.setFont(new Font("Arial", Font.BOLD, 30));
			lbFase.setBounds(172, 36, 228, 86);
		}
		return lbFase;
	}
	private JButton getBtInfo() {
		if (btInfo == null) {
			btInfo = new JButton("Info");
			btInfo.setFont(new Font("Arial", Font.BOLD, 12));
			btInfo.setBounds(491, 11, 62, 23);
		}
		return btInfo;
	}
	private JLabel getLbLimiteAcciones() {
		if (lbLimiteAcciones == null) {
			lbLimiteAcciones = new JLabel("Su limite de acciones para esta fase es de: ");
			lbLimiteAcciones.setFont(new Font("Arial", Font.PLAIN, 16));
			lbLimiteAcciones.setBounds(105, 129, 362, 35);
		}
		return lbLimiteAcciones;
	}
	private JSpinner getSpAcciones() {
		if (spAcciones == null) {
			spAcciones = new JSpinner();
			spAcciones.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spAcciones.setFont(new Font("Arial", Font.PLAIN, 14));
			spAcciones.setBounds(327, 182, 62, 23);
		}
		return spAcciones;
	}
	private JLabel getLbAcciones() {
		if (lbAcciones == null) {
			lbAcciones = new JLabel("Numero de acciones:");
			lbAcciones.setFont(new Font("Arial", Font.PLAIN, 16));
			lbAcciones.setBounds(172, 175, 161, 35);
		}
		return lbAcciones;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio total: ");
			lbPrecio.setFont(new Font("Arial", Font.BOLD, 16));
			lbPrecio.setBounds(195, 216, 138, 40);
		}
		return lbPrecio;
	}
	private JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.setFont(new Font("Arial", Font.PLAIN, 20));
			btComprar.setBounds(205, 281, 138, 56);
		}
		return btComprar;
	}
	private JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setFont(new Font("Arial", Font.PLAIN, 12));
			btSalir.setBounds(491, 314, 62, 23);
		}
		return btSalir;
	}
}
