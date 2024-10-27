package shared.gestioncampania;

import frontend.SwingUtil;
import frontend.campaniaaccionistas.FrameCreacionCampaniaAccionistas;

public class GestionFrameCrearCampaniaShared {
	
	private FrameCreacionCampaniaAccionistas view;
	private GestionCampaniaShared gesCam;

	public GestionFrameCrearCampaniaShared(FrameCreacionCampaniaAccionistas view) {
		this.view = view;
		this.gesCam = view.getGesCam();
	}
	
	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentana()));
		view.getBtCrear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> crearCampania()));
	}

	private void crearCampania() {
		gesCam.crearCampania((int) view.getSpNumAcciones().getValue());
		
	}

	private void cerrarVentana() {
		view.dispose();
	}

}
