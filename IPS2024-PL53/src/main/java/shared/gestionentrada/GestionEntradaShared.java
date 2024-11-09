package shared.gestionentrada;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import backend.data.CreadorDataService;
import backend.data.entradas.EntradaDTO;
import backend.data.entradas.EntradasCRUDService;
import backend.service.ventas.entrada.Entrada;
import backend.service.ventas.entrada.Seccion;
import backend.service.ventas.entrada.Tribuna;
import frontend.SwingUtil;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entradaUI.VentanaSeleccionEntradas;
import shared.gestionpartido.GestionPartidoShared;

public class GestionEntradaShared {
	
	EntradasCRUDService service = CreadorDataService.getEntradaService();

	private Map<Tribuna, Map<Seccion, List<List<Entrada>>>> estadio;
	private String idPartido;
	private VentanaPrincipalEntrada view;
	private Date[][] datos;
	
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
		GestionVentanaSeleccion gvs = new GestionVentanaSeleccion(vSE,estadio,idPartido,view);
		gvs.initController();
		vSE.setVisible(true);
		view.setVisible(false);
	}
	
	private void seleccionarPartido() {
		int row = view.getTablePartidos().getSelectedRow();
		Date fecha = datos[row][0];
		Time inicio = new Time(datos[row][1].getTime());
		Time fin = new Time(datos[row][2].getTime());
		GestionPartidoShared gps = new GestionPartidoShared();
		String partidoId = gps.getIdPartidoByFechaInicioFin(fecha, inicio, fin);
		inicializarMap();
		setPartidoId(partidoId);	
	}
	
	private String[] creaColumnas() {
	    String[] titColumna = {"Fecha", "Hora inicio", "Hora fin"};
	    return titColumna;
	}
	
	private Date[][] cargaDatos() {
		GestionPartidoShared gps = new GestionPartidoShared();
		this.datos = gps.getTodosPartidos();
		return datos;
	}
	
	private void setPartidoId(String idPartido) {
		this.idPartido = idPartido;
		cargarMap();
	}
	
	private void inicializarMap() {
		this.estadio = new HashMap<>();
		// Tribunas (a-d)
		for (Tribuna tribuna : Tribuna.values()) {
            estadio.put(tribuna, new HashMap<>());

            // Secciones (a-f)
            for (Seccion seccion : Seccion.values()) {
                estadio.get(tribuna).put(seccion, new ArrayList<>());

                // Filas (0-9)
                for (int fila = 0; fila <= 9; fila++) {
                    List<Entrada> asientosFila = new ArrayList<>();

                    // Asientos (0-14)
                    for (int asiento = 0; asiento <= 14; asiento++) {
                        Entrada entrada = new Entrada(tribuna, seccion, fila, asiento);
                        asientosFila.add(entrada);
                    }

                    estadio.get(tribuna).get(seccion).add(asientosFila);
                }
            }
        }
		
	}
	
	private void cargarMap() {
		
		List<EntradaDTO> entradasEnBBDD = service.findByIDPartidoEntrada(idPartido);
		
		for (EntradaDTO entrada : entradasEnBBDD) {
			estadio.get(Tribuna.valueOf(entrada.tribuna.toUpperCase())).get(Seccion.valueOf(entrada.seccion.toUpperCase())).get(entrada.nFila).get(entrada.nAsiento).setCodEntrada(entrada.cod_entrada);
			estadio.get(Tribuna.valueOf(entrada.tribuna.toUpperCase())).get(Seccion.valueOf(entrada.seccion.toUpperCase())).get(entrada.nFila).get(entrada.nAsiento).setOcupado(true);
		}
	}
}
