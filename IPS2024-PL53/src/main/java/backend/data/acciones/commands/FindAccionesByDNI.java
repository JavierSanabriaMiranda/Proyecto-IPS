package backend.data.acciones.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.acciones.AccionDTO;

public class FindAccionesByDNI {
private static final String QUERY = "SELECT ID_ACCION FROM ACCION, ACCIONISTA WHERE "
		+ "accion.ID_ACCIONISTA=accionista.ID_ACCIONISTA AND DNI=?";
    
    private Database db = new Database();
    
    private String DNI;
    
    public FindAccionesByDNI(String DNI) {
    	this.DNI=DNI;
    }

    public List<AccionDTO> execute() throws SQLException {
        List<AccionDTO> acciones = new ArrayList<>();
        
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {
            
            pst.setString(1, DNI);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    AccionDTO accion = new AccionDTO(
                        rs.getString("ID_ACCION")
                    );
                    acciones.add(accion);
                }
            }
        }
        
        return acciones;
    }
}
