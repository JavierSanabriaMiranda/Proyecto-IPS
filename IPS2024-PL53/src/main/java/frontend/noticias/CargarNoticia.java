package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CargarNoticia extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnTitulo;
	private JPanel pnTituloNoticia;
	private JPanel pnTexto;
	private JScrollPane scPanelTextoNoticia;
	private JTextArea textAreaTextoNoticia;
	private JPanel pnImagenesBotones;
	private JPanel pnImagenes;
	private JPanel pnBotones;
	private JButton btCancelar;
	private JButton btAñadir;
	private JButton btElegirImagenes;
	private JTable tablaImagenes;
	private JTextField tfTitulo;
	private JTextField textoTitulo;

	/**
	 * Create the frame.
	 */
	public CargarNoticia() {
		setBackground(Color.WHITE);
		setTitle("Cargar Noticia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 10));
		contentPane.add(getPnTitulo());
		contentPane.add(getPnTexto());
		contentPane.add(getPnImagenesBotones());
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setAlignmentY(1.0f);
			pnTitulo.setAlignmentX(1.0f);
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getPnTituloNoticia(), BorderLayout.SOUTH);
			pnTitulo.add(getTextField_1(), BorderLayout.CENTER);
		}
		return pnTitulo;
	}
	private JPanel getPnTituloNoticia() {
		if (pnTituloNoticia == null) {
			pnTituloNoticia = new JPanel();
			pnTituloNoticia.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00EDtulo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnTituloNoticia.setBackground(Color.WHITE);
			pnTituloNoticia.setLayout(new BorderLayout(10, 0));
			pnTituloNoticia.add(getTextField_2(), BorderLayout.CENTER);
		}
		return pnTituloNoticia;
	}
	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Texto de la noticia:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnTexto.setBackground(Color.WHITE);
			pnTexto.setLayout(new GridLayout(0, 1, 0, 0));
			pnTexto.add(getScPanelTextoNoticia());
		}
		return pnTexto;
	}
	private JScrollPane getScPanelTextoNoticia() {
		if (scPanelTextoNoticia == null) {
			scPanelTextoNoticia = new JScrollPane();
			scPanelTextoNoticia.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scPanelTextoNoticia.setViewportView(getTextAreaTextoNoticia());
		}
		return scPanelTextoNoticia;
	}
	private JTextArea getTextAreaTextoNoticia() {
		if (textAreaTextoNoticia == null) {
			textAreaTextoNoticia = new JTextArea();
			textAreaTextoNoticia.setLineWrap(true);  // Habilitar el ajuste de línea
	        textAreaTextoNoticia.setWrapStyleWord(true);  // Ajustar por palabra completa
			textAreaTextoNoticia.setText("");
		}
		return textAreaTextoNoticia;
	}
	private JPanel getPnImagenesBotones() {
		if (pnImagenesBotones == null) {
			pnImagenesBotones = new JPanel();
			pnImagenesBotones.setBackground(Color.WHITE);
			pnImagenesBotones.setLayout(new BorderLayout(20, 0));
			pnImagenesBotones.add(getPnImagenes(), BorderLayout.CENTER);
			pnImagenesBotones.add(getPnBotones(), BorderLayout.SOUTH);
		}
		return pnImagenesBotones;
	}
	private JPanel getPnImagenes() {
		if (pnImagenes == null) {
			pnImagenes = new JPanel();
			pnImagenes.setBorder(new TitledBorder(null, "Im\u00E1genes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnImagenes.setBackground(Color.WHITE);
			pnImagenes.setLayout(new BorderLayout(0, 0));
			pnImagenes.add(getBtElegirImagenes(), BorderLayout.NORTH);
			pnImagenes.add(getTablaImagenes(), BorderLayout.CENTER);
		}
		return pnImagenes;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(Color.WHITE);
			pnBotones.setLayout(new GridLayout(1, 2, 0, 0));
			pnBotones.add(getBtCancelar());
			pnBotones.add(getBtAñadir());
		}
		return pnBotones;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btCancelar.setBackground(Color.RED);
			btCancelar.setForeground(Color.WHITE);
		}
		return btCancelar;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Cargar");
			btAñadir.setBackground(new Color(60, 179, 113));
			btAñadir.setFont(new Font("Tahoma", Font.BOLD, 13));
			btAñadir.setForeground(Color.WHITE);
			btAñadir.setEnabled(false);
		}
		return btAñadir;
	}
	private JButton getBtElegirImagenes() {
		if (btElegirImagenes == null) {
			btElegirImagenes = new JButton("Elegir Imágenes");
			btElegirImagenes.setBackground(new Color(216, 191, 216));
		}
		return btElegirImagenes;
	}
	private JTable getTablaImagenes() {
		if (tablaImagenes == null) {
			tablaImagenes = new JTable();
			tablaImagenes.setBackground(Color.WHITE);
		}
		return tablaImagenes;
	}
	private JTextField getTextField_1() {
		if (tfTitulo == null) {
			tfTitulo = new JTextField();
			tfTitulo.setFocusable(false);
			tfTitulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 42));
			tfTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			tfTitulo.setText("Cargar Noticia");
			tfTitulo.setBackground(new Color(135, 206, 235));
			tfTitulo.setEditable(false);
		}
		return tfTitulo;
	}
	private JTextField getTextField_2() {
		if (textoTitulo == null) {
			textoTitulo = new JTextField();
			textoTitulo.setColumns(10);
		}
		return textoTitulo;
	}
}
