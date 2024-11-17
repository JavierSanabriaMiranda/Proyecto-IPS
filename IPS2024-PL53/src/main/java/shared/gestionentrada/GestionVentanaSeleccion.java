 package shared.gestionentrada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.data.CreadorDataService;
import backend.data.asientos.AsientoDTO;
import backend.data.asientos.AsientosCRUDService;
import backend.data.clientes.ClienteDTO;
import backend.data.clientes.ClientesCRUDService;
import backend.data.entradas.EntradaDTO;
import backend.data.entradas.EntradasCRUDService;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;
import backend.service.ventas.entrada.Entrada;
import frontend.SwingUtil;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entradaUI.VentanaSeleccionEntradas;

public class GestionVentanaSeleccion {
	private VentanaSeleccionEntradas view;
	private String idPartido;
	private List<Entrada> entradas;
	VentanaPrincipalEntrada ventanaPrincipalEntrada;
	
	public GestionVentanaSeleccion(VentanaSeleccionEntradas view, String idPartido, VentanaPrincipalEntrada v) {
		this.view = view;
		this.idPartido = idPartido;
		entradas = new ArrayList<Entrada>();
		this.ventanaPrincipalEntrada=v;
	}

	public void initController() {
		view.getBtContinuar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionFinalizar()));
		
		view.getBtAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarVentanaAnterior()));
		
		view.getTxDni().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleContinuarButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleContinuarButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleContinuarButton();
            }
        });
    }
	
	private void accionFinalizar() {
		int[] filaAsiento = canBook();
		if(filaAsiento[0]!=-1) {
			añadirTodoBBDD(filaAsiento[0], filaAsiento[1]);
			mostrarMensaje(filaAsiento[0], filaAsiento[1]);
			cerrarVentana();
		}else {
			if((int)view.getSpAsientos().getValue()==1)
				JOptionPane.showMessageDialog(null, "No hay ningun asiento libre en la tribuna y seccion indicada",
						"Error en la Reserva",JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "No hay tantos asientos contiguos libres en la tribuna y seccion indicada",
						"Error en la Reserva",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private int[] canBook() {
		String tribuna = (String) view.getCbTribuna().getSelectedItem();
		String seccion = (String) view.getCbSeccion().getSelectedItem();
		int nAsientos = (int)view.getSpAsientos().getValue();
		return comprobarAsientosLibres(tribuna,seccion,nAsientos);
		
	}

	private int[] comprobarAsientosLibres(String tribuna, String seccion, int nAsientos) {
	    AsientosCRUDService service = CreadorDataService.getAsientosService();
	    for (int fila = 0; fila < 10; fila++) {
	        int asientosLibres = 0;
	        int asientoInicio = -1;
	        for (int asiento = 0; asiento < 15; asiento++) {
	            if (service.findEqualAsiento(tribuna, seccion, String.valueOf(fila), String.valueOf(asiento)).idAsiento == null) {
	                if (asientosLibres == 0)
	                    asientoInicio = asiento;
	                asientosLibres++;
	                entradas.add(new Entrada());
	                if (asientosLibres == nAsientos)
	                    return new int[]{fila, asientoInicio};
	            } else {
	                asientosLibres = 0;
	                asientoInicio = -1;
	                entradas.clear();
	            }
	        }
	    }
	    return new int[]{-1, -1};
	}

	
	private void añadirTodoBBDD(int fila, int asiento) {
		añadirCliente();
		añadirVentas();
		añadirAsientosYEntradas(fila, asiento);
	}

	private void añadirCliente() {
		ClientesCRUDService serviceClientes = CreadorDataService.getClientesService();
		serviceClientes.addCliente(new ClienteDTO(view.getTxDni().getText(),""));
	}

	private void añadirVentas() {
		VentasCRUDService serviceVentas = CreadorDataService.getVentasService();
		for(Entrada e : entradas)
			serviceVentas.addVentas(new VentaDto(e.getCodEntrada(),view.getTxDni().getText(),new Date(),e.PRECIO));
	}
	
	private void añadirAsientosYEntradas(int fila, int asiento) {
		AsientosCRUDService service = CreadorDataService.getAsientosService();
		EntradasCRUDService service2 = CreadorDataService.getEntradaService();
		for(Entrada e : entradas) {
			AsientoDTO asientoDTO = new AsientoDTO(
					UUID.randomUUID().toString(),
					(String) view.getCbTribuna().getSelectedItem(),
					(String) view.getCbSeccion().getSelectedItem(),
					fila,
					asiento);
			service.addAsiento(asientoDTO);
			service2.addEntrada(new EntradaDTO(e.getCodEntrada(),idPartido,asientoDTO.idAsiento));
		}
	}

	private void mostrarMensaje(int fila, int asiento) {
		JOptionPane.showMessageDialog(null, mostrarEntradasSeleccionadas(fila, asiento), "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}

	private String mostrarEntradasSeleccionadas(int fila, int asiento) {
		String mensaje="Gracias por la compra!\n";
		for(int i=0; i<asiento;i++) {
			mensaje+="Entrada "+i+": Tribuna("+view.getCbTribuna().getSelectedItem()+"), Sección("+
					view.getCbSeccion().getSelectedItem()+"), Fila("+fila+"), Asiento("+(asiento+i)+")\n";
		}
		return mensaje;
	}

	private void cerrarVentana() {
		view.dispose();
		ventanaPrincipalEntrada.setVisible(true);  
		ventanaPrincipalEntrada.dispose();
	}
	
	private void mostrarVentanaAnterior() {
		view.setVisible(false);
		ventanaPrincipalEntrada.setVisible(true);	
	}
	
	private void toggleContinuarButton() {
        view.getBtContinuar().setEnabled(!view.getTxDni().getText().trim().isEmpty());
    }
	
}
