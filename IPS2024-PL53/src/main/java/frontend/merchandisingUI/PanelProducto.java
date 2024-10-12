package frontend.merchandisingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import backend.model.Producto;

public class PanelProducto extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel panelArticulo;
    private JLabel lbArticulo;
    private JPanel panelBotones;
    private JPanel panelUnidades;
    private JLabel lblNewLabel;
    private JButton btAñadir;
    private JButton btEliminar;
    private JSpinner spUnidades;
    private Producto producto;
    private VentanaPrincipal vp;

    public PanelProducto(Producto producto, VentanaPrincipal vp) {
        this.producto = producto;
        this.vp = vp;
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(getPanelArticulo(), BorderLayout.CENTER);
        this.add(getPanelBotones(), BorderLayout.EAST);
        
        // Agregamos el ComponentAdapter para redimensionar las imñgenes
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                associateImagesToPanel();
            }
        });
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

    private JLabel getLbArticulo() {
        if (lbArticulo == null) {
            lbArticulo = new JLabel("");
            lbArticulo.setFont(new Font("Tahoma", Font.BOLD, 12));
            lbArticulo.setForeground(new Color(0, 0, 0));
            lbArticulo.setText(producto.toString());
            lbArticulo.setIcon(new ImageIcon(PanelProducto.class.getResource("/img/" + producto.getCode() + ".jpg")));
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
            subPanelBotones.setLayout(new GridLayout(1, 3, 0, 0)); // 1 fila, 3 columnas
            subPanelBotones.setBackground(Color.WHITE);

            // Añadir los componentes al subpanel
            subPanelBotones.add(getPanelUnidades());
            subPanelBotones.add(getBtAñadir());
            subPanelBotones.add(getBtEliminar());

            // Ajustar el tamaño preferido del subpanel para hacerlo mñs ancho y menos alto
            subPanelBotones.setPreferredSize(new java.awt.Dimension(300, 40)); // Mñs ancho (300 px), menos alto (40 px)

            // Añadimos el subpanel al panel principal de botones
            panelBotones.add(subPanelBotones, BorderLayout.CENTER);
        }
        return panelBotones;
    }

    private JPanel getPanelUnidades() {
        if (panelUnidades == null) {
            panelUnidades = new JPanel();
            panelUnidades.setBackground(Color.WHITE);
            panelUnidades.setLayout(new BorderLayout(0, 0));
            panelUnidades.add(getLblNewLabel(), BorderLayout.NORTH);
            panelUnidades.add(getSpUnidades(), BorderLayout.CENTER);
        }
        return panelUnidades;
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("Unidades:");
            lblNewLabel.setLabelFor(getSpUnidades());
            lblNewLabel.setDisplayedMnemonic('U');
        }
        return lblNewLabel;
    }

    private JButton getBtAñadir() {
        if (btAñadir == null) {
            btAñadir = new JButton("A\u00F1adir");
            btAñadir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accionAñadir();
                }
            });
            btAñadir.setFont(new Font("Tahoma", Font.BOLD, 12));
            btAñadir.setForeground(new Color(255, 255, 255));
            btAñadir.setBackground(new Color(50, 205, 50));
            btAñadir.setMnemonic('A');
            btAñadir.setPreferredSize(new java.awt.Dimension(100, 40)); // Ajustar el tamaño preferido
        }
        return btAñadir;
    }
    
    private void accionAñadir() {
		vp.getMerchandising().addProduct(producto, (Integer) spUnidades.getValue());
        vp.ponerTextoCarrito(vp.getMerchandising().orderToString());
        vp.ponerTextoPrecio(vp.getMerchandising().getPrecio() + " €");
        vp.mostarSiguiente(true);
        getBtEliminar().setEnabled(true);
	}

    private JButton getBtEliminar() {
        if (btEliminar == null) {
            btEliminar = new JButton("Eliminar");
            btEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accionEliminar();
                }
            });
            btEliminar.setEnabled(false);
            btEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
            btEliminar.setForeground(new Color(255, 255, 255));
            btEliminar.setBackground(new Color(50, 205, 50));
            btEliminar.setMnemonic('E');
            btEliminar.setPreferredSize(new java.awt.Dimension(100, 40)); // Ajustar el tamaño preferido
        }
        return btEliminar;
    }
    
    private void accionEliminar() {
    	vp.getMerchandising().removeProduct(producto, (Integer) spUnidades.getValue());
        vp.ponerTextoCarrito(vp.getMerchandising().orderToString());
        if (vp.getMerchandising().getOrder().size() == 0) {
            vp.ponerTextoPrecio("");
            vp.mostarSiguiente(false);
            getBtEliminar().setEnabled(false);
        } else {
            vp.ponerTextoPrecio(vp.getMerchandising().getPrecio() + " €");
        }
    }

    private JSpinner getSpUnidades() {
        if (spUnidades == null) {
            spUnidades = new JSpinner();
            spUnidades.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        }
        return spUnidades;
    }

    private void associateImagesToPanel() {
        adaptImage(getLbArticulo(), "/img/" + producto.getCode() + ".jpg");
    }

    private void adaptImage(JLabel label, String imagePath) {
        // Definir el tamaño deseado para las imñgenes
        final int MAX_WIDTH = 150;  // Ancho mñximo para las imñgenes
        final int MAX_HEIGHT = 150; // Alto mñximo para las imñgenes
        
        // Cargar la imagen original
        ImageIcon tmpImagen = new ImageIcon(getClass().getResource(imagePath));
        
        // Obtener las dimensiones de la imagen original
        int imageWidth = tmpImagen.getIconWidth();
        int imageHeight = tmpImagen.getIconHeight();
        
        // Calcular el factor de escalado para mantener proporciones
        float scale = Math.min((float) MAX_WIDTH / imageWidth, (float) MAX_HEIGHT / imageHeight);
        
        // Nuevas dimensiones escaladas
        int newWidth = (int) (imageWidth * scale);
        int newHeight = (int) (imageHeight * scale);
        
        // Escalar la imagen
        Image scaledImage = tmpImagen.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        // Asignar la imagen escalada al JLabel
        label.setIcon(new ImageIcon(scaledImage));
        
        // Establecer el tamaño fijo del JLabel para que coincida con la imagen
        label.setPreferredSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
        label.setMinimumSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
        label.setMaximumSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
    }
}
