package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.service.noticias.Imagen;

public class CargarNoticia extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnTitulo;
	private JPanel pnTituloNoticia;
	private JPanel pnTexto;
	private JScrollPane scPanelTextoNoticia;
	private JTextArea taTextoNoticia;
	private JPanel pnImagenesBotones;
	private JPanel pnImagenes;
	private JPanel pnBotones;
	private JButton btCancelar;
	private JButton btAñadir;
	private JButton btElegirImagenes;
	private JTextField tfTitulo;
	private JTextField textoTitulo;
	private JPanel pnEliminar;
	private JButton btEliminar;
	private JScrollPane scPanelImagenes;
	private JList<Imagen> listaImagenes;
	public DefaultListModel<Imagen> modeloListaImagenes;
	private JFileChooser selector;

	/**
	 * Create the frame.
	 */
	public CargarNoticia() {
		setBackground(Color.WHITE);
		setTitle("Cargar Noticia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 650);
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
			pnTitulo.setBackground(new Color(230, 230, 250));
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getPnTituloNoticia(), BorderLayout.SOUTH);
			pnTitulo.add(getTitulo(), BorderLayout.CENTER);
		}
		return pnTitulo;
	}
	private JPanel getPnTituloNoticia() {
		if (pnTituloNoticia == null) {
			pnTituloNoticia = new JPanel();
			pnTituloNoticia.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00EDtulo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnTituloNoticia.setBackground(Color.WHITE);
			pnTituloNoticia.setLayout(new BorderLayout(10, 0));
			pnTituloNoticia.add(getTextoTitulo(), BorderLayout.CENTER);
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
			scPanelTextoNoticia.setViewportView(getTaTextoNoticia());
		}
		return scPanelTextoNoticia;
	}
	public JTextArea getTaTextoNoticia() {
		if (taTextoNoticia == null) {
			taTextoNoticia = new JTextArea();
			taTextoNoticia.setLineWrap(true);  // Habilitar el ajuste de línea
	        taTextoNoticia.setWrapStyleWord(true);  // Ajustar por palabra completa
			taTextoNoticia.setText("");
		}
		return taTextoNoticia;
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
			pnImagenes.add(getPnEliminar(), BorderLayout.SOUTH);
			pnImagenes.add(getScPanelImagenes(), BorderLayout.CENTER);
		}
		return pnImagenes;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(new Color(230, 230, 250));
			pnBotones.setLayout(new GridLayout(1, 2, 0, 0));
			pnBotones.add(getBtCancelar());
			pnBotones.add(getBtAñadir());
		}
		return pnBotones;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btCancelar.setBackground(Color.RED);
			btCancelar.setForeground(Color.WHITE);
		}
		return btCancelar;
	}
	public JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Cargar");
			btAñadir.setBackground(new Color(60, 179, 113));
			btAñadir.setFont(new Font("Tahoma", Font.BOLD, 13));
			btAñadir.setForeground(Color.WHITE);
			btAñadir.setEnabled(false);
		}
		return btAñadir;
	}
	public JButton getBtElegirImagenes() {
		if (btElegirImagenes == null) {
			btElegirImagenes = new JButton("Elegir Imágenes");
			btElegirImagenes.setBackground(new Color(216, 191, 216));
		}
		return btElegirImagenes;
	}
	private JTextField getTitulo() {
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
	public JTextField getTextoTitulo() {
		if (textoTitulo == null) {
			textoTitulo = new JTextField();
			textoTitulo.setColumns(10);
		}
		return textoTitulo;
	}
	private JPanel getPnEliminar() {
		if (pnEliminar == null) {
			pnEliminar = new JPanel();
			pnEliminar.setBackground(Color.WHITE);
			pnEliminar.setLayout(new BorderLayout(0, 0));
			pnEliminar.add(getBtEliminar(), BorderLayout.EAST);
		}
		return pnEliminar;
	}
	public JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setEnabled(false);
			btEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btEliminar.setForeground(Color.WHITE);
			btEliminar.setBackground(Color.RED);
			btEliminar.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return btEliminar;
	}
	private JScrollPane getScPanelImagenes() {
		if (scPanelImagenes == null) {
			scPanelImagenes = new JScrollPane();
			scPanelImagenes.setBackground(Color.WHITE);
			scPanelImagenes.setViewportView(getListaImagenes());
		}
		return scPanelImagenes;
	}
	public JList<Imagen> getListaImagenes() {
		if (listaImagenes == null) {
			modeloListaImagenes = new DefaultListModel<Imagen>();
			listaImagenes = new JList<Imagen>(modeloListaImagenes);
			listaImagenes.setBackground(Color.WHITE);
		}
		return listaImagenes;
	}

	public JFileChooser getSelector() {
	    if (selector == null) {
	        selector = new JFileChooser();
	        selector.setMultiSelectionEnabled(true);
	        selector.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "avif"));
	    }
	    return selector;
	}

}
