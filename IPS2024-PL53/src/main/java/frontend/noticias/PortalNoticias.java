package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PortalNoticias extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnPrincipal;
	private JPanel pnSuperior;
	private JLabel lbTitulo;
	private JScrollPane scPanelNoticias;
	private JPanel pnNoticias;
	private JPanel pnBotones;
	private JButton btSalir;

	/**
	 * Create the frame.
	 */
	public PortalNoticias() {
		setTitle("Portal de Noticias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnPrincipal(), "pn1");
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setBackground(Color.WHITE);
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPnSuperior(), BorderLayout.NORTH);
			pnPrincipal.add(getScPanelNoticias(), BorderLayout.CENTER);
			pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
		}
		return pnPrincipal;
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new BorderLayout(0, 0));
			pnSuperior.add(getLbTitulo(), BorderLayout.WEST);
			//pnSuperior.add(new PanelMiniaturaNoticia(), BorderLayout.CENTER);
		}
		return pnSuperior;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("NOTICIAS");
			lbTitulo.setFont(new Font("Serif", Font.BOLD, 30));
			lbTitulo.setBackground(Color.WHITE);
		}
		return lbTitulo;
	}
	private JScrollPane getScPanelNoticias() {
		if (scPanelNoticias == null) {
			scPanelNoticias = new JScrollPane();
			scPanelNoticias.setViewportView(getPnNoticias());
		}
		return scPanelNoticias;
	}
	private JPanel getPnNoticias() {
		if (pnNoticias == null) {
			pnNoticias = new JPanel();
			pnNoticias.setBackground(Color.WHITE);
			pnNoticias.setLayout(new GridLayout(0, 4, 5, 5));
		}
		return pnNoticias;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(Color.WHITE);
			pnBotones.setLayout(new BorderLayout(0, 0));
			pnBotones.add(getBtSalir(), BorderLayout.EAST);
		}
		return pnBotones;
	}
	private JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
			btSalir.setForeground(Color.WHITE);
			btSalir.setBackground(Color.RED);
		}
		return btSalir;
	}
}
