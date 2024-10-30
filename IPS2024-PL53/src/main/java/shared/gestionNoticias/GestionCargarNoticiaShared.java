package shared.gestionNoticias;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.data.CreadorDataService;
import backend.data.noticias.ImagenDTO;
import backend.data.noticias.NoticiaCRUDService;
import backend.data.noticias.NoticiaDTO;
import backend.service.noticias.Imagen;
import frontend.SwingUtil;
import frontend.noticias.CargarNoticia;

public class GestionCargarNoticiaShared {
	private CargarNoticia view;
	
	public GestionCargarNoticiaShared(CargarNoticia view) {
		this.view = view;
		
		initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> initView()));
		
		view.getBtAñadir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cargarNoticia()));
		
		view.getBtEliminar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarImagenes()));
		
		view.getBtElegirImagenes().addActionListener(e -> SwingUtil.exceptionWrapper(() -> abrirFicheros()));
		
		view.getTextoTitulo().getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {verificarCamposTexto();}
		    @Override
		    public void removeUpdate(DocumentEvent e) {verificarCamposTexto();}
		    @Override
		    public void changedUpdate(DocumentEvent e) {verificarCamposTexto();}
		});

		view.getTaTextoNoticia().getDocument().addDocumentListener(new DocumentListener() {
			@Override
		    public void insertUpdate(DocumentEvent e) {verificarCamposTexto();}
		    @Override
		    public void removeUpdate(DocumentEvent e) {verificarCamposTexto();}
		    @Override
		    public void changedUpdate(DocumentEvent e) {verificarCamposTexto();}
		});
		
		view.getListaImagenes().addListSelectionListener(e -> {
	        if (!e.getValueIsAdjusting()) {  // Esto previene múltiples eventos durante un solo ajuste de selección
	            boolean haySeleccion = !view.getListaImagenes().isSelectionEmpty();
	            view.getBtEliminar().setEnabled(haySeleccion);
	        }
	    });
	}

	private void initView() {
		view.getTextoTitulo().setText("");
		view.getTaTextoNoticia().setText("");
		view.modeloListaImagenes.clear();
		view.getBtAñadir().setEnabled(false);
	}
	
	private void cargarNoticia() {
		NoticiaCRUDService service = CreadorDataService.getNoticiaService();
		String cod_noticia = generarCodigoUnico();
		NoticiaDTO noticia = new NoticiaDTO(cod_noticia,view.getTextoTitulo().getText(),view.getTaTextoNoticia().getText());
		service.addNoticia(noticia, añadirImagenes(cod_noticia));
		initView();
	}
	
	private List<ImagenDTO> añadirImagenes(String cod_noticia) {
	    GestionImagenesShared servicioImagenes = new GestionImagenesShared();
	    List<ImagenDTO> imagenes = new ArrayList<>();

	    List<File> archivosSeleccionados = new ArrayList<>();
	    for (int i = 0; i < view.modeloListaImagenes.size(); i++) {
	        archivosSeleccionados.add(new File(view.modeloListaImagenes.get(i).getUrlImagen()));
	    }
	    try {
	        List<String> nombresCopiados = servicioImagenes.copiarImagenes(archivosSeleccionados);
	        for (String nombreCopiado : nombresCopiados) {
	            imagenes.add(new ImagenDTO(cod_noticia, generarCodigoUnico(), nombreCopiado));
	        }
	    } catch (IOException ex) {
	        System.err.println("Error al copiar las imágenes: " + ex.getMessage());
	    }

	    return imagenes;
	}
	
	private void eliminarImagenes() {
		for( int i=0; i<view.getListaImagenes().getSelectedValuesList().size();i++) {
			view.modeloListaImagenes.removeElement(view.getListaImagenes().getSelectedValuesList().get(i));
		}
	}
	
	private void abrirFicheros() {
		int respuesta = view.getSelector().showOpenDialog(null);
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			for(int i=0;i<view.getSelector().getSelectedFiles().length;i++) {
				if(!view.modeloListaImagenes.contains(view.getSelector().getSelectedFiles()[i])) {
					view.modeloListaImagenes.addElement(new Imagen(view.getSelector().getSelectedFiles()[i].getName(),
							view.getSelector().getSelectedFiles()[i].getPath()));
				}
			}
		}
	}
	
	private void verificarCamposTexto() {
        String titulo = view.getTextoTitulo().getText().trim();
        String texto = view.getTaTextoNoticia().getText().trim();

        view.getBtAñadir().setEnabled(!titulo.isEmpty() && !texto.isEmpty());
    }

	private static String generarCodigoUnico() {
        StringBuilder codigo = new StringBuilder(10);
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();
        
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(CHARACTERS.length());
            codigo.append(CHARACTERS.charAt(index));
        }

        return codigo.toString();
    }
}
