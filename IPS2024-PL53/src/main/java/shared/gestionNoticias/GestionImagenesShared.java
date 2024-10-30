package shared.gestionNoticias;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    public void eliminarArchivosCarpeta() {
        Path directory = Paths.get(DESTINO_IMAGENES);

        try {
            Files.walk(directory)
                .filter(Files::isRegularFile) // Filtra solo archivos
                .filter(file -> !file.getFileName().toString().equals("NO_BORRAR.txt"))
                .forEach(file -> {
                    try {
                        Files.delete(file);
                    } catch (IOException e) {
                        System.err.println("Error al eliminar el archivo: " + file);
                    }
                });
            System.out.println("Todos los archivos (excepto NO_BORRAR.txt) han sido eliminados.");
        } catch (IOException e) {
            System.err.println("Error al acceder a la carpeta: " + e.getMessage());
        }
    }
}
