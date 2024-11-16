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
	private JLabel lbUsuario;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lbPassword;

	/**
	 * Create the frame.
	 */
	public FrameRegistrarNuevoAccionista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 326);
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
		contentPane.add(getLbUsuario());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getLbPassword());
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
			txNombre.setBounds(134, 77, 222, 32);
		}
		return txNombre;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
			btCancelar.setBounds(336, 255, 89, 23);
		}
		return btCancelar;
	}
	public JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
			btAceptar.setBounds(230, 255, 89, 23);
		}
		return btAceptar;
	}
	private JLabel getLbUsuario() {
		if (lbUsuario == null) {
			lbUsuario = new JLabel("Nombre Usuario:");
			lbUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
			lbUsuario.setBounds(63, 140, 107, 14);
		}
		return lbUsuario;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Arial", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBounds(180, 131, 176, 32);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
			textField_1.setColumns(10);
			textField_1.setBounds(145, 183, 211, 32);
		}
		return textField_1;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseña:");
			lbPassword.setFont(new Font("Arial", Font.PLAIN, 13));
			lbPassword.setBounds(63, 192, 107, 14);
		}
		return lbPassword;
	}
}
