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
    private static final String QUERY = "SELECT producto.CODPRODUCTO, PRECIO, UNIDADES " 
    		+ "FROM PRODUCTO, COMPRA_PRODUCTO " 
    		+ "WHERE producto.CODPRODUCTO = compra_producto.CODPRODUCTO AND CODCOMPRA = ?";

    
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
                	String cod = rs.getString("CODPRODUCTO");
                    float precio = rs.getFloat("PRECIO");
                    int unidades = rs.getInt("UNIDADES");
                    
                    String nombre = obtenerNombre(cod);
                    productos.add(new ProductoDTO(nombre,precio,unidades));
                }
            }
        }
        return productos;
    }

	private String obtenerNombre(String cod) throws SQLException{
		 final String QUERY2 = "SELECT NOMBRE FROM PRODUCTO WHERE CODPRODUCTO=?";
		 
		 try (Connection c = db.getConnection();
	             PreparedStatement pst = c.prepareStatement(QUERY2)) {
	            pst.setString(1, cod);
	            try (ResultSet rs = pst.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getString("NOMBRE");
	                }
	            }
	        }
		 
		 return "No se encontro el nombre";
	}
}

