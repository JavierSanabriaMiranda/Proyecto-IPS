package frontend.menu;


import javax.swing.JFrame;

public interface ConfiguradorDeMenu {
	
	/**
	 * Recibe el menú a configurar y lo configura adecuadamente a cada usuario
	 * @param menu a configurar
	 */
	void configurarMenu(JFrame menu, AplicacionMain app);

}
