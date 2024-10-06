package frontend.empleados;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

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
	private JTextField txSalario;
	private JComboBox<String> cbPuesto;
	private JButton btAdd;
	private JComboBox<String> cbTipoEmpleado;
	private JLabel lbTipoEmpleado;
	private JDateChooser clNacimiento;

	/**
	 * Create the panel.
	 */
	public PanelAddEmpleados() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 112, 0, 11, 377, 138, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 35, 35, 35, 35, 35, 35, 35, 35, 102, 35};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 0;
		add(getVerticalStrut(), gbc_verticalStrut);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		add(getHorizontalStrut(), gbc_horizontalStrut);
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.anchor = GridBagConstraints.WEST;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 2;
		gbc_lbNombre.gridy = 2;
		add(getLbNombre(), gbc_lbNombre);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 6;
		gbc_horizontalStrut_1.gridy = 2;
		add(getHorizontalStrut_1(), gbc_horizontalStrut_1);
		GridBagConstraints gbc_txNombre = new GridBagConstraints();
		gbc_txNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txNombre.gridx = 5;
		gbc_txNombre.gridy = 2;
		add(getTxNombre(), gbc_txNombre);
		GridBagConstraints gbc_lbApellido = new GridBagConstraints();
		gbc_lbApellido.anchor = GridBagConstraints.WEST;
		gbc_lbApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbApellido.gridx = 2;
		gbc_lbApellido.gridy = 3;
		add(getLbApellido(), gbc_lbApellido);
		GridBagConstraints gbc_txApellido = new GridBagConstraints();
		gbc_txApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txApellido.gridx = 5;
		gbc_txApellido.gridy = 3;
		add(getTxApellido(), gbc_txApellido);
		GridBagConstraints gbc_lbDNI = new GridBagConstraints();
		gbc_lbDNI.anchor = GridBagConstraints.WEST;
		gbc_lbDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lbDNI.gridx = 2;
		gbc_lbDNI.gridy = 4;
		add(getLbDNI(), gbc_lbDNI);
		GridBagConstraints gbc_txDNI = new GridBagConstraints();
		gbc_txDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txDNI.gridx = 5;
		gbc_txDNI.gridy = 4;
		add(getTxDNI(), gbc_txDNI);
		GridBagConstraints gbc_lbTelefono = new GridBagConstraints();
		gbc_lbTelefono.anchor = GridBagConstraints.WEST;
		gbc_lbTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lbTelefono.gridx = 2;
		gbc_lbTelefono.gridy = 5;
		add(getLbTelefono(), gbc_lbTelefono);
		GridBagConstraints gbc_txTelefono = new GridBagConstraints();
		gbc_txTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTelefono.gridx = 5;
		gbc_txTelefono.gridy = 5;
		add(getTxTelefono(), gbc_txTelefono);
		GridBagConstraints gbc_lbNacimiento = new GridBagConstraints();
		gbc_lbNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lbNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lbNacimiento.gridx = 2;
		gbc_lbNacimiento.gridy = 6;
		add(getLbNacimiento(), gbc_lbNacimiento);
		GridBagConstraints gbc_txNacimiento = new GridBagConstraints();
		gbc_txNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_txNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNacimiento.gridx = 5;
		gbc_txNacimiento.gridy = 6;
		add(getClNacimiento(), gbc_txNacimiento);
		GridBagConstraints gbc_lbSalario = new GridBagConstraints();
		gbc_lbSalario.anchor = GridBagConstraints.WEST;
		gbc_lbSalario.insets = new Insets(0, 0, 5, 5);
		gbc_lbSalario.gridx = 2;
		gbc_lbSalario.gridy = 7;
		add(getLbSalario(), gbc_lbSalario);
		GridBagConstraints gbc_txSalario = new GridBagConstraints();
		gbc_txSalario.insets = new Insets(0, 0, 5, 5);
		gbc_txSalario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txSalario.gridx = 5;
		gbc_txSalario.gridy = 7;
		add(getTxSalario(), gbc_txSalario);
		GridBagConstraints gbc_lbTipoEmpleado = new GridBagConstraints();
		gbc_lbTipoEmpleado.anchor = GridBagConstraints.WEST;
		gbc_lbTipoEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_lbTipoEmpleado.gridx = 2;
		gbc_lbTipoEmpleado.gridy = 8;
		add(getLbTipoEmpleado(), gbc_lbTipoEmpleado);
		GridBagConstraints gbc_lbPuesto = new GridBagConstraints();
		gbc_lbPuesto.anchor = GridBagConstraints.WEST;
		gbc_lbPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lbPuesto.gridx = 2;
		gbc_lbPuesto.gridy = 9;
		add(getLbPuesto(), gbc_lbPuesto);
		GridBagConstraints gbc_cbTipoEmpleado = new GridBagConstraints();
		gbc_cbTipoEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipoEmpleado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipoEmpleado.gridx = 5;
		gbc_cbTipoEmpleado.gridy = 8;
		add(getCbTipoEmpleado(), gbc_cbTipoEmpleado);
		GridBagConstraints gbc_cbPuesto = new GridBagConstraints();
		gbc_cbPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_cbPuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPuesto.gridx = 5;
		gbc_cbPuesto.gridy = 9;
		add(getCbPuesto(), gbc_cbPuesto);
		GridBagConstraints gbc_btAdd = new GridBagConstraints();
		gbc_btAdd.gridx = 6;
		gbc_btAdd.gridy = 10;
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
			lbSalario = new JLabel("Salario Anual (\u20AC):");
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
			txTelefono = new JTextFieldNumerico();
			txTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JTextField getTxSalario() {
		if (txSalario == null) {
			txSalario = new JTextFieldNumerico();
			txSalario.setFont(new Font("Arial", Font.PLAIN, 12));
			txSalario.setColumns(10);
		}
		return txSalario;
	}
	private JComboBox<String> getCbPuesto() {
		if (cbPuesto == null) {
			cbPuesto = new JComboBox<String>();
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
	
	public void inicializarPanel() {
		getTxNombre().setText("");
		getTxApellido().setText("");
		getTxDNI().setText("");
		getTxTelefono().setText("");
		getTxSalario().setText("");
		getClNacimiento().setDate(null);
		//getCbTipoEmpleado().setSelectedIndex(0);
		//getCbPuesto().setSelectedIndex(0);
		// TODO se ha de provocar que cuando se inicialice el combo del tipo, se cambia el model del puesto al correcto
	}
	private JComboBox<String> getCbTipoEmpleado() {
		if (cbTipoEmpleado == null) {
			cbTipoEmpleado = new JComboBox<String>();
			cbTipoEmpleado.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return cbTipoEmpleado;
	}
	private JLabel getLbTipoEmpleado() {
		if (lbTipoEmpleado == null) {
			lbTipoEmpleado = new JLabel("Tipo de Empleado:");
			lbTipoEmpleado.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return lbTipoEmpleado;
	}
	
	private JDateChooser getClNacimiento() {
		if (clNacimiento == null) {
			clNacimiento = new JDateChooser();
			clNacimiento.setMaxSelectableDate(new Date());
			// Establece el JDateChooser como no editable por teclado y le cambia el color
			JTextField textCalendar = (JTextField) clNacimiento.getDateEditor().getUiComponent();
			textCalendar.setEnabled(false);
			textCalendar.setBackground(Color.WHITE);
			textCalendar.setDisabledTextColor(Color.BLACK);
			clNacimiento.getCalendarButton().setPreferredSize(new Dimension(100,20));
			clNacimiento.getCalendarButton().setText("Seleccionar");
		}
		return clNacimiento;
	}
	
	@SuppressWarnings("serial")
	public class JTextFieldNumerico extends JTextField {
		
		public JTextFieldNumerico() {
	        super();
	        ((AbstractDocument) this.getDocument()).setDocumentFilter(new NumericFilter());
	    }
		
		private class NumericFilter extends DocumentFilter {
	        @Override
	        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	            if (string == null) {
	                return;
	            }
	            if (esNumero(string)) {
	                super.insertString(fb, offset, string, attr);
	            }
	        }

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            if (text == null) {
	                return;
	            }
	            if (esNumero(text)) {
	                super.replace(fb, offset, length, text, attrs);
	            }
	        }

	        @Override
	        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
	            super.remove(fb, offset, length);
	        }

	        private boolean esNumero(String text) {
	            return text.matches("\\d*\\.?\\d*"); // Solo permite dígitos
	        }
	    }
	}
}
