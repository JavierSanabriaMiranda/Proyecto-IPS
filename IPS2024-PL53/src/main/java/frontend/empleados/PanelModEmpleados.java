package frontend.empleados;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.ListSelectionModel;

import backend.service.empleados.EmpleadoBase;

public class PanelModEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnDatos;
	private JPanel pnEmpleados;
	private JScrollPane scrollPaneEmp;
	private JList<EmpleadoBase> listEmpleados;

	/**
	 * Create the panel.
	 */
	public PanelModEmpleados() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		add(getPnDatos(), BorderLayout.CENTER);
		add(getPnEmpleados(), BorderLayout.EAST);

	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
		}
		return pnDatos;
	}
	private JPanel getPnEmpleados() {
		if (pnEmpleados == null) {
			pnEmpleados = new JPanel();
			pnEmpleados.setLayout(new BorderLayout(0, 0));
			pnEmpleados.add(getScrollPaneEmp());
			pnEmpleados.add(getListEmpleados(), BorderLayout.NORTH);
		}
		return pnEmpleados;
	}
	private JScrollPane getScrollPaneEmp() {
		if (scrollPaneEmp == null) {
			scrollPaneEmp = new JScrollPane();
		}
		return scrollPaneEmp;
	}
	private JList getListEmpleados() {
		if (listEmpleados == null) {
			listEmpleados = new JList();
			listEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listEmpleados.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return listEmpleados;
	}
}
