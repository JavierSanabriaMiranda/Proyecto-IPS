package backend.data.entradas;

public class EntradaDTO {

	public String cod_entrada;
    public String idPartido;
    public String idAsiento;
    
    public EntradaDTO() {
    }
    
	public EntradaDTO(String cod_entrada, String idPartido, String idAsiento) {
		this.cod_entrada = cod_entrada;
		this.idPartido = idPartido;
		this.idAsiento = idAsiento;
	}
    
    
}
