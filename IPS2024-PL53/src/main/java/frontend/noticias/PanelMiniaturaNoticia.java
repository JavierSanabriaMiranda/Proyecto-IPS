package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelMiniaturaNoticia extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnTitulo;
	private JButton btLeerMas;
	private JLabel imagen;
	private JLabel lbTitulo;
	
	public PanelMiniaturaNoticia() {
		setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1, 0, 0));
		setPreferredSize(new Dimension(140, 200));
		
		add(getImagen());
		add(getPnTitulo());
		
	}	
	
	public JLabel getImagen() {
		if (imagen == null) {
			imagen = new JLabel("");
			imagen.setBackground(new Color(224, 255, 255));
			imagen.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return imagen;
	}
	
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBackground(new Color(240, 248, 255));
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getBtLeerMas(), BorderLayout.SOUTH);
			pnTitulo.add(getLbTitulo(), BorderLayout.CENTER);
		}
		return pnTitulo;
	}
	
	public JButton getBtLeerMas() {
		if (btLeerMas == null) {
			btLeerMas = new JButton("Leer Más");
			btLeerMas.setFont(new Font("Calibri", Font.BOLD, 11));
			btLeerMas.setBackground(new Color(255, 228, 225));
		}
		return btLeerMas;
	}
	public JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("");
			lbTitulo.setVerticalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Serif", Font.BOLD, 16));
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTitulo;
	}
}
