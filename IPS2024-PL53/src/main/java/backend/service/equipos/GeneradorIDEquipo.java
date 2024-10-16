package backend.service.equipos;

import java.util.Random;

public class GeneradorIDEquipo {

	Random random = new Random();

	public int getNuevoID() {
		return random.nextInt(10000000);
	}
}
