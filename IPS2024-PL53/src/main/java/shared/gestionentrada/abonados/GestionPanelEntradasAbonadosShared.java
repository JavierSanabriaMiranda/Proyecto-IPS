package shared.gestionentrada.abonados;

import frontend.SwingUtil;
import frontend.entradaUI.abonados.VentanaInicioAbonados;

public class GestionPanelEntradasAbonadosShared {
	
	private VentanaInicioAbonados view;

	public GestionPanelEntradasAbonadosShared(VentanaInicioAbonados view) {
		this.view = view;
	}
	
	public void initController() {
		view.getBtnAtras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
	}
	

}
