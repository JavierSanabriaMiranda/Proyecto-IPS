package shared.gestionNoticias;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class GestionImagenesShared {
	 private static final String DESTINO_IMAGENES = "src/main/java/img/noticias/";

	    public List<String> copiarImagenes(List<File> imagenes) throws IOException {
	        List<String> nombresCopiados = new ArrayList<>();

	        for (File imagen : imagenes) {
	            String nombreUnico = generarNombreUnico(imagen.getName());
	            Path destino = Path.of(DESTINO_IMAGENES, nombreUnico);

	            // Copiar el archivo
	            Files.copy(imagen.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
	            nombresCopiados.add(nombreUnico);
	        }

	        return nombresCopiados;
	    }

	    private String generarNombreUnico(String nombreOriginal) {
	        String nombreSinExtension = nombreOriginal.substring(0, nombreOriginal.lastIndexOf('.'));
	        String extension = nombreOriginal.substring(nombreOriginal.lastIndexOf('.'));
	        return nombreSinExtension + "_" + System.currentTimeMillis() + extension;
	    }
}
