package shared.gestioncampania;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

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
			crearViewFases();
		}
		else
			view.dispose();
			
	}

	private void crearViewFases() {
		view.setVisible(false);
		viewFases = new FrameCambiarFasesCampaniaAccionistas();
		actualizarFaseEnLabel();
		viewFases.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		initControllerFases();
		viewFases.setVisible(true);
	}

	private void initControllerFases() {
		viewFases.getBtAvanzar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> avanzarFase()));
		viewFases.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                SwingUtilities.invokeLater(() -> view.dispose());
            }
        });
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
		else 
			actualizarFaseEnLabel();
	}

	private void actualizarFaseEnLabel() {
		viewFases.getLbFaseActual().setText("Fase Actual: " + gesCam.getFaseCampania());
	}

}
