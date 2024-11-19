package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuAccionista extends ConfiguradorDeMenuBase {

	@Override
	protected void configurarMenuParaUsuario(JFrame menu, AplicacionMain app) {
		// Añade el portal de Accionistas
		JMenuItem portalAccionistas = new JMenuItem("Portal de accionistas");
		portalAccionistas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarPortalAccionistas();
		});
		super.menuAccionistas.add(portalAccionistas);
	}

}
