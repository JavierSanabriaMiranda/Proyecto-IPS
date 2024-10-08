package backend.data.instalaciones.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.instalaciones.InstalacionDto;

public class CargarInstalaciones {
	
	private static final String SQL = "SELECT COD_INSTALACION FROM INSTALACION";
	
	private Database db = new Database();
	
	public CargarInstalaciones() {
		
	}
	
	public List<InstalacionDto> execute() {
		return mapsToInstalacion(db.executeQueryMap(SQL));
	}
	
    private List<InstalacionDto> mapsToInstalacion(List<Map<String, Object>> listaMap) {
        List<InstalacionDto> lista = new ArrayList<InstalacionDto>();
        
        // Recorre cada mapa y convierte los datos en un objeto InstalacionDto.
        for (Map<String, Object> fila : listaMap) {
        	InstalacionDto dto = new InstalacionDto(); // Renombrado a dto
            dto.codInstalacion = (String) fila.get("COD_INSTALACION");
            
            
            lista.add(dto);
        }
        return lista;         
    }
	
}
