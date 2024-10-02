package backend.model;


public class Producto {

	private String codigo;
	private String tipo;
	private String nombre;
	private float precio;
	private int unidades;

	/**
	 * constructor de la clase producto.
	 * 
	 * @param codigo, codigo de pedido, de tipo String
	 * @param tipo, tipo de producto, de tipo String
	 * @param nombre, nombe del producto, de tipo String
	 * @param precio, precio del producto, de tipo float
	 * @param unidades, unidades del producto, de tipo int
	 */
	public Producto(String codigo, String tipo, String nombre, float precio, int unidades) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
	}

	/**
	 * otro constructor de la clase producto.
	 * 
	 * @param otroProducto, producto.
	 */
	public Producto(Producto otroProducto) {
		this(otroProducto.codigo, otroProducto.tipo, otroProducto.nombre, otroProducto.precio,otroProducto.unidades);
	}
	
	/**
	 * devuelve el tipo del producto
	 * 
	 * @return String del tipo del producto
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * devuelve la nombre del producto
	 * 
	 * @return String de la nombre del producto
	 */
	public String getnombre() {
		return nombre;
	}

	/**
	 * inicializa el valor de la nombre
	 * 
	 * @param nombre
	 */
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo que devuelve el precio del producto
	 * 
	 * @return precio del producto de tipo float.
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * metodo que inicializa el valor de los productos
	 * 
	 * @param precio, valor del producto.
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * metodo que devuelve el codigo de pedido
	 * 
	 * @return codigo de pedido, de tipo String
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * metodo que inicializa el valor del codigo
	 * 
	 * @param codigo, codigo del producto
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * metodo que devuelve el numero de unidades pedidas de un articulo
	 * 
	 * @return numero de unidades, de tipo int
	 */
	public int getUnidades() {
		return unidades;
	}
	
	/**
	 * metodo que inicializa el numero de unidades
	 * 
	 * @param unidades, unidades del articulo pedido
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/**
	 * metodo que imprime un producto con un formato especial.
	 */
	@Override
	public String toString() {
		String strProducto;
		strProducto = this.tipo + " - " + this.nombre + " - " + this.precio + " €";
		if (this.unidades != 0) {
			strProducto += " (" + this.unidades + " uds." + ")";
		}
		return strProducto;
	}
	
}
