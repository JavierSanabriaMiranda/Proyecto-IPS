package shared.gestionventas;

import java.math.BigDecimal;
import java.util.Date;

import backend.data.CreadorDataService;
import backend.data.entradas.EntradaDTO;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.VentasDTO;
import backend.service.ventas.entrada.Entrada;

public class GestionVentasShared {
	
	private VentasCRUDService service = new CreadorDataService().getVentasService();
	
	public void addVentasParaEntradaBBDD(EntradaDTO entrada, String dni) {
		VentasDTO venta = new VentasDTO();
		venta.id_ventas = entrada.cod_entrada;
		venta.dni = dni;
		venta.coste = new BigDecimal(Entrada.PRECIO);
		venta.fecha = new Date();
		
		service.addVentas(venta);
	}

}
