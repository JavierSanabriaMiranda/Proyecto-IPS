package shared.gestionestadisticos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.Month;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import backend.data.ventas.VentaDto;
import frontend.SwingUtil;
import frontend.estadisticos.FrameEstadisticosGastosEIngresos;

public class GestionFrameEstadisticosGastosEIngresosShared {

	private static final String NO_PERIOCIDAD = "";
	private static final String PERIOCIDAD_MENSUAL = "Mensual";
	private static final String PERIOCIDAD_ANUAL = "Anual";
	
	private GestionEstadisticosGastosEIngresosShared gesEst = new GestionEstadisticosGastosEIngresosShared();
	private FrameEstadisticosGastosEIngresos view;
	private String periocidad = "";
	
	
	public GestionFrameEstadisticosGastosEIngresosShared(FrameEstadisticosGastosEIngresos view) {
		this.view = view;
	}

	public void initController() {
		view.getCbPeriocidad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> seleccionarPeriocidad()));
		view.getBtMostrarGrafico().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarGrafico()));
	}

	private void mostrarGrafico() {
		if (periocidad == PERIOCIDAD_ANUAL) {
			mostrarGraficoAnual();
		} else if (periocidad == PERIOCIDAD_MENSUAL) {
			mostrarGraficoMensual();
		}
			
	}

	private void mostrarGraficoMensual() {
		// TODO Implementar
	}

	private void mostrarGraficoAnual() {
		List<VentaDto> ingresosPeriocidadAnual = gesEst.getVentasAnual(view.getYearChooser().getYear());
		
		// Crea el dataset y añade los datos de la lista de ventas
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (VentaDto venta : ingresosPeriocidadAnual) {
            dataset.addValue(venta.getCoste(), "Ingresos", Month.of(venta.mes));
        }
        
        // Crea el gráfico de barras agrupado
        JFreeChart barChart = ChartFactory.createBarChart(
                "Gráfico de Ventas",  // Título
                "Mes",               // Etiqueta del eje X
                "Coste",             // Etiqueta del eje Y
                dataset,             // Dataset
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Inserta el gráfico en un ChartPanel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        view.getPnGrafico().add(chartPanel, BorderLayout.CENTER);
        view.getPnGrafico().revalidate();  // Asegura que el panel se redibuje
	}

	private void seleccionarPeriocidad() {
		String seleccion = (String) view.getCbPeriocidad().getSelectedItem();
		
		if (seleccion.isEmpty()) {
			periocidad = NO_PERIOCIDAD;
			view.getLbFecha().setText("");
			view.getPnPeriocidad().remove(view.getMonthChooser());
			view.getPnPeriocidad().remove(view.getYearChooser());
			view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
			view.repaint();
		} else {
			if (seleccion.equalsIgnoreCase("Mensual")) {
				periocidad = PERIOCIDAD_MENSUAL;
				view.getLbFecha().setText("Mes:");
				view.getPnPeriocidad().remove(view.getYearChooser());
				view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
				view.repaint();
				view.getPnPeriocidad().add(view.getMonthChooser());
			} else if (seleccion.equalsIgnoreCase("Anual")) {
				periocidad = PERIOCIDAD_ANUAL;
				view.getLbFecha().setText("Año:");
				view.getPnPeriocidad().remove(view.getMonthChooser());
				view.getPnPeriocidad().remove(view.getBtMostrarGrafico());
				view.repaint();
				view.getPnPeriocidad().add(view.getYearChooser());
			}
			view.getPnPeriocidad().add(view.getBtMostrarGrafico());
		}
		
	}
	
}
