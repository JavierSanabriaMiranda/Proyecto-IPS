package frontend.entradaUI.abonados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.eventos.Partido;
import shared.gestionentrada.abonados.GestionEntradasAbonadosShared;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class VentanaInicioAbonados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodAbono;
	private JTextField txtCodAbono;
	private JScrollPane scPartidos;
	private JList<Partido> listPartidos;
	private JLabel lblPartidos;
	private JButton btnComprar;
	private JTextPane textInfo;
	private JButton btnAtras;
	private GestionEntradasAbonadosShared geas;


	/**
	 * Create the frame.
	 */
	public VentanaInicioAbonados(GestionEntradasAbonadosShared geas) {
		this.geas = geas;
		setTitle("Compra de entradas para abonados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 486);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCodAbono());
		contentPane.add(getTxtCodAbono());
		contentPane.add(getScPartidos());
		contentPane.add(getLblPartidos());
		contentPane.add(getBtnComprar());
		contentPane.add(getTextInfo());
		contentPane.add(getBtnAtras());
	}
	private JLabel getLblCodAbono() {
		if (lblCodAbono == null) {
			lblCodAbono = new JLabel("Introduzca el código de su abono: ");
			lblCodAbono.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCodAbono.setBounds(33, 27, 206, 22);
		}
		return lblCodAbono;
	}
	public JTextField getTxtCodAbono() {
		if (txtCodAbono == null) {
			txtCodAbono = new JTextField();
			txtCodAbono.setBounds(33, 50, 265, 30);
			txtCodAbono.setColumns(10);
		}
		return txtCodAbono;
	}
	private JScrollPane getScPartidos() {
		if (scPartidos == null) {
			scPartidos = new JScrollPane();
			scPartidos.setBounds(33, 123, 501, 220);
			scPartidos.setViewportView(getListPartidos());
		}
		return scPartidos;
	}
	public JList<Partido> getListPartidos() {
		if (listPartidos == null) {
			listPartidos = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
			DefaultListModel<Partido> listModel = (DefaultListModel<Partido>) listPartidos.getModel();
			listModel.clear(); // Limpia el modelo actual
			List<Partido> listaPartidos = geas.getPartidosConSuplemento();
			listModel.addAll(listaPartidos);
			listPartidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listPartidos;
	}
	private JLabel getLblPartidos() {
		if (lblPartidos == null) {
			lblPartidos = new JLabel("Partidos con Suplemento");
			lblPartidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblPartidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPartidos.setBounds(33, 98, 501, 22);
		}
		return lblPartidos;
	}
	public JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.setBounds(464, 408, 106, 30);
		}
		return btnComprar;
	}
	private JTextPane getTextInfo() {
		if (textInfo == null) {
			textInfo = new JTextPane();
			textInfo.setEditable(false);
			textInfo.setText("- El precio de suplemento es de 15 euros y el asiento será el asignado a su abono.");
			textInfo.setBounds(33, 345, 501, 30);
		}
		return textInfo;
	}
	public JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setBounds(10, 408, 106, 30);
		}
		return btnAtras;
	}

	public GestionEntradasAbonadosShared getGeas() {
		return geas;
	}
}
