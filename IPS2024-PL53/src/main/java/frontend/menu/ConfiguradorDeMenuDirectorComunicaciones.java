package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuDirectorComunicaciones implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Entrevistas"
		JMenu entrevistasMenu = new JMenu("Entrevistas");
		menuBar.add(entrevistasMenu);

		// Opción "Crear Entrevistas"
		JMenuItem crearEntrevistas = new JMenuItem("Crear Entrevistas");
		crearEntrevistas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarGestionCrearEntrevistas();
		});
		entrevistasMenu.add(crearEntrevistas);
	}

}
