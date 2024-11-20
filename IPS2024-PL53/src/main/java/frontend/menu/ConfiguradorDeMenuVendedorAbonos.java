package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuVendedorAbonos implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();
		
		// Menú "Ventas"
		JMenu ventasMenu = new JMenu("Ventas");
		menuBar.add(ventasMenu);

		// Opción "Ventas de Entradas"
		JMenuItem ventasEntradas = new JMenuItem("Compra de Entradas");
		ventasEntradas.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarEntradas();
		});
		ventasMenu.add(ventasEntradas);
		// Opción "Compra de abonos"
		JMenuItem compraAbonos = new JMenuItem("Compra de Abonos");
		compraAbonos.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarAbonos();
		});
		ventasMenu.add(compraAbonos);
	}

}
