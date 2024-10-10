package shared.gestionentrada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.data.CreadorDataService;
import backend.data.entradas.EntradaDTO;
import backend.data.entradas.EntradasCRUDService;
import backend.data.ventas.VentasCRUDService;
import backend.service.ventas.entrada.Entrada;
import backend.service.ventas.entrada.Seccion;
import backend.service.ventas.entrada.Tribuna;
import shared.gestionventas.GestionVentasShared;

public class GestionEntradaShared {
	
	EntradasCRUDService service = CreadorDataService.getEntradaService();

	private Map<Tribuna, Map<Seccion, List<List<Entrada>>>> estadio;
	
	/*
	 * Lista auxiliar para guardar temporalmente los asientos que el usuario 
	 * quiere reservar antes de su aceptacion
	 */
	private List<Entrada> entradasReservar;
	private String idPartido;
	
	public GestionEntradaShared() {
	}
	
	public void inicializarParaUI() {
		inicializarMap();
		
		this.entradasReservar = new ArrayList<>();
	}
	
	public void setPartidoId(String idPartido) {
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

                // Filas (0-10)
                for (int fila = 0; fila <= 10; fila++) {
                    List<Entrada> asientosFila = new ArrayList<>();

                    // Asientos (0-15)
                    for (int asiento = 0; asiento <= 15; asiento++) {
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
	
	// True si se pueden se pueden reservar n asientos
	public boolean canReservarAsientos(String tribuna, String seccion, int n) {
		entradasReservar = buscarAsientosConsecutivos(tribuna, seccion, n);
		return entradasReservar != null;
	}
	
	public void addEntradasBBDD(String dni) {
				
		for (Entrada entrada : entradasReservar) {
			EntradaDTO e = new EntradaDTO();
			e.cod_entrada = entrada.getCodEntrada();
			e.tribuna = entrada.getTribuna().toString();
			e.seccion = entrada.getSeccion().toString();
			e.nFila = entrada.getFila();
			e.nAsiento = entrada.getAsiento();
			e.idPartido = idPartido;
			
			crearVentasParaEntrada(e, dni);
			service.addEntrada(e);
		}
	}
	
	private void crearVentasParaEntrada(EntradaDTO entrada, String dni) {
		GestionVentasShared gvs = new GestionVentasShared();
		gvs.addVentasParaEntradaBBDD(entrada, dni);
	}
	
	public String getEntradasCompradas() {
		String res = "";
		
		for (Entrada e : entradasReservar) {
			res += "Entrada: Tribuna("+e.getTribuna()+") Sección("+e.getSeccion()+") "
					+ "Fila("+e.getFila()+") Asiento("+e.getAsiento()+")\n";
		}
		return res;
	}
	
	/*
	 * Retorna true si el ya existe una venta con ese codigo
	 */
	public boolean checkIfCodExists(String cod) {
		VentasCRUDService ventasService = CreadorDataService.getVentasService();
		return ventasService.findByCodVentas(cod) != null;
	}
}
