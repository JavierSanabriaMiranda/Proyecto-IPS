package shared.gestionNoticias;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import backend.data.CreadorDataService;
import backend.data.noticias.NoticiaCRUDService;
import backend.data.noticias.NoticiaDTO;
import backend.service.noticias.Imagen;
import backend.service.noticias.Noticia;
import frontend.SwingUtil;
import frontend.noticias.PanelMiniaturaNoticia;
import frontend.noticias.PortalNoticias;

public class GestionPortalNoticiasShared {
	private PortalNoticias view;
	List<Imagen> imagenes;
	int indiceImagen;
	
	public GestionPortalNoticiasShared(PortalNoticias view) {
		this.view = view;
		imagenes = new ArrayList<Imagen>();
		indiceImagen=0;
		
		initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getBtAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inicializar()));
		
		view.getBtImgAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarImagenAnterior(indiceImagen-1)));
		
		view.getBtImgSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarImagenSiguiente(indiceImagen+1)));
		
		view.getBtImagen().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn3(indiceImagen)));
		
		view.getBtImagen().addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {redimensionarImagen(indiceImagen,(Component) e.getSource());}
	    });	
	}

	private void initView() {
		crearNoticias();
	}

	private void inicializar() {
		indiceImagen=0;
		showPn1();
	}

	private void crearNoticias() {
		NoticiaCRUDService service = CreadorDataService.getNoticiaService();
		List<NoticiaDTO> noticias = service.findNoticias();
		for(int i=0;i<noticias.size();i++) {
			Noticia n = new Noticia(noticias.get(i).getTitulo(),noticias.get(i).getTexto(),buscarImagenes(noticias.get(i).getCodNoticia(),service));
			PanelMiniaturaNoticia pnMiniaturaImagen = crearControladorPanelMiniatura(n);
			if(i==0)
				view.getPnSuperior().add(pnMiniaturaImagen, BorderLayout.CENTER);
			else
				view.getPnNoticias().add(pnMiniaturaImagen);			
		}
	}

	private List<Imagen> buscarImagenes(String codNoticia, NoticiaCRUDService service) {
		List<Imagen> imagenes = new ArrayList<Imagen>();
		for(String i : service.findImagenesNoticia(codNoticia)) {
			imagenes.add(new Imagen(i, "/img/noticias/"+i));
		}
		this.imagenes=imagenes;
		return imagenes;
	}
	
	private PanelMiniaturaNoticia crearControladorPanelMiniatura(Noticia n) {
		PanelMiniaturaNoticia pnMiniaturaImagen = new PanelMiniaturaNoticia();
		GestionPanelMiniaturaShared gpns = new GestionPanelMiniaturaShared(this,pnMiniaturaImagen,view,n);
		gpns.initController();
		return pnMiniaturaImagen;
	}
	
	public void redimensionarImagen(int index, Component component) {
	    if (index >= 0 && index < imagenes.size()) {
	    	// Construir la ruta completa utilizando la ruta del proyecto
            String rutaProyecto = System.getProperty("user.dir"); // Obtiene la ruta del directorio de trabajo
            String rutaImagenRelativa = "src/main/resources/"+imagenes.get(index).getUrlImagen();
            File imagenFile = Paths.get(rutaProyecto, rutaImagenRelativa).toFile();
            ImageIcon originalIcon = new ImageIcon(imagenFile.getAbsolutePath());
	        Image scaledImage = originalIcon.getImage().getScaledInstance(component.getWidth(),component.getHeight(),Image.SCALE_SMOOTH);
	        ((JButton) component).setIcon(new ImageIcon(scaledImage));
	    }
	}

	// Llamadas a redimensionarImagen en los métodos de cambio de imagen:
	private void mostrarImagenAnterior(int index) {
	    if (index >= 0 && index < imagenes.size()) {
	        redimensionarImagen(index,view.getBtImagen());
	        indiceImagen = index;
	        view.getBtImgAnterior().setEnabled(indiceImagen > 0);
	        view.getBtImgSiguiente().setEnabled(indiceImagen < imagenes.size() - 1);
	    }
	}

	private void mostrarImagenSiguiente(int index) {
	    if (index >= 0 && index < imagenes.size()) {
	    	redimensionarImagen(index,view.getBtImagen());
	        indiceImagen = index;
	        view.getBtImgAnterior().setEnabled(indiceImagen > 0);
	        view.getBtImgSiguiente().setEnabled(indiceImagen < imagenes.size() - 1);
	    }
	}
	
	private void showPn1() {
		((CardLayout)view.getContentPane().getLayout()).show(view.getContentPane(),"pn1");
	}
	
	private void showPn3(int index) {
		((CardLayout)view.getContentPane().getLayout()).show(view.getContentPane(),"pn3");
		redimensionarImagen(index,view.getBtImagenExpandida());
	}
}
