package shared.gestionProductos;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.productos.ProductoCRUDService;
import backend.data.productos.dtos.CompraProductoDTO;
import backend.data.productos.dtos.MerchandisingDTO;
import backend.data.productos.dtos.ProductoDTO;
import backend.data.productos.dtos.VentaDto;
import backend.service.ventas.merchandising.Producto;
import backend.service.ventas.merchandising.VentaMerchandising;
import frontend.SwingUtil;
import frontend.merchandisingUI.PanelProducto;
import frontend.merchandisingUI.VentanaPrincipal;

public class GestionProductoShared {
	private ProductoCRUDService model;
	private VentanaPrincipal view;
	private VentaMerchandising ventaMerchandising;
	private List <Producto> catalogo;
	
	public GestionProductoShared(ProductoCRUDService m, VentanaPrincipal v) {
		this.model = m;
		this.view = v;
		this.catalogo = new ArrayList<Producto>();
		
		model = CreadorDataService.getproductoService();

		this.initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getBtnCancel().addActionListener(e -> SwingUtil.exceptionWrapper(() -> initView()));
		
		view.getBtnNext1().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionSiguiente1()));
		
		view.getBtnPrevious2().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn1()));
		
		view.getBtnNext2().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn3()));
		
		view.getBtTodos().addActionListener(e -> SwingUtil.exceptionWrapper(() -> createProductPanels(model.findAllProducts())));
		
		view.getBtEquipaciones().addActionListener(e -> SwingUtil.exceptionWrapper(() -> createProductPanels(model.getFilterProducts("equipacion"))));
		
		view.getBtModaTextil().addActionListener(e -> SwingUtil.exceptionWrapper(() -> createProductPanels(model.getFilterProducts("moda textil"))));
		
		view.getBtAccesorios().addActionListener(e -> SwingUtil.exceptionWrapper(() -> createProductPanels(model.getFilterProducts("accesorio"))));
		
		view.getBtnFinish().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionFinal()));
	}

	public void initView() {
		ventaMerchandising = new VentaMerchandising();
		loadProductsBBDD();
		view.getTxtPrice().setText("");
		view.getCarritoTextArea().setText("");
		view.getBtnNext1().setEnabled(false);
		createProductPanels(model.findAllProducts());

		showPn1();
	}
	
	private void showPn1() {
		view.getPnInfo1().add(view.getPnOrder());
		view.getPnBts1().add(view.getTxtPrice(), 0);
		((CardLayout) view.getPnContents().getLayout()).show(view.getPnContents(), "pn1");
	}
	
	private void showPn2() {
		view.getPnBts2().add(view.getTxtPrice(), 0);
		((CardLayout) view.getPnContents().getLayout()).show(view.getPnContents(), "pn2");
	}
	
	private void showPn3() {
		((CardLayout) view.getPnContents().getLayout()).show(view.getPnContents(), "pn3");
		
	}
	
	private void accionSiguiente1() {
		view.getTaResumenPedido().setText(ventaMerchandising.toString());
		showPn2();
	}
	
	private void accionFinal() {
		initView();
		List<ProductoDTO> list = new ArrayList<ProductoDTO>();
		for(Producto p : ventaMerchandising.getProductos()) {
			list.add(new ProductoDTO(p.getCode(), p.getType(), p.getName(), p.getPrice()));
		}
		saveOrder(list,ventaMerchandising.getCodCompra(),
				ventaMerchandising.getFechaCompra(),ventaMerchandising.getPrecioTotal());
	}

	private void createProductPanels(List<ProductoDTO> productos) {
	    // Limpiar el panel de productos
	    view.getPnProductos().removeAll();  // Limpiar el panel de productos, no el JScrollPane

	    // Generar y agregar los productos al panel
	    for (ProductoDTO p : productos) {
	    	Producto producto = new Producto(p.getCodigo(),p.getTipo(),p.getNombre(),p.getPrecio(),p.getUnidades());
	    	PanelProducto pn = new PanelProducto(producto);
	    	GestionPanelProductoShared gp = new GestionPanelProductoShared(pn, this, producto);
	    	gp.initController();
	        view.getPnProductos().add(pn);
	    }

	    // Refrescar la vista para que Swing actualice correctamente
	    view.getPnProductos().revalidate();
	    view.getPnProductos().repaint();
	}
	
	public void loadProductsBBDD() {			 
		 loadProducts(model.findAllProducts());
	}

	private void loadProducts(List<ProductoDTO> listaProductos) {
		for(ProductoDTO p : listaProductos) {
			catalogo.add(new Producto(p.getCodigo(),p.getTipo(),p.getNombre(),p.getPrecio(),p.getUnidades()));
		}	
	}
	
	public void saveOrder(List<ProductoDTO> orderList,String cod_compra, Date fecha, Float precio) {
		model.addVenta(new VentaDto(cod_compra,null,fecha,precio));
		model.addMerchandising(new MerchandisingDTO(cod_compra));
		model.addOrderProducts(new CompraProductoDTO(orderList,cod_compra));
	}
	
	public VentaMerchandising getVentaMerchandising() {
		return this.ventaMerchandising;
	}
	
	public VentanaPrincipal getVp() {
		return this.view;
	}
}
