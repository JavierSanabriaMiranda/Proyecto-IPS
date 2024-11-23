package shared.gestionestadisticos;

import frontend.SwingUtil;
import frontend.estadisticos.FrameEstadisticosGastosEIngresos;

public class GestionFrameEstadisticosGastosEIngresos {

	private FrameEstadisticosGastosEIngresos view;
	
	public GestionFrameEstadisticosGastosEIngresos(FrameEstadisticosGastosEIngresos view) {
		this.view = view;
	}

	public void initController() {
		view.getCbPeriocidad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> seleccionarPeriocidad()));
		view.getBtMostrarGrafico().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarGrafico()));
	}

	private void mostrarGrafico() {
		// TODO Implementar
	}

	private void seleccionarPeriocidad() {
		String seleccion = (String) view.getCbPeriocidad().getSelectedItem();
		
		if (seleccion.isEmpty()) {
			view.getLbFecha().setText("");
			view.getPnPeriocidad().remove(view.getMonthChooser());
			view.getPnPeriocidad().remove(view.getYearChooser());
			view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
			view.repaint();
		} else {
			if (seleccion.equalsIgnoreCase("Mensual")) {
				view.getLbFecha().setText("Mes:");
				view.getPnPeriocidad().remove(view.getYearChooser());
				view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
				view.repaint();
				view.getPnPeriocidad().add(view.getMonthChooser());
			} else if (seleccion.equalsIgnoreCase("Anual")) {
				view.getLbFecha().setText("Año:");
				view.getPnPeriocidad().remove(view.getMonthChooser());
				view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
				view.repaint();
				view.getPnPeriocidad().add(view.getYearChooser());
			}
			view.getPnPeriocidad().add(view.getBtMostrarGrafico());
		}
		
	}
	
}
