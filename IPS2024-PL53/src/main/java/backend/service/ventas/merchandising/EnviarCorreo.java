package backend.service.ventas.merchandising;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.SwingWorker;

public class EnviarCorreo {
    // Configuración del servidor SMTP
    private static String host = "smtp.gmail.com";
    private static String puerto = "587";
    private static String remitente = "tiendaburgosfc@gmail.com";
    private static String clave = "zrst comg rega jutn";
    
    private VentaMerchandising ventaMerchandising;
    private final String cliente;
    
    public EnviarCorreo(VentaMerchandising ventaMerchandising, String cliente) {
    	this.ventaMerchandising=ventaMerchandising;
    	this.cliente=cliente;
    }
    
    public void enviarMensaje() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                Properties propiedades = new Properties();
                propiedades.put("mail.smtp.auth", "true");
                propiedades.put("mail.smtp.starttls.enable", "true");
                propiedades.put("mail.smtp.host", host);
                propiedades.put("mail.smtp.port", puerto);

                Session sesion = Session.getInstance(propiedades, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remitente, clave);
                    }
                });

                try {
                    Message mensaje = new MimeMessage(sesion);
                    mensaje.setFrom(new InternetAddress(remitente));
                    mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cliente));
                    mensaje.setSubject("Pedido: " + ventaMerchandising.getCodCompra() + " confirmado");

                    // Construcción del HTML con una tabla para los productos
                    StringBuilder contenidoHTML = new StringBuilder();
                    contenidoHTML.append("<html><body style='font-family: Arial, sans-serif; color: #333;'>");
                    contenidoHTML.append("<h2 style='color: #0073e6;'>Confirmación de Pedido</h2>");
                    contenidoHTML.append("<p>Estimado cliente,</p>");
                    contenidoHTML.append("<p>Gracias por tu compra. Tu pedido <strong>").append(ventaMerchandising.getCodCompra()).append("</strong> ha sido confirmado.</p>");
                    contenidoHTML.append("<p>Detalles del pedido:</p>");
                    contenidoHTML.append("<table style='width: 100%; border-collapse: collapse;'>");
                    contenidoHTML.append("<tr style='background-color: #f2f2f2;'><th style='padding: 8px; border: 1px solid #ddd;'>Producto</th>");
                    contenidoHTML.append("<th style='padding: 8px; border: 1px solid #ddd;'>Cantidad</th></tr>");

                    // Agregar cada producto a la tabla
                    for (Producto p : ventaMerchandising.getProductos()) {
                        contenidoHTML.append("<tr><td style='padding: 8px; border: 1px solid #ddd;'>")
                                .append(p.getName())
                                .append("</td><td style='padding: 8px; text-align: center; border: 1px solid #ddd;'>")
                                .append(p.getUnits())
                                .append(" uds.</td></tr>");
                    }
                    
                    contenidoHTML.append("</table>");
                    contenidoHTML.append("<p><strong>Precio Total: ").append(ventaMerchandising.getPrecioTotal()).append("€</strong></p>");
                    contenidoHTML.append("<p style='margin-top: 20px;'>Saludos,<br>Tienda Burgos FC</p>");
                    contenidoHTML.append("<hr style='border: none; height: 1px; background-color: #0073e6;' />");
                    contenidoHTML.append("<p style='font-size: 12px; color: #888;'>Por favor, no respondas a este correo.</p>");
                    contenidoHTML.append("</body></html>");

                    // Establecer el contenido HTML
                    mensaje.setContent(contenidoHTML.toString(), "text/html; charset=utf-8");

                    mensaje.setReplyTo(InternetAddress.parse("noreply.tiendaburgosfc@gmail.com"));
                    Transport.send(mensaje);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        worker.execute();
    }

}
