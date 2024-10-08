package backend.service.ventas.entrada;

public class Entrada {
	
	private Tribuna tribuna;
	private Seccion seccion;
	private int fila;
	private int asiento;
	private boolean ocupado;
	public static final int PRECIO = 30;
	
	public Entrada(Tribuna tribuna, Seccion seccion, int nFila, int nAsiento) {
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.fila = nFila;
		this.asiento = nAsiento;
		this.ocupado = false;
	}
	
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
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public boolean isOcupado() {
		return this.ocupado;
	}
}
