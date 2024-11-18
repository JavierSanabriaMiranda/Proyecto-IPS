package backend.data.merchandising;

import java.sql.SQLException;

import backend.data.merchandising.commands.AddMerchandising;
import backend.util.log.LogManager;

public class MerchandisingCRUDImpl implements MerchandisingCRUDService {

	@Override
	public void addMerchandising(MerchandisingDTO merchandisingDTO) {
        try {
        	LogManager.logAction("Modificación en Base de Datos. Tabla: COMPRA_MERCHANDISING");
            new AddMerchandising(merchandisingDTO).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
}
