package backend.service.ventas.entrada;

import java.util.Random;

public class Entrada {
	
	private String cod_entrada;
	private Tribuna tribuna;
	private Seccion seccion;
	private int fila;
	private int asiento;
	private boolean ocupado;
	public static final int PRECIO = 30;
	
	private Random random = new Random();
	
	public Entrada(Tribuna tribuna, Seccion seccion, int nFila, int nAsiento) {
		this.cod_entrada = "" + random.nextInt(10000000);
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.fila = nFila;
		this.asiento = nAsiento;
		this.ocupado = false;
	}
	public String getCodEntrada() {
		return this.cod_entrada;
	}
	public void setCodEntrada(String cod) {
		this.cod_entrada = cod;
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
