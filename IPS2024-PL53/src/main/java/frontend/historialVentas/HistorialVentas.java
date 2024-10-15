package frontend.historialVentas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import shared.gestionHistorial.GestionHistorialShared;

public class HistorialVentas {

	private JFrame frmHistorialDeVentas;
	private JPanel pnFechas;
	private JPanel pnEtiquetas;
	private JLabel lbFechaInicio;
	private JLabel lbFechaFin;
	private JPanel pnSpinners;
	private JSpinner spInicio;
	private JSpinner spFin;
	private JPanel pnResumen;
	private JTextField tfBalance;
	private JButton btSeleccionar;
	private JPanel pnVentas;
	private JScrollPane srcTabla;
	private JTable tablaResumenVentas;
	private DefaultTableModel tableModelResumen;
	private JPanel pn1;
	private JButton btSalir;
	private JPanel pn2;
	private JPanel pnTitulo;
	private JLabel lbCompraMerchandising;
	private JPanel pnInfo2;
	private JButton btAnterior;
	private JScrollPane scrollPaneResumen;
	private JTable tableResumenCompraMerchan;
	private DefaultTableModel tableModelResumenCompraMerchan;
	private JPanel pn3;
	private JLabel lbDetalles;
	private JPanel pnDetalles;
	private JPanel pnInfo3;
	private JButton btConfirmarFecha;
	private JButton btAnterior2;
	private JButton btSalir3;
	private JTextField tfBalance2;
	private JButton btSalir2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					HistorialVentas window = new HistorialVentas();
					GestionHistorialShared ghs = new GestionHistorialShared(window);
					ghs.initController();
					window.frmHistorialDeVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistorialVentas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistorialDeVentas = new JFrame();
		frmHistorialDeVentas.setTitle("Historial de Ventas");
		frmHistorialDeVentas.getContentPane().setBackground(Color.WHITE);
		frmHistorialDeVentas.getContentPane().setLayout(new CardLayout(0, 0));
		frmHistorialDeVentas.getContentPane().add(getPn1(), "pn1");
		frmHistorialDeVentas.getContentPane().add(getPn2(), "pn2");
		frmHistorialDeVentas.getContentPane().add(getPn3(), "pn3");
		frmHistorialDeVentas.setBounds(100, 100, 780, 530);
		frmHistorialDeVentas.setLocationRelativeTo(null);
		frmHistorialDeVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrmHistorialDeVentas() {
		return frmHistorialDeVentas;
	}

	public JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
	        pn1.setLayout(new BorderLayout(0, 0));
	        pn1.add(getPnFechas(), BorderLayout.NORTH);
	        pn1.add(getPnInfo1(), BorderLayout.SOUTH);
	        pn1.add(getPnVentas(), BorderLayout.CENTER);
		}
		return pn1;
	}

	private JPanel getPnFechas() {
		if (pnFechas == null) {
			pnFechas = new JPanel();
			pnFechas.setMinimumSize(new Dimension(10, 30));
			pnFechas.setBackground(Color.WHITE);
			pnFechas.setLayout(new GridLayout(0, 1, 0, 0));
			pnFechas.add(getPnEtiquetas());
			pnFechas.add(getPnSpinners());
			pnFechas.add(getBtConfirmarFecha());
		}
		return pnFechas;
	}
	
	private JPanel getPnEtiquetas() {
		if (pnEtiquetas == null) {
			pnEtiquetas = new JPanel();
			pnEtiquetas.setBackground(Color.WHITE);
			pnEtiquetas.setLayout(new GridLayout(1, 2, 0, 0));
			pnEtiquetas.add(getLbFechaInicio());
			pnEtiquetas.add(getLbFechaFin());
		}
		return pnEtiquetas;
	}
	
	private JLabel getLbFechaInicio() {
		if (lbFechaInicio == null) {
			lbFechaInicio = new JLabel("Fecha de inicio:");
			lbFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbFechaInicio.setBackground(Color.WHITE);
		}
		return lbFechaInicio;
	}
	
	private JLabel getLbFechaFin() {
		if (lbFechaFin == null) {
			lbFechaFin = new JLabel("Fecha de fin:");
			lbFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lbFechaFin;
	}
	
	private JPanel getPnSpinners() {
		if (pnSpinners == null) {
			pnSpinners = new JPanel();
			pnSpinners.setMinimumSize(new Dimension(10, 20));
			pnSpinners.setBackground(Color.WHITE);
			pnSpinners.setLayout(new GridLayout(1, 2, 0, 0));
			pnSpinners.add(getSpInicio());
			pnSpinners.add(getSpFin());
		}
		return pnSpinners;
	}
	
	public JSpinner getSpInicio() {
	    if (spInicio == null) {
	        spInicio = new JSpinner();
	        spInicio.setBackground(new Color(224, 255, 255));
	        Calendar calendar = Calendar.getInstance();
	        Date today = calendar.getTime();
	        spInicio.setModel(new SpinnerDateModel(today, null, today, Calendar.DAY_OF_YEAR));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spInicio, "dd/MM/yyyy");
	        spInicio.setEditor(dateEditor);
	    }
	    return spInicio;
	}

	public JSpinner getSpFin() {
	    if (spFin == null) {
	        spFin = new JSpinner();
	        spFin.setBackground(new Color(224, 255, 255));
	        Calendar calendar = Calendar.getInstance();
	        Date today = calendar.getTime();
	        spFin.setModel(new SpinnerDateModel(today, null, today, Calendar.DAY_OF_YEAR));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spFin, "dd/MM/yyyy");
	        spFin.setEditor(dateEditor);
	    }
	    return spFin;
	}
	
	public JButton getBtConfirmarFecha() {
		if (btConfirmarFecha == null) {
			btConfirmarFecha = new JButton("Confirmar fechas");
			btConfirmarFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
			btConfirmarFecha.setBackground(new Color(152, 251, 152));
		}
		return btConfirmarFecha;
	}

	public JPanel getPnInfo1() {
		if (pnResumen == null) {
			pnResumen = new JPanel();
			pnResumen.setBackground(new Color(224, 255, 255));
			pnResumen.setLayout(new GridLayout(1, 2, 20, 0));
			pnResumen.add(getTfBalance());
			pnResumen.add(getBtSalir());
			pnResumen.add(getBtSeleccionar());
		}
		return pnResumen;
	}
	
	public JTextField getTfBalance() {
		if (tfBalance == null) {
			tfBalance = new JTextField();
			tfBalance.setBackground(Color.WHITE);
			tfBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
			tfBalance.setEditable(false);
			tfBalance.setColumns(10);
		}
		return tfBalance;
	}
	
	public JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setForeground(Color.WHITE);
			btSalir.setBackground(Color.RED);
		}
		return btSalir;
	}
	
	public JButton getBtSeleccionar() {
	    if (btSeleccionar == null) {
	        btSeleccionar = new JButton("Seleccionar");
	        btSeleccionar.setBackground(new Color(50, 205, 50));
	        btSeleccionar.setForeground(Color.WHITE);
	        btSeleccionar.setMnemonic('S');
	        btSeleccionar.setEnabled(false); // Inicialmente deshabilitado
	    }
	    return btSeleccionar;
	}

	private JPanel getPnVentas() {
		if (pnVentas == null) {
			pnVentas = new JPanel();
			pnVentas.setBackground(Color.WHITE);
			pnVentas.setLayout(new BorderLayout(0, 0));
			pnVentas.add(getSrcTabla(), BorderLayout.CENTER);
		}
		return pnVentas;
	}
	
	private JScrollPane getSrcTabla() {
		if (srcTabla == null) {
			srcTabla = new JScrollPane();
			srcTabla.setBackground(Color.WHITE);
			srcTabla.setViewportView(getTablaResumenVentas());
		}
		return srcTabla;
	}
	
	public JTable getTablaResumenVentas() {
	    if (tablaResumenVentas == null) {
	        String[] columnNames = {"Concepto", "Fecha", "Cuantía ingreso"};
	        tableModelResumen = new DefaultTableModel(columnNames, 0); 
	        tablaResumenVentas = new JTable(tableModelResumen);
	        tablaResumenVentas.setBackground(Color.WHITE);
	        tablaResumenVentas.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        tablaResumenVentas.setRowHeight(25);
	        tablaResumenVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite seleccionar solo una fila a la vez
	        tablaResumenVentas.setRowSelectionAllowed(true); // Permitir la selección de filas
	        tablaResumenVentas.setColumnSelectionAllowed(false); // Deshabilitar la selección de columnas
	        tablaResumenVentas.getTableHeader().setReorderingAllowed(false);
	        tablaResumenVentas.setDefaultEditor(Object.class, null); // Deshabilitar edición
	    }
	    return tablaResumenVentas;
	}



	public JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnTitulo(), BorderLayout.NORTH);
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
			pn2.add(getPnCompraMerchan(), BorderLayout.CENTER);
		}
		return pn2;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getLbCompraMerchandising(), BorderLayout.CENTER);
		}
		return pnTitulo;
	}
	
	private JLabel getLbCompraMerchandising() {
		if (lbCompraMerchandising == null) {
			lbCompraMerchandising = new JLabel("Resumen de la compra:");
			lbCompraMerchandising.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbCompraMerchandising.setBackground(Color.WHITE);
		}
		return lbCompraMerchandising;
	}
	
	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(new Color(255, 255, 255));
			pnInfo2.setLayout(new GridLayout(1, 2, 20, 0));
			pnInfo2.add(getTfBalance2());
			pnInfo2.add(getBtSalir2());
			pnInfo2.add(getBtAnterior());
		}
		return pnInfo2;
	}
	
	public JButton getBtSalir2() {
		if (btSalir2 == null) {
			btSalir2 = new JButton("Salir");
			btSalir2.setForeground(Color.WHITE);
			btSalir2.setBackground(Color.RED);
		}
		return btSalir2;
	}
	
	public JTextField getTfBalance2() {
		if (tfBalance2 == null) {
			tfBalance2 = new JTextField();
			tfBalance2.setBackground(Color.WHITE);
			tfBalance2.setFont(new Font("Tahoma", Font.BOLD, 12));
			tfBalance2.setEditable(false);
			tfBalance2.setColumns(10);
		}
		return tfBalance2;
	}
	
	public JButton getBtAnterior() {
		if (btAnterior == null) {
			btAnterior = new JButton("Anterior");
			btAnterior.setBackground(new Color(50, 205, 50));
			btAnterior.setForeground(Color.WHITE);
			btAnterior.setMnemonic('A');
		}
		return btAnterior;
	}
	
	private JScrollPane getPnCompraMerchan() {
		if (scrollPaneResumen == null) {
			scrollPaneResumen = new JScrollPane();
			scrollPaneResumen.setViewportView(getTableResumenCompraMerchan());
		}
		return scrollPaneResumen;
	}
	
	public JTable getTableResumenCompraMerchan() {
	    if (tableResumenCompraMerchan == null) {
	        String[] columnNames = {"Producto", "Cantidad", "Precio Unitario", "Total"};
	        tableModelResumenCompraMerchan = new DefaultTableModel(columnNames, 0);
	        tableResumenCompraMerchan = new JTable(tableModelResumenCompraMerchan);
	        tableResumenCompraMerchan.setFillsViewportHeight(true);
	        tableResumenCompraMerchan.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        tableResumenCompraMerchan.setRowHeight(25);
	        tableResumenCompraMerchan.setFocusable(false);
	        tableResumenCompraMerchan.setRowSelectionAllowed(false);
	        tableResumenCompraMerchan.setColumnSelectionAllowed(false);
	        tableResumenCompraMerchan.setCellSelectionEnabled(false);
	        tableResumenCompraMerchan.getTableHeader().setReorderingAllowed(false); // Deshabilitar reordenamiento de columnas
	        tableResumenCompraMerchan.getTableHeader().setResizingAllowed(false);   // Deshabilitar redimensionamiento de columnas
	        tableResumenCompraMerchan.setEnabled(false); // Desactivar completamente la tabla
	    }
	    return tableResumenCompraMerchan;
	}


	public JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(new Color(255, 255, 255));
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getPnDetalles(), BorderLayout.CENTER);
			pn3.add(getPnInfo3(), BorderLayout.SOUTH);
		}
		return pn3;
	}
	
	private JPanel getPnDetalles() {
		if (pnDetalles == null) {
			pnDetalles = new JPanel();
			pnDetalles.setBackground(Color.WHITE);
			pnDetalles.setLayout(new BorderLayout(0, 0));
			pnDetalles.add(getLbDetalles(), BorderLayout.CENTER);
		}
		return pnDetalles;
	}
	
	private JLabel getLbDetalles() {
		if (lbDetalles == null) {
			lbDetalles = new JLabel("No hay más detalles para esta venta");
			lbDetalles.setBackground(Color.WHITE);
			lbDetalles.setHorizontalAlignment(SwingConstants.CENTER);
			lbDetalles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lbDetalles;
	}
	
	public JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new GridLayout(1, 2, 20, 0));
			pnInfo3.add(getBtSalir3());
			pnInfo3.add(getBtAnterior2());
		}
		return pnInfo3;
	}
	
	public JButton getBtSalir3() {
		if (btSalir3 == null) {
			btSalir3 = new JButton("Salir");
			btSalir3.setForeground(Color.WHITE);
			btSalir3.setBackground(Color.RED);
		}
		return btSalir3;
	}
	
	public JButton getBtAnterior2() {
		if (btAnterior2 == null) {
			btAnterior2 = new JButton("Anterior");
			btAnterior2.setBackground(new Color(50, 205, 50));
			btAnterior2.setForeground(Color.WHITE);
			btAnterior2.setMnemonic('A');
		}
		return btAnterior2;
	}
	
	public DefaultTableModel getModelVentas() {
		return tableModelResumen;
	}
	
	public DefaultTableModel getModelMerchandising() {
		return tableModelResumenCompraMerchan;
	}
}
