package backend.data.noticias;

public class ImagenDTO {
	private String codigoNoticia;
	private String idImagen;
	private String nombre;

    // Constructor
    public ImagenDTO(String codigoNoticia, String idImagen, String nombre) {
        this.codigoNoticia = codigoNoticia;
        this.idImagen = idImagen;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getCodNoticia() { return codigoNoticia; }
    public void setCodNoticia(String codigoNoticia) { this.codigoNoticia = codigoNoticia; }
    
    public String getIdImagen() { return idImagen; }
    public void setIdImagen(String idImagen) { this.idImagen = idImagen; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
