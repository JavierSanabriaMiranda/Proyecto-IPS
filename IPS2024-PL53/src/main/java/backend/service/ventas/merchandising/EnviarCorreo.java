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
    
    private String cod_compra;
    private String contenido;
    private final String cliente;
    
    public EnviarCorreo(String cod_compra, String mensaje, String cliente) {
    	this.cod_compra=cod_compra;
    	this.contenido=mensaje;
    	this.cliente=cliente;
    }
    
    public void enviarMensaje() {
        // Usar SwingWorker para enviar el correo en segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                // Propiedades del correo
                Properties propiedades = new Properties();
                propiedades.put("mail.smtp.auth", "true");
                propiedades.put("mail.smtp.starttls.enable", "true");
                propiedades.put("mail.smtp.host", host);
                propiedades.put("mail.smtp.port", puerto);

                // Autenticación del remitente
                Session sesion = Session.getInstance(propiedades, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remitente, clave);
                    }
                });

                try {
                    // Crear el mensaje
                    Message mensaje = new MimeMessage(sesion);
                    mensaje.setFrom(new InternetAddress(remitente));
                    mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cliente));
                    mensaje.setSubject("Pedido: " + cod_compra + " confirmado");
                    mensaje.setText(contenido);

                    // Establecer la dirección no respondable
                    mensaje.setReplyTo(InternetAddress.parse("noreply.tiendaburgosfc@gmail.com"));

                    // Enviar el mensaje
                    Transport.send(mensaje);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                // Aquí puedes actualizar la interfaz después de que el correo se haya enviado (opcional)
                System.out.println("Proceso de envío de correo completado.");
            }
        };

        // Ejecutar el SwingWorker
        worker.execute();
    }
}
