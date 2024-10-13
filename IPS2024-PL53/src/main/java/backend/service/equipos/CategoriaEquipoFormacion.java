package backend.service.equipos;

public enum CategoriaEquipoFormacion {
	JUVENIL("juvenil", 16, 19),
    CADETE("cadete", 13, 14),
    INFANTIL("infantil", 11, 12),
    ALEVIN("alevin", 9, 10),
    BENJAMIN("benjamin", 7, 8),
    PREBENJAMIN("prebenjamin", 5, 6);

	private final String categoria;
	private final int edadMinima;
	private final int edadMaxima;

	CategoriaEquipoFormacion(String categoria, int edadMinima, int edadMaxima) {
		this.categoria = categoria;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	// Método para verificar si una edad cumple con la restricción de la categoría
	public boolean cumpleConRestriccionDeEdad(int edad) {
		return edad >= edadMinima && edad <= edadMaxima;
	}

	public static CategoriaEquipoFormacion getCategoria(String nombre) {
		for (CategoriaEquipoFormacion cat : CategoriaEquipoFormacion.values()) {
			if (cat.categoria.equalsIgnoreCase(nombre))
				return cat;
		}
		throw new IllegalArgumentException("El valor del nombre: " + nombre + " no consta como Categoria");
	}
}
