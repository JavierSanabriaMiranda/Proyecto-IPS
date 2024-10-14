package backend.data.ventas.commands;

import java.sql.Connection;
import java.sql.Date; // Importar java.sql.Date para convertir las fechas correctamente
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class FindVentasFechas {
    private static final String QUERY = "SELECT FECHA, COSTE "
            + "FROM VENTAS "
            + "WHERE FECHA BETWEEN ? AND ?";

    private Database db = new Database();
    private java.util.Date inicio;
    private java.util.Date fin;

    public FindVentasFechas(java.util.Date inicio, java.util.Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public List<VentaDto> execute() throws SQLException {
        List<VentaDto> ventas = new ArrayList<>();

        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {
            
            // Convertimos las fechas de java.util.Date a java.sql.Date
            pst.setDate(1, new Date(inicio.getTime()));
            pst.setDate(2, new Date(fin.getTime()));

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    VentaDto venta = new VentaDto(
                        rs.getDate("FECHA"),
                        rs.getFloat("COSTE") // Cambié "PRECIO" a "COSTE" para que coincida con la consulta
                    );
                    ventas.add(venta);
                }
            }
        }
        return ventas;
    }
}
