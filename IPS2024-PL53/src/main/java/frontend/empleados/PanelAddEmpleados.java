package frontend.empleados;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelAddEmpleados extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnDNI;
	private JLabel lbDNI;
	private JTextField txDNI;
	private JPanel pnNombre;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JPanel pnApellido;
	private JLabel lbApellido;
	private JTextField txApellido;
	private JPanel pnTelefono;
	private JLabel lbTelefono;
	private JTextField txTelefono;
	private JPanel Nacimiento;
	private JLabel lbNacimiento;
	private JTextField txNacimiento;
	private JPanel pnSalario;
	private JLabel lbSalario;
	private JTextField txSalario;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_1_1;
	private Component verticalStrut_1_2;
	private Component verticalStrut_1_3;
	private Component verticalStrut_1_4;
	private JPanel pnPuesto;
	private JLabel lbPuesto;
	private Component verticalStrut_2;
	private JComboBox cbPuesto;
	private JPanel pnAdd;
	private JButton btAdd;
	private Component verticalStrut_3;

	/**
	 * Create the panel.
	 */
	public PanelAddEmpleados() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(getVerticalStrut_1());
		add(getPnDNI());
		add(getVerticalStrut());
		add(getPnNombre());
		add(getVerticalStrut_1_1());
		add(getPnApellido());
		add(getVerticalStrut_1_2());
		add(getPnTelefono());
		add(getVerticalStrut_1_3());
		add(getNacimiento());
		add(getVerticalStrut_1_4());
		add(getPnSalario());
		add(getVerticalStrut_2());
		add(getPnPuesto());
		add(getVerticalStrut_3());
		add(getPnAdd());

	}

	private JPanel getPnDNI() {
		if (pnDNI == null) {
			pnDNI = new JPanel();
			pnDNI.setLayout(new BoxLayout(pnDNI, BoxLayout.X_AXIS));
			pnDNI.add(getLbDNI());
			pnDNI.add(getTxDNI());
		}
		return pnDNI;
	}
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("DNI: ");
			lbDNI.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbDNI;
	}
	private JTextField getTxDNI() {
		if (txDNI == null) {
			txDNI = new JTextField();
			txDNI.setFont(new Font("Arial", Font.PLAIN, 12));
			txDNI.setColumns(10);
			txDNI.setMaximumSize(new Dimension(250, 20));
		}
		return txDNI;
	}
	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setLayout(new BoxLayout(pnNombre, BoxLayout.X_AXIS));
			pnNombre.add(getLbNombre());
			pnNombre.add(getTxNombre());
		}
		return pnNombre;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre: ");
			lbNombre.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setMaximumSize(new Dimension(250, 20));
			txNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JPanel getPnApellido() {
		if (pnApellido == null) {
			pnApellido = new JPanel();
			pnApellido.setLayout(new BoxLayout(pnApellido, BoxLayout.X_AXIS));
			pnApellido.add(getLbApellido());
			pnApellido.add(getTxApellido());
		}
		return pnApellido;
	}
	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellido: ");
			lbApellido.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbApellido;
	}
	private JTextField getTxApellido() {
		if (txApellido == null) {
			txApellido = new JTextField();
			txApellido.setMaximumSize(new Dimension(250, 20));
			txApellido.setFont(new Font("Arial", Font.PLAIN, 12));
			txApellido.setColumns(10);
		}
		return txApellido;
	}
	private JPanel getPnTelefono() {
		if (pnTelefono == null) {
			pnTelefono = new JPanel();
			pnTelefono.setLayout(new BoxLayout(pnTelefono, BoxLayout.X_AXIS));
			pnTelefono.add(getLbTelefono());
			pnTelefono.add(getTxTelefono());
		}
		return pnTelefono;
	}
	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Teléfono: ");
			lbTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbTelefono;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.setMaximumSize(new Dimension(250, 20));
			txTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JPanel getNacimiento() {
		if (Nacimiento == null) {
			Nacimiento = new JPanel();
			Nacimiento.setLayout(new BoxLayout(Nacimiento, BoxLayout.X_AXIS));
			Nacimiento.add(getLbNacimiento());
			Nacimiento.add(getTxNacimiento());
		}
		return Nacimiento;
	}
	private JLabel getLbNacimiento() {
		if (lbNacimiento == null) {
			lbNacimiento = new JLabel("Fecha Nacimiento: ");
			lbNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbNacimiento;
	}
	private JTextField getTxNacimiento() {
		if (txNacimiento == null) {
			txNacimiento = new JTextField();
			txNacimiento.setMaximumSize(new Dimension(250, 20));
			txNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
			txNacimiento.setColumns(10);
		}
		return txNacimiento;
	}
	private JPanel getPnSalario() {
		if (pnSalario == null) {
			pnSalario = new JPanel();
			pnSalario.setLayout(new BoxLayout(pnSalario, BoxLayout.X_AXIS));
			pnSalario.add(getLbSalario());
			pnSalario.add(getTxSalario());
		}
		return pnSalario;
	}
	private JLabel getLbSalario() {
		if (lbSalario == null) {
			lbSalario = new JLabel("Salario Anual: ");
			lbSalario.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbSalario;
	}
	private JTextField getTxSalario() {
		if (txSalario == null) {
			txSalario = new JTextField();
			txSalario.setMaximumSize(new Dimension(250, 20));
			txSalario.setFont(new Font("Arial", Font.PLAIN, 12));
			txSalario.setColumns(10);
		}
		return txSalario;
	}
	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(20);
		}
		return verticalStrut;
	}
	private Component getVerticalStrut_1() {
		if (verticalStrut_1 == null) {
			verticalStrut_1 = Box.createVerticalStrut(20);
		}
		return verticalStrut_1;
	}
	private Component getVerticalStrut_1_1() {
		if (verticalStrut_1_1 == null) {
			verticalStrut_1_1 = Box.createVerticalStrut(20);
		}
		return verticalStrut_1_1;
	}
	private Component getVerticalStrut_1_2() {
		if (verticalStrut_1_2 == null) {
			verticalStrut_1_2 = Box.createVerticalStrut(20);
		}
		return verticalStrut_1_2;
	}
	private Component getVerticalStrut_1_3() {
		if (verticalStrut_1_3 == null) {
			verticalStrut_1_3 = Box.createVerticalStrut(20);
		}
		return verticalStrut_1_3;
	}
	private Component getVerticalStrut_1_4() {
		if (verticalStrut_1_4 == null) {
			verticalStrut_1_4 = Box.createVerticalStrut(20);
		}
		return verticalStrut_1_4;
	}
	private JPanel getPnPuesto() {
		if (pnPuesto == null) {
			pnPuesto = new JPanel();
			pnPuesto.setLayout(new BoxLayout(pnPuesto, BoxLayout.X_AXIS));
			pnPuesto.add(getLbPuesto());
			pnPuesto.add(getCbPuesto());
		}
		return pnPuesto;
	}
	private JLabel getLbPuesto() {
		if (lbPuesto == null) {
			lbPuesto = new JLabel("Puesto de Trabajo: ");
			lbPuesto.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbPuesto;
	}
	private Component getVerticalStrut_2() {
		if (verticalStrut_2 == null) {
			verticalStrut_2 = Box.createVerticalStrut(20);
		}
		return verticalStrut_2;
	}
	private JComboBox getCbPuesto() {
		if (cbPuesto == null) {
			cbPuesto = new JComboBox();
			cbPuesto.setMaximumSize(new Dimension(250, 20));
			cbPuesto.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return cbPuesto;
	}
	private JPanel getPnAdd() {
		if (pnAdd == null) {
			pnAdd = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnAdd.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnAdd.add(getBtAdd());
		}
		return pnAdd;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Añadir");
			btAdd.setFont(new Font("Arial", Font.PLAIN, 12));
			btAdd.setAlignmentX(0.5f);
		}
		return btAdd;
	}
	private Component getVerticalStrut_3() {
		if (verticalStrut_3 == null) {
			verticalStrut_3 = Box.createVerticalStrut(20);
		}
		return verticalStrut_3;
	}
}
