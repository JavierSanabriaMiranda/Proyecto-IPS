package frontend.empleados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class FrameRegistroUsuarioDeEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbNombreUsuario;
	private JLabel lbPassword;
	private JTextField txNombreUsuario;
	private JPasswordField passwordField;
	private JTextPane txtpnIntroduzcaLosDatos;
	private JButton btCancelar;
	private JButton btAceptar;

	/**
	 * Create the frame.
	 */
	public FrameRegistroUsuarioDeEmpleados() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 251);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbNombreUsuario());
		contentPane.add(getLbPassword());
		contentPane.add(getTxNombreUsuario());
		contentPane.add(getPasswordField());
		contentPane.add(getTxtpnIntroduzcaLosDatos());
		contentPane.add(getBtCancelar());
		contentPane.add(getBtAceptar());
	}

	private JLabel getLbNombreUsuario() {
		if (lbNombreUsuario == null) {
			lbNombreUsuario = new JLabel("Nombre Usuario:");
			lbNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
			lbNombreUsuario.setBounds(35, 67, 98, 45);
		}
		return lbNombreUsuario;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseña:");
			lbPassword.setFont(new Font("Arial", Font.PLAIN, 13));
			lbPassword.setBounds(35, 123, 98, 45);
		}
		return lbPassword;
	}
	public JTextField getTxNombreUsuario() {
		if (txNombreUsuario == null) {
			txNombreUsuario = new JTextField();
			txNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
			txNombreUsuario.setBounds(137, 67, 221, 36);
			txNombreUsuario.setColumns(10);
		}
		return txNombreUsuario;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(113, 123, 245, 36);
		}
		return passwordField;
	}
	private JTextPane getTxtpnIntroduzcaLosDatos() {
		if (txtpnIntroduzcaLosDatos == null) {
			txtpnIntroduzcaLosDatos = new JTextPane();
			txtpnIntroduzcaLosDatos.setEditable(false);
			txtpnIntroduzcaLosDatos.setText("Introduzca los datos correspondientes al nuevo usuario del nuevo empleado a registrar");
			txtpnIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 13));
			txtpnIntroduzcaLosDatos.setBounds(35, 11, 362, 45);
		}
		return txtpnIntroduzcaLosDatos;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
			btCancelar.setBounds(330, 180, 89, 23);
		}
		return btCancelar;
	}
	public JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
			btAceptar.setBounds(231, 180, 89, 23);
		}
		return btAceptar;
	}
}
