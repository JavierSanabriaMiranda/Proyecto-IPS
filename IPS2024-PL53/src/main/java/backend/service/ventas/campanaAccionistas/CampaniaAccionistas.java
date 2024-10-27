package backend.service.ventas.campanaAccionistas;

import backend.service.ventas.VentaBase;

public class CampaniaAccionistas extends VentaBase {

	private static final int FASE_1 = 1;
	private static final int FASE_2 = 2;
	private static final int FASE_3 = 3;
	
	private String codCampaña;
	private int numAccionesIniciales;
	private int numAccionesRestantes;
	private int fase;
	
	public CampaniaAccionistas(String codCampaña, int accionesIniciales, int accionesRestantes, int fase) {
		super();
		this.codCampaña = codCampaña;
		this.numAccionesIniciales = accionesIniciales;
		this.numAccionesRestantes = accionesRestantes;
		this.fase = fase;
	}
	
	
}
