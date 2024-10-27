package frontend.empleados;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import backend.service.empleados.Empleado;
import shared.gestionempleados.GestionEmpleadosShared;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelRemEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionEmpleadosShared gesEmp;
	private JPanel pnDatos;
	private JPanel pnEmpleados;
	private JScrollPane scEmpleados;
	private JList<Empleado> listEmpleados;
	private DefaultListModel<Empleado> modeloList;
	private JTextPane txDatos;
	private JPanel pnBtEliminar;
	private JButton btEliminar;
	private JLabel lbEmpleados;
	private Component verticalStrut;

	/**
	 * Create the panel.
	 */
	public PanelRemEmpleados(GestionEmpleadosShared gesEmp) {
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
			pnDatos.setLayout(new BorderLayout(0, 0));
			pnDatos.add(getTxDatos());
			pnDatos.add(getPnBtEliminar(), BorderLayout.SOUTH);
			pnDatos.add(getVerticalStrut(), BorderLayout.NORTH);
		}
		return pnDatos;
	}
	private JPanel getPnEmpleados() {
		if (pnEmpleados == null) {
			pnEmpleados = new JPanel();
			pnEmpleados.setBorder(new LineBorder(Color.BLACK, 2));
			pnEmpleados.setBackground(new Color(255, 255, 255));
			pnEmpleados.setLayout(new BorderLayout(0, 0));
			pnEmpleados.add(getScEmpleados());
			getScEmpleados().setViewportView(getListEmpleados());
			pnEmpleados.setPreferredSize(new Dimension(400, Integer.MAX_VALUE));
			pnEmpleados.add(getLbEmpleados(), BorderLayout.NORTH);
		}
		return pnEmpleados;
	}
	private JScrollPane getScEmpleados() {
		if (scEmpleados == null) {
			scEmpleados = new JScrollPane();
		}
		return scEmpleados;
	}
	public JList<Empleado> getListEmpleados() {
		if (listEmpleados == null) {
			listEmpleados = new JList<Empleado>();
			listEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listEmpleados.setFont(new Font("Arial", Font.PLAIN, 12));
			
			modeloList = new DefaultListModel<>();
			listEmpleados.setModel(modeloList);
		}
		return listEmpleados;
	}
	
	public DefaultListModel<Empleado> getModeloList() {
		return modeloList;
	}
	

	public JTextPane getTxDatos() {
		if (txDatos == null) {
			txDatos = new JTextPane();
			txDatos.setFont(new Font("Arial", Font.PLAIN, 22));
			txDatos.setEditable(false);
	        // Obtener el documento y aplicar estilo para centrar el texto
	        StyledDocument doc = txDatos.getStyledDocument();
	        SimpleAttributeSet center = new SimpleAttributeSet();
	        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	        doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		return txDatos;
	}
	private JPanel getPnBtEliminar() {
		if (pnBtEliminar == null) {
			pnBtEliminar = new JPanel();
			pnBtEliminar.setPreferredSize(new Dimension(10, 110));
			pnBtEliminar.setBackground(new Color(255, 255, 255));
			pnBtEliminar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnBtEliminar.add(getBtEliminar());
		}
		return pnBtEliminar;
	}
	public JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
			btEliminar.setEnabled(false);
			
		}
		return btEliminar;
	}



	private JLabel getLbEmpleados() {
		if (lbEmpleados == null) {
			lbEmpleados = new JLabel("Empleados");
			lbEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmpleados.setFont(new Font("Arial", Font.PLAIN, 20));
			lbEmpleados.setBackground(new Color(255, 255, 255));
		}
		return lbEmpleados;
	}


	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(20);
		}
		return verticalStrut;
	}
}
