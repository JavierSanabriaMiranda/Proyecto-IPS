package backend.service.empleados.nodeportivos.horarios;

import java.time.LocalTime;

public interface Turno {
	
	LocalTime getHoraInicio();
	LocalTime getHoraFin();
	String getIDTurno();
	long getHorasDuracion();
	void setIDTurno(String id);
	

}
