package util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalTimeConverter {

	public static LocalTime convertDateToLocalTime(Date date) {
        // Convertir Date a LocalTime
        return date.toInstant()
                .atZone(ZoneId.systemDefault()) // Usar la zona horaria por defecto
                .toLocalTime(); // Obtener el LocalTime
    }
}
