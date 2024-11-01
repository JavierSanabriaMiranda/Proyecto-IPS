package shared.gestionAcciones;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.data.CreadorDataService;
import backend.data.acciones.AccionDTO;
import backend.data.acciones.AccionesCRUDService;
import backend.service.ventas.campanaAccionistas.Accion;
import frontend.SwingUtil;
import frontend.campaña_de_acciones.PanelAccion;
import frontend.campaña_de_acciones.PortalAccionistas;

public class GestionPortalAccionistasShared {
	PortalAccionistas view;
	public GestionPortalAccionistasShared(PortalAccionistas view) {
		this.view = view;
		
		initView();
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getBtLogin().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn2()));
		
		view.getBtComprar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionComprar()));
		
		view.getTfDNI().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleButtonState();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleButtonState();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleButtonState();
            } 
        });
	}

	private void initView() {
		showPn1();
		view.getTfDNI().setText("");
		view.getBtLogin().setEnabled(false);
	}
	
	private void showPn1() {
		((CardLayout) view.getContentPane().getLayout()).show(view.getContentPane(), "pn1");
	}

	private void showPn2() {
		((CardLayout) view.getContentPane().getLayout()).show(view.getContentPane(), "pn2");
		view.getLbAcciones().setText("Acciones permitidas: "+calcularAccionesPermitidas());
		rellenarPanelAcciones();
	}
	
	private void rellenarPanelAcciones() {
		AccionesCRUDService service = CreadorDataService.getAccionesService();
		List<AccionDTO> acciones = service.findAccionesByDNI(view.getTfDNI().getText());
		for(AccionDTO a : acciones) {
			view.getPnListaAcciones().add(new PanelAccion(new Accion(a.getIdAccion())));
		}
	}

	private String calcularAccionesPermitidas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void accionComprar() {
		// TODO Auto-generated method stub
	}

	private void toggleButtonState() {
        view.getBtLogin().setEnabled(!view.getTfDNI().getText().trim().isEmpty());
    }
	
}
