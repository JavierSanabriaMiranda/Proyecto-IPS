package backend.data.productos;

public class ProductoDTO {
    private String codigo;
    private String tipo;
    private String nombre;
    private float precio;
    private int unidades;
    private String codigoCompra;

    // Constructor
    public ProductoDTO(String codigo, String tipo, String nombre, float precio, int unidades, String codigoCompra) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.codigoCompra = codigoCompra;
    }

    public ProductoDTO(String codProducto, String tipo, String nombre,float precio) {
    	this.codigo = codProducto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
	}

	// Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }

    public String getCodigoCompra() { return codigoCompra; }
    public void setCodigoCompra(String codigoCompra) { this.codigoCompra = codigoCompra; }
}

