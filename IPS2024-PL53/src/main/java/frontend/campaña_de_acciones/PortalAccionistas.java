package frontend.campaña_de_acciones;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class PortalAccionistas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel pn1;
	JPanel pnTituloLogin;
	JLabel lbTituloLogin;
	JLabel imagenLogin;
	private JButton btLogin;
	private JPanel pn2;
	private JLabel lbTituloAcciones;
	private JPanel pnDatos;
	private JLabel lbDNI;
	private JPanel pnDNI;
	private JTextField tfDNI;
	private JPanel pnAcciones;
	private JLabel lbAcciones;
	private JScrollPane scAcciones;
	private JPanel pnListaAcciones;
	private JPanel pnSalir;
	private JButton btSalir;
	private JPanel pnComprar;
	private JButton btComprar;

	/**
	 * Create the frame.
	 */
	public PortalAccionistas() {
		setTitle("Portal de Accionistas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setContentPane(getContentPane());
		
	}
	
	@Override
	public JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new CardLayout(0, 0));
			contentPane.add(getPn1(), "pn1");		
			contentPane.add(getPn2(), "pn2");
		}
		return contentPane;
	}

	private JPanel getPn1() {
		if(pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnTituloLogin(), BorderLayout.NORTH);			
			pn1.add(getBtLogin(), BorderLayout.SOUTH);
			pn1.add(getPnDatos(), BorderLayout.CENTER);
		}
		return pn1;
	}

	private JPanel getPnTituloLogin() {
		if(pnTituloLogin == null) {
			pnTituloLogin = new JPanel();
			pnTituloLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			pnTituloLogin.setBackground(Color.WHITE);
			pnTituloLogin.setLayout(new BorderLayout(0, 0));
			pnTituloLogin.add(getLbTituloLogin(), BorderLayout.CENTER);
			pnTituloLogin.add(getImagenLogin(), BorderLayout.EAST);
		}
		return pnTituloLogin;
	}

	private JLabel getLbTituloLogin() {
		if(lbTituloLogin == null) {
			lbTituloLogin = new JLabel("Login Page");
			lbTituloLogin.setBackground(Color.WHITE);
			lbTituloLogin.setFont(new Font("Arial", Font.BOLD, 30));
			lbTituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTituloLogin;
	}
	
	private JLabel getImagenLogin() {
		if(imagenLogin == null) {
			imagenLogin = new JLabel("");
			imagenLogin.setBackground(Color.WHITE);
			imagenLogin.setIcon(new ImageIcon(this.getClass().getResource("/img/accionistas/login.jpg")));
		}
		return imagenLogin;
	}

	public JButton getBtLogin() {
		if (btLogin == null) {
			btLogin = new JButton("Login");
			btLogin.setEnabled(false);
			btLogin.setFont(new Font("Tahoma", Font.BOLD, 28));
			btLogin.setForeground(Color.WHITE);
			btLogin.setBackground(new Color(65, 105, 225));
		}
		return btLogin;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(Color.WHITE);
			pnDatos.setLayout(new GridLayout(2, 1, 0, 0));
			pnDatos.add(getLbDNI());
			pnDatos.add(getPnDNI());
		}
		return pnDatos;
	}
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("Ingrese su DNI para acceder:    ");
			lbDNI.setHorizontalAlignment(SwingConstants.CENTER);
			lbDNI.setFont(new Font("Arial", Font.PLAIN, 20));
			lbDNI.setBackground(Color.WHITE);
		}
		return lbDNI;
	}
	private JPanel getPnDNI() {
		if (pnDNI == null) {
			pnDNI = new JPanel();
			pnDNI.setBackground(Color.WHITE);
			pnDNI.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnDNI.add(getTfDNI());
		}
		return pnDNI;
	}
	public JTextField getTfDNI() {
		if (tfDNI == null) {
			tfDNI = new JTextField();
			tfDNI.setHorizontalAlignment(SwingConstants.CENTER);
			tfDNI.setFont(new Font("Arial", Font.PLAIN, 20));
			tfDNI.setColumns(18);
		}
		return tfDNI;
	}
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getLbTituloAcciones(), BorderLayout.NORTH);
			pn2.add(getPnAcciones(), BorderLayout.CENTER);
			pn2.add(getPnSalir(), BorderLayout.SOUTH);
		}
		return pn2;
	}
	private JLabel getLbTituloAcciones() {
		if (lbTituloAcciones == null) {
			lbTituloAcciones = new JLabel("Mis Acciones");
			lbTituloAcciones.setBorder(new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
			lbTituloAcciones.setFont(new Font("Arial", Font.BOLD, 40));
			lbTituloAcciones.setBackground(Color.WHITE);
			lbTituloAcciones.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTituloAcciones;
	}
	
	private JPanel getPnAcciones() {
		if (pnAcciones == null) {
			pnAcciones = new JPanel();
			pnAcciones.setBackground(Color.WHITE);
			pnAcciones.setLayout(new BorderLayout(0, 0));
			pnAcciones.add(getLbAcciones(), BorderLayout.NORTH);
			pnAcciones.add(getScAcciones(), BorderLayout.CENTER);
			pnAcciones.add(getPnComprar(), BorderLayout.SOUTH);
		}
		return pnAcciones;
	}

	public JLabel getLbAcciones() {
		if (lbAcciones == null) {
			lbAcciones = new JLabel("");
			lbAcciones.setFont(new Font("Dialog", Font.PLAIN, 27));
		}
		return lbAcciones;
	}
	private JScrollPane getScAcciones() {
		if (scAcciones == null) {
			scAcciones = new JScrollPane();
			scAcciones.setBackground(Color.WHITE);
			scAcciones.setViewportView(getPnListaAcciones());
		}
		return scAcciones;
	}
	public JPanel getPnListaAcciones() {
		if (pnListaAcciones == null) {
			pnListaAcciones = new JPanel();
			pnListaAcciones.setBackground(Color.WHITE);
			pnListaAcciones.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return pnListaAcciones;
	}
	private JPanel getPnSalir() {
		if (pnSalir == null) {
			pnSalir = new JPanel();
			pnSalir.setBackground(Color.WHITE);
			pnSalir.setLayout(new BorderLayout(0, 0));
			pnSalir.add(getBtSalir(), BorderLayout.EAST);
		}
		return pnSalir;
	}
	public JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setForeground(Color.WHITE);
			btSalir.setBackground(Color.RED);
			btSalir.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btSalir;
	}
	private JPanel getPnComprar() {
		if (pnComprar == null) {
			pnComprar = new JPanel();
			pnComprar.setBackground(Color.WHITE);
			pnComprar.setLayout(new FlowLayout());
			pnComprar.add(getBtComprar());
		}
		return pnComprar;
	}
	public JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar más acciones");
			btComprar.setMargin(new Insets(2, 100, 2, 100));
			btComprar.setBackground(new Color(230, 230, 250));
			btComprar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return btComprar;
	}
}
