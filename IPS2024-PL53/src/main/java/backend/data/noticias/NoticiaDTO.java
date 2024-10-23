package backend.data.noticias;

public class NoticiaDTO {
	private String codigoNoticia;
	private String titulo;
	private String texto;

    // Constructor
    public NoticiaDTO(String codigoNoticia, String titulo, String texto) {
        this.codigoNoticia = codigoNoticia;
        this.titulo = titulo;
        this.texto = texto;
    }

    // Getters y Setters
    public String getCodNoticia() { return codigoNoticia; }
    public void setCodNoticia(String codigoNoticia) { this.codigoNoticia = codigoNoticia; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.codigoNoticia = titulo; }
    
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

}
