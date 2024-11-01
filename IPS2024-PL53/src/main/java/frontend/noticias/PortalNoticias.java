package frontend.noticias;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PortalNoticias extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel pnPrincipal;
    private JPanel pnSuperior;
    private JLabel lbTitulo;
    private JScrollPane scPanelNoticias;
    private JPanel pnNoticias;
    private JPanel pnBotones;
    private JButton btSalir;
    private JPanel pnNoticia;
    private JLabel lbTituloNoticia;
    private JPanel pnImagenesTexto;
    private JPanel pnImagenes;
    private JButton btImgAnterior;
    private JButton btImagen;
    private JButton btImgSiguiente;
    private JPanel pnBotonAnterior;
    private JButton btAnterior;
    private JScrollPane pnTexto;
    private JTextArea taTexto;
    private JPanel pnImagenExpandida;
    private JPanel pnBotonAnterior2;
    private JButton btAnterior2;
    private JButton btImagenExpandida;

    public PortalNoticias() {
        setTitle("Portal de Noticias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 640);
        setMinimumSize(new Dimension(850,740));
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 216, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        contentPane.add(getPnPrincipal(), "pn1");
        contentPane.add(getPnNoticia(), "pn2");
        contentPane.add(getPnImagenExpandida(), "pn3");
    }

    private JPanel getPnPrincipal() {
        if (pnPrincipal == null) {
            pnPrincipal = new JPanel();
            pnPrincipal.setBackground(new Color(176, 224, 230));
            pnPrincipal.setLayout(new BorderLayout(0, 0));
            pnPrincipal.add(getPnSuperior(), BorderLayout.NORTH);
            pnPrincipal.add(getScPanelNoticias(), BorderLayout.CENTER);
            pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
        }
        return pnPrincipal;
    }

    public JPanel getPnSuperior() {
        if (pnSuperior == null) {
            pnSuperior = new JPanel();
            pnSuperior.setBackground(new Color(220, 220, 220));
            pnSuperior.setLayout(new BorderLayout(0, 0));
            pnSuperior.add(getLbTitulo(), BorderLayout.WEST);
        }
        return pnSuperior;
    }

    private JLabel getLbTitulo() {
        if (lbTitulo == null) {
            lbTitulo = new JLabel("NOTICIAS");
            lbTitulo.setForeground(new Color(0, 0, 0));
            lbTitulo.setFont(new Font("Serif", Font.BOLD, 50));
            lbTitulo.setBackground(new Color(255, 255, 255));
        }
        return lbTitulo;
    }

    private JScrollPane getScPanelNoticias() {
        if (scPanelNoticias == null) {
            scPanelNoticias = new JScrollPane();
            scPanelNoticias.setViewportView(getPnNoticias());
        }
        return scPanelNoticias;
    }

    public JPanel getPnNoticias() {
        if (pnNoticias == null) {
            pnNoticias = new JPanel();
            pnNoticias.setBackground(new Color(220, 220, 220));
            pnNoticias.setLayout(new GridLayout(0, 3, 5, 5));
        }
        return pnNoticias;
    }

    private JPanel getPnBotones() {
        if (pnBotones == null) {
            pnBotones = new JPanel();
            pnBotones.setBackground(new Color(220, 220, 220));
            pnBotones.setLayout(new BorderLayout(0, 0));
            pnBotones.add(getBtSalir(), BorderLayout.EAST);
        }
        return pnBotones;
    }

    public JButton getBtSalir() {
        if (btSalir == null) {
            btSalir = new JButton("Salir");
            btSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
            btSalir.setForeground(Color.WHITE);
            btSalir.setBackground(Color.RED);
        }
        return btSalir;
    }

    private JPanel getPnNoticia() {
        if (pnNoticia == null) {
            pnNoticia = new JPanel();
            pnNoticia.setBackground(Color.WHITE);
            pnNoticia.setLayout(new BorderLayout(0, 0));
            pnNoticia.add(getLbTituloNoticia(), BorderLayout.NORTH);
            pnNoticia.add(getPnImagenesTexto(), BorderLayout.CENTER);
            pnNoticia.add(getPnBotonAnterior(), BorderLayout.SOUTH);
        }
        return pnNoticia;
    }

    public JLabel getLbTituloNoticia() {
        if (lbTituloNoticia == null) {
            lbTituloNoticia = new JLabel("");
            lbTituloNoticia.setHorizontalAlignment(SwingConstants.CENTER);
            lbTituloNoticia.setBackground(Color.WHITE);
            lbTituloNoticia.setFont(new Font("Serif", Font.BOLD, 30));
        }
        return lbTituloNoticia;
    }

    public JPanel getPnImagenesTexto() {
        if (pnImagenesTexto == null) {
            pnImagenesTexto = new JPanel();
            pnImagenesTexto.setBackground(Color.WHITE);
            pnImagenesTexto.setLayout(new BorderLayout(0, 0));
            pnImagenesTexto.add(getPnImagenes(), BorderLayout.NORTH);
            pnImagenesTexto.add(getPnTexto(), BorderLayout.CENTER);
        }
        return pnImagenesTexto;
    }

    public JPanel getPnImagenes() {
        if (pnImagenes == null) {
            pnImagenes = new JPanel();
            pnImagenes.setBackground(Color.WHITE);
            pnImagenes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            pnImagenes.add(getBtImgAnterior());
            pnImagenes.add(getBtImagen());
            pnImagenes.add(getBtImgSiguiente());
        }
        return pnImagenes;
    }

    public JButton getBtImgAnterior() {
        if (btImgAnterior == null) {
            btImgAnterior = new JButton("<");
            btImgAnterior.setBackground(new Color(255, 255, 255));
            btImgAnterior.setEnabled(false);
        }
        return btImgAnterior;
    }

    public JButton getBtImagen() {
        if (btImagen == null) {
            btImagen = new JButton("");
            btImagen.setToolTipText("Pulsar para ampliar");
            btImagen.setHorizontalAlignment(SwingConstants.CENTER);
            btImagen.setBackground(Color.WHITE);
            btImagen.setPreferredSize(new Dimension(150, 100));
        }
        return btImagen;
    }

    public JButton getBtImgSiguiente() {
        if (btImgSiguiente == null) {
            btImgSiguiente = new JButton(">");
            btImgSiguiente.setEnabled(false);
            btImgSiguiente.setBackground(Color.WHITE);
        }
        return btImgSiguiente;
    }

    private JPanel getPnBotonAnterior() {
        if (pnBotonAnterior == null) {
            pnBotonAnterior = new JPanel();
            pnBotonAnterior.setBackground(Color.WHITE);
            pnBotonAnterior.setLayout(new BorderLayout(0, 0));
            pnBotonAnterior.add(getBtAnterior(), BorderLayout.EAST);
        }
        return pnBotonAnterior;
    }

    public JButton getBtAnterior() {
        if (btAnterior == null) {
            btAnterior = new JButton("Anterior");
            btAnterior.setFont(new Font("Tahoma", Font.BOLD, 13));
            btAnterior.setMnemonic('A');
            btAnterior.setForeground(Color.WHITE);
            btAnterior.setBackground(new Color(60, 179, 113));
        }
        return btAnterior;
    }

    private JScrollPane getPnTexto() {
        if (pnTexto == null) {
            pnTexto = new JScrollPane();
            pnTexto.setBackground(Color.WHITE);
            pnTexto.setViewportView(getTaTexto());
        }
        return pnTexto;
    }

    public JTextArea getTaTexto() {
        if (taTexto == null) {
            taTexto = new JTextArea();
            taTexto.setFont(new Font("Calibri", Font.PLAIN, 16));
            taTexto.setLineWrap(true);
            taTexto.setWrapStyleWord(true);
            taTexto.setMargin(new Insets(10, 10, 10, 10));
            taTexto.setEditable(false);
            taTexto.setBackground(Color.WHITE);
            taTexto.setForeground(Color.DARK_GRAY);
            taTexto.setOpaque(true);
        }
        return taTexto;
    }
	private JPanel getPnImagenExpandida() {
		if (pnImagenExpandida == null) {
			pnImagenExpandida = new JPanel();
			pnImagenExpandida.setLayout(new BorderLayout(0, 0));
			pnImagenExpandida.add(getPnBotonAnterior2(), BorderLayout.SOUTH);
			pnImagenExpandida.add(getBtImagenExpandida(), BorderLayout.CENTER);
		}
		return pnImagenExpandida;
	}
	private JPanel getPnBotonAnterior2() {
		if (pnBotonAnterior2 == null) {
			pnBotonAnterior2 = new JPanel();
			pnBotonAnterior2.setLayout(new BorderLayout(0, 0));
			pnBotonAnterior2.add(getBtAnterior2(), BorderLayout.EAST);
		}
		return pnBotonAnterior2;
	}
	public JButton getBtAnterior2() {
		if (btAnterior2 == null) {
			btAnterior2 = new JButton("Anterior");
			btAnterior2.setBackground(new Color(60, 179, 113));
			btAnterior2.setForeground(Color.WHITE);
			btAnterior2.setFont(new Font("Tahoma", Font.BOLD, 13));
			btAnterior2.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return btAnterior2;
	}
	public JButton getBtImagenExpandida() {
		if (btImagenExpandida == null) {
			btImagenExpandida = new JButton("");
		}
		return btImagenExpandida;
	}
}
