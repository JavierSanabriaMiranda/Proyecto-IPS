package backend.service.empleados;

import java.util.Random;

public class GeneradorIDEmpleado {

	Random random = new Random();
	
	public int getNuevoID() {
		return random.nextInt(10000000);
	}
}
