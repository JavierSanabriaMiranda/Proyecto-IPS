package backend.service.ventas.merchandising;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
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

    public static void crearFactura(String filePath, String codCompra, String clienteEmail,
                                     String clienteDNI, String clienteNombre, String clienteDomicilio, List<Producto> productos, float precioBase) {
        try {
            // Crear documento PDF
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            // Abrir el documento para escribir en él
            document.open();

            // Añadir fecha en la parte superior derecha
            Paragraph fecha = new Paragraph("" + java.time.LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 11));
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
            document.add(new Paragraph("Domicilio Fiscal: Calle Valdés Salas, 11, 33007 Oviedo, Asturias", FontFactory.getFont(FontFactory.HELVETICA, 12)));

            // Espacio
            document.add(Chunk.NEWLINE);

            // Información del cliente
            Paragraph infoCliente = new Paragraph("Información del Cliente:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            infoCliente.setAlignment(Element.ALIGN_RIGHT);
            document.add(infoCliente);
            Paragraph nombre = new Paragraph("Nombre: " + clienteNombre, FontFactory.getFont(FontFactory.HELVETICA, 12));
            nombre.setAlignment(Element.ALIGN_RIGHT);
            document.add(nombre);
            Paragraph dni = new Paragraph("DNI: " + clienteDNI, FontFactory.getFont(FontFactory.HELVETICA, 12));
            dni.setAlignment(Element.ALIGN_RIGHT);
            document.add(dni);
            Paragraph email = new Paragraph("Email: " + clienteEmail, FontFactory.getFont(FontFactory.HELVETICA, 12));
            email.setAlignment(Element.ALIGN_RIGHT);
            document.add(email);
            Paragraph domicilio = new Paragraph("Domicilio: " + clienteDomicilio, FontFactory.getFont(FontFactory.HELVETICA, 12));
            domicilio.setAlignment(Element.ALIGN_RIGHT);
            document.add(domicilio);

            // Espacio
            document.add(Chunk.NEWLINE);

            // Línea separadora
            document.add(new Chunk(new LineSeparator()));
            document.add(Chunk.NEWLINE);

            // Encabezado "Artículos:"
            Paragraph articulosHeader = new Paragraph("Artículos:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13));
            articulosHeader.setAlignment(Element.ALIGN_LEFT);
            document.add(articulosHeader);

            // Espacio
            document.add(Chunk.NEWLINE);

            // Crear tabla de productos sin líneas visibles
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

            // Añadir productos a la tabla con alternancia de colores
            boolean colorAlternado = false;
            for (Producto producto : productos) {
                BaseColor colorFila = colorAlternado ? new BaseColor(240, 240, 240) : BaseColor.WHITE; // Color alternado
                table.addCell(crearCelda(producto.getName(), colorFila));
                table.addCell(crearCelda("" + producto.getUnits(), colorFila));
                table.addCell(crearCelda(String.format("%.2f €", producto.getPrice()), colorFila));
                table.addCell(crearCelda(String.format("%.2f €", producto.getUnits() * producto.getPrice()), colorFila));
                colorAlternado = !colorAlternado; // Cambiar color
            }

            // Añadir la tabla al documento
            document.add(table);

            // Espacio
            document.add(Chunk.NEWLINE);

            // Línea separadora antes del total
            document.add(new Chunk(new LineSeparator()));

            // Cálculo de IVA y total final
            float iva = precioBase * 0.21f;
            float precioFinal = precioBase + iva;

            // Mostrar desglose del precio
            Paragraph precioBase2 = new Paragraph("Precio Base: " + String.format("%.2f €", precioBase), FontFactory.getFont(FontFactory.HELVETICA, 12));
            precioBase2.setAlignment(Element.ALIGN_RIGHT);
            document.add(precioBase2);
            Paragraph iva2 = new Paragraph("IVA (21%): " + String.format("%.2f €", iva), FontFactory.getFont(FontFactory.HELVETICA, 12));
            iva2.setAlignment(Element.ALIGN_RIGHT);
            document.add(iva2);
            Paragraph precioFinal2 = new Paragraph("Precio Final: " + String.format("%.2f €", precioFinal), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            precioFinal2.setAlignment(Element.ALIGN_RIGHT);
            document.add(precioFinal2);

            // Cerrar el documento
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPCell crearCabecera(String texto) {
        PdfPCell headerCell = new PdfPCell(new Paragraph(texto, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.WHITE)));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBackgroundColor(new BaseColor(100, 149, 237));
        headerCell.setPaddingBottom(10);
        headerCell.setBorder(PdfPCell.NO_BORDER);
        return headerCell;
    }

    private static PdfPCell crearCelda(String texto, BaseColor backgroundColor) {
        PdfPCell cell = new PdfPCell(new Paragraph(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(backgroundColor);
        cell.setPaddingBottom(5);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
}
