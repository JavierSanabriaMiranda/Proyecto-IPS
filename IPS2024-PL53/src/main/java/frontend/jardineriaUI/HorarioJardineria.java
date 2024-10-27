package frontend.jardineriaUI;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class HorarioJardineria extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel pnTitulos;
	private JPanel pnCentral;
	private JLabel lblHorarioEmpleado;
	private JLabel lblHorarioInstalacion;
	private JLabel lblSeleccionHoras;
	private JPanel pnHorarioEmpleado;
	private JPanel pnHorarioInstalacion;
	private JPanel pnSeleccionHoras;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JButton btnAñadir;
	private JButton btnAtras2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HorarioJardineria dialog = new HorarioJardineria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HorarioJardineria() {
		setBounds(100, 100, 1074, 536);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getPnCentral(), BorderLayout.CENTER);
		contentPanel.add(getPnTitulos(), BorderLayout.NORTH);
	}

	private JPanel getPnTitulos() {
		if (pnTitulos == null) {
			pnTitulos = new JPanel();
			pnTitulos.setBackground(new Color(255, 255, 255));
			pnTitulos.setLayout(new GridLayout(0, 3, 0, 0));
			pnTitulos.add(getLblHorarioEmpleado());
			pnTitulos.add(getLblHorarioInstalacion());
			pnTitulos.add(getLblSeleccionHoras());
		}
		return pnTitulos;
	}

	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new GridLayout(0, 3, 0, 0));
			pnCentral.add(getPnHorarioEmpleado());
			pnCentral.add(getPnHorarioInstalacion());
			pnCentral.add(getPnSeleccionHoras());
			
		}
		return pnCentral;
	}

	private JLabel getLblSeleccionHoras() {
		if (lblSeleccionHoras == null) {
			lblSeleccionHoras = new JLabel("SELECCIÓN DE HORAS");
			lblSeleccionHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));

		}
		return lblSeleccionHoras;
	}

	private JLabel getLblHorarioInstalacion() {
		if (lblHorarioInstalacion == null) {
			lblHorarioInstalacion = new JLabel("HORARIO INSTALACIÓN");
			lblHorarioInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorarioInstalacion;
	}
	
	private JLabel getLblHorarioEmpleado() {
		if (lblHorarioEmpleado == null) {
			lblHorarioEmpleado = new JLabel("HORARIO EMPLEADO");
			lblHorarioEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHorarioEmpleado.setBackground(new Color(255, 255, 255));
		}
		return lblHorarioEmpleado;
	}

	private JPanel getPnHorarioEmpleado() {
		if (pnHorarioEmpleado == null) {
			pnHorarioEmpleado = new JPanel();
			pnHorarioEmpleado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnHorarioEmpleado.setBackground(new Color(255, 255, 255));
		}
		return pnHorarioEmpleado;
	}
	private JPanel getPnHorarioInstalacion() {
		if (pnHorarioInstalacion == null) {
			pnHorarioInstalacion = new JPanel();
			pnHorarioInstalacion.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnHorarioInstalacion.setBackground(new Color(255, 255, 255));
		}
		return pnHorarioInstalacion;
	}
	private JPanel getPnSeleccionHoras() {
		if (pnSeleccionHoras == null) {
			pnSeleccionHoras = new JPanel();
			pnSeleccionHoras.setBackground(new Color(255, 255, 255));
			pnSeleccionHoras.setLayout(null);
			pnSeleccionHoras.add(getSpHoraInicio());
			pnSeleccionHoras.add(getSpHoraFin());
			pnSeleccionHoras.add(getLblHoraInicio());
			pnSeleccionHoras.add(getLblHoraFin());
			pnSeleccionHoras.add(getBtnAñadir());
			pnSeleccionHoras.add(getBtnAtras2());
		}
		return pnSeleccionHoras;
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			spHoraInicio = new JSpinner();
			spHoraInicio.setBounds(102, 80, 126, 30);
		}
		return spHoraInicio;
	}
	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			spHoraFin = new JSpinner();
			spHoraFin.setBounds(102, 187, 126, 30);
		}
		return spHoraFin;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio: ");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraInicio.setBounds(62, 49, 100, 20);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraFin.setBounds(62, 156, 100, 20);
		}
		return lblHoraFin;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("Añadir");
			btnAñadir.setBounds(251, 438, 89, 23);
		}
		return btnAñadir;
	}
	private JButton getBtnAtras2() {
		if (btnAtras2 == null) {
			btnAtras2 = new JButton("Atras");
			btnAtras2.setBounds(10, 438, 89, 23);
		}
		return btnAtras2;
	}
}
