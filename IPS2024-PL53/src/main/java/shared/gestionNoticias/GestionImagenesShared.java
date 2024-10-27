package shared.gestionNoticias;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class GestionImagenesShared {
    private static final String DESTINO_IMAGENES = "src/main/resources/img/noticias/";

    public List<String> copiarImagenes(List<File> imagenes) throws IOException {
        List<String> nombresCopiados = new ArrayList<>();

        for (File imagen : imagenes) {
            Path destino = Path.of(DESTINO_IMAGENES, imagen.getName());

            // Copiar el archivo
            Files.copy(imagen.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            nombresCopiados.add(imagen.getName());

            // Actualizar el caché del sistema de archivos después de cada copia
            refrescarCacheCarpeta();
        }

        return nombresCopiados;
    }

    // Método para actualizar el caché del sistema de archivos
    private void refrescarCacheCarpeta() {
        File folder = new File(DESTINO_IMAGENES);
        folder.listFiles();  // Forzar la actualización del caché
    }
}
