package frontend.portalAccionistas;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;

import backend.service.ventas.campanaAccionistas.Accion;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class PanelAccionEnVenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private Accion accion;
	private JLabel lbAccion;
	private Component horizontalStrut;
	private JButton btComprar;
	private Component horizontalGlue;
	private Component horizontalStrut_1;

	/**
	 * Create the panel.
	 */
	public PanelAccionEnVenta(Accion accion) {
		this.accion = accion;
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getHorizontalStrut());
		add(getLbAccion());
		add(getHorizontalGlue());
		add(getBtComprar());
		add(getHorizontalStrut_1());

	}
	public Accion getAccion() {
		return accion;
	}
	
	public JLabel getLbAccion() {
		if (lbAccion == null) {
			lbAccion = new JLabel("Acción");
			lbAccion.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		return lbAccion;
	}
	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
		}
		return horizontalStrut;
	}
	public JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.setForeground(new Color(255, 255, 255));
			btComprar.setBackground(new Color(60, 179, 113));
			btComprar.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return btComprar;
	}
	private Component getHorizontalGlue() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}
	private Component getHorizontalStrut_1() {
		if (horizontalStrut_1 == null) {
			horizontalStrut_1 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_1;
	}
}
