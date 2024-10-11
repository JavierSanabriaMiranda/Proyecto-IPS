package shared.gestionempleados;

public enum PuestoEmpleado {

	DIRECTOR_COMUNICACIONES("director de comunicaciones"), ENCARGADO_TIENDA("encargado de tienda"), ENTRENADOR("entrenador"), 
	EMPLEADO_COCINA("empleado de cocina"), EMPLEADO_JARDINERIA("empleado de jardineria"), EMPLEADO_TIENDA("empleado de tienda"), 
	GERENTE("gerente"), GESTOR_INSTALACIONES("gestor de instalaciones"), JUGADOR("jugador"), VENDEDOR_ABONOS("vendedor de entradas/abonos");
	
	private final String nombre;
	
	PuestoEmpleado(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	/**
	 * Método que devuelve el puesto de empleado correcto en función del String que lo define
	 * @param nombre del puesto
	 * @return puesto correspondiente al nombre
	 */
	public static PuestoEmpleado getPuesto(String nombre) {
		for (PuestoEmpleado pe : PuestoEmpleado.values()) {
			if (pe.nombre.equals(nombre))
				return pe;
		}
		throw new IllegalArgumentException("El valor del nombre: " + nombre + " no consta como Puesto de Empleado");
	}
}
