package frontend.abonos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import frontend.merchandisingUI.VentanaPrincipal;

public class VentanaAbonos extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JPanel pn1;
	private JLabel lbTitulo;
	private JLabel fotoEstadio;
	private JPanel pnRegistro;
	private JPanel pnAsiento;
	private JPanel pnTribuna;
	private JLabel lbTribuna;
	private JComboBox<String> cbTribuna;
	private JPanel pnSeccion;
	private JLabel lbSeccion;
	private JComboBox<String> cbSeccion;
	private JPanel pnFila;
	private JLabel lbFila;
	private JComboBox<String> cbFila;
	private JPanel pnNAsiento;
	private JLabel lbAsiento;
	private JComboBox<String> cbAsiento;
	private JPanel pnInfo;
	private JPanel pnBotones;
	private JButton btSalir;
	private JButton btSiguiente;
	private JTextField tfPrecio;
	private JPanel pn2;
	private JPanel pnResumen;
	private JPanel pnInfoAbono;
	private JLabel lbResumen;
	private JTextArea taResumen;
	private JPanel pnDatos;
	private JPanel pnDNI;
	private JLabel lbDNI;
	private JTextField tfDNI;
	private JPanel pnEdad;
	private JRadioButton rdMenor;
	private JRadioButton rdAdulto;
	private JRadioButton rdJuvilado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnInfo2;
	private JPanel pnBotones2;
	private JButton btAnterior;
	private JButton btConfirmar;

	/**
	 * Create the frame.
	 */
	public VentanaAbonos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setMinimumSize(new Dimension(450,370));
		contentPane.setMaximumSize(new Dimension(700,500));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		contentPane.add(getPn1(),"pn1");
		contentPane.add(getPn2(), "pn2");
	}
	
	public JPanel getPn1() {
		if(pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
			pn1.setLayout(new BorderLayout(10, 10));
			pn1.add(getLbTitulo(), BorderLayout.NORTH);
			pn1.add(getFotoEstadio(), BorderLayout.WEST);
			pn1.add(getPnRegistro(), BorderLayout.CENTER);
			pn1.add(getPnInfo(), BorderLayout.SOUTH);
		}
		return pn1;
	}

	public JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("ABONO TEMPORADA 2024/2025");
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lbTitulo;
	}
	private JLabel getFotoEstadio() {
		if (fotoEstadio == null) {
			fotoEstadio = new JLabel("");
			fotoEstadio.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/productos/estadio.png")));
		}
		return fotoEstadio;
	}	
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(0, 10));
			pnRegistro.add(getPnAsiento(), BorderLayout.CENTER);		
		}
		return pnRegistro;
	}
	private JPanel getPnAsiento() {
		if (pnAsiento == null) {
			pnAsiento = new JPanel();
			pnAsiento.setBackground(new Color(255, 255, 255));
			pnAsiento.setLayout(new GridLayout(4, 1, 0, 5));
			pnAsiento.add(getPnTribuna());
			pnAsiento.add(getPnSeccion());
			pnAsiento.add(getPnFila());
			pnAsiento.add(getPnNAsiento());
		}
		return pnAsiento;
	}
	private JPanel getPnTribuna() {
		if (pnTribuna == null) {
			pnTribuna = new JPanel();
			pnTribuna.setBackground(new Color(255, 255, 255));
			pnTribuna.setLayout(new BorderLayout(0, 0));
			pnTribuna.add(getLbTribuna(), BorderLayout.NORTH);
			pnTribuna.add(getCbTribuna(), BorderLayout.CENTER);
		}
		return pnTribuna;
	}
	private JLabel getLbTribuna() {
		if (lbTribuna == null) {
			lbTribuna = new JLabel("Tribuna:");
			lbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbTribuna.setBackground(new Color(255, 255, 255));
		}
		return lbTribuna;
	}
	public JComboBox<String> getCbTribuna() {
		if (cbTribuna == null) {
			cbTribuna = new JComboBox<String>();
			cbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbTribuna.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D"}));
		}
		return cbTribuna;
	}
	private JPanel getPnSeccion() {
		if (pnSeccion == null) {
			pnSeccion = new JPanel();
			pnSeccion.setBackground(new Color(255, 255, 255));
			pnSeccion.setLayout(new BorderLayout(0, 0));
			pnSeccion.add(getLbSeccion(), BorderLayout.NORTH);
			pnSeccion.add(getCbSeccion(), BorderLayout.CENTER);
		}
		return pnSeccion;
	}
	private JLabel getLbSeccion() {
		if (lbSeccion == null) {
			lbSeccion = new JLabel("Sección:");
			lbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbSeccion.setBackground(new Color(255, 255, 255));
		}
		return lbSeccion;
	}
	public JComboBox<String> getCbSeccion() {
		if (cbSeccion == null) {
			cbSeccion = new JComboBox<String>();
			cbSeccion.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D", "E", "F"}));
			cbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return cbSeccion;
	}
	
	private JPanel getPnFila() {
		if (pnFila == null) {
			pnFila = new JPanel();
			pnFila.setBackground(new Color(255, 255, 255));
			pnFila.setLayout(new BorderLayout(0, 0));
			pnFila.add(getLbFila(), BorderLayout.NORTH);
			pnFila.add(getCbFila(), BorderLayout.CENTER);
		}
		return pnFila;
	}
	private JLabel getLbFila() {
		if (lbFila == null) {
			lbFila = new JLabel("Fila:");
			lbFila.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbFila.setBackground(new Color(255, 255, 255));
		}
		return lbFila;
	}
	public JComboBox<String> getCbFila() {
		if (cbFila == null) {
			cbFila = new JComboBox<String>();
			cbFila.setModel(new DefaultComboBoxModel<String>(rellenarFilas()));
			cbFila.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return cbFila;
	}
	
	private String[] rellenarFilas() {
		String[] filas = new String[10];
		for(int i=0;i<filas.length;i++) {
			filas[i]=String.valueOf(i);
		}
		return filas;
	}
	
	private JPanel getPnNAsiento() {
		if (pnNAsiento == null) {
			pnNAsiento = new JPanel();
			pnNAsiento.setBackground(new Color(255, 255, 255));
			pnNAsiento.setLayout(new BorderLayout(0, 0));
			pnNAsiento.add(getLbAsiento(), BorderLayout.NORTH);
			pnNAsiento.add(getCbAsiento(), BorderLayout.CENTER);
		}
		return pnNAsiento;
	}
	private JLabel getLbAsiento() {
		if (lbAsiento == null) {
			lbAsiento = new JLabel("Asiento:");
			lbAsiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbAsiento.setBackground(new Color(255, 255, 255));
		}
		return lbAsiento;
	}
	public JComboBox<String> getCbAsiento() {
		if (cbAsiento == null) {
			cbAsiento = new JComboBox<String>();
			cbAsiento.setModel(new DefaultComboBoxModel<String>(rellenarAsientos()));
			cbAsiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return cbAsiento;
	}
	
	private String[] rellenarAsientos() {
		String[] asientos = new String[15];
		for(int i=0;i<asientos.length;i++) {
			asientos[i]=String.valueOf(i);
		}
		return asientos;
	}
	
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBackground(Color.WHITE);
			pnInfo.setLayout(new BorderLayout(0, 0));
			pnInfo.add(getPnBotones(), BorderLayout.EAST);
		}
		return pnInfo;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(new Color(255, 255, 255));
			pnBotones.setLayout(new GridLayout(0, 2, 10, 0));
			pnBotones.add(getBtSalir());
			pnBotones.add(getBtSiguiente());
		}
		return pnBotones;
	}
	public JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setBackground(Color.RED);
			btSalir.setForeground(Color.WHITE);
			btSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return btSalir;
	}
	public JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setForeground(new Color(255, 255, 255));
			btSiguiente.setBackground(new Color(60, 179, 113));
			btSiguiente.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return btSiguiente;
	}
	public JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
			pn2.add(getPnResumen(),BorderLayout.CENTER);
		}
		return pn2;
	}
	private JPanel getPnResumen() {
		if (pnResumen == null) {
			pnResumen = new JPanel();
			pnResumen.setBackground(new Color(255, 255, 255));
			pnResumen.setLayout(new GridLayout(2,1,0,10));
			pnResumen.add(getPnInfoAbono());
			pnResumen.add(getPnDatos());
		}
		return pnResumen;
	}
	
	private JPanel getPnInfoAbono() {
		if (pnInfoAbono == null) {
			pnInfoAbono = new JPanel();
			pnInfoAbono.setBackground(new Color(255, 255, 255));
			pnInfoAbono.setLayout(new BorderLayout(0,10));
			pnInfoAbono.add(getLbResumen(), BorderLayout.NORTH);
			pnInfoAbono.add(getTaResumen(), BorderLayout.CENTER);
		}
		return pnInfoAbono;
	}
	private JLabel getLbResumen() {
		if (lbResumen == null) {
			lbResumen = new JLabel("\nResumen del abono:");
			lbResumen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbResumen.setBackground(new Color(255, 255, 255));
		}
		return lbResumen;
	}
	public JTextArea getTaResumen() {
		if (taResumen == null) {
			taResumen =  new JTextArea();
			taResumen.setBorder(null);
			taResumen.setEditable(false);
			taResumen.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return taResumen;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(new Color(255, 255, 255));
			pnDatos.setLayout(new BorderLayout(0, 10));
			pnDatos.add(getPnDNI(), BorderLayout.NORTH);
			pnDatos.add(getPnEdad(), BorderLayout.CENTER);
		}
		return pnDatos;
	}
	private JPanel getPnDNI() {
		if (pnDNI == null) {
			pnDNI = new JPanel();
			pnDNI.setBackground(new Color(255, 255, 255));
			pnDNI.setLayout(new BorderLayout(10, 0));
			pnDNI.add(getLbDNI(), BorderLayout.WEST);
			pnDNI.add(getTfDNI(), BorderLayout.CENTER);
		}
		return pnDNI;
	}
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("DNI:");
			lbDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbDNI;
	}
	public JTextField getTfDNI() {
		if (tfDNI == null) {
			tfDNI = new JTextField();
			tfDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfDNI.setColumns(10);
		}
		return tfDNI;
	}
	private JPanel getPnEdad() {
		if (pnEdad == null) {
			pnEdad = new JPanel();
			pnEdad.setBackground(new Color(255, 255, 255));
			pnEdad.setBorder(new TitledBorder(null, "Rango de Edad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnEdad.setLayout(new GridLayout(3, 1, 0, 0));
			pnEdad.add(getRdMenor());
			pnEdad.add(getRdAdulto());
			pnEdad.add(getRdJuvilado());
		}
		return pnEdad;
	}
	public JRadioButton getRdMenor() {
		if (rdMenor == null) {
			rdMenor = new JRadioButton("Menor (Menos de 18 años)");
			rdMenor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			buttonGroup.add(rdMenor);
			rdMenor.setBackground(new Color(255, 255, 255));
		}
		return rdMenor;
	}
	public JRadioButton getRdAdulto() {
		if (rdAdulto == null) {
			rdAdulto = new JRadioButton("Adulto");
			rdAdulto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rdAdulto.setSelected(true);
			buttonGroup.add(rdAdulto);
			rdAdulto.setBackground(new Color(255, 255, 255));
		}
		return rdAdulto;
	}
	public JRadioButton getRdJuvilado() {
		if (rdJuvilado == null) {
			rdJuvilado = new JRadioButton("Jubilado (65 años o más)");
			rdJuvilado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			buttonGroup.add(rdJuvilado);
			rdJuvilado.setBackground(new Color(255, 255, 255));
		}
		return rdJuvilado;
	}
	
	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getTfPrecio(), BorderLayout.CENTER);
			pnInfo2.add(getPnBotones2(), BorderLayout.EAST);
		}
		return pnInfo2;
	}
	public JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setText("");
			tfPrecio.setBackground(new Color(255, 255, 255));
			tfPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
			tfPrecio.setEditable(false);
			tfPrecio.setColumns(10);
		}
		return tfPrecio;
	}
	private JPanel getPnBotones2() {
		if (pnBotones2 == null) {
			pnBotones2 = new JPanel();
			pnBotones2.setBackground(new Color(255, 255, 255));
			pnBotones2.setLayout(new GridLayout(0, 2, 10, 0));
			pnBotones2.add(getBtAnterior());
			pnBotones2.add(getBtConfirmar());
		}
		return pnBotones2;
	}
	public JButton getBtAnterior() {
		if (btAnterior == null) {
			btAnterior = new JButton("Anterior");
			btAnterior.setBackground(new Color(60, 179, 113));
			btAnterior.setForeground(new Color(255, 255, 255));
			btAnterior.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return btAnterior;
	}
	public JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar");
			btConfirmar.setEnabled(false);
			btConfirmar.setForeground(new Color(255, 255, 255));
			btConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btConfirmar.setBackground(new Color(60, 179, 113));
		}
		return btConfirmar;
	}
}
