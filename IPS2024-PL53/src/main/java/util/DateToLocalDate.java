package util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateToLocalDate {

	public static LocalDate convertToLocalDate(Date date) {
		if (date == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-indexados
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return LocalDate.of(year, month, day);
    }
}