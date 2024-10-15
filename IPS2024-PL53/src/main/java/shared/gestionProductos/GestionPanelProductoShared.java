package shared.gestionProductos;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;

import backend.service.ventas.merchandising.Producto;
import frontend.SwingUtil;
import frontend.merchandisingUI.PanelProducto;

public class GestionPanelProductoShared {
	private PanelProducto view;
	private Producto producto;
	private GestionProductoShared gps;
	
	public GestionPanelProductoShared(PanelProducto v,GestionProductoShared gps, Producto producto) {
		this.view = v;
		this.gps = gps;
		this.producto= producto;
	}
	
	public void initController() {
		view.addComponentListener(new ComponentAdapter() { 
			@Override
			public void componentResized(ComponentEvent e) {
				SwingUtil.exceptionWrapper(() -> associateImagesToPanel());
			}
		});
		
		view.getBtAñadir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> addProducto()));
		
		view.getBtEliminar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionEliminar()));
	}
	
	private void addProducto() {
		gps.getVentaMerchandising().add(producto);
        gps.getVp().getCarritoTextArea().setText(gps.getVentaMerchandising().toString());
        gps.getVp().getTxtPrice().setText(gps.getVentaMerchandising().getPrecioTotal()+ "€");
        gps.getVp().getBtnNext1().setEnabled(true);
        view.getBtEliminar().setEnabled(true);
	}
	
	private void accionEliminar() {
		gps.getVentaMerchandising().remove(producto);
    	gps.getVp().getCarritoTextArea().setText(gps.getVentaMerchandising().toString());
    	if(gps.getVentaMerchandising().contarUnidades(producto)==0) {
    		view.getBtEliminar().setEnabled(false);
    	}
        if (gps.getVentaMerchandising().getProductos().size() == 0) {
        	gps.getVp().getTxtPrice().setText("");
        	gps.getVp().getBtnNext1().setEnabled(false);
            
        } else {
        	gps.getVp().getTxtPrice().setText(gps.getVentaMerchandising().getPrecioTotal()+ "€");
        }
    }
	
	private void associateImagesToPanel() {
        adaptImage("/img/" + producto.getCode() + ".jpg");
    }
	
	private void adaptImage(String imagePath) {
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
        view.getLbArticulo().setIcon(new ImageIcon(scaledImage));
        
        // Establecer el tamaño fijo del JLabel para que coincida con la imagen
        view.getLbArticulo().setPreferredSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
        view.getLbArticulo().setMinimumSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
        view.getLbArticulo().setMaximumSize(new java.awt.Dimension(MAX_WIDTH, MAX_HEIGHT));
    }

}
