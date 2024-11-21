package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuEntrenador implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		addMenuEntrenamientosEquipos(menu, app);
		addMenuCrearFranjasEntrevistas(menu, app);

	}

	private void addMenuCrearFranjasEntrevistas(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Entrevistas"
		JMenu entrevistasMenu = new JMenu("Entrevistas");
		menuBar.add(entrevistasMenu);

		// Opción "Crear Franjas de Entrevista"
		JMenuItem crearEntrevistas = new JMenuItem("Crear Franjas de Entrevista");
		crearEntrevistas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarGestionCrearFranjasEntrevistas();
		});
		entrevistasMenu.add(crearEntrevistas);
	}

	private void addMenuEntrenamientosEquipos(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Equipos"
		JMenu equiposMenu = new JMenu("Equipos");
		menuBar.add(equiposMenu);

		JMenuItem horariosEntrenamientos = new JMenuItem("Horario Equipos");
		horariosEntrenamientos.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarHorarioEquipos();
		});
		equiposMenu.add(horariosEntrenamientos);
	}

}
