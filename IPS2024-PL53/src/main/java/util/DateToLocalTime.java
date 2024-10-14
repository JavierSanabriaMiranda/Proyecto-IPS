package util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateToLocalTime {

    // Método para convertir Date a LocalTime
    public static LocalTime convertDateToLocalTime(Date date) {
    	if (date == null)
    		throw new IllegalArgumentException("La fecha no puede ser nula");
    	
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Extraer solo horas y minutos
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        LocalTime localTime = LocalTime.of(hour, minute);
        System.out.println("Converted LocalTime: " + localTime); // Imprime la hora y los minutos correctamente
        return localTime;
    }
}
