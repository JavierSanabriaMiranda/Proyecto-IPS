package backend.util.log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogManager {
    private static Logger logger;
    private static String logFilePath;
    private static String usuario;

    
    public static void initialize(String usuario) throws IOException {
        if (logger != null) {
            return; 
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String logDirectory = "src/main/resources/logs";

        logFilePath = logDirectory + "/log_" + usuario + "_" + timestamp + ".log";

        // Configurar el Logger
        logger = Logger.getLogger("LogManager");
        FileHandler fileHandler = new FileHandler(logFilePath, true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false); // Evita que los logs se impriman en consola

        logAction("Sistema: Inicio del log para el usuario: " + usuario);
    }

    
    public static void logAction(String accion) {
        if (logger == null) {
            return; //Si el logger es null, será porque se ha iniciado la aplicación sin iniciar sesión
        }
        logger.info("[Usuario: " + usuario + "] - Acción: " + accion);
    }

    public static void logAction(String usuario, String accion, String detalles) {
        if (logger == null) {
            return; //Si el logger es null, será porque se ha iniciado la aplicación sin iniciar sesión
        }
        logger.info("[Usuario: " + usuario + "] - Acción: " + accion + " - Detalles: " + detalles);
    }

    public static String getLogFilePath() {
        return logFilePath;
    }
}

