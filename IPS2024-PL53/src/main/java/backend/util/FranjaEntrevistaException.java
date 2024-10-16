package backend.util;

/**
 * Excepcion que se produce cuando se intenta crear una franja de entrevista para un dia y en ese 
 * dia el jugador ya tiene programada una entrevista.
 */
@SuppressWarnings("serial")
public class FranjaEntrevistaException extends Exception {
	private static final long serialVersionUID = 1L;
	public FranjaEntrevistaException(Throwable e) {
		super(e);
	}
	public FranjaEntrevistaException(String s) {
		super(s);
	}
}
