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
	private JLabel lbNombre;
	private JTextField txNombre;
	private JButton btCancelar;
	private JButton btAceptar;

	/**
	 * Create the frame.
	 */
	public FrameRegistrarNuevoAccionista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 212);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtpnParaRegistrarseComo());
		contentPane.add(getLbNombre());
		contentPane.add(getTxNombre());
		contentPane.add(getBtCancelar());
		contentPane.add(getBtAceptar());
	}
	private JTextPane getTxtpnParaRegistrarseComo() {
		if (txtpnParaRegistrarseComo == null) {
			txtpnParaRegistrarseComo = new JTextPane();
			txtpnParaRegistrarseComo.setEditable(false);
			txtpnParaRegistrarseComo.setText("Para registrarse como nuevo accionista proporcione los siguientes datos:");
			txtpnParaRegistrarseComo.setFont(new Font("Arial", Font.PLAIN, 14));
			txtpnParaRegistrarseComo.setBounds(53, 11, 337, 54);
		}
		return txtpnParaRegistrarseComo;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 13));
			lbNombre.setBounds(63, 86, 61, 14);
		}
		return lbNombre;
	}
	public JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			txNombre.setColumns(10);
			txNombre.setBounds(121, 77, 176, 32);
		}
		return txNombre;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
			btCancelar.setBounds(334, 136, 89, 23);
		}
		return btCancelar;
	}
	public JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
			btAceptar.setBounds(235, 136, 89, 23);
		}
		return btAceptar;
	}
}
