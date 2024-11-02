package shared.gestionAcciones;

import java.util.List;

import backend.service.ventas.campanaAccionistas.Accion;
import frontend.portalAccionistas.FrameCompraAcciones;

public class GestionFrameCompraAccionesShared {

	private FrameCompraAcciones view;
	private GestionCompraVentaAccionesShared gesComVen;

	public GestionFrameCompraAccionesShared(FrameCompraAcciones view, String dniAccionista) {
		this.view = view;
		this.gesComVen = new GestionCompraVentaAccionesShared(dniAccionista);

		cargarAccionesEnVenta();
	}

	public void initController() {

	}

	private void cargarAccionesEnVenta() {
		List<Accion> accionesEnVenta = gesComVen.getAccionesEnVenta();
	}

}
