package frontend.entradaUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipalEntrada extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbPartido;
	private JLabel lbComboPartido;
	private JButton btSeleccionar;
	private JButton btCancelar;
	private JScrollPane scpPartidos;
	private JTable tablePartidos;

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
	public JButton getBtSeleccionar() {
		if (btSeleccionar == null) {
			btSeleccionar = new JButton("Seleccionar");
			btSeleccionar.setEnabled(false);
			btSeleccionar.setForeground(new Color(255, 255, 255));
			btSeleccionar.setBackground(new Color(60, 179, 113));
			btSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btSeleccionar.setBounds(320, 434, 131, 37);
		}
		return btSeleccionar;
	}
	
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setForeground(new Color(255, 255, 255));
			btCancelar.setBackground(Color.RED);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btCancelar.setBounds(165, 434, 131, 37);
		}
		return btCancelar;
	}
	
	/*
	 * Hacer tabla cabecera columnas tipo String y el resto tipo date.
	 * Primera columna: fecha
	 * Segunda columna: hora inicio
	 * Tercera columna: hora sin
	 */
	public JTable getTablePartidos() {
		if (tablePartidos == null) {
			tablePartidos = new JTable();
			tablePartidos.setSelectionMode(0);

		}
		return tablePartidos;
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
