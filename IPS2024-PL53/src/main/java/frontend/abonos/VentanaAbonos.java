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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import frontend.merchandisingUI.VentanaPrincipal;

public class VentanaAbonos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private JPanel pnDatos;
	private JPanel pnDNI;
	private JLabel lbDNI;
	private JTextField tfDNI;
	private JPanel pnEdad;
	private JRadioButton rdMenor;
	private JRadioButton rdAdulto;
	private JRadioButton rdJuvilado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnInfo;
	private JPanel pnBotones;
	private JButton btSalir;
	private JButton btSiguiente;
	private JTextField tfPrecio;

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
	}
	
	private JPanel getPn1() {
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

	private JLabel getLbTitulo() {
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
			pnRegistro.add(getPnAsiento(), BorderLayout.NORTH);
			pnRegistro.add(getPnDatos(),BorderLayout.CENTER);			
		}
		return pnRegistro;
	}
	private JPanel getPnAsiento() {
		if (pnAsiento == null) {
			pnAsiento = new JPanel();
			pnAsiento.setBackground(new Color(255, 255, 255));
			pnAsiento.setLayout(new GridLayout(2, 1, 0, 5));
			pnAsiento.add(getPnTribuna());
			pnAsiento.add(getPnSeccion());
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
			lbDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbDNI;
	}
	private JTextField getTfDNI() {
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
	private JRadioButton getRdMenor() {
		if (rdMenor == null) {
			rdMenor = new JRadioButton("Menor (Menos de 18 años)");
			buttonGroup.add(rdMenor);
			rdMenor.setBackground(new Color(255, 255, 255));
		}
		return rdMenor;
	}
	private JRadioButton getRdAdulto() {
		if (rdAdulto == null) {
			rdAdulto = new JRadioButton("Adulto");
			buttonGroup.add(rdAdulto);
			rdAdulto.setBackground(new Color(255, 255, 255));
		}
		return rdAdulto;
	}
	private JRadioButton getRdJuvilado() {
		if (rdJuvilado == null) {
			rdJuvilado = new JRadioButton("Juvilado (65 años o más)");
			buttonGroup.add(rdJuvilado);
			rdJuvilado.setBackground(new Color(255, 255, 255));
		}
		return rdJuvilado;
	}
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBackground(Color.WHITE);
			pnInfo.setLayout(new BorderLayout(0, 0));
			pnInfo.add(getPnBotones(), BorderLayout.EAST);
			pnInfo.add(getTfPrecio(), BorderLayout.CENTER);
		}
		return pnInfo;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(new Color(255, 255, 255));
			pnBotones.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotones.add(getBtSalir());
			pnBotones.add(getBtSiguiente());
		}
		return pnBotones;
	}
	private JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setBackground(Color.RED);
			btSalir.setForeground(Color.WHITE);
			btSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return btSalir;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.setForeground(new Color(255, 255, 255));
			btSiguiente.setBackground(new Color(60, 179, 113));
			btSiguiente.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return btSiguiente;
	}
	
	private JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setText("    Precio del abono: ");
			tfPrecio.setBackground(new Color(255, 255, 255));
			tfPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
			tfPrecio.setEditable(false);
			tfPrecio.setColumns(10);
		}
		return tfPrecio;
	}
}
