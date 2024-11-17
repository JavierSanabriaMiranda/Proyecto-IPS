package backend.service.ventas.entrada;

public class Entrada {
	
	private String cod_entrada;
	public final int PRECIO = 30;
	
	public Entrada() {
		generateCode();
	}
	public String getCodEntrada() {
		return this.cod_entrada;
	}
	public void setCodEntrada(String cod) {
		this.cod_entrada = cod;
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
