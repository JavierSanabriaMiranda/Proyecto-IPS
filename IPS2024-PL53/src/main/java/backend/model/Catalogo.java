package backend.model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Producto> listaProductos = null;
	private List<Producto> listaProductosTipo;

	/**
     * constructor de la clase Carta. Se encarga de inicializar una lista de objetos Producto
	 * y llama al metodo cargarProductos()
     */
	public Catalogo() {
		listaProductos = new ArrayList<Producto>();
		listaProductosTipo = new ArrayList<Producto>();
		cargarProductos();
	}

	/**
	 * metodo que se encarga de cargar los Productos leyendolos del fichero de texto que los contiene.
	 */
	private void cargarProductos() {
		//TO DO
	}

	/**
	 * metodo que devuelve un array de objetos Producto con todos los Productos del menu.
	 * 
	 * @return array de todos los Productos.
	 */
	public Producto[] getProductos() {
		Producto[] Productos = listaProductos.toArray(new Producto[listaProductos.size()]);
		return Productos;
	}
	
	
	/*
	 * Metodo que devuelve todos los productos de un tipo pasado por parametro
	 */
	public Producto[] getProductos(String tipo) {
		listaProductosTipo.clear();
		for(Producto product : listaProductos) {
			if(product.getTipo().equals(tipo)) {
				listaProductosTipo.add(product);
			}
		}
		return listaProductosTipo.toArray(new Producto[listaProductosTipo.size()]);
	}
		

}
