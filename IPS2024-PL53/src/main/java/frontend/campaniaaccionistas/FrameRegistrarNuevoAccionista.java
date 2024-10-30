package frontend.campaniaaccionistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrameRegistrarNuevoAccionista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnParaRegistrarseComo;
	private JLabel lbDni;
	private JLabel lbNombre;
	private JTextField txDni;
	private JTextField txNombre;
	private JButton btCancelar;
	private JButton btAceptar;

	/**
	 * Create the frame.
	 */
	public FrameRegistrarNuevoAccionista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtpnParaRegistrarseComo());
		contentPane.add(getLbDni());
		contentPane.add(getLbNombre());
		contentPane.add(getTxDni());
		contentPane.add(getTxNombre());
		contentPane.add(getBtCancelar());
		contentPane.add(getBtAceptar());
	}
	private JTextPane getTxtpnParaRegistrarseComo() {
		if (txtpnParaRegistrarseComo == null) {
			txtpnParaRegistrarseComo = new JTextPane();
			txtpnParaRegistrarseComo.setEditable(false);
			txtpnParaRegistrarseComo.setText("Para registrarse como nuevo accionista proporcione los siguientes datos");
			txtpnParaRegistrarseComo.setFont(new Font("Arial", Font.PLAIN, 14));
			txtpnParaRegistrarseComo.setBounds(53, 11, 337, 54);
		}
		return txtpnParaRegistrarseComo;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI:");
			lbDni.setFont(new Font("Arial", Font.PLAIN, 12));
			lbDni.setBounds(64, 76, 41, 22);
		}
		return lbDni;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			lbNombre.setBounds(64, 109, 61, 14);
		}
		return lbNombre;
	}
	public JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setFont(new Font("Arial", Font.PLAIN, 12));
			txDni.setBounds(125, 76, 176, 20);
			txDni.setColumns(10);
		}
		return txDni;
	}
	public JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			txNombre.setColumns(10);
			txNombre.setBounds(125, 106, 176, 20);
		}
		return txNombre;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
			btCancelar.setBounds(335, 176, 89, 23);
		}
		return btCancelar;
	}
	public JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
			btAceptar.setBounds(233, 176, 89, 23);
		}
		return btAceptar;
	}
}
