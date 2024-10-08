package frontend.reservaUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class HorarioReserva extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VentanaPrincipalReserva vpr;
	private JScrollPane scrollPanelHorario;
	private JPanel panelSeleccion;
	private JPanel panelHorario;

	/**
	 * Create the dialog.
	 */
	public HorarioReserva(VentanaPrincipalReserva vpr) {
		setTitle("ReservaHorario");
		setModal(true);
		this.vpr = vpr;
		setBounds(100, 100, 655, 665);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		contentPanel.add(getScrollPanelHorario());
		contentPanel.add(getPanelSeleccion());
	}

	public VentanaPrincipalReserva getVpr() {
		return vpr;
	}
	private JScrollPane getScrollPanelHorario() {
		if (scrollPanelHorario == null) {
			scrollPanelHorario = new JScrollPane();
			scrollPanelHorario.setViewportView(getPanelHorario());
		}
		return scrollPanelHorario;
	}
	private JPanel getPanelSeleccion() {
		if (panelSeleccion == null) {
			panelSeleccion = new JPanel();
			panelSeleccion.setBackground(new Color(255, 255, 255));
			panelSeleccion.setLayout(null);
		}
		return panelSeleccion;
	}
	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			panelHorario.setLayout(new GridLayout(15, 1, 0, 0));
		}
		return panelHorario;
	}
}
