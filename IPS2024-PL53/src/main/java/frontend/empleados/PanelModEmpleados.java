package frontend.empleados;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import backend.service.empleados.Empleado;
import backend.service.empleados.deportivos.Jugador;
import shared.gestionempleados.GestionEmpleadosShared;
import shared.gestionempleados.PuestoEmpleado;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;

public class PanelModEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionEmpleadosShared gesEmp;
	private JPanel pnDatos;
	private JPanel pnEmpleados;
	private JScrollPane scrollPaneEmp;
	private JList<Empleado> listEmpleados;
	private DefaultListModel<Empleado> modeloList;
	private JLabel lbNombre;
	private JLabel lbApellido;
	private JLabel lbDNI;
	private JLabel lbTelefono;
	private JLabel lbFechaNac;
	private JLabel lbSalario;
	private JTextField txNombre;
	private JTextField txApellido;
	private JTextField txDNI;
	private JTextField txTelefono;
	private JTextField txSalario;
	private JDateChooser clFechaNac;
	private JButton btMod;
	private JLabel lbEmpleados;

	//TODO poner límite a los JTextFields acordes a los de la BBDD
	
	/**
	 * Create the panel.
	 */
	public PanelModEmpleados(GestionEmpleadosShared gesEmp) {
		this.gesEmp = gesEmp;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		add(getPnDatos(), BorderLayout.CENTER);
		add(getPnEmpleados(), BorderLayout.EAST);

	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(new Color(255, 255, 255));
			GridBagLayout gbl_pnDatos = new GridBagLayout();
			gbl_pnDatos.columnWidths = new int[] { 61, 0, 52, 15, 330, 0 };
			gbl_pnDatos.rowHeights = new int[] { 0, 35, 35, 35, 35, 35, 35, 35, 0, 0 };
			gbl_pnDatos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_pnDatos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnDatos.setLayout(gbl_pnDatos);
			GridBagConstraints gbc_lbNombre = new GridBagConstraints();
			gbc_lbNombre.anchor = GridBagConstraints.WEST;
			gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lbNombre.gridx = 2;
			gbc_lbNombre.gridy = 2;
			pnDatos.add(getLbNombre(), gbc_lbNombre);
			GridBagConstraints gbc_txNombre = new GridBagConstraints();
			gbc_txNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txNombre.gridx = 4;
			gbc_txNombre.gridy = 2;
			pnDatos.add(getTxNombre(), gbc_txNombre);
			GridBagConstraints gbc_lbApellido = new GridBagConstraints();
			gbc_lbApellido.anchor = GridBagConstraints.WEST;
			gbc_lbApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lbApellido.gridx = 2;
			gbc_lbApellido.gridy = 3;
			pnDatos.add(getLbApellido(), gbc_lbApellido);
			GridBagConstraints gbc_txApellido = new GridBagConstraints();
			gbc_txApellido.insets = new Insets(0, 0, 5, 0);
			gbc_txApellido.fill = GridBagConstraints.HORIZONTAL;
			gbc_txApellido.gridx = 4;
			gbc_txApellido.gridy = 3;
			pnDatos.add(getTxApellido(), gbc_txApellido);
			GridBagConstraints gbc_lbDNI = new GridBagConstraints();
			gbc_lbDNI.anchor = GridBagConstraints.WEST;
			gbc_lbDNI.insets = new Insets(0, 0, 5, 5);
			gbc_lbDNI.gridx = 2;
			gbc_lbDNI.gridy = 4;
			pnDatos.add(getLbDNI(), gbc_lbDNI);
			GridBagConstraints gbc_txDNI = new GridBagConstraints();
			gbc_txDNI.insets = new Insets(0, 0, 5, 0);
			gbc_txDNI.fill = GridBagConstraints.HORIZONTAL;
			gbc_txDNI.gridx = 4;
			gbc_txDNI.gridy = 4;
			pnDatos.add(getTxDNI(), gbc_txDNI);
			GridBagConstraints gbc_lbTelefono = new GridBagConstraints();
			gbc_lbTelefono.anchor = GridBagConstraints.WEST;
			gbc_lbTelefono.insets = new Insets(0, 0, 5, 5);
			gbc_lbTelefono.gridx = 2;
			gbc_lbTelefono.gridy = 5;
			pnDatos.add(getLbTelefono(), gbc_lbTelefono);
			GridBagConstraints gbc_txTelefono = new GridBagConstraints();
			gbc_txTelefono.insets = new Insets(0, 0, 5, 0);
			gbc_txTelefono.fill = GridBagConstraints.HORIZONTAL;
			gbc_txTelefono.gridx = 4;
			gbc_txTelefono.gridy = 5;
			pnDatos.add(getTxTelefono(), gbc_txTelefono);
			GridBagConstraints gbc_lbFechaNac = new GridBagConstraints();
			gbc_lbFechaNac.anchor = GridBagConstraints.WEST;
			gbc_lbFechaNac.insets = new Insets(0, 0, 5, 5);
			gbc_lbFechaNac.gridx = 2;
			gbc_lbFechaNac.gridy = 6;
			pnDatos.add(getLbFechaNac(), gbc_lbFechaNac);
			GridBagConstraints gbc_txFechaNac = new GridBagConstraints();
			gbc_txFechaNac.insets = new Insets(0, 0, 5, 0);
			gbc_txFechaNac.fill = GridBagConstraints.HORIZONTAL;
			gbc_txFechaNac.gridx = 4;
			gbc_txFechaNac.gridy = 6;
			pnDatos.add(getClFechaNac(), gbc_txFechaNac);
			GridBagConstraints gbc_lbSalario = new GridBagConstraints();
			gbc_lbSalario.anchor = GridBagConstraints.WEST;
			gbc_lbSalario.insets = new Insets(0, 0, 5, 5);
			gbc_lbSalario.gridx = 2;
			gbc_lbSalario.gridy = 7;
			pnDatos.add(getLbSalario(), gbc_lbSalario);
			GridBagConstraints gbc_txSalario = new GridBagConstraints();
			gbc_txSalario.insets = new Insets(0, 0, 5, 0);
			gbc_txSalario.anchor = GridBagConstraints.NORTH;
			gbc_txSalario.fill = GridBagConstraints.HORIZONTAL;
			gbc_txSalario.gridx = 4;
			gbc_txSalario.gridy = 7;
			pnDatos.add(getTxSalario(), gbc_txSalario);
			GridBagConstraints gbc_btMod = new GridBagConstraints();
			gbc_btMod.anchor = GridBagConstraints.EAST;
			gbc_btMod.gridx = 4;
			gbc_btMod.gridy = 8;
			pnDatos.add(getBtMod(), gbc_btMod);
		}
		return pnDatos;
	}

	private JPanel getPnEmpleados() {
		if (pnEmpleados == null) {
			pnEmpleados = new JPanel();
			pnEmpleados.setBackground(new Color(255, 255, 255));
			pnEmpleados.setLayout(new BorderLayout(0, 0));
			pnEmpleados.setBorder(new LineBorder(Color.BLACK, 2));
			pnEmpleados.add(getScrollPaneEmp(), BorderLayout.CENTER);
			getScrollPaneEmp().setViewportView(getListEmpleados());
			pnEmpleados.setPreferredSize(new Dimension(400, Integer.MAX_VALUE));
			pnEmpleados.add(getLbEmpleados(), BorderLayout.NORTH);
		}
		return pnEmpleados;
	}

	private JScrollPane getScrollPaneEmp() {
		if (scrollPaneEmp == null) {
			scrollPaneEmp = new JScrollPane();
			scrollPaneEmp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return scrollPaneEmp;
	}

	private JList<Empleado> getListEmpleados() {
		if (listEmpleados == null) {
			listEmpleados = new JList<Empleado>();
			listEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listEmpleados.setFont(new Font("Arial", Font.PLAIN, 14));
			listEmpleados.setPreferredSize(new Dimension(800, Integer.MAX_VALUE));

			modeloList = new DefaultListModel<>();
			listEmpleados.setModel(modeloList);
		}
		return listEmpleados;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbNombre;
	}

	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellido:");
			lbApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbApellido;
	}

	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("DNI:");
			lbDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbDNI;
	}

	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Teléfono:");
			lbTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbTelefono;
	}

	private JLabel getLbFechaNac() {
		if (lbFechaNac == null) {
			lbFechaNac = new JLabel("Fecha de Nacimiento:");
			lbFechaNac.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbFechaNac;
	}

	private JLabel getLbSalario() {
		if (lbSalario == null) {
			lbSalario = new JLabel("Salario Anual:");
			lbSalario.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return lbSalario;
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Arial", Font.PLAIN, 12));
			txNombre.setColumns(10);
		}
		return txNombre;
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

	private JDateChooser getClFechaNac() {
		if (clFechaNac == null) {
			clFechaNac = new JDateChooser();
			clFechaNac.setMaxSelectableDate(new Date());
			// Establece el JDateChooser como no editable por teclado y le cambia el color
			JTextField textCalendar = (JTextField) clFechaNac.getDateEditor().getUiComponent();
			textCalendar.setEnabled(false);
			textCalendar.setBackground(Color.WHITE);
			textCalendar.setDisabledTextColor(Color.BLACK);
			clFechaNac.getCalendarButton().setPreferredSize(new Dimension(100, 20));
			clFechaNac.getCalendarButton().setText("Seleccionar");
		}
		return clFechaNac;
	}

	private JButton getBtMod() {
		if (btMod == null) {
			btMod = new JButton("Modificar");
			btMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modEmpleado();
				}
			});
			btMod.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return btMod;
	}

	private void modEmpleado() {
		if (camposCorrectos()) {
			if (!listEmpleados.isSelectionEmpty()) {
				String id = getListEmpleados().getSelectedValue().getIDEmpleado();
				String nombre = getTxNombre().getText();
				String apellido = getTxApellido().getText();
				String dni = getTxDNI().getText();
				String telefono = getTxTelefono().getText();
				Date nacimiento = getClFechaNac().getDate();
				double salario = Double.parseDouble(getTxSalario().getText());
				
				// Redondeamos el salario a 2 decimales
				salario = Math.round(salario * 100.0) / 100.0;
				
				gesEmp.modEmpleado(id, nombre, apellido, dni, telefono, nacimiento, salario);
				JOptionPane.showMessageDialog(this, "Se ha modificado al empleado correctamente", "Confirmación de Modificación de Empleado", 
						JOptionPane.INFORMATION_MESSAGE);
				inicializarPanel();
			}
			else {
				JOptionPane.showMessageDialog(this, "Se debe seleccionar un empleado a modificar","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private JLabel getLbEmpleados() {
		if (lbEmpleados == null) {
			lbEmpleados = new JLabel("Empleados");
			lbEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmpleados.setFont(new Font("Arial", Font.PLAIN, 20));
		}
		return lbEmpleados;
	}

	public void inicializarPanel() {
		getTxNombre().setText("");
		getTxApellido().setText("");
		getTxDNI().setText("");
		getTxTelefono().setText("");
		getTxSalario().setText("");
		getClFechaNac().setDate(null);
		getListEmpleados().clearSelection();
		modeloList.clear();
		modeloList.addAll(gesEmp.getEmpleadosFromGestor());
	}

	private boolean camposCorrectos() {
		// Se comprueba que los campos no están vacíos
		if (getTxNombre().getText().isBlank() || getTxApellido().getText().isBlank() || getTxDNI().getText().isBlank()
				|| getTxSalario().getText().isBlank() || getTxTelefono().getText().isBlank()
				|| getClFechaNac().getDate() == null) {
			JOptionPane.showMessageDialog(this, "Se deben rellenar todos los campos","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Si no es jugador de futbol y se intenta cambiar su fecha a menor de edad
		if (!getListEmpleados().getSelectedValue().getPuesto().equals(PuestoEmpleado.JUGADOR) && !esMayorEdad(getClFechaNac().getDate())) {
			JOptionPane.showMessageDialog(this, "Solo los jugadores pueden ser menores de edad","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
			
		return true;
	}
	
	private boolean esMayorEdad(Date fecha) {
        // Convierte la fecha de tipo Date a LocalDate
        LocalDate fechaLocal = new java.sql.Date(fecha.getTime()).toLocalDate();
        
        // Obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Calcula la diferencia de años
        Period periodo = Period.between(fechaLocal, fechaActual);

        return periodo.getYears() >= 18;
	}


}
