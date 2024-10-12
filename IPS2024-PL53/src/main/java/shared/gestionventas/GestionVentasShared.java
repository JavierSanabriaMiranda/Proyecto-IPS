package shared.gestionventas;

import java.math.BigDecimal;
import java.util.Date;

import backend.data.CreadorDataService;
import backend.data.entradas.EntradaDTO;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;
import backend.service.ventas.entrada.Entrada;

public class GestionVentasShared {
	
	private VentasCRUDService service = new CreadorDataService().getVentasService();
	
	public void addVentasParaEntradaBBDD(EntradaDTO entrada, String dni) {
		VentaDto venta = new VentaDto();
		venta.idVenta = entrada.cod_entrada;
		venta.DNI = dni;
		venta.coste = Entrada.PRECIO;
		venta.fecha = new Date();
		
		service.addVentas(venta);
	}

}
