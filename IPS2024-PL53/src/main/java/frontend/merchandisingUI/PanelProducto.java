package frontend.merchandisingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import backend.service.ventas.merchandising.Producto;

public class PanelProducto extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel panelArticulo;
    private JLabel lbArticulo;
    private JPanel panelBotones;
    private JButton btAñadir;
    private JButton btEliminar;
    private Producto producto;

    public PanelProducto(Producto producto) {
        this.producto = producto;
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(getPanelArticulo(), BorderLayout.CENTER);
        this.add(getPanelBotones(), BorderLayout.EAST);
    }

    private JPanel getPanelArticulo() {
        if (panelArticulo == null) {
            panelArticulo = new JPanel();
            panelArticulo.setBackground(Color.WHITE);
            panelArticulo.setLayout(new GridLayout(0, 1, 0, 0));
            panelArticulo.add(getLbArticulo());
        }
        return panelArticulo;
    }

    public JLabel getLbArticulo() {
        if (lbArticulo == null) {
            lbArticulo = new JLabel("");
            lbArticulo.setFont(new Font("Tahoma", Font.BOLD, 12));
            lbArticulo.setForeground(new Color(0, 0, 0));
            lbArticulo.setText(producto.toString());
            lbArticulo.setIcon(new ImageIcon(PanelProducto.class.getResource("/img/productos/" + producto.getCode() + ".jpg")));
        }
        return lbArticulo;
    }

    private JPanel getPanelBotones() {
        if (panelBotones == null) {
            panelBotones = new JPanel();
            panelBotones.setBackground(Color.WHITE);
            panelBotones.setLayout(new BorderLayout());

            // Creamos un subpanel para contener los botones y controlar su tamaño
            JPanel subPanelBotones = new JPanel();
            subPanelBotones.setLayout(new GridLayout(1, 2, 0, 0)); // 1 fila, 3 columnas
            subPanelBotones.setBackground(Color.WHITE);

            // Añadir los componentes al subpanel
            subPanelBotones.add(getBtAñadir());
            subPanelBotones.add(getBtEliminar());

            // Ajustar el tamaño preferido del subpanel para hacerlo mñs ancho y menos alto
            subPanelBotones.setPreferredSize(new java.awt.Dimension(300, 40)); // Mñs ancho (300 px), menos alto (40 px)

            // Añadimos el subpanel al panel principal de botones
            panelBotones.add(subPanelBotones, BorderLayout.CENTER);
        }
        return panelBotones;
    }

    public JButton getBtAñadir() {
        if (btAñadir == null) {
            btAñadir = new JButton("A\u00F1adir");
            btAñadir.setFont(new Font("Tahoma", Font.BOLD, 12));
            btAñadir.setForeground(new Color(255, 255, 255));
            btAñadir.setBackground(new Color(50, 205, 50));
            btAñadir.setMnemonic('A');
            btAñadir.setPreferredSize(new java.awt.Dimension(100, 40)); // Ajustar el tamaño preferido
        }
        return btAñadir;
    }
    
    

    public JButton getBtEliminar() {
        if (btEliminar == null) {
            btEliminar = new JButton("Eliminar");
            btEliminar.setEnabled(false);
            btEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
            btEliminar.setForeground(new Color(255, 255, 255));
            btEliminar.setBackground(new Color(50, 205, 50));
            btEliminar.setMnemonic('E');
            btEliminar.setPreferredSize(new java.awt.Dimension(100, 40)); // Ajustar el tamaño preferido
        }
        return btEliminar;
    }
}
