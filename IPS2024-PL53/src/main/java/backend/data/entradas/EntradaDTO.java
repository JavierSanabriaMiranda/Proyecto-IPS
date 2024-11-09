package backend.data.entradas;

public class EntradaDTO {

	public String cod_entrada;
    public String tribuna;
    public String seccion;
    public int nFila;
    public int nAsiento; 
    public String idPartido;
    public float coste;
    
    public EntradaDTO() {
    }
    
	public EntradaDTO(String cod_entrada, String tribuna, String seccion,int nFila, int nAsiento, String idPartido, float coste) {
		this.cod_entrada = cod_entrada;
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.nFila = nFila;
		this.nAsiento = nAsiento;
		this.idPartido = idPartido;
		this.coste = coste;
	}
    
    
}
