package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuGestorInstalaciones implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Ventas"
		JMenu ventasMenu = new JMenu("Ventas");
		menuBar.add(ventasMenu);

		// Opción "Reservar instalaciones"
		JMenuItem reservasInstalaciones = new JMenuItem("Reservar Instalaciones");
		reservasInstalaciones.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarReservas();
		});
		ventasMenu.add(reservasInstalaciones);
	}

}
