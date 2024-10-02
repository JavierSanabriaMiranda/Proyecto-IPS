package backend.model;


public class Producto {

	private String codigo;
	private String tipo;
	private String nombre;
	private float precio;

	/**
	 * constructor de la clase producto.
	 * 
	 * @param codigo, codigo de pedido, de tipo String
	 * @param tipo, tipo de producto, de tipo String
	 * @param nombre, nombe del producto, de tipo String
	 * @param precio, precio del producto, de tipo float
	 */
	public Producto(String codigo, String tipo, String nombre, float precio) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * otro constructor de la clase producto.
	 * 
	 * @param otroProducto, producto.
	 */
	public Producto(Producto otroProducto) {
		this(otroProducto.codigo, otroProducto.tipo, otroProducto.nombre, otroProducto.precio);
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
	 * metodo que imprime un producto con un formato especial.
	 */
	@Override
	public String toString() {
		return this.tipo + " - " + this.nombre + " - " + this.precio + " €";
	}
	
}
