package frontend.portalAccionistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FrameCompraAcciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JScrollPane scpnAcciones;
	private JPanel pnAccionesEnVenta;


	/**
	 * Create the frame.
	 */
	public FrameCompraAcciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnTitulo(), BorderLayout.NORTH);
		contentPane.add(getScpnAcciones(), BorderLayout.CENTER);
	}
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBackground(new Color(255, 255, 255));
			pnTitulo.add(getLbTitulo());
		}
		return pnTitulo;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Acciones en Venta");
			lbTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
			lbTitulo.setBackground(new Color(255, 255, 255));
		}
		return lbTitulo;
	}
	private JScrollPane getScpnAcciones() {
		if (scpnAcciones == null) {
			scpnAcciones = new JScrollPane();
			scpnAcciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scpnAcciones.setViewportView(getPnAccionesEnVenta());
		}
		return scpnAcciones;
	}
	private JPanel getPnAccionesEnVenta() {
		if (pnAccionesEnVenta == null) {
			pnAccionesEnVenta = new JPanel();
			pnAccionesEnVenta.setBackground(Color.WHITE);
			pnAccionesEnVenta.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return pnAccionesEnVenta;
	}
}
