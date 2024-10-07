package backend.model;

import java.util.ArrayList;
import java.util.List;

import backend.util.FileUtil;

public class Catalogo {

	private static final String PRODUCTS_FILE = "files/products.dat";
	private List<Producto> productos = null;
	private List<Producto> productosTipo = null;

	public Catalogo() {
		productos = new ArrayList<Producto>();
		productosTipo = new ArrayList<Producto>();
		this.loadProducts();
	}

	private void loadProducts() {
		FileUtil.loadFile(PRODUCTS_FILE, productos);
	}

	public Producto[] getProducts() {
		Producto[] p = productos.toArray(new Producto[productos.size()]);
		return p;
	}

	public Producto[] getProductsByType() {
		Producto[] p = productosTipo.toArray(new Producto[productosTipo.size()]);
		return p;
	}
	
	public Producto[] filterByType(String type) {
		productosTipo.clear();
		for (Producto producto: this.productos)
			if(producto.getType().equals(type))
				productosTipo.add(producto);
		return getProductsByType();
	}

}
