package shared.gestionNoticias;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import backend.service.noticias.Noticia;
import frontend.SwingUtil;
import frontend.noticias.PanelMiniaturaNoticia;
import frontend.noticias.PortalNoticias;

public class GestionPanelMiniaturaShared {
    private GestionPortalNoticiasShared gpns;
    private PanelMiniaturaNoticia view;
    private PortalNoticias portal;
    private Noticia noticia;

    public GestionPanelMiniaturaShared(GestionPortalNoticiasShared gpns, PanelMiniaturaNoticia view, PortalNoticias portal, Noticia noticia) {
        this.gpns = gpns;
        this.view = view;
        this.portal = portal;
        this.noticia = noticia;

        initView();
    }

    private void initView() {
        view.getLbTitulo().setText("<html>"+noticia.getTitulo()+"</html>");
        if (noticia.getImagenes().size() == 0) {
            view.remove(view.getImagen());
            view.setLayout(new GridLayout(1, 1, 0, 0));
        } else {
            redimensionarMiniatura(0);
        }
    }

    public void initController() {
        view.getBtLeerMas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> rellenarPanel()));
        
        portal.getBtAnterior2().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn2()));
        
     // Listener para redimensionar la miniatura al cambiar el tamaño del componente
        view.getImagen().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarMiniatura(0);
            }
        });
    }

    private void rellenarPanel() {
        showPn2();
        gpns.imagenes = noticia.getImagenes();
        gpns.indiceImagen = 0;

        portal.getLbTituloNoticia().setText("<html>"+noticia.getTitulo()+"</html>");
        portal.getTaTexto().setText(noticia.getTexto());

        if (noticia.getImagenes().isEmpty()) {
            portal.getPnImagenes().setVisible(false);
        } else {
            portal.getPnImagenes().setVisible(true);
            gpns.redimensionarImagen(0,portal.getBtImagen());
            
            // Reinicia los botones de navegación
            portal.getBtImgAnterior().setEnabled(false);
            portal.getBtImgSiguiente().setEnabled(noticia.getImagenes().size() > 1);
        }
    }
    
    private void redimensionarMiniatura(int index) {
        if (noticia.getImagenes().size() > index) {
            // Construir la ruta completa utilizando la ruta del proyecto
            String rutaProyecto = System.getProperty("user.dir"); // Obtiene la ruta del directorio de trabajo
            String rutaImagenRelativa = "src/main/resources/"+noticia.getImagenes().get(index).getUrlImagen();
            File imagenFile = Paths.get(rutaProyecto, rutaImagenRelativa).toFile();
            ImageIcon originalIcon = new ImageIcon(imagenFile.getAbsolutePath());
            Image scaledImage = originalIcon.getImage().getScaledInstance(
                    140,
                    100,
                    Image.SCALE_SMOOTH);
            view.getImagen().setIcon(new ImageIcon(scaledImage));
        }
    }

    private void showPn2() {
        ((CardLayout) portal.getContentPane().getLayout()).show(portal.getContentPane(), "pn2");
    }
}
