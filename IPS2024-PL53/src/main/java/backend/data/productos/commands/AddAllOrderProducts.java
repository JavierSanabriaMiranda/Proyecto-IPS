package backend.data.productos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import backend.data.Database;
import backend.data.productos.CompraProductoDTO;
import backend.data.productos.ProductoDTO;

public class AddAllOrderProducts {
    private static final String QUERY = "INSERT INTO COMPRA_PRODUCTO VALUES (?, ?, ?)";
    private Database db = new Database();
    private List<ProductoDTO> orderList;
    private String codCompra;

    public AddAllOrderProducts(CompraProductoDTO compraProductoDTO) {
    	this.orderList = compraProductoDTO.getProductos();
        this.codCompra = compraProductoDTO.getCodCompra();
	}

	public void execute() throws SQLException {
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {

            for (ProductoDTO producto : orderList) {
                pst.setInt(1, producto.getUnidades());
                pst.setString(2, codCompra);
                pst.setString(3, producto.getCodigo());
                pst.executeUpdate();
            }
        }
    }
}
