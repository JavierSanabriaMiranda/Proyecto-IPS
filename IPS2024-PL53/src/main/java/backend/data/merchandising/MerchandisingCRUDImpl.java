package backend.data.merchandising;

import java.sql.SQLException;

import backend.data.merchandising.commands.AddMerchandising;

public class MerchandisingCRUDImpl implements MerchandisingCRUDService {

	@Override
	public void addMerchandising(MerchandisingDTO merchandisingDTO) {
        try {
            new AddMerchandising(merchandisingDTO).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
}
