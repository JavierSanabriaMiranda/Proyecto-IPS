package backend.service.ventas.campanaAccionistas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Accionista {
	
	private String idAccionista;
	private String dni;
	private String nombre;
	private List<Accion> acciones = new ArrayList<>();

	public Accionista(String id, String dni, String nombre) {
		this.idAccionista = id;
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Accionista(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public String getIdAccionista() {
		return idAccionista;
	}
	
	public void setIdAccionista(String id) {
		this.idAccionista = id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public List<Accion> getAcciones() {
		return new ArrayList<>(acciones);
	}
	
	public void addAccion(Accion accion) {
		if (accion == null)
			throw new IllegalArgumentException("La accion no puede ser null");
		acciones.add(accion);
	}
	
	public void addAcciones(List<Accion> listAcciones) {
		if (listAcciones == null)
			throw new IllegalArgumentException("La lista no puede ser null");
		if (listAcciones.contains(null))
			throw new IllegalArgumentException("La lista no puede contener null");
		acciones.addAll(listAcciones);
	}
}
