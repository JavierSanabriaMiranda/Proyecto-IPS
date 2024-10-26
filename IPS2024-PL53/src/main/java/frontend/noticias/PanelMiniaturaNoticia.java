package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import backend.service.noticias.Noticia;

public class PanelMiniaturaNoticia extends JPanel {
	private static final long serialVersionUID = 1L;
	Noticia noticia;
	private JPanel pnTitulo;
	private JButton btLeerMas;
	private JLabel lbTitulo;
	private JLabel imagen;
	
	public PanelMiniaturaNoticia(Noticia noticia) {
		this.noticia = noticia;
		setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1, 0, 0));
		add(getImagen());
		add(getPnTitulo());
		
	}	
	
	private JLabel getImagen() {
		if (imagen == null) {
			imagen = new JLabel("");
			imagen.setIcon(new ImageIcon(PanelMiniaturaNoticia.class.getResource(noticia.getImagenes().get(0).getUrl())));
			imagen.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return imagen;
	}
	
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getBtLeerMas(), BorderLayout.SOUTH);
			pnTitulo.add(getLbTitulo(), BorderLayout.CENTER);
		}
		return pnTitulo;
	}
	
	
	private JButton getBtLeerMas() {
		if (btLeerMas == null) {
			btLeerMas = new JButton("Leer Más");
			btLeerMas.setBackground(new Color(216, 191, 216));
		}
		return btLeerMas;
	}
	
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("");
			lbTitulo.setFont(new Font("Serif", Font.BOLD, 18));
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setText(noticia.getTitulo());
		}
		return lbTitulo;
	}
}
