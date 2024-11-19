package frontend.menu;

import javax.swing.JFrame;

public class ConfiguradorDeMenuNoUsuario extends ConfiguradorDeMenuBase {

	@Override
	protected void configurarMenuParaUsuario(JFrame menu, AplicacionMain app) {
		// Sin implementación, pues los usuarios que no inician sesión deben tener
		// la configuración de menú por defecto
	}

}
