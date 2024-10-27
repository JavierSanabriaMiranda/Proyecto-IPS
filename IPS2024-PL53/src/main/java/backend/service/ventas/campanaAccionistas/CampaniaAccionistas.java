package backend.service.ventas.campanaAccionistas;

import backend.service.ventas.VentaBase;

public class CampaniaAccionistas extends VentaBase {

	private static final int FASE_1 = 1;
	private static final int FASE_2 = 2;
	private static final int FASE_3 = 3;
	
	public enum EstadoCampania {
		ABIERTA, FINALIZADA
	}
	
	private String codCampania;
	private EstadoCampania estado;
	private int numAccionesIniciales;
	private int numAccionesRestantes;
	private int fase;
	
	public CampaniaAccionistas(String codCampania, int accionesIniciales, int accionesRestantes, int fase, 
				EstadoCampania estado) {
		super();
		if (codCampania == null)
			throw new IllegalArgumentException("El código de campaña no puede ser null");
		if (estado == null) {
			throw new IllegalAccessError("El estado de la campaña no puede ser null");
		}
		this.codCampania = codCampania;
		this.numAccionesIniciales = accionesIniciales;
		this.numAccionesRestantes = accionesRestantes;
		this.fase = fase;
		this.estado = estado;
	}
	
	
	
	
}
