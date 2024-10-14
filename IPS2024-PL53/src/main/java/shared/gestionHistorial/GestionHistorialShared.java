package shared.gestionHistorial;

import java.awt.CardLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

import backend.data.CreadorDataService;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;
import frontend.SwingUtil;
import frontend.historialVentas.HistorialVentas;


public class GestionHistorialShared {
	private HistorialVentas view;
	
	public GestionHistorialShared(HistorialVentas v) {
		this.view = v;

		this.initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getSpInicio().addChangeListener(e -> SwingUtil.exceptionWrapper(() -> controlarFechaInicio()));
		
		view.getSpFin().addChangeListener(e -> SwingUtil.exceptionWrapper(() -> controlarFechaFin()));
		
		view.getBtConfirmarFecha().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showTablaHistorial()));
		
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> confirmar()));
		
		view.getBtSeleccionar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> seleccionarPanel()));
		
		view.getBtAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> showPn1()));
		
		view.getTablaResumenVentas().getSelectionModel().addListSelectionListener(e -> SwingUtil.exceptionWrapper(() -> accionSeleccionarFilas()));
	}

	public void initView() {
		
	}
	
	private void controlarFechaInicio() {
		Date inicioDate = (Date) view.getSpInicio().getValue();
        ((SpinnerDateModel) view.getSpFin().getModel()).setStart(inicioDate);
	}
	
	private void controlarFechaFin() {
		Date finDate = (Date) view.getSpFin().getValue();
        ((SpinnerDateModel) view.getSpInicio().getModel()).setEnd(finDate);
	}
	
	private void showTablaHistorial() {
		restablecerTablaModelo(view.getTablaResumenVentas());
		restablecerTablaModelo(view.getTableResumenCompraMerchan());
		VentasCRUDService service = CreadorDataService.getVentasService();
		Date inicio = (Date) view.getSpInicio().getValue();
		Date fin = (Date) view.getSpFin().getValue();
		addVentas(service.findVentasFechas(inicio, fin));
	}
	
	// Método para añadir un producto al resumen
		private void addVentas(List<VentaDto> ventas) {
			for(VentaDto v : ventas) {
			    Object[] rowData = {"P", v.getFecha(), v.getCoste()};
			    view.getModelVentas().addRow(rowData);
			}
		}
	
	private void confirmar() {
		if(confirfmarCancelacion()) {
			System.exit(0);
		}	
	}

	private boolean confirfmarCancelacion() {
		boolean confirmacion=false;
		int response = JOptionPane.showConfirmDialog(null,"¿Estás seguro que quieres salir de la ventana?");
		if(response==JOptionPane.YES_OPTION) {
				confirmacion=true;
		}
		return confirmacion;
	}
	
	private void seleccionarPanel(){
		int filaSeleccionada = view.getTablaResumenVentas().getSelectedRow();
		String concepto = (String) view.getTablaResumenVentas().getValueAt(filaSeleccionada, 0);
		if(concepto.equals("merchandising")) {
			showPn2();
		}else {
			showPn3();
		}
	}
	
	private void accionSeleccionarFilas() {
		boolean isRowSelected = view.getTablaResumenVentas().getSelectedRow() != -1;
        view.getBtSeleccionar().setEnabled(isRowSelected);
	}
	
	private void restablecerTablaModelo(JTable tabla) {
		DefaultTableModel model = (DefaultTableModel) (tabla.getModel());
		model.setRowCount(0);
	}
	
	private void showPn1() {
		view.getPn1().add(view.getPnInfo1());
		view.getTfBalance().setText("Balance: ");
		((CardLayout)view.getFrmHistorialDeVentas().getContentPane().getLayout()).show(view.getFrmHistorialDeVentas().getContentPane(),"pn1");
	}
	
	private void showPn2() {
		view.getPn2().add(view.getPnInfo2());
		view.getTfBalance().setText("Precio Total: ");
		((CardLayout)view.getFrmHistorialDeVentas().getContentPane().getLayout()).show(view.getFrmHistorialDeVentas().getContentPane(),"pn2");	
	}
	
	private void showPn3() {
		view.getPn3().add(view.getPnInfo3());
		((CardLayout)view.getFrmHistorialDeVentas().getContentPane().getLayout()).show(view.getFrmHistorialDeVentas().getContentPane(),"pn3");
	}

	
	
}

