package shared.gestionAbonos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Date;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.data.CreadorDataService;
import backend.data.abonos.AbonoDTO;
import backend.data.abonos.AbonosCRUDService;
import backend.data.asientos.AsientoDTO;
import backend.data.asientos.AsientosCRUDService;
import backend.data.clientes.ClienteDTO;
import backend.data.clientes.ClientesCRUDService;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;
import backend.service.ventas.abono.Abono;
import frontend.SwingUtil;
import frontend.abonos.VentanaAbonos;

public class GestionVentaAbonos {
	private VentanaAbonos view;
	private Abono abono;
	
	public GestionVentaAbonos(VentanaAbonos v) {
		this.view = v;
		abono = new Abono();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.getBtSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionSiguiente()));
		
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));
		
		view.getBtAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() ->showPn1()));
		
		view.getBtConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionFinal()));
		
		view.getRdAdulto().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarMensajePrecio("Adulto")));
		
		view.getRdMenor().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarMensajePrecio("Menor")));
		
		view.getRdJuvilado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarMensajePrecio("Juvilado")));
		
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
	
	private void showPn1() {
		view.getPn1().add(view.getLbTitulo(),BorderLayout.NORTH);
		((CardLayout) view.contentPane.getLayout()).show(view.contentPane, "pn1");
	}
	
	private void showPn2() {
		view.getPn2().add(view.getLbTitulo(),BorderLayout.NORTH);
		mostrarMensajeResumen();
		mostrarMensajePrecio("Adulto");
		((CardLayout) view.contentPane.getLayout()).show(view.contentPane, "pn2");
	}

	private void accionSiguiente() {
		if(isAsientoLibre()) {
			showPn2();
		}else {
			JOptionPane.showMessageDialog(null, "Este asiento ya esta reservado por otro abonado", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private boolean isAsientoLibre() {
		AsientosCRUDService service = CreadorDataService.getAsientosService();
		String tribuna = (String) view.getCbTribuna().getSelectedItem();
		String seccion = (String) view.getCbSeccion().getSelectedItem();
		String fila = (String) view.getCbFila().getSelectedItem();
		String asiento = (String) view.getCbAsiento().getSelectedItem();
		return service.findEqualAsiento(tribuna,seccion,fila,asiento).idAsiento==null;
	}

	private void accionFinal() {
		añadirCliente();
		añadirVenta();
		String idAsiento = añadirAsiento();
		añadirAbono(idAsiento);
		mostrarMensaje();
		view.dispose();
	}

	private void añadirCliente() {
		ClientesCRUDService serviceClientes = CreadorDataService.getClientesService();
		serviceClientes.addCliente(new ClienteDTO(view.getTfDNI().getText(),""));
		
	}
	
	private void añadirVenta() {
		VentasCRUDService serviceVentas = CreadorDataService.getVentasService();
		serviceVentas.addVentas(new VentaDto(abono.getCodAbono(),view.getTfDNI().getText(),new Date(),abono.getPrecio()));
	}

	private String añadirAsiento() {
		AsientosCRUDService service = CreadorDataService.getAsientosService();
		AsientoDTO asiento = new AsientoDTO();
		asiento.nAsiento = Integer.parseInt(view.getCbAsiento().getSelectedItem().toString());
		asiento.nFila = Integer.parseInt(view.getCbFila().getSelectedItem().toString());
		asiento.seccion = (String) view.getCbSeccion().getSelectedItem();
		asiento.tribuna = (String) view.getCbTribuna().getSelectedItem();
		String idAsiento = UUID.randomUUID().toString();
		asiento.idAsiento = idAsiento;
		service.addAsiento(asiento);
		
		return idAsiento;
	}

	private void añadirAbono(String idAsiento) {
		AbonosCRUDService service = CreadorDataService.getAbonosService();
		AbonoDTO abono = new AbonoDTO();
		abono.codAbono=this.abono.getCodAbono();
		abono.idAsiento=idAsiento;
		service.addAbono(abono);
	}

	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, "Gracias por la compra!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostrarMensajeResumen() {
		String mensaje="\n\t- Tribuna: " + view.getCbTribuna().getSelectedItem() + "\n";
		mensaje+="\t- Sección: " + view.getCbSeccion().getSelectedItem() + "\n";
		mensaje+="\t- Fila: " + view.getCbFila().getSelectedItem() + "\n";
		mensaje+="\t- Asiento: " + view.getCbAsiento().getSelectedItem() + "\n";
		view.getTaResumen().setText(mensaje);
	}
	
	private void mostrarMensajePrecio(String tipo){
		calcularPrecio(tipo);
		view.getTfPrecio().setText("    Precio del abono: " + abono.getPrecio()+ " €");
	}
	
	private void calcularPrecio(String tipo) {
		switch(tipo) {
			case "Adulto" : abono.setPrecio(320);
				break;
			case "Menor" : abono.setPrecio(160);
				break;
			case "Juvilado" : abono.setPrecio(200);
				break;
		}
	}
	
	private void toggleButtonState() {
        view.getBtConfirmar().setEnabled(!view.getTfDNI().getText().trim().isEmpty());
    }
	
}
