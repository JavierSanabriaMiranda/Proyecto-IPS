package frontend.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontend.AplicacionMain;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FrameLogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbLogIn;
	private JTextField txNombreUsuario;
	private JPasswordField passwordField;
	private JLabel lbNombreUsuario;
	private JLabel lbPassword;
	private JButton btLogIn;
	private JButton btEntrarSinLogIn;

	/**
	 * Create the frame.
	 */
	public FrameLogIn() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 431);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AplicacionMain.class.getResource("/img/productos/logo.jpg")));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogIn());
		contentPane.add(getTxNombreUsuario());
		contentPane.add(getPasswordField());
		contentPane.add(getLbNombreUsuario());
		contentPane.add(getLbPassword());
		contentPane.add(getBtLogIn());
		contentPane.add(getBtEntrarSinLogIn());
	}
	private JLabel getLbLogIn() {
		if (lbLogIn == null) {
			lbLogIn = new JLabel("Log In");
			lbLogIn.setHorizontalAlignment(SwingConstants.CENTER);
			lbLogIn.setFont(new Font("Arial", Font.BOLD, 40));
			lbLogIn.setBounds(153, 28, 133, 97);
		}
		return lbLogIn;
	}
	public JTextField getTxNombreUsuario() {
		if (txNombreUsuario == null) {
			txNombreUsuario = new JTextField();
			txNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
			txNombreUsuario.setBounds(149, 136, 244, 53);
			txNombreUsuario.setColumns(10);
		}
		return txNombreUsuario;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(149, 216, 244, 53);
		}
		return passwordField;
	}
	private JLabel getLbNombreUsuario() {
		if (lbNombreUsuario == null) {
			lbNombreUsuario = new JLabel("Nombre de Usuario:");
			lbNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNombreUsuario.setBounds(10, 136, 129, 53);
		}
		return lbNombreUsuario;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseña:");
			lbPassword.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPassword.setBounds(56, 215, 83, 53);
		}
		return lbPassword;
	}
	public JButton getBtLogIn() {
		if (btLogIn == null) {
			btLogIn = new JButton("Iniciar Sesión");
			btLogIn.setBounds(242, 315, 177, 45);
		}
		return btLogIn;
	}
	public JButton getBtEntrarSinLogIn() {
		if (btEntrarSinLogIn == null) {
			btEntrarSinLogIn = new JButton("Entrar sin iniciar sesión");
			btEntrarSinLogIn.setBounds(38, 315, 177, 45);
		}
		return btEntrarSinLogIn;
	}
}
