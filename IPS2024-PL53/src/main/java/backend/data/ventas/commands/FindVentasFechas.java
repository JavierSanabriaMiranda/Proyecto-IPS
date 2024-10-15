package backend.data.ventas.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class FindVentasFechas {
    private static final String QUERY = "SELECT FECHA, COSTE, ID_VENTAS FROM VENTAS WHERE FECHA BETWEEN ? AND ?";
    
    private Database db = new Database();
    private Date inicio;
    private Date fin;
    
    public FindVentasFechas(Date inicio, Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public List<VentaDto> execute() throws SQLException {
        List<VentaDto> ventas = new ArrayList<>();
        
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement(QUERY)) {
             
            pst.setDate(1, new java.sql.Date(inicio.getTime()));
            pst.setDate(2, new java.sql.Date(fin.getTime()));
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String idVenta = rs.getString("ID_VENTAS");
                    Date fecha = rs.getDate("FECHA");
                    float coste = rs.getFloat("COSTE");
                    String tipoVenta = obtenerTipoVenta(idVenta);
                    
                    VentaDto venta = new VentaDto(idVenta, fecha, coste, tipoVenta);
                    ventas.add(venta);
                }
            }
        }
        return ventas;
    }
    
    private String obtenerTipoVenta(String idVenta) throws SQLException {
        // Comprobar en COMPRA_MERCHANDISING
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement("SELECT 1 FROM COMPRA_MERCHANDISING WHERE CODCOMPRA = ?")) {
            pst.setString(1, idVenta);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "Merchandising";
                }
            }
        }

        // Comprobar en ABONO_TEMPORADA
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement("SELECT 1 FROM ABONO_TEMPORADA WHERE CODABONO = ?")) {
            pst.setString(1, idVenta);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "Abono de Temporada";
                }
            }
        }

        // Comprobar en CAMPAÑA_ACCIONISTA
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement("SELECT 1 FROM CAMPAÑA_ACCIONISTA WHERE CODACCIONISTA = ?")) {
            pst.setString(1, idVenta);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "Campaña Accionista";
                }
            }
        }
        
        // Comprobar en ENTRADA
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement("SELECT 1 FROM ENTRADA WHERE COD_ENTRADA = ?")) {
            pst.setString(1, idVenta);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "Entrada";
                }
            }
        }
        
        // Comprobar en RESERVA DE INSTALACIONES
        try (Connection c = db.getConnection();
             PreparedStatement pst = c.prepareStatement("SELECT 1 FROM RESERVA WHERE COD_RESERVA = ?")) {
            pst.setString(1, idVenta);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "Reserva de Instalaciones";
                }
            }
        }
        
        return "Otro";
    }
}

