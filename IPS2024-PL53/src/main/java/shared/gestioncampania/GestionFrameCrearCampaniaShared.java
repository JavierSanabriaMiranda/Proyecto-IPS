package shared.gestioncampania;

import javax.swing.JOptionPane;

import frontend.SwingUtil;
import frontend.campaniaaccionistas.FrameCambiarFasesCampaniaAccionistas;
import frontend.campaniaaccionistas.FrameCreacionCampaniaAccionistas;

public class GestionFrameCrearCampaniaShared {
	
	private FrameCreacionCampaniaAccionistas view;
	private FrameCambiarFasesCampaniaAccionistas viewFases;
	private GestionCampaniaShared gesCam = new GestionCampaniaShared();

	public GestionFrameCrearCampaniaShared(FrameCreacionCampaniaAccionistas view) {
		this.view = view;
	}

	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentana()));
		view.getBtCrear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> crearCampania()));
	}
	
	public void cargarCampaniaEnCurso() {
		boolean cargarCampania = gesCam.cargarCampaniaEnCurso();
		// Si hay una campaña ya en curso
		if (cargarCampania)
			continuarCampania();
	}

	private void crearCampania() {
		gesCam.crearCampania((int) view.getSpNumAcciones().getValue());
		
		crearViewFases();
	}

	private void cerrarVentana() {
		view.dispose();
	}
	
	private void continuarCampania() {
		int seleccion = JOptionPane.showConfirmDialog(view, "Ya hay una campaña de accionistas en curso\n"
				+ "¿Quiere continuar con la gestión de la misma?", "Campaña en curso", JOptionPane.OK_CANCEL_OPTION);
		
		if (seleccion == JOptionPane.OK_OPTION) {
			view.setVisible(false);
			crearViewFases();
		}
		else
			view.dispose();
			
	}

	private void crearViewFases() {
		viewFases = new FrameCambiarFasesCampaniaAccionistas();
		actualizarFaseEnLabel();
		viewFases.setVisible(true);
		initControllerFases();
	}

	private void initControllerFases() {
		viewFases.getBtAvanzar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> avanzarFase()));
	}
	
	private void avanzarFase() {
		gesCam.avanzarFase();
		if (gesCam.isCampaniaFinalizada()) {
			int ventas = gesCam.getAccionesVendidas();
			
			JOptionPane.showMessageDialog(viewFases, "La campaña ha sido finalizada\nAcciones vendidas: " + ventas, 
					"Final de la Campaña", JOptionPane.INFORMATION_MESSAGE);
			viewFases.dispose();
			view.dispose();
		}
		
	}

	private void actualizarFaseEnLabel() {
		viewFases.getLbFaseActual().setText("Fase Actual: " + gesCam.getFaseCampania());
	}

}
