package frontend.empleados.horarios;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalTime;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class PanelHora extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbHora;
	private JLabel lbEstado;
	private Component horizontalStrut;
	private Component horizontalStrut_1;

	/**
	 * Create the panel.
	 */
	public PanelHora() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getHorizontalStrut_1());
		add(getLbHora());
		add(getHorizontalStrut());
		add(getLbEstado());
		this.setPreferredSize(new Dimension(this.getWidth(), 30));
	}

	private JLabel getLbHora() {
		if (lbHora == null) {
			lbHora = new JLabel("00:00 - 01:00\r\n");
			lbHora.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbHora;
	}
	private JLabel getLbEstado() {
		if (lbEstado == null) {
			lbEstado = new JLabel("Libre\r\n");
			lbEstado.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbEstado;
	}
	
	protected void setHora(LocalTime hora) {
		LocalTime horaSiguiente = hora.plusHours(1);
		getLbHora().setText(hora + " - " + horaSiguiente);
	}

	protected void setOcupado(LocalTime horaInicio, LocalTime horaFin) {
		getLbEstado().setText("Trabajo de " + horaInicio + " a " + horaFin);
		this.setBackground(Color.LIGHT_GRAY);
	}
	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
		}
		return horizontalStrut;
	}
	private Component getHorizontalStrut_1() {
		if (horizontalStrut_1 == null) {
			horizontalStrut_1 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_1;
	}
}
