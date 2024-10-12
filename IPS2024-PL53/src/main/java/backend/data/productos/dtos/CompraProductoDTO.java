package backend.data.productos.dtos;

import java.util.List;

public class CompraProductoDTO {
	private List<ProductoDTO> productos;
	private String codCompra;
	
	public CompraProductoDTO(List<ProductoDTO> orderList, String cod_compra) {
		this.setProductos(orderList);
		this.setCodCompra(cod_compra);
	}

	public List<ProductoDTO> getProductos() {return productos;}
	public void setProductos(List<ProductoDTO> productos) {this.productos = productos;}

	public String getCodCompra() {return codCompra;}
	public void setCodCompra(String codCompra) {this.codCompra = codCompra;}

	

}
