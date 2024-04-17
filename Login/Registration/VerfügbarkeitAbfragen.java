package MySpace.Login.Registration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;

public class VerfügbarkeitAbfragen {
//Hier gehe ich die txt Zeile für Zeile durch, um die Verfügbarkeit des Benutzernamens zu überprüfen.
 public static boolean verfügbarkeitAbfragen(String benutzername){
        boolean status = true;
        try {
            dateiCheck();
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_userports());
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //String readOneLines = Files.readString(filePath, Charset.defaultCharset());
            for (String string : readAllLines) {
                if (string.contains(benutzername)) {
                    System.out.println(Farben.color_red_underlined + "Der Benutzername ist leider schon vergeben." +  Farben.reset);
                    status = false;
                    break;
                }
            }
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }
        return status;
    } 
    
        public static void dateiCheck(){
        Path filePath = Paths.get(DateipfadeErstellen.create_filepath_userports());
        if (!Files.exists(filePath)) {
            try {
                // Beispiel: Eine neue Datei erstellen
                Files.createFile(filePath);
                System.out.println("Neue Datei erstellt: " + filePath);
            } catch (IOException e) {
                System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
            }
        }        
    }
}
