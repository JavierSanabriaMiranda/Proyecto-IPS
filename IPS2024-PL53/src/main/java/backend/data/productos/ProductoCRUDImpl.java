package backend.data.productos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.productos.commands.AddAllOrderProducts;
import backend.data.productos.commands.FilterProductos;
import backend.data.productos.commands.FindAllProducts;

public class ProductoCRUDImpl implements ProductoCRUDService {

    @Override
    public List<ProductoDTO> findAllProducts() {
        List<ProductoDTO> res = new ArrayList<>();
        try {
            res = new FindAllProducts().execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void addOrderProducts(CompraProductoDTO compraProductoDTO) {
        try {
            new AddAllOrderProducts(compraProductoDTO).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductoDTO> getFilterProducts(String filter) {
    	List<ProductoDTO> res = new ArrayList<>();
    	try {
            res = new FilterProductos(filter).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return res;
    }
}
