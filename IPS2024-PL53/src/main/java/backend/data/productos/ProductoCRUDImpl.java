package backend.data.productos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.productos.commands.AddAllOrderProducts;
import backend.data.productos.commands.FilterProductos;
import backend.data.productos.commands.FindAllProducts;
import backend.data.productos.commands.FindProductsByMerchanId;
import backend.util.log.LogManager;

public class ProductoCRUDImpl implements ProductoCRUDService {

    @Override
    public List<ProductoDTO> findAllProducts() {
        List<ProductoDTO> res = new ArrayList<>();
        try {
        	LogManager.logAction("Acceso a Base de Datos. Tabla: PRODUCTO");
            res = new FindAllProducts().execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void addOrderProducts(CompraProductoDTO compraProductoDTO) {
        try {
        	LogManager.logAction("Modificación en Base de Datos. Tabla: COMPRA_PRODUCTO");
            new AddAllOrderProducts(compraProductoDTO).execute();
        } catch (SQLException e) {
            System.err.println("Error al añadir productos a la base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public List<ProductoDTO> getFilterProducts(String filter) {
    	List<ProductoDTO> res = new ArrayList<>();
    	try {
    		LogManager.logAction("Acceso a Base de Datos. Tabla: PRODUCTO");
            res = new FilterProductos(filter).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return res;
    }

	@Override
	public List<ProductoDTO> findProductsByMerchanId(String id) {
		List<ProductoDTO> res = new ArrayList<>();
    	try {
    		LogManager.logAction("Acceso a Base de Datos. Tabla: PRODUCTO");
            res = new FindProductsByMerchanId(id).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return res;
	}
}
