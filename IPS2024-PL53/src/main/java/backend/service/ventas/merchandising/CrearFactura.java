package backend.service.ventas.merchandising;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class CrearFactura {

    public static void crearFactura(String filePath, String codCompra, String clienteEmail, List<Producto> productos, float totalPedido) {
        try {
            // Crear documento PDF
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            
            // Abrir el documento para escribir en él
            document.open();
            
            // Añadir fecha en la parte superior derecha
            Paragraph fecha = new Paragraph(""+java.time.LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 11));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            document.add(fecha);
            
            // Añadir imagen (logo)
            Image logo = Image.getInstance("src/main/resources/img/productos/logo.jpg");
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_LEFT);
            document.add(logo);
            
            // Espacio
            document.add(Chunk.NEWLINE);
            
            // Título de la tienda
            Paragraph titulo = new Paragraph("TIENDA BURGOS FC", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            titulo.setAlignment(Element.ALIGN_LEFT);
            document.add(titulo);
            
            // Información de la tienda
            document.add(new Paragraph("Universidad de Oviedo", FontFactory.getFont(FontFactory.HELVETICA, 12)));
            document.add(new Paragraph("Email: tiendaburgosfc@gmail.com", FontFactory.getFont(FontFactory.HELVETICA, 12)));
            document.add(new Paragraph("NIF: 12345678A", FontFactory.getFont(FontFactory.HELVETICA, 12))); // NIF de ejemplo
            document.add(new Paragraph("Domicilio Fiscal:  Calle Valdés Salas, 11, 33007 Oviedo, Asturias", FontFactory.getFont(FontFactory.HELVETICA, 12)));

            // Espacio
            document.add(Chunk.NEWLINE);
            
            // Información del cliente
            Paragraph clienteInfo = new Paragraph("Cliente: " + clienteEmail, FontFactory.getFont(FontFactory.HELVETICA, 12));
            clienteInfo.setAlignment(Element.ALIGN_RIGHT);
            document.add(clienteInfo);
            
            // Línea separadora
            document.add(new Chunk(new LineSeparator()));
            document.add(Chunk.NEWLINE);
            
            // Encabezado "Artículos:"
            Paragraph articulosHeader = new Paragraph("Artículos:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13));
            articulosHeader.setAlignment(Element.ALIGN_LEFT);
            document.add(articulosHeader);
            
            // Espacio
            document.add(Chunk.NEWLINE);
            
            // Crear tabla de productos con diseño elegante
            PdfPTable table = new PdfPTable(4); // 4 columnas: Producto, Unidades, Precio, Total
            table.setWidthPercentage(90); // Ancho de la tabla al 90%
            
            // Definir anchos de las columnas
            float[] columnWidths = {5f, 2f, 2f, 2f};
            table.setWidths(columnWidths);
            
            // Estilizar las celdas de cabecera
            table.addCell(crearCabecera("Producto"));
            table.addCell(crearCabecera("Unidades"));
            table.addCell(crearCabecera("Precio"));
            table.addCell(crearCabecera("Total"));

            // Añadir productos a la tabla
            for (Producto producto : productos) {
                table.addCell(crearCelda("                     "+producto.getName(),true));
                table.addCell(crearCelda(""+producto.getUnits(),false));
                table.addCell(crearCelda(String.format("%.2f €", producto.getPrice()),false));
                table.addCell(crearCelda(String.format("%.2f €", producto.getUnits() * producto.getPrice()),false));
            }
            
            // Añadir la tabla al documento
            document.add(table);
            
            // Espacio
            document.add(Chunk.NEWLINE);
            
            // Línea separadora antes del total
            document.add(new Chunk(new LineSeparator()));
            
            // Total del pedido como pie de página
            Paragraph total = new Paragraph("Total del pedido: " + String.format("%.2f €", totalPedido), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);
            
            // Cerrar el documento
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static PdfPCell crearCabecera(String texto) {
    	PdfPCell headerCell;
        headerCell = new PdfPCell(new Paragraph(texto, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11)));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBorderWidth(0);
        headerCell.setPaddingBottom(10);
        
        return headerCell;
    }
    
    private static PdfPCell crearCelda(String texto,boolean isFirstCelda) {
    	PdfPCell cell;
    	cell = new PdfPCell(new Paragraph(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
    	if(!isFirstCelda)
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidth(0);
        cell.setPaddingBottom(5);
        
        return cell;
    }
}
