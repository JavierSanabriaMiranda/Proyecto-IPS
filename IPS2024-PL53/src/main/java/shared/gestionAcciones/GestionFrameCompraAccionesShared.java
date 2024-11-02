package shared.gestionAcciones;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import backend.service.ventas.campanaAccionistas.Accion;
import frontend.SwingUtil;
import frontend.portalAccionistas.FrameCompraAcciones;
import frontend.portalAccionistas.PanelAccionEnVenta;

public class GestionFrameCompraAccionesShared {

	private FrameCompraAcciones view;
	private GestionPortalAccionistasShared gesPor;
	private GestionCompraVentaAccionesShared gesComVen;

	public GestionFrameCompraAccionesShared(FrameCompraAcciones view, String dniAccionista,
			GestionPortalAccionistasShared gesPor) {
		this.view = view;
		this.gesPor = gesPor;
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
		} else {
			// Establecemos un número de filas al layout para que no se vea feo cuando 
			// hay pocas acciones a la venta
			GridLayout layout = (GridLayout) view.getPnAccionesEnVenta().getLayout();
			if (accionesEnVenta.size() < 4) {
				layout.setRows(4);
			} else {
				layout.setRows(0);
			}
			
			
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
		Accion acc = pnAcc.getAccion();
		String msg = String.format("¿Estás seguro de que deseas comprar esta acción por %.2f\u20AC?", acc.getPrecio());
		int respuesta = JOptionPane.showConfirmDialog(view, msg, "Confirmar Compra", JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.YES_OPTION) {
			gesComVen.comprarAccion(acc);
			view.getPnAccionesEnVenta().remove(pnAcc);
			view.getPnAccionesEnVenta().repaint();
		}
	}

	private void cerrarVentana() {
		gesPor.rellenarPanelAcciones();
		gesPor.getView().setVisible(true);
		view.dispose();
	}

}
