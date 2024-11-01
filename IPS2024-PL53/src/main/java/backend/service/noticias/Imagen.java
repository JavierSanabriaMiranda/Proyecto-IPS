package backend.service.noticias;

public class Imagen {
	private String name;
	private String url;

    // Constructor
    public Imagen(String name,String url) {
    	this.name=name;
    	this.url=url;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getUrlImagen() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    @Override
    public String toString() {
        return this.name;
    }
}
