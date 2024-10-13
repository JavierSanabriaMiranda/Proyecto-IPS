package backend.service.equipos;

public enum CategoriaEquipoFormacion {
	JUVENIL("juvenil"), CADETE("cadete"), INFANTIL("infantil"), ALEVIN("alevin"), BENJAMIN("benjamin"), PRE_BENJAMIN("prebenjamin");

	private final String categoria;
	
	CategoriaEquipoFormacion(String string) {
		this.categoria = string;
	}
	
	
	public static CategoriaEquipoFormacion getCategoria(String nombre) {
		for (CategoriaEquipoFormacion cat : CategoriaEquipoFormacion.values()) {
			if (cat.categoria.equals(nombre))
				return cat;
		}
		throw new IllegalArgumentException("El valor del nombre: " + nombre + " no consta como Categoria");
	}
	
}
