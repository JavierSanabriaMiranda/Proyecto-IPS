package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuDirectorComunicaciones implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		addMenuCrearEntrevistas(menu, app);
		addMenuCrearNoticias(menu, app);
	}

	private void addMenuCrearNoticias(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Noticias"
		JMenu noticiasMenu = new JMenu("Noticias");
		menuBar.add(noticiasMenu);

		// Opción "Cargar Noticias"
		JMenuItem cargarNoticias = new JMenuItem("Crear Noticia");
		cargarNoticias.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarCargarNoticias();
		});
		noticiasMenu.add(cargarNoticias);
	}

	private void addMenuCrearEntrevistas(JFrame menu, AplicacionMain app) {
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
