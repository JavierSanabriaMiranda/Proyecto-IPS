package backend.data;

import backend.data.accionistas.AccionistasCRUDImpl;
import backend.data.accionistas.AccionistasCRUDService;
import backend.data.campaniaaccionistas.CampaniaAccionistasCRUDImpl;
import backend.data.campaniaaccionistas.CampaniaAccionistasCRUDService;
import backend.data.clientes.ClientesCRUDImpl;
import backend.data.clientes.ClientesCRUDService;
import backend.data.empleados.EmpleadoCRUDImpl;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entradas.EntradasCRUDImpl;
import backend.data.entradas.EntradasCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDImpl;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrevistas.EntrevistaCRUDImpl;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.EquipoCRUDServiceImpl;
import backend.data.horarios.HorarioCRUDImpl;
import backend.data.horarios.HorarioCRUDService;
import backend.data.merchandising.MerchandisingCRUDImpl;
import backend.data.merchandising.MerchandisingCRUDService;
import backend.data.noticias.NoticiaCRUDImpl;
import backend.data.noticias.NoticiaCRUDService;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;
import backend.data.productos.ProductoCRUDImpl;
import backend.data.productos.ProductoCRUDService;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;

public class CreadorDataService {

	public static EmpleadosCRUDService getEmpleadosService() {
		return new EmpleadoCRUDImpl();
	}

	public static HorarioCRUDService getHorarioService() {
		return new HorarioCRUDImpl();
	}

	public static ProductoCRUDService getproductoService() {
		return  new ProductoCRUDImpl();
	}

	public static ClientesCRUDService getClientesService() {
		return new ClientesCRUDImpl();
	}

	public static EntradasCRUDService getEntradaService() {
		return new EntradasCRUDImpl();
	}

	public static VentasCRUDService getVentasService() {
		return new VentasCRUDImpl();
	}

    public static EquipoCRUDService getEquiposService() {
    	return new EquipoCRUDServiceImpl();
    }

	public static PartidosCRUDService getPartidosService() {
		return new PartidosCRUDImpl();
	}

	public static MerchandisingCRUDService getMerchandisingService() {
		return new MerchandisingCRUDImpl();
	}
	
	public static EntrenamientoCRUDService getEntrenamientoService() {
		return new EntrenamientoCRUDImpl();
	}
	
	public static EntrevistaCRUDService getEntrevistaService() {
		return new EntrevistaCRUDImpl();
	}
	
	public static NoticiaCRUDService getNoticiaService() {
		return new NoticiaCRUDImpl();
	}
	
	public static CampaniaAccionistasCRUDService getCampaniasService() {
		return new CampaniaAccionistasCRUDImpl();
	}
	
	public static AccionistasCRUDService getAccionistasService() {
		return new AccionistasCRUDImpl();
	}
}
