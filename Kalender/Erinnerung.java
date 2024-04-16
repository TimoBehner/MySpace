package MySpace.Kalender;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;

public class Erinnerung {
    public static void checkErinnerung02(){
        try {
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_kalender());
            if (!Files.exists(filePath)) {
                try {
                    // Beispiel: Eine neue Datei erstellen
                    Files.createFile(filePath);
                    System.out.println("Neue Datei erstellt: " + filePath);
                } catch (IOException e) {
                System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
                }
            }
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            // Zeitzone für Deutschland (Mitteleuropäische Zeit)
            TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");

            // Lokale für Deutschland
            Locale locale = Locale.GERMANY;

            // Aktuelles Datum von Deutschland
            String dateFormatString = getDateFormatString(timeZone, locale);
            // Annahme: `readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                if (string.contains(dateFormatString)) {
                    System.out.println(Farben.color_red + "Erinnerung: " + Farben.reset + string);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
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