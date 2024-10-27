package frontend.campaniaaccionistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.gestioncampania.GestionCampaniaShared;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class FrameCreacionCampaniaAccionistas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionCampaniaShared gesCam = new GestionCampaniaShared();
	private JPanel contentPane;
	private JLabel lbCrearNuevaCampania;
	private JLabel lbNumAcciones;
	private JSpinner spNumAcciones;
	private JButton btCancelar;
	private JButton btCrear;

	/**
	 * Create the frame.
	 */
	public FrameCreacionCampaniaAccionistas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 311);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbCrearNuevaCampania());
		contentPane.add(getLbNumAcciones());
		contentPane.add(getSpNumAcciones());
		contentPane.add(getBtCancelar());
		contentPane.add(getBtCrear());
	}
	
	public GestionCampaniaShared getGesCam() {
		return gesCam;
	}
	
	private JLabel getLbCrearNuevaCampania() {
		if (lbCrearNuevaCampania == null) {
			lbCrearNuevaCampania = new JLabel("Crear Nueva Campaña");
			lbCrearNuevaCampania.setHorizontalAlignment(SwingConstants.CENTER);
			lbCrearNuevaCampania.setFont(new Font("Arial", Font.BOLD, 30));
			lbCrearNuevaCampania.setBounds(85, 11, 344, 109);
		}
		return lbCrearNuevaCampania;
	}
	private JLabel getLbNumAcciones() {
		if (lbNumAcciones == null) {
			lbNumAcciones = new JLabel("Número Acciones: ");
			lbNumAcciones.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNumAcciones.setBounds(130, 116, 167, 63);
		}
		return lbNumAcciones;
	}
	public JSpinner getSpNumAcciones() {
		if (spNumAcciones == null) {
			spNumAcciones = new JSpinner();
			spNumAcciones.setBackground(new Color(255, 255, 255));
			spNumAcciones.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spNumAcciones.setFont(new Font("Arial", Font.PLAIN, 14));
			spNumAcciones.setBounds(281, 138, 68, 20);
		}
		return spNumAcciones;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setBackground(new Color(255, 255, 255));
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btCancelar.setBounds(406, 240, 89, 23);
		}
		return btCancelar;
	}
	public JButton getBtCrear() {
		if (btCrear == null) {
			btCrear = new JButton("Crear");
			btCrear.setBackground(new Color(255, 255, 255));
			btCrear.setFont(new Font("Arial", Font.PLAIN, 14));
			btCrear.setBounds(307, 241, 89, 23);
		}
		return btCrear;
	}
}
