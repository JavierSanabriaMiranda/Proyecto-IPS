package backend.service.empleados.nodeportivos.horarios;

import java.time.LocalDate;
import java.util.List;

import backend.service.horarios.FranjaTiempo;

public interface Horario {
	
	/**
	 * Devuelve el horario en forma de lista de franjas de tiempo, que está asignado para la 
	 * fecha introducida como parámetro. En caso de no haber horario para dicho día, devuelve una lista vacía
	 *  
	 * @param dia del horario a obtener
	 * @return lista de franjas de tiempo que representan el horario y, si no lo hay, lista vacía
	 */
	List<FranjaTiempo> getHorarioDia(LocalDate dia);

}
