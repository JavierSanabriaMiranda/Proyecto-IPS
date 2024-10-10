package frontend.entradaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import shared.gestionentrada.GestionEntradaShared;
import shared.gestionpartido.GestionPartidoShared;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class VentanaPrincipalEntrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbPartido;
	private JLabel lbComboPartido;
	private JButton btSeleccionar;
	private JButton btCancelar;
	
	private GestionPartidoShared gps = new GestionPartidoShared();
	private JScrollPane scpPartidos;
	private JTable tablePartidos;
	
	private Date[][] datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalEntrada frame = new VentanaPrincipalEntrada();
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
	public VentanaPrincipalEntrada() {
		
		setResizable(false);
		setTitle("Venta de Entradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbPartido());
		contentPane.add(getLbComboPartido());
		contentPane.add(getBtSeleccionar());
		contentPane.add(getBtCancelar());
		contentPane.add(getScpPartidos());
		setLocationRelativeTo(null);
	}

	private JLabel getLbPartido() {
		if (lbPartido == null) {
			lbPartido = new JLabel("Seleccione el partido del que desea comprar entradas");
			lbPartido.setHorizontalAlignment(SwingConstants.CENTER);
			lbPartido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbPartido.setBounds(10, 10, 443, 37);
		}
		return lbPartido;
	}
	private JLabel getLbComboPartido() {
		if (lbComboPartido == null) {
			lbComboPartido = new JLabel("Posibles partidos:");
			lbComboPartido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbComboPartido.setBounds(10, 78, 218, 37);
		}
		return lbComboPartido;
	}
	private JButton getBtSeleccionar() {
		if (btSeleccionar == null) {
			btSeleccionar = new JButton("Seleccionar");
			btSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionEntradaShared ges = seleccionarPartido();
					
					mostrarVentanaSeleccion(ges);
				}
			});
			btSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btSeleccionar.setBounds(320, 434, 131, 37);
		}
		return btSeleccionar;
	}
	
	private void mostrarVentanaSeleccion(GestionEntradaShared ges) {
		VentanaSeleccionEntradas vSE = new VentanaSeleccionEntradas(ges);
		vSE.setVisible(true);
		this.setVisible(false);
	}
	
	private GestionEntradaShared seleccionarPartido() {
		int row = getTablePartidos().getSelectedRow();
		
		
		Date fecha = datos[row][0];
		Time inicio = new Time(datos[row][1].getTime());
		Time fin = new Time(datos[row][2].getTime());
		String partidoId = gps.getIdPartidoByFechaInicioFin(fecha, inicio, fin);
		GestionEntradaShared ges = new GestionEntradaShared();
		ges.inicializarParaUI();
		ges.setPartidoId(partidoId);
		return ges;
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btCancelar.setBounds(165, 434, 131, 37);
		}
		return btCancelar;
	}
	
	
	/*
	 * Hacer tabla cabecera columnas tipo String y el resto tipo date.
	 * Primera columna: fecha
	 * Segunda columna: hora inicio
	 * Tercera columna: hora sin
	 * 
	 * Solo se seleciona por filas y pasar el Date[] de la fila para encontrar el partido id
	 */
	private JTable getTablePartidos() {
		if (tablePartidos == null) {
			tablePartidos = new JTable(this.cargaDatos(), this.creaColumnas());
			tablePartidos.setSelectionMode(0);
			cargaDatos();
		}
		return tablePartidos;
	}
	
	private String[] creaColumnas() {
	    String[] titColumna = {"Fecha", "Hora inicio", "Hora fin"};
	    return titColumna;
	}
	
	private Date[][] cargaDatos() {
		this.datos = gps.getTodosPartidos();
		return datos;
	}
	
	private JScrollPane getScpPartidos() {
		if (scpPartidos == null) {
			scpPartidos = new JScrollPane();
			scpPartidos.setBounds(10, 126, 441, 279);
			scpPartidos.setViewportView(getTablePartidos());
		}
		return scpPartidos;
	}
	
}
