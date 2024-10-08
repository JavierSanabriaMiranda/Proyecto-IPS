package frontend.entradaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalEntradas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitulo;
	private JPanel pnDatos;
	private JLabel lbTribuna;
	private JLabel lbSeccion;
	private JComboBox cbTribuna;
	private JComboBox cbSeccion;
	private JLabel lbDni;
	private JTextField txDni;
	private JButton btContinuar;
	private JButton btCancelar;
	private JLabel lbAsientos;
	private JSpinner spAsientos;
	
//	private VentaEntradas vE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalEntradas frame = new VentanaPrincipalEntradas();
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
	public VentanaPrincipalEntradas() {
		setTitle("Compra de Entradas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitulo());
		contentPane.add(getPnDatos());
		contentPane.add(getBtContinuar());
		contentPane.add(getBtCancelar());
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
			pnDatos.setBounds(10, 59, 519, 286);
			pnDatos.setLayout(null);
			pnDatos.add(getLbTribuna());
			pnDatos.add(getLbSeccion());
			pnDatos.add(getCbTribuna());
			pnDatos.add(getCbSeccion());
			pnDatos.add(getLbDni());
			pnDatos.add(getTxDni());
			pnDatos.add(getLbAsientos());
			pnDatos.add(getSpAsientos());
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
	private JComboBox getCbTribuna() {
		if (cbTribuna == null) {
			cbTribuna = new JComboBox();
			cbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbTribuna.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
			cbTribuna.setBounds(99, 33, 244, 30);
		}
		return cbTribuna;
	}
	private JComboBox getCbSeccion() {
		if (cbSeccion == null) {
			cbSeccion = new JComboBox();
			cbSeccion.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
			cbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbSeccion.setBounds(99, 96, 244, 30);
		}
		return cbSeccion;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("Dni:");
			lbDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbDni.setBounds(10, 222, 108, 30);
		}
		return lbDni;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setBounds(99, 222, 217, 30);
			txDni.setColumns(10);
		}
		return txDni;
	}
	private JButton getBtContinuar() {
		if (btContinuar == null) {
			btContinuar = new JButton("Continuar");
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btContinuar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btContinuar.setBounds(395, 363, 134, 39);
		}
		return btContinuar;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btCancelar.setBounds(251, 363, 134, 39);
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
			spAsientos.setBounds(234, 159, 109, 30);
		}
		return spAsientos;
	}
}
