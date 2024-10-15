package util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateToLocalTimeConverter {

	public static LocalTime convertDateToLocalTime(Date date) {
        // Convertir Date a LocalTime
        return date.toInstant()
                .atZone(ZoneId.systemDefault()) // Usar la zona horaria por defecto
                .toLocalTime(); // Obtener el LocalTime
    }
	
	 public static Date combinarFechaYHora(Date fecha, LocalTime hora) {
	        // Crear un Calendar con la fecha dada
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fecha);

	        // Actualizar el Calendar con la hora del LocalTime
	        calendar.set(Calendar.HOUR_OF_DAY, hora.getHour());
	        calendar.set(Calendar.MINUTE, hora.getMinute());
	        calendar.set(Calendar.SECOND, hora.getSecond());
	        calendar.set(Calendar.MILLISECOND, 0); // Para mayor precisión, eliminar milisegundos

	        // Devolver el objeto Date que combina la fecha y la hora
	        return calendar.getTime();
	    }
}
