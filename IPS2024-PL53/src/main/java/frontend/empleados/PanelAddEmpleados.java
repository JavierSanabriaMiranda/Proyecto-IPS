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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelAddEmpleados extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private JTextField txNombre;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut;
	private JLabel lbApellido;
	private JLabel lbDNI;
	private JLabel lbTelefono;
	private JLabel lbSalario;
	private JLabel lbNacimiento;
	private JLabel lbPuesto;
	private JTextField txApellido;
	private JTextField txDNI;
	private JTextField txTelefono;
	private JTextField txNacimiento;
	private JTextField txSalario;
	private JComboBox cbPuesto;
	private JButton btAdd;

	/**
	 * Create the panel.
	 */
	public PanelAddEmpleados() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 112, 0, 0, 377, 138, 0};
		gridBagLayout.rowHeights = new int[] {0, 35, 35, 35, 35, 35, 35, 35, 0, 0, 35};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		add(getVerticalStrut(), gbc_verticalStrut);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		add(getHorizontalStrut(), gbc_horizontalStrut);
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.anchor = GridBagConstraints.WEST;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 1;
		gbc_lbNombre.gridy = 1;
		add(getLbNombre(), gbc_lbNombre);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 1;
		add(getHorizontalStrut_1(), gbc_horizontalStrut_1);
		GridBagConstraints gbc_txNombre = new GridBagConstraints();
		gbc_txNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txNombre.gridx = 4;
		gbc_txNombre.gridy = 1;
		add(getTxNombre(), gbc_txNombre);
		GridBagConstraints gbc_lbApellido = new GridBagConstraints();
		gbc_lbApellido.anchor = GridBagConstraints.WEST;
		gbc_lbApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbApellido.gridx = 1;
		gbc_lbApellido.gridy = 2;
		add(getLbApellido(), gbc_lbApellido);
		GridBagConstraints gbc_txApellido = new GridBagConstraints();
		gbc_txApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txApellido.gridx = 4;
		gbc_txApellido.gridy = 2;
		add(getTxApellido(), gbc_txApellido);
		GridBagConstraints gbc_lbDNI = new GridBagConstraints();
		gbc_lbDNI.anchor = GridBagConstraints.WEST;
		gbc_lbDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lbDNI.gridx = 1;
		gbc_lbDNI.gridy = 3;
		add(getLbDNI(), gbc_lbDNI);
		GridBagConstraints gbc_txDNI = new GridBagConstraints();
		gbc_txDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txDNI.gridx = 4;
		gbc_txDNI.gridy = 3;
		add(getTxDNI(), gbc_txDNI);
		GridBagConstraints gbc_lbTelefono = new GridBagConstraints();
		gbc_lbTelefono.anchor = GridBagConstraints.WEST;
		gbc_lbTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lbTelefono.gridx = 1;
		gbc_lbTelefono.gridy = 4;
		add(getLbTelefono(), gbc_lbTelefono);
		GridBagConstraints gbc_txTelefono = new GridBagConstraints();
		gbc_txTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTelefono.gridx = 4;
		gbc_txTelefono.gridy = 4;
		add(getTxTelefono(), gbc_txTelefono);
		GridBagConstraints gbc_lbNacimiento = new GridBagConstraints();
		gbc_lbNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lbNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lbNacimiento.gridx = 1;
		gbc_lbNacimiento.gridy = 5;
		add(getLbNacimiento(), gbc_lbNacimiento);
		GridBagConstraints gbc_txNacimiento = new GridBagConstraints();
		gbc_txNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_txNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNacimiento.gridx = 4;
		gbc_txNacimiento.gridy = 5;
		add(getTxNacimiento(), gbc_txNacimiento);
		GridBagConstraints gbc_lbSalario = new GridBagConstraints();
		gbc_lbSalario.anchor = GridBagConstraints.WEST;
		gbc_lbSalario.insets = new Insets(0, 0, 5, 5);
		gbc_lbSalario.gridx = 1;
		gbc_lbSalario.gridy = 6;
		add(getLbSalario(), gbc_lbSalario);
		GridBagConstraints gbc_txSalario = new GridBagConstraints();
		gbc_txSalario.insets = new Insets(0, 0, 5, 5);
		gbc_txSalario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txSalario.gridx = 4;
		gbc_txSalario.gridy = 6;
		add(getTxSalario(), gbc_txSalario);
		GridBagConstraints gbc_lbPuesto = new GridBagConstraints();
		gbc_lbPuesto.anchor = GridBagConstraints.WEST;
		gbc_lbPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lbPuesto.gridx = 1;
		gbc_lbPuesto.gridy = 7;
		add(getLbPuesto(), gbc_lbPuesto);
		GridBagConstraints gbc_cbPuesto = new GridBagConstraints();
		gbc_cbPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_cbPuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPuesto.gridx = 4;
		gbc_cbPuesto.gridy = 7;
		add(getCbPuesto(), gbc_cbPuesto);
		GridBagConstraints gbc_btAdd = new GridBagConstraints();
		gbc_btAdd.gridx = 5;
		gbc_btAdd.gridy = 9;
		add(getBtAdd(), gbc_btAdd);

	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			txNombre.setColumns(10);
		}
		return txNombre;
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
	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(20);
		}
		return verticalStrut;
	}
	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellido:");
			lbApellido.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbApellido;
	}
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("DNI:");
			lbDNI.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbDNI;
	}
	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Teléfono:");
			lbTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbTelefono;
	}
	private JLabel getLbSalario() {
		if (lbSalario == null) {
			lbSalario = new JLabel("Salario Anual");
			lbSalario.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbSalario;
	}
	private JLabel getLbNacimiento() {
		if (lbNacimiento == null) {
			lbNacimiento = new JLabel("Fecha de Nacimiento:");
			lbNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbNacimiento;
	}
	private JLabel getLbPuesto() {
		if (lbPuesto == null) {
			lbPuesto = new JLabel("Puesto de Trabajo:");
			lbPuesto.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbPuesto;
	}
	private JTextField getTxApellido() {
		if (txApellido == null) {
			txApellido = new JTextField();
			txApellido.setFont(new Font("Arial", Font.PLAIN, 12));
			txApellido.setColumns(10);
		}
		return txApellido;
	}
	private JTextField getTxDNI() {
		if (txDNI == null) {
			txDNI = new JTextField();
			txDNI.setFont(new Font("Arial", Font.PLAIN, 12));
			txDNI.setColumns(10);
		}
		return txDNI;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JTextField getTxNacimiento() {
		if (txNacimiento == null) {
			txNacimiento = new JTextField();
			txNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
			txNacimiento.setColumns(10);
		}
		return txNacimiento;
	}
	private JTextField getTxSalario() {
		if (txSalario == null) {
			txSalario = new JTextField();
			txSalario.setFont(new Font("Arial", Font.PLAIN, 12));
			txSalario.setColumns(10);
		}
		return txSalario;
	}
	private JComboBox getCbPuesto() {
		if (cbPuesto == null) {
			cbPuesto = new JComboBox();
			cbPuesto.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return cbPuesto;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Añadir");
			btAdd.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return btAdd;
	}
}
