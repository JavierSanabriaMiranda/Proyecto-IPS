package backend.service.ventas.abono;

import backend.service.ventas.VentaBase;

public class Abono extends VentaBase{
	private String cod_abono;
	private float precio;
	
	public Abono() {
		generateCode();
		this.precio=320;
	}
	public String getCodAbono() {
		return this.cod_abono;
	}
	public void setCodAbono(String cod) {
		this.cod_abono = cod;
	}
	@Override
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	private void generateCode() {
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
        int longitudCodigo = 8;
        for(int i = 0; i < longitudCodigo; i++){ 
            int numero = (int)(Math.random() * (base.length())); 
            cod_abono += base.charAt(numero);
        }
    }
}
