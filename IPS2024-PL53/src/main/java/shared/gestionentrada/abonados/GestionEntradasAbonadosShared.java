package shared.gestionentrada.abonados;

import backend.data.CreadorDataService;
import backend.data.asientos.AsientosCRUDService;
import backend.data.entradas.EntradasCRUDService;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;
import backend.service.empleados.nodeportivos.Gerente;
import shared.gestionequipos.GestorEquipos;

public class GestionEntradasAbonadosShared {
	
	EntradasCRUDService serviceEntradas = CreadorDataService.getEntradaService();
	AsientosCRUDService serviceAsiento = CreadorDataService.getAsientosService();
	PartidosCRUDService servicePartidos = new PartidosCRUDImpl();
	private GestorEquipos gestorEquipos = new Gerente();
	
	public GestionEntradasAbonadosShared() {
		cargarPartidos();
	}
	
	
	public void cargarPartidos() {
		
	}

}
