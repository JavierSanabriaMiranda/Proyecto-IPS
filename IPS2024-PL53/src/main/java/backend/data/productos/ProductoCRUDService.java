package backend.data.productos;

import java.util.List;

import backend.data.productos.dtos.CompraProductoDTO;
import backend.data.productos.dtos.MerchandisingDTO;
import backend.data.productos.dtos.ProductoDTO;
import backend.data.productos.dtos.VentaDto;

public interface ProductoCRUDService {
    List<ProductoDTO> findAllProducts();
	void addVenta(VentaDto ventaDTO);
	void addMerchandising(MerchandisingDTO merchandisingDTO);
	void addOrderProducts(CompraProductoDTO compraProductoDTO);
	List<ProductoDTO> getFilterProducts(String filter);
}

