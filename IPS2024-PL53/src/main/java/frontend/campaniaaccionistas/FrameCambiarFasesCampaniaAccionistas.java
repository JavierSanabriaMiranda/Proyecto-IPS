package frontend.campaniaaccionistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FrameCambiarFasesCampaniaAccionistas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbFaseActual;
	private JButton btAvanzar;

	/**
	 * Create the frame.
	 */
	public FrameCambiarFasesCampaniaAccionistas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbFaseActual());
		contentPane.add(getBtAvanzar());
	}
	private JLabel getLbFaseActual() {
		if (lbFaseActual == null) {
			lbFaseActual = new JLabel("Fase Actual: ");
			lbFaseActual.setFont(new Font("Tahoma", Font.BOLD, 30));
			lbFaseActual.setBounds(87, 22, 243, 76);
		}
		return lbFaseActual;
	}
	private JButton getBtAvanzar() {
		if (btAvanzar == null) {
			btAvanzar = new JButton("Siguiente Fase");
			btAvanzar.setBackground(new Color(255, 255, 255));
			btAvanzar.setFont(new Font("Arial", Font.PLAIN, 14));
			btAvanzar.setBounds(137, 170, 142, 54);
		}
		return btAvanzar;
	}
}
