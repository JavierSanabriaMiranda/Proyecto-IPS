package frontend.empleados;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class FrameGestionEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MostrarMenu mostrarMenu = new MostrarMenu();
	private PanelAddEmpleados panelAddEmpleados = new PanelAddEmpleados();
	private JPanel contentPane;
	private JPanel pnOpciones;
	private JPanel pnBotonesSeleccion;
	private JPanel pnDatos;
	private JButton btnAddEmp;
	private JButton btnModEmp;
	private JButton btnRemEmp;
	private JPanel pnAtras;
	private JButton btAtras;
	private JPanel pnAdd;
	private JPanel pnMod;
	private JPanel pnRem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGestionEmpleados frame = new FrameGestionEmpleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameGestionEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 718);
		setMinimumSize(new Dimension(800, 500));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(getPnOpciones());
	}

	private JPanel getPnOpciones() {
		if (pnOpciones == null) {
			pnOpciones = new JPanel();
			pnOpciones.setBackground(new Color(255, 255, 255));
			pnOpciones.setLayout(new BorderLayout(0, 0));
			pnOpciones.add(getPnBotonesSeleccion(), BorderLayout.NORTH);
			pnOpciones.add(getPnDatos());
			pnOpciones.add(getPnAtras(), BorderLayout.SOUTH);
		}
		return pnOpciones;
	}

	private JPanel getPnBotonesSeleccion() {
		if (pnBotonesSeleccion == null) {
			pnBotonesSeleccion = new JPanel();
			pnBotonesSeleccion.setBackground(new Color(255, 255, 255));
			pnBotonesSeleccion.setLayout(new GridLayout(0, 3, 0, 0));
			pnBotonesSeleccion.add(getBtnAddEmp());
			pnBotonesSeleccion.add(getBtnModEmp());
			pnBotonesSeleccion.add(getBtnRemEmp());
		}
		return pnBotonesSeleccion;
	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(new Color(255, 255, 255));
			pnDatos.setLayout(new CardLayout(0, 0));
			pnDatos.add(getPnAdd(), "addEmpleado");
			pnDatos.add(getPnMod(), "modEmpleado");
			pnDatos.add(getPnRem(), "remEmpleado");
		}
		return pnDatos;
	}

	private void seleccionarMenu(String menu) {
		switch (menu) {
		case "addEmpleado":
			mostrarMenuAdd();
			break;
		case "modEmpleado":
			mostrarMenuMod();
			break;
		case "remEmpleado":
			mostrarMenuRem();
			break;
		default:
			throw new IllegalArgumentException("El código " + menu + " no es un panel válido");
		}
	}

	
	private void mostrarMenuAdd() {
		panelAddEmpleados.inicializarPanel();
		((CardLayout) getPnDatos().getLayout()).show(getPnDatos(), "addEmpleado");
	}

	private void mostrarMenuMod() {
		((CardLayout) getPnDatos().getLayout()).show(getPnDatos(), "modEmpleado");
	}

	private void mostrarMenuRem() {
		((CardLayout) getPnDatos().getLayout()).show(getPnDatos(), "remEmpleado");		
	}
	
	class MostrarMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton fuente = (JButton) e.getSource();
			seleccionarMenu(fuente.getActionCommand());
		}
		
	}

	private JButton getBtnAddEmp() {
		if (btnAddEmp == null) {
			btnAddEmp = new JButton("Añadir");
			btnAddEmp.setActionCommand("addEmpleado");
			btnAddEmp.setFont(new Font("Arial", Font.PLAIN, 12));
			btnAddEmp.addActionListener(mostrarMenu);
		}
		return btnAddEmp;
	}

	private JButton getBtnModEmp() {
		if (btnModEmp == null) {
			btnModEmp = new JButton("Modificar");
			btnModEmp.setActionCommand("modEmpleado");
			btnModEmp.setFont(new Font("Arial", Font.PLAIN, 12));
			btnModEmp.setPreferredSize(new Dimension(100, 40));
			btnModEmp.addActionListener(mostrarMenu);
		}
		return btnModEmp;
	}

	private JButton getBtnRemEmp() {
		if (btnRemEmp == null) {
			btnRemEmp = new JButton("Eliminar");
			btnRemEmp.setActionCommand("remEmpleado");
			btnRemEmp.setFont(new Font("Arial", Font.PLAIN, 12));
			btnRemEmp.addActionListener(mostrarMenu);
		}
		return btnRemEmp;
	}

	private JPanel getPnAtras() {
		if (pnAtras == null) {
			pnAtras = new JPanel();
			pnAtras.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) pnAtras.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnAtras.add(getBtAtras());
		}
		return pnAtras;
	}

	private JButton getBtAtras() {
		if (btAtras == null) {
			btAtras = new JButton("Atras");
			btAtras.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return btAtras;
	}

	private JPanel getPnAdd() {
		if (pnAdd == null) {
			pnAdd = new JPanel();
			pnAdd.setBackground(new Color(255, 255, 255));
			pnAdd.setLayout(new GridLayout(1, 0, 0, 0));
			pnAdd.add(panelAddEmpleados);
		}
		return pnAdd;
	}

	private JPanel getPnMod() {
		if (pnMod == null) {
			pnMod = new JPanel();
			pnMod.setBackground(new Color(255, 255, 255));
		}
		return pnMod;
	}

	private JPanel getPnRem() {
		if (pnRem == null) {
			pnRem = new JPanel();
			pnRem.setBackground(new Color(255, 255, 255));
		}
		return pnRem;
	}
}
