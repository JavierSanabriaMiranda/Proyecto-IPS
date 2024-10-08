package backend.service.ventas.entrada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentaEntradas {
	
	private Map<Tribuna, Map<Seccion, List<List<Entrada>>>> estadio;
	
	/*
	 * Lista auxiliar para guardar temporalmente los asientos que el usuario 
	 * quiere reservar antes de su aceptacion
	 */
	private List<Entrada> entradasReservar;
	
	public VentaEntradas() {
		inicializarMap();
		this.entradasReservar = new ArrayList<>();
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
	
	private List<Entrada> buscarAsientosConsecutivos(String tribuna, String seccion, int n) {
        if (!estadio.containsKey(tribuna) || !estadio.get(tribuna).containsKey(seccion)) {
            System.out.println("La tribuna o la sección no existen.");
            // No dejar intruducir valores incorrectos en ui
        }

        // Recorre cada fila de la sección dada
        List<Entrada> asientosLibresConsecutivos = new ArrayList<>();
        for (List<Entrada> fila : estadio.get(tribuna).get(seccion)) {

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

        return asientosLibresConsecutivos;
    }
	
	public boolean encontrarAsientos(String tribuna, String seccion, int n) {
		entradasReservar = buscarAsientosConsecutivos(tribuna, seccion, n);
		return this.entradasReservar.isEmpty();
	}
	
	public void reservarAsientos() {
		for (Entrada e : entradasReservar) {
			e.setOcupado(true);
		}
//		grabarABase();
	}
}
