package shared.gestionAcciones;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import backend.service.ventas.campanaAccionistas.Accion;
import frontend.SwingUtil;
import frontend.portalAccionistas.FrameCompraAcciones;
import frontend.portalAccionistas.PanelAccionEnVenta;
import frontend.portalAccionistas.PortalAccionistas;

public class GestionFrameCompraAccionesShared {

	private FrameCompraAcciones view;
	private PortalAccionistas viewPortal;
	private GestionCompraVentaAccionesShared gesComVen;
	

	public GestionFrameCompraAccionesShared(FrameCompraAcciones view, String dniAccionista, PortalAccionistas viewPortal) {
		this.view = view;
		this.viewPortal = viewPortal;
		this.gesComVen = new GestionCompraVentaAccionesShared(dniAccionista);


	}

	public void initController() {
		view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	cerrarVentana();
            }
        });
	}

	void cargarAccionesEnVenta() {
		List<Accion> accionesEnVenta = gesComVen.getAccionesEnVenta();
		if (accionesEnVenta.isEmpty()) {
			JOptionPane.showMessageDialog(view, "Actualmente no hay acciones en Venta", "Ninguna Acción en Venta", 
					JOptionPane.INFORMATION_MESSAGE);
			cerrarVentana();
		}
		else {
			for (Accion acc : accionesEnVenta) {
				PanelAccionEnVenta pnAcc = new PanelAccionEnVenta(acc);
				mostrarInfoAccionEnVenta(pnAcc);
				initControllerPanelAccion(pnAcc);
				view.getPnAccionesEnVenta().add(pnAcc);
			}	
		}
	}

	private void mostrarInfoAccionEnVenta(PanelAccionEnVenta pnAcc) {
		String id = pnAcc.getAccion().getIdAccion();
		float precio = pnAcc.getAccion().getPrecio();
		pnAcc.getLbAccion().setText(String.format("Acción %s - %.2f\u20AC", id, precio));
	}

	private void initControllerPanelAccion(PanelAccionEnVenta pnAcc) {
		pnAcc.getBtComprar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprarAccion(pnAcc)));
	}

	private void comprarAccion(PanelAccionEnVenta pnAcc) {
		// TODO Auto-generated method stub
	}
	
	private void cerrarVentana() {
		viewPortal.setVisible(true);
		view.dispose();
	}

}
