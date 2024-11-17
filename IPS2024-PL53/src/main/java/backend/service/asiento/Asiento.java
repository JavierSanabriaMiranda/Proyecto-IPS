package backend.service.asiento;

public class Asiento {
	private Tribuna tribuna;
	private Seccion seccion;
	private int fila;
	private int asiento;
	private boolean ocupado;
	
	public Asiento(Tribuna tribuna, Seccion seccion, int nFila, int nAsiento) {
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.fila = nFila;
		this.asiento = nAsiento;
		this.ocupado = false;
	}

	public Tribuna getTribuna() {
		return tribuna;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public int getFila() {
		return fila;
	}

	public int getAsiento() {
		return asiento;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;		
	}
}
