package backend.data.asientos;

public class AsientoDTO {

	public String idAsiento;
	public String tribuna;
	public String seccion;
	public int nFila;
	public int nAsiento; 
	
	public AsientoDTO() {
	}
	
	public AsientoDTO(String idAsiento, String tribuna, String seccion,int nFila, int nAsiento) {
		this.idAsiento = idAsiento;
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.nFila = nFila;
		this.nAsiento = nAsiento;
	}
	
}
