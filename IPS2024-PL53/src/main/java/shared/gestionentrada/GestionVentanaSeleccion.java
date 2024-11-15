package shared.gestionentrada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import backend.service.ventas.entrada.Seccion;
import backend.service.ventas.entrada.Tribuna;
import frontend.SwingUtil;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entradaUI.VentanaSeleccionEntradas;

public class GestionVentanaSeleccion {
	private VentanaSeleccionEntradas view;
	private Map<Tribuna, Map<Seccion, List<List<Entrada>>>> estadio;
	private String idPartido;
	private List<Entrada> entradasReservar;
	VentanaPrincipalEntrada ventanaPrincipalEntrada;
	
	public GestionVentanaSeleccion(VentanaSeleccionEntradas view, Map<Tribuna, Map<Seccion, List<List<Entrada>>>> estadio,
			String idPartido, VentanaPrincipalEntrada v) {
		this.view = view;
		this.estadio = estadio;
		this.idPartido = idPartido;
		this.entradasReservar = new ArrayList<>();
		this.ventanaPrincipalEntrada=v;
	}

	public void initController() {
		view.getBtContinuar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> accionContinuar()));
		
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentana()));
		
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

	private void accionContinuar() {
		if (checkIfCanBook()) {
			List<AsientoDTO> asientos = addAsientoBBDD();
			addEntradasBBDD(view.getTxDni().getText(), asientos);
			
			JOptionPane.showMessageDialog(null, "Gracias por la compra.\n" + getEntradasCompradas());
			cerrarVentana();
		} else {
			if((int) view.getSpAsientos().getValue()==1)
				JOptionPane.showMessageDialog(null, "No hay asientos en esta tribuna y sección.");
			else
				JOptionPane.showMessageDialog(null, "No se pueden reservar tantos asientos contiguos.");
		}
		
	}

	private boolean checkIfCanBook() {
		String tribuna = (String) view.getCbTribuna().getSelectedItem();
		String seccion = (String) view.getCbSeccion().getSelectedItem();
		int nAsientos = (int) view.getSpAsientos().getValue();
		return canReservarAsientos(tribuna, seccion, nAsientos);
	}
	
	// True si se pueden se pueden reservar n asientos
	public boolean canReservarAsientos(String tribuna, String seccion, int n) {
		entradasReservar = buscarAsientosConsecutivos(tribuna, seccion, n);
		return entradasReservar != null;
	}
	
	private List<Entrada> buscarAsientosConsecutivos(String trib, String sec, int n) {
		Tribuna tribuna = Tribuna.valueOf(trib.toUpperCase());
		Seccion seccion = Seccion.valueOf(sec.toUpperCase());
        if (!estadio.containsKey(tribuna) || !estadio.get(tribuna).containsKey(seccion)) {
            System.out.println("La tribuna o la sección no existen.");
        }

        // Recorre cada fila de la sección dada
        for (List<Entrada> fila : estadio.get(tribuna).get(seccion)) {
            List<Entrada> asientosLibresConsecutivos = new ArrayList<>();

            // Recorre cada asiento de la fila
            for (Entrada asiento : fila) {
                if (!asiento.isOcupado()) {
                    asientosLibresConsecutivos.add(asiento); // Añade el asiento libre a la lista

                    // Si ya encontramos `n` asientos consecutivos, los devolvemos
                    if (asientosLibresConsecutivos.size() == n) {
                        return asientosLibresConsecutivos;
                    }
                } else {
                    asientosLibresConsecutivos.clear(); // Si encontramos un asiento ocupado, reiniciamos la lista
                }
            }
        }
        return null;
    }
	
	public void addEntradasBBDD(String dni, List<AsientoDTO> asientos) {
		EntradasCRUDService service = CreadorDataService.getEntradaService();
		for (Entrada entrada : entradasReservar) {
			int nAsiento = entrada.getAsiento();
			AsientoDTO asiento = null;
			
			for (AsientoDTO dto : asientos) {
				if (dto.nAsiento == nAsiento) {
					asiento = dto;
					break;
				}
			}
			if (asiento == null)
				throw new IllegalStateException("Hay una entrada con un asiento que no se ha registrado");
			
			EntradaDTO e = new EntradaDTO(
			entrada.getCodEntrada(),
			idPartido,
			asiento.idAsiento,
			entrada.PRECIO);
			
			crearVentasParaEntrada(e, dni);
			service.addEntrada(e);
		}
	}
	
	private List<AsientoDTO> addAsientoBBDD() {
		AsientosCRUDService service = CreadorDataService.getAsientosService();
		List<AsientoDTO> asientos = new ArrayList<>();
		for (Entrada entrada : entradasReservar) {
			AsientoDTO dtoA = new AsientoDTO();
			dtoA.nAsiento = entrada.getAsiento();
			dtoA.nFila = entrada.getFila();
			dtoA.seccion = entrada.getSeccion().toString();
			dtoA.tribuna = entrada.getTribuna().toString();
			dtoA.idAsiento = UUID.randomUUID().toString();
			asientos.add(dtoA);
			service.addAsiento(dtoA);
		}
		return asientos;
	}
	
	private void crearVentasParaEntrada(EntradaDTO entrada, String dni) {
		ClientesCRUDService serviceClientes = CreadorDataService.getClientesService();
		serviceClientes.addCliente(new ClienteDTO(dni,""));
		VentasCRUDService serviceVentas = CreadorDataService.getVentasService();
		serviceVentas.addVentas(new VentaDto(entrada.cod_entrada,dni,new Date(),entrada.coste));
	}
	
	public String getEntradasCompradas() {
		String res = "";
		
		for (Entrada e : entradasReservar) {
			res += "Entrada: Tribuna("+e.getTribuna()+") Sección("+e.getSeccion()+") "
					+ "Fila("+e.getFila()+") Asiento("+e.getAsiento()+")\n";
		}
		return res;
	}
	
	private void cerrarVentana() {
		view.dispose();
		ventanaPrincipalEntrada.setVisible(true);  
		ventanaPrincipalEntrada.dispose();
	}
	
	private void toggleContinuarButton() {
        // Habilitar el botón solo si hay texto en el campo txDni
        view.getBtContinuar().setEnabled(!view.getTxDni().getText().trim().isEmpty());
    }
	
}
