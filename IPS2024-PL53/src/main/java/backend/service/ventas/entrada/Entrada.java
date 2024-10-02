package backend.service.ventas.entrada;

public class Entrada {
	
	private Tribuna tribuna;
	private Seccion seccion;
	private int fila;
	private int asiento;
	
	public Tribuna getTribuna() {
		return tribuna;
	}
	private void setTribuna(Tribuna tribuna) {
		this.tribuna = tribuna;
	}
	public Seccion getSeccion() {
		return seccion;
	}
	private void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	public int getFila() {
		return fila;
	}
	private void setFila(int fila) {
		this.fila = fila;
	}
	public int getAsiento() {
		return asiento;
	}
	private void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
	
}
