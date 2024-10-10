package frontend.entradaUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import shared.gestioncliente.GestionClienteShared;
import shared.gestionentrada.GestionEntradaShared;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaSeleccionEntradas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitulo;
	private JPanel pnDatos;
	private JLabel lbTribuna;
	private JLabel lbSeccion;
	private JComboBox<String> cbTribuna;
	private JComboBox<String> cbSeccion;
	private JButton btContinuar;
	private JButton btCancelar;
	private JLabel lbAsientos;
	private JSpinner spAsientos;
	
	private GestionEntradaShared ges;
	private GestionClienteShared gcs = new GestionClienteShared();
	
	private JLabel lbDni;
	private JTextField txDni;

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionEntradas(GestionEntradaShared ges) {
		this.ges = ges;
		setTitle("Compra de Entradas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitulo());
		contentPane.add(getPnDatos());
		contentPane.add(getBtContinuar());
		contentPane.add(getBtCancelar());
		setLocationRelativeTo(null);
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Compra de entradas");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbTitulo.setBounds(10, 10, 529, 39);
		}
		return lbTitulo;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos necesarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatos.setBounds(10, 59, 519, 288);
			pnDatos.setLayout(null);
			pnDatos.add(getLbTribuna());
			pnDatos.add(getLbSeccion());
			pnDatos.add(getCbTribuna());
			pnDatos.add(getCbSeccion());
			pnDatos.add(getLbAsientos());
			pnDatos.add(getSpAsientos());
			pnDatos.add(getLbDni());
			pnDatos.add(getTxDni());
		}
		return pnDatos;
	}
	private JLabel getLbTribuna() {
		if (lbTribuna == null) {
			lbTribuna = new JLabel("Tribuna:");
			lbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbTribuna.setBounds(10, 33, 108, 30);
		}
		return lbTribuna;
	}
	private JLabel getLbSeccion() {
		if (lbSeccion == null) {
			lbSeccion = new JLabel("Sección:");
			lbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbSeccion.setBounds(10, 96, 108, 30);
		}
		return lbSeccion;
	}
	private JComboBox<String> getCbTribuna() {
		if (cbTribuna == null) {
			cbTribuna = new JComboBox<String>();
			cbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbTribuna.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D"}));
			cbTribuna.setBounds(123, 33, 244, 30);
		}
		return cbTribuna;
	}
	private JComboBox<String> getCbSeccion() {
		if (cbSeccion == null) {
			cbSeccion = new JComboBox<String>();
			cbSeccion.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D", "E", "F"}));
			cbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbSeccion.setBounds(123, 96, 244, 30);
		}
		return cbSeccion;
	}

	private JButton getBtContinuar() {
		if (btContinuar == null) {
			btContinuar = new JButton("Continuar");
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (clientExists()) {
						if (checkIfCanBook()) {
							ges.addEntradasBBDD(getTxDni().getText());
							JOptionPane.showMessageDialog(null,
									"Gracias por la compra.\n" + ges.getEntradasCompradas());
						} else {
							JOptionPane.showMessageDialog(null,
									"No se pueden reservar tantos " + "asientos contiguos.");
						}
					}
				}
			});
			btContinuar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btContinuar.setBounds(393, 366, 134, 39);
		}
		return btContinuar;
	}
	
	private boolean clientExists() {
		String dni = this.getTxDni().getText();
		return gcs.checkIfClientExistsByDni(dni);
	}
	
	private boolean checkIfCanBook() {
		String tribuna = (String) this.getCbTribuna().getSelectedItem();
		String seccion = (String) this.getCbSeccion().getSelectedItem();
		int nAsientos = (int) this.getSpAsientos().getValue();
		return ges.canReservarAsientos(tribuna, seccion, nAsientos);
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btCancelar.setBounds(249, 366, 134, 39);
		}
		return btCancelar;
	}
	private JLabel getLbAsientos() {
		if (lbAsientos == null) {
			lbAsientos = new JLabel("Numero de asientos contiguos:");
			lbAsientos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbAsientos.setBounds(10, 159, 211, 30);
		}
		return lbAsientos;
	}
	private JSpinner getSpAsientos() {
		if (spAsientos == null) {
			spAsientos = new JSpinner();
			spAsientos.setModel(new SpinnerNumberModel(1, 1, 15, 1));
			spAsientos.setBounds(200, 159, 109, 30);
		}
		return spAsientos;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI:");
			lbDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbDni.setBounds(10, 222, 91, 30);
		}
		return lbDni;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setBounds(123, 222, 172, 30);
			txDni.setColumns(10);
		}
		return txDni;
	}
}
