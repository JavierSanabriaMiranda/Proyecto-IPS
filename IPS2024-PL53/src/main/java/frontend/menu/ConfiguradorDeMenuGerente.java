package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuGerente implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		addMenuGestionEmpleados(menu, app);
		addMenuHistorialVentas(menu, app);
		addMenuGestionEquipos(menu, app);
		addMenuCrearCampaniaAccionistas(menu, app);
		addMenuEstadisticos(menu, app);
	}

	private void addMenuEstadisticos(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Estadísticos"
		JMenu estadisticosMenu = new JMenu("Estadísticos");
		menuBar.add(estadisticosMenu);
		
		// Opción "Estadísticos Económicos"
		JMenuItem estadisticosEconomicos = new JMenuItem("Estadísticos Económicos");
		estadisticosEconomicos.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarEstadisticosEconomicos();
		});
		estadisticosMenu.add(estadisticosEconomicos);
	}

	private void addMenuHistorialVentas(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Historial de Ventas"
		JMenu historialMenu = new JMenu("Historial de Ventas");
		menuBar.add(historialMenu);

		// Opción "Ver Historial de Ventas"
		JMenuItem historialVentas = new JMenuItem("Ver Historial de Ventas");
		historialVentas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarHistorialDeVentas();
		});
		historialMenu.add(historialVentas);
	}

	private void addMenuGestionEquipos(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Equipos"
		JMenu equiposMenu = new JMenu("Equipos");
		menuBar.add(equiposMenu);

		// Opción "Añadir equipos"
		JMenuItem anadirEquipos = new JMenuItem("Añadir Equipos");
		anadirEquipos.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarGestionEquipos();
		});
		equiposMenu.add(anadirEquipos);

		// Opción "Crear partidos para equipos"
		JMenuItem crearPartidos = new JMenuItem("Crear Partido");
		crearPartidos.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarCreacionPartidos();
		});
		equiposMenu.add(crearPartidos);
	}

	private void addMenuCrearCampaniaAccionistas(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Accionistas"
		JMenu accionistasMenu = new JMenu("Accionistas");
		menuBar.add(accionistasMenu);

		// Opción "Crear campaña de accionistas"
		JMenuItem crearCampania = new JMenuItem("Crear Campaña de Accionistas");
		crearCampania.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarCrearCampania();
		});
		accionistasMenu.add(crearCampania);
	}

	private void addMenuGestionEmpleados(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Gestión"
		JMenu gestionMenu = new JMenu("Gestión de Empleados");
		menuBar.add(gestionMenu);

		// Opción "Gestionar empleados"
		JMenuItem gestionEmpleados = new JMenuItem("Gestionar Empleados");
		gestionEmpleados.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarGestionEmpleados();
		});
		gestionMenu.add(gestionEmpleados);

		// Opción "Asignar horarios"
		JMenuItem asignarHorarios = new JMenuItem("Asignar Horarios");
		asignarHorarios.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarHorariosEmpleados();
		});
		gestionMenu.add(asignarHorarios);

		// Opción "Asignar horarios de jardineria"
		JMenuItem horarioJardineros = new JMenuItem("Horarios Jardinería");
		horarioJardineros.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarJardineria();
		});
		gestionMenu.add(horarioJardineros);
	}

}
