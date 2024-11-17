package shared.gestionentrada;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import backend.data.CreadorDataService;
import backend.data.partidos.PartidoDTO;
import backend.data.partidos.PartidosCRUDService;
import frontend.SwingUtil;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entradaUI.VentanaSeleccionEntradas;

public class GestionEntradaShared {
	private VentanaPrincipalEntrada view;
	String partidoId;
	
	public GestionEntradaShared(VentanaPrincipalEntrada view) {
		this.view=view;
	
		initView();
	}
	
	private void initView() {
		JTable tablePartidos = view.getTablePartidos();
	    tablePartidos.setModel(new DefaultTableModel(cargaDatos(), creaColumnas()));
	}
	
	public void initController() {
		view.getBtSeleccionar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarVentanaSeleccion()));
		
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getTablePartidos().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        // Habilita el botón solo si hay una fila seleccionada
		        if (!event.getValueIsAdjusting()) { // Evita que se dispare el evento varias veces
		            view.getBtSeleccionar().setEnabled(view.getTablePartidos().getSelectedRow() != -1);
		        }
		    }
		});
	
	}
	
	private void mostrarVentanaSeleccion() {
		seleccionarPartido();
		VentanaSeleccionEntradas vSE = new VentanaSeleccionEntradas();
		GestionVentanaSeleccion gvs = new GestionVentanaSeleccion(vSE,partidoId,view);
		gvs.initController();
		vSE.setVisible(true);
		view.setVisible(false);
	}
	
	private void seleccionarPartido() {
		int row = view.getTablePartidos().getSelectedRow();
		Date fecha = (Date) view.getTablePartidos().getValueAt(row, 0);
		Time inicio = (Time) view.getTablePartidos().getValueAt(row, 1);
		Time fin = (Time) view.getTablePartidos().getValueAt(row, 2);
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		partidoId = service.findIdByFechaInicioFin(fecha, inicio, fin);	
	}
	
	private String[] creaColumnas() {
	    String[] titColumna = {"Fecha", "Hora inicio", "Hora fin"};
	    return titColumna;
	}
	
	private Date[][] cargaDatos() {
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		List<PartidoDTO> partidos = service.findAllPartidos();
		
		Date[][] partidosFechas = new Date[partidos.size()][3];
		
		for (int i = 0 ; i < partidos.size() ; i++) {
			partidosFechas[i][0] = partidos.get(i).fecha; 
			partidosFechas[i][1] = partidos.get(i).horaInicio; 
			partidosFechas[i][2] = partidos.get(i).horaFin; 
			
		}
		return partidosFechas;
	}
}
