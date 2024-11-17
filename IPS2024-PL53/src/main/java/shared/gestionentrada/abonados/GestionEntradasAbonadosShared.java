package shared.gestionentrada.abonados;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import backend.data.CreadorDataService;
import backend.data.abonos.AbonoDTO;
import backend.data.abonos.AbonosCRUDImpl;
import backend.data.abonos.AbonosCRUDService;
import backend.data.abonos.commands.DtoAssemblerAbonos;
import backend.data.asientos.AsientosCRUDService;
import backend.data.entradas.EntradaDTO;
import backend.data.entradas.EntradasCRUDService;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;
import backend.data.partidos.commands.DtoAssemblerPartido;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.eventos.Partido;
import backend.service.ventas.abonos.Abono;
import shared.gestionequipos.partidos.GestorPartidos;

public class GestionEntradasAbonadosShared {
	
	EntradasCRUDService serviceEntradas = CreadorDataService.getEntradaService();
	AsientosCRUDService serviceAsiento = CreadorDataService.getAsientosService();
	PartidosCRUDService servicePartidos = new PartidosCRUDImpl();
	AbonosCRUDService serviceAbonos = new AbonosCRUDImpl();
	VentasCRUDService serviceVentas = new VentasCRUDImpl();
	private GestorPartidos gestorPartidos = new Gerente();
	
	public GestionEntradasAbonadosShared() {
		cargarPartidosConSuplemento();
	}
	
	
	public void cargarPartidosConSuplemento() {
		List<Partido> partidosConSup = DtoAssemblerPartido
				.dtoToPartido(servicePartidos.findPartidosConSuplemento());
		for (Partido partido : partidosConSup) {
			gestorPartidos.addPartidoConSuplemento(partido);
		}
	}
	
	public List<Partido> getPartidosConSuplemento(){
		return this.gestorPartidos.getPartidosConSuplemento();
	}
	
	public Abono getAbonoByCode(String cod) {
		Optional<AbonoDTO> opAbono = serviceAbonos.findAbonoByCode(cod);
		if (opAbono.isEmpty())
			return null;
		Abono abono = DtoAssemblerAbonos.toAbono(opAbono.get());
		return abono;
	}
	
	public boolean compruebaNoHayEntradaParaEseAbono(String idAsiento, String idPartido) {
		Optional<EntradaDTO> entDto = serviceEntradas.findEntradaByAsientoAndPartido(idAsiento, idPartido);
		if (entDto.isEmpty())
			return true;
		else
			return false;
	}


	public void addEntradaABDD(Abono abono, String idPartido) {
		String codEntrada = UUID.randomUUID().toString();
		
		VentaDto ventadto = new VentaDto();
		ventadto.idVenta = codEntrada;
		ventadto.coste = 15;
		ventadto.fecha = new Date();
		ventadto.concepto = "Venta de suplemento para abonado";
		
		serviceVentas.addVentas(ventadto);
		
		EntradaDTO dto = new EntradaDTO();
		dto.cod_entrada = codEntrada;
		dto.coste = 15;
		dto.idAsiento = abono.getIdAsiento();
		dto.idPartido = idPartido;
		
		serviceEntradas.addEntrada(dto);
		
		
	}

}
