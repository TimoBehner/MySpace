package MySpace.Moneytracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class RegelmäßigesEinkommen {
    public static Boolean einkommenCheck(){
        Boolean theFirst = false;

        // Zeitzone für Deutschland (Mitteleuropäische Zeit)
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        // Lokale für Deutschland
        Locale locale = Locale.GERMANY;

        // Aktuelles Datum von Deutschland
        String dateFormatString = getDateFormatString(timeZone, locale);
        
        if (dateFormatString.contains("01.01") || dateFormatString.contains("01.02") || dateFormatString.contains("01.03") || dateFormatString.contains("01.04") || dateFormatString.contains("01.05") || dateFormatString.contains("01.06") || dateFormatString.contains("01.07") || dateFormatString.contains("01.08") || dateFormatString.contains("01.09") || dateFormatString.contains("01.10") || dateFormatString.contains("01.11")|| dateFormatString.contains("01.12")) {
            theFirst = true;
        }
        return theFirst;
    }


    public static String getDateFormatString(TimeZone timeZone, Locale locale) {
        // Aktuelles Datum
        LocalDate currentDate = LocalDate.now();

        // DateTimeFormatter für das Kurzformat
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", locale);

        // Zeitzone festlegen
        formatter = formatter.withZone(timeZone.toZoneId());

        // Datum formatieren
        return currentDate.format(formatter);
    }
}
