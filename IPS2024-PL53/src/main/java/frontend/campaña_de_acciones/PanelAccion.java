package frontend.campaña_de_acciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import backend.service.ventas.campanaAccionistas.Accion;

public class PanelAccion extends JPanel {
	Accion accion;
	private static final long serialVersionUID = 1L;
	private JLabel lbAccion;
	private JLabel lbCodigoAccion;
	private JPanel pnBtAcciones;
	private JButton btVender;
	private JButton btQuitar;

	/**
	 * Create the panel.
	 */
	public PanelAccion(Accion accion) {
		setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		this.accion=accion;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getLbAccion(), BorderLayout.WEST);
		add(getLbCodigoAccion(), BorderLayout.CENTER);
		add(getPnBtAcciones(), BorderLayout.EAST);

	}

	private JLabel getLbAccion() {
		if (lbAccion == null) {
			lbAccion = new JLabel("Accion:");
			lbAccion.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lbAccion.setBackground(Color.WHITE);
		}
		return lbAccion;
	}
	private JLabel getLbCodigoAccion() {
		if (lbCodigoAccion == null) {
			lbCodigoAccion = new JLabel("");
			lbCodigoAccion.setFont(new Font("Tahoma", Font.BOLD, 17));
			lbCodigoAccion.setHorizontalAlignment(SwingConstants.CENTER);
			lbCodigoAccion.setText(accion.getIdAccion());
		}
		return lbCodigoAccion;
	}
	private JPanel getPnBtAcciones() {
		if (pnBtAcciones == null) {
			pnBtAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centrar horizontalmente
			pnBtAcciones.setBackground(Color.WHITE);
			pnBtAcciones.add(getBtVender());
			pnBtAcciones.add(getBtQuitar());
		}
		return pnBtAcciones;
	}
	private JButton getBtVender() {
		if (btVender == null) {
			btVender = new JButton("Vender");
			btVender.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btVender.setForeground(Color.WHITE);
			btVender.setBackground(new Color(60, 179, 113));
		}
		return btVender;
	}
	private JButton getBtQuitar() {
		if (btQuitar == null) {
			btQuitar = new JButton("Quitar Venta");
			btQuitar.setEnabled(false);
			btQuitar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btQuitar.setForeground(Color.WHITE);
			btQuitar.setBackground(Color.RED);
		}
		return btQuitar;
	}
}
