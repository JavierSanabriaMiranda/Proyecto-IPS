package backend.data.noticias;

public class ImagenDTO {
	private String codigoNoticia;
	private String idImagen;
	private String url;

    // Constructor
    public ImagenDTO(String codigoNoticia, String idImagen, String url) {
        this.codigoNoticia = codigoNoticia;
        this.idImagen = idImagen;
        this.url = url;
    }

    // Getters y Setters
    public String getCodNoticia() { return codigoNoticia; }
    public void setCodNoticia(String codigoNoticia) { this.codigoNoticia = codigoNoticia; }
    
    public String getIdImagen() { return idImagen; }
    public void setIdImagen(String idImagen) { this.idImagen = idImagen; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
