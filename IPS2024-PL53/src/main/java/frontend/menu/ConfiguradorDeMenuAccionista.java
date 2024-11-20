package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuAccionista implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Accionistas"
        JMenu accionistasMenu = new JMenu("Accionistas");
        
        menuBar.add(accionistasMenu);
		
		// Añade el portal de Accionistas
		JMenuItem portalAccionistas = new JMenuItem("Portal de accionistas");
		portalAccionistas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarPortalAccionistas();
		});
		
        accionistasMenu.add(portalAccionistas);
	}

}
