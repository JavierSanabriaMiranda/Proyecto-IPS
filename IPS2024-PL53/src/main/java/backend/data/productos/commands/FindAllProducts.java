package backend.data.productos.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.productos.ProductoDTO;

public class FindAllProducts {
    private static final String QUERY = "SELECT * FROM PRODUCTO";
    private Database db = new Database();

    public List<ProductoDTO> execute() throws SQLException {
        List<ProductoDTO> productos = new ArrayList<>();
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                ProductoDTO producto = new ProductoDTO(
                    rs.getString("CODPRODUCTO"),
                    rs.getString("TIPO"),
                    rs.getString("NOMBRE"),
                    rs.getFloat("PRECIO")
                );
                productos.add(producto);
            }
        }
        return productos;
    }
}
