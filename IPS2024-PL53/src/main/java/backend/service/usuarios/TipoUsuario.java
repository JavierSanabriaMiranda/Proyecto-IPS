package backend.service.usuarios;

public enum TipoUsuario {
	NO_USUARIO("No usuario"), ACCIONISTA("Accionista"), JUGADOR("Jugador"), ENTRENADOR("Entrenador"), 
	GERENTE("Gerente"), VENDEDOR_ENTRADAS_ABONOS("Vendedor Entradas/Abonos"), 
	ENCARGADO_TIENDA("Encargado de Tienda"), GESTOR_INSTALACIONES("Gestor de Instalaciones"),
	EMPLEADO_TIENDA("Empleado de Tienda"), EMPLEADO_JARDINERIA("Empleado de Jardinería"), 
	EMPLEADO_COCINA("Empleado de Cocina"), DIRECTOR_COMUNICACIONES("Director de Comunicaciones");
	
	private final String nombre;
	
	private TipoUsuario(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}