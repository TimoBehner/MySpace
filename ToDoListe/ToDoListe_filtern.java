package MySpace.ToDoListe;

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
import MySpace.Fortsetzung;
import MySpace.Login.AESVerschlüsselung.PasswortEncryptenBzwDecrypten;

public class ToDoListe_filtern {
    /*
     * Nach der Kategorie Haushalt filtern
     */
    public static void toDoListe_filtern_Haushalt(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile das Wort Haushalt enthält, wird diese Zeile geprintet.
                if (string.contains("Haushalt")) {
                    System.out.println(Farben.color_green + "ToDo: "+ Farben.reset + string);                   
                }
            }
            //Die Methode frageNachFortsetzung_filtern() aufrufen, um die Möglichkeit zubekommen neu zu filtern.
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }        
    }




    /*
     * Nach der Kategorie Sonstiges filtern
     */
    public static void toDoListe_filtern_Sonstiges(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile das Wort Sonstiges enthält, wird diese Zeile geprintet.
                if (string.contains("Sonstiges")) {
                    System.out.println(Farben.color_green + "ToDo: "+ Farben.reset + string);                   
                }
            }
            //Die Methode frageNachFortsetzung_filtern() aufrufen, um die Möglichkeit zubekommen neu zu filtern.
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }        
    }





    /*
     * Nach der Kategorie Schule filtern
     */
    public static void toDoListe_filtern_Schule(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile das Wort Schule enthält, wird diese Zeile geprintet.
                if (string.contains("Schule")) {
                    System.out.println(Farben.color_green + "ToDo: "+ Farben.reset + string);                   
                }
            }
            //Die Methode frageNachFortsetzung_filtern() aufrufen, um die Möglichkeit zubekommen neu zu filtern.
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }        
    }


    /*
     * Nach der Kategorie Soziales filtern
     */
    public static void toDoListe_filtern_Soziales(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile das Wort Soziales enthält, wird diese Zeile geprintet.
                if (string.contains("Soziales")) {
                    System.out.println(Farben.color_green + "ToDo: "+ Farben.reset + string);                   
                }
            }
            //Die Methode frageNachFortsetzung_filtern() aufrufen, um die Möglichkeit zubekommen neu zu filtern.
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }        
    }



    /*
     * Nach der heutigen Deadline filtern
     */
    public static void toDoListe_filtern_Deadline(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(PasswortEncryptenBzwDecrypten.getFile_Path(), "ToDoDatenbank.txt");
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            // Zeitzone für Deutschland (Mitteleuropäische Zeit)
            TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
            // Lokale für Deutschland
            Locale locale = Locale.GERMANY;
            // Aktuelles Datum von Deutschland
            String dateFormatString = getDateFormatString(timeZone, locale);
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile dateFormatString enthält, wird diese Zeile geprintet.
                if (string.contains(dateFormatString)) {
                    System.out.println(Farben.color_red + "Erinnerung: " + Farben.reset + string);
                }
            }
            //Die Methode frageNachFortsetzung_filtern() aufrufen, um die Möglichkeit zubekommen neu zu filtern.
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }



    /*
     * Nach der heutigen Deadline am anfang  filtern
     */
    public static void toDoListe_filtern_Deadline_anfang(){
        //Try Catch um Erros abzufangen.
        try {
            //Den Dateipfad laden.
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            //Liste erstellen in die alle eingelesenen Zeilen gespeichert werden.
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            // Zeitzone für Deutschland (Mitteleuropäische Zeit)
            TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
            // Lokale für Deutschland
            Locale locale = Locale.GERMANY;
            // Aktuelles Datum von Deutschland
            String dateFormatString = getDateFormatString(timeZone, locale);
            //`readAllLines` ist eine List<String>, die die zu überprüfenden Zeilen enthält
            for (String string : readAllLines) {
                //Wenn die Zeile dateFormatString enthält, wird diese Zeile geprintet.
                if (string.contains(dateFormatString)) {
                    System.out.println(Farben.color_red + "Erinnerung: " + Farben.reset + string);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }





    /*
     * Das aktuelle Datum erhalten.
     */
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
