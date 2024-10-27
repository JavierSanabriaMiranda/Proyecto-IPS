package shared.gestionjardineria;

import frontend.jardineriaUI.HorarioJardineria;
import frontend.jardineriaUI.VentanaJardineros;

public class GestionPanelJardineriaShared {
	private VentanaJardineros view;
	private HorarioJardineria diagJar;

	public GestionPanelJardineriaShared(VentanaJardineros view) {
		this.view = view;
	}

	public VentanaJardineros getView() {
		return view;
	}

	public HorarioJardineria getDiagJar() {
		return diagJar;
	}

	public void initController() {
		
	}

}
