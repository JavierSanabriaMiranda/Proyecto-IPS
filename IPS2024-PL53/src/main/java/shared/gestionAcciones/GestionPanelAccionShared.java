package shared.gestionAcciones;

import backend.data.CreadorDataService;
import backend.data.acciones.AccionDTO;
import backend.data.acciones.AccionesCRUDService;
import backend.service.ventas.campanaAccionistas.Accion;
import frontend.SwingUtil;
import frontend.portalAccionistas.PanelAccion;

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
		view.getBtQuitar().setEnabled(accion.isEnVenta());
		view.getBtVender().setEnabled(!accion.isEnVenta());
	}

	public void initController() {		
		view.getBtVender().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionVender()));
		
		view.getBtQuitar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionQuitar()));
	}

	private void accionVender() {
		view.getBtQuitar().setEnabled(true);
		AccionesCRUDService service = CreadorDataService.getAccionesService();
		service.updateIsEnVenta(new AccionDTO(accion.getIdAccion(),accion.isEnVenta()), true);
		view.getBtVender().setEnabled(false);
	}
	
	private void accionQuitar() {
		view.getBtQuitar().setEnabled(false);
		AccionesCRUDService service = CreadorDataService.getAccionesService();
		service.updateIsEnVenta(new AccionDTO(accion.getIdAccion(),accion.isEnVenta()), false);
		view.getBtVender().setEnabled(true);
	}

}
