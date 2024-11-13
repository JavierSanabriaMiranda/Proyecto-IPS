package backend.service.ventas.entrada;

public class Entrada {
	
	private String cod_entrada;
	private Asiento asiento;
	public final int PRECIO = 30;
	
	public Entrada(Tribuna tribuna, Seccion seccion, int nFila, int nAsiento) {
		generateCode();
		this.asiento = new Asiento(tribuna, seccion, nFila, nAsiento);
	}
	public String getCodEntrada() {
		return this.cod_entrada;
	}
	public void setCodEntrada(String cod) {
		this.cod_entrada = cod;
	}
	public Tribuna getTribuna() {
		return asiento.getTribuna();
	}
	public Seccion getSeccion() {
		return asiento.getSeccion();
	}
	public int getFila() {
		return asiento.getFila();
	}
	public int getAsiento() {
		return asiento.getAsiento();
	}
	public void setOcupado(boolean ocupado) {
		asiento.setOcupado(ocupado);
	}
	public boolean isOcupado() {
		return asiento.isOcupado();
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
