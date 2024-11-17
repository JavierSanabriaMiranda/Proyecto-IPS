package shared.gestionentrada.abonados;

import javax.swing.JOptionPane;

import backend.service.eventos.Partido;
import backend.service.ventas.abonos.Abono;
import frontend.SwingUtil;
import frontend.entradaUI.abonados.VentanaInicioAbonados;

public class GestionPanelEntradasAbonadosShared {
	
	private VentanaInicioAbonados view;

	public GestionPanelEntradasAbonadosShared(VentanaInicioAbonados view) {
		this.view = view;
	}
	
	public void initController() {
		view.getBtnAtras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getBtnComprar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprarEntrada()));
	}

	
	
	private void comprarEntrada() {
		if (campoCodigoAbonoVaio()) {
			JOptionPane.showMessageDialog(null,
					"Debes de indicar tu código de abono.", "Error Código Abono",
					JOptionPane.WARNING_MESSAGE);
		} else if (!isAbonado()) {
			JOptionPane.showMessageDialog(null,
					"El código del abono no existe.", "Error Código Abono",
					JOptionPane.WARNING_MESSAGE);
		} else if(verificarSeleccionPartido()) {
			JOptionPane.showMessageDialog(null,
					"Debes escoger el Partido que deseas comprar.", "Error Selección de Partido",
					JOptionPane.WARNING_MESSAGE);
		} else if(!verificarEntradaYaComprada()) {
			JOptionPane.showMessageDialog(null,
					"Ya se ha comprado una entrada con este abono para este partido", "Error Selección de Partido",
					JOptionPane.WARNING_MESSAGE);
		} else {
			addEntrada();
			JOptionPane.showMessageDialog(null, "Su entrada ha sido comprada.", "Entrada comprada",
					JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		}
	}

	private boolean verificarEntradaYaComprada() {
		Abono abono = view.getGeas().getAbonoByCode(view.getTxtCodAbono().getText());
		
		Partido partido = view.getListPartidos().getSelectedValue();
		return view.getGeas().compruebaNoHayEntradaParaEseAbono(abono.getIdAsiento(), partido.getIdPartido());
	}

	private boolean campoCodigoAbonoVaio() {
		if (view.getTxtCodAbono().getText().isBlank())
			return true;
		return false;
	}

	private boolean verificarSeleccionPartido() {
		return view.getListPartidos().isSelectionEmpty();
	}

	private boolean isAbonado() {
		Abono abono = view.getGeas().getAbonoByCode(view.getTxtCodAbono().getText());
		if (abono == null)
			return false;
		return true;
	}
	
	private void addEntrada() {
		Abono abono = view.getGeas().getAbonoByCode(view.getTxtCodAbono().getText());
		
		Partido partido = view.getListPartidos().getSelectedValue();
		
		view.getGeas().addEntradaABDD(abono, partido.getIdPartido());
	}
	

}
