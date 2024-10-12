package backend.service.ventas.reservas;

import java.util.Random;

public class GeneradorCodReserva {
	Random random = new Random();
	
	public String getNuevoCod() {
		return String.valueOf(random.nextInt(10000000));
	}
}
