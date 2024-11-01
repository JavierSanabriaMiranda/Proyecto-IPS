package backend.service.noticias;

import java.util.List;

public class Noticia {
	private String titulo;
	private String texto;
	private List<Imagen> imagenes;

    // Constructor
    public Noticia(String titulo,String texto, List<Imagen> imagenes) {
    	this.titulo=titulo;
    	this.texto=texto;
    	this.setImagenes(imagenes);
    }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

	public List<Imagen> getImagenes() {return imagenes;}
	public void setImagenes(List<Imagen> imagenes) {this.imagenes = imagenes;}

}
