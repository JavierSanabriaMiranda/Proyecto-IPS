package backend.data.productos;

import java.util.List;

public interface ProductoCRUDService {
    List<ProductoDTO> findAllProducts();
	void addOrderProducts(CompraProductoDTO compraProductoDTO);
	List<ProductoDTO> getFilterProducts(String filter);
	List<ProductoDTO> findProductsByMerchanId(String id);
}

