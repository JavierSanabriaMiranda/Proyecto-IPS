package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuNoUsuario implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		addPortalNoticias(menu, app);
        addAccederACampania(menu, app);
	}

	private void addAccederACampania(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Accionistas"
        JMenu accionistasMenu = new JMenu("Accionistas");
        menuBar.add(accionistasMenu);

        
        JMenuItem accederCampania = new JMenuItem("Acceder a Campaña de Accionistas");
        accederCampania.addActionListener(e -> {
            menu.setVisible(false);
            app.inicializarParticiparEnACampania();
        });
        accionistasMenu.add(accederCampania);
	}

	private void addPortalNoticias(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Noticias"
        JMenu noticiasMenu = new JMenu("Noticias");
        menuBar.add(noticiasMenu);
        
        // Opción "Ver Portal Noticias"
        JMenuItem portalNoticias = new JMenuItem("Portal de Noticias");
        portalNoticias.addActionListener(e -> {
            menu.setVisible(false);
            app.inicializarPortalNoticias();
        });
        noticiasMenu.add(portalNoticias);
	}

}
