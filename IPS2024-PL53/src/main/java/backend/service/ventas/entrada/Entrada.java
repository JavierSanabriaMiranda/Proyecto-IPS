package backend.service.ventas.entrada;

public class Entrada {
	
	private String cod_entrada;
	private Tribuna tribuna;
	private Seccion seccion;
	private int fila;
	private int asiento;
	private boolean ocupado;
	public final int PRECIO = 30;
	
	public Entrada(Tribuna tribuna, Seccion seccion, int nFila, int nAsiento) {
		generateCode();
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
	public Seccion getSeccion() {
		return seccion;
	}
	public int getFila() {
		return fila;
	}
	public int getAsiento() {
		return asiento;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public boolean isOcupado() {
		return this.ocupado;
	}
	
	private void generateCode() {
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
        int longitudCodigo = 8;
        for(int i = 0; i < longitudCodigo; i++){ 
            int numero = (int)(Math.random() * (base.length())); 
            cod_entrada += base.charAt(numero);
        }
    }
	
}
