package backend.data.productos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.productos.ProductoDTO;

public class FindProductsByMerchanId {
    private static final String QUERY = "SELECT p.NOMBRE, p.PRECIO, cp.UNIDADES "
            + "FROM PRODUCTO p, COMPRA_PRODUCTO cp "
            + "WHERE p.CODPRODUCTO = cp.CODPRODUCTO AND cp.CODCOMPRA = ?";
    
    private Database db = new Database();
    private String id;
    
    public FindProductsByMerchanId(String id) {
        this.id = id;
    }

    public List<ProductoDTO> execute() throws SQLException {
        List<ProductoDTO> productos = new ArrayList<>();
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {
            
            pst.setString(1, id);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    ProductoDTO producto = new ProductoDTO(
                        rs.getString("NOMBRE"),
                        rs.getFloat("PRECIO"),
                        rs.getInt("UNIDADES")
                    );
                    productos.add(producto);
                }
            }
        }
        return productos;
    }
}

