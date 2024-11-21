package frontend.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConfiguradorDeMenuEncargadoTienda implements ConfiguradorDeMenu {

	@Override
	public void configurarMenu(JFrame menu, AplicacionMain app) {
		JMenuBar menuBar = menu.getJMenuBar();

		// Menú "Ventas"
		JMenu ventasMenu = new JMenu("Ventas");
		menuBar.add(ventasMenu);

		// Opción "Ventas de Merchandising"
		JMenuItem ventasMerchandising = new JMenuItem("Compra de Merchandising");
		ventasMerchandising.addActionListener(e -> {
			menu.setVisible(false);
			app.inicializarMerchandising();
		});
		ventasMenu.add(ventasMerchandising);
	}
}
