package shared.gestionAcciones;

import backend.service.ventas.campanaAccionistas.Accion;
import frontend.SwingUtil;
import frontend.campaña_de_acciones.PanelAccion;

public class GestionPanelAccionShared {
	private PanelAccion view;
	private Accion accion;
	
	public GestionPanelAccionShared(PanelAccion v, Accion accion) {
		this.view = v;
		this.accion = accion;
		
		initView();
	}
	
	private void initView(){
		view.getLbCodigoAccion().setText(accion.getIdAccion());	
	}

	public void initController() {		
		view.getBtVender().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionVender()));
		
		view.getBtQuitar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionQuitar()));
	}

	private void accionVender() {
		// TODO Auto-generated method stub
	}
	
	private void accionQuitar() {
		// TODO Auto-generated method stub
	}

}
