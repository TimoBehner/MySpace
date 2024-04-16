package MySpace.Kalender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class Eventsabrufen {
    //Hier lass ich mir alle Events ausgeben.
    public static void readString(){
        try {
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_kalender());
            if (!Files.exists(filePath)) {
                try {
                    Files.createFile(filePath);
                    System.out.println("Neue Datei erstellt: " + filePath);
                } catch (IOException e) {
                System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
                }
            }
            List<String> readAllLines = Files.readAllLines(filePath);
            int number = 1;
            for (String string : readAllLines) {
                System.out.println(Farben.color_green + "Event: " + number + " " + Farben.reset + string);
                number++;
            }
            Fortsetzung.frageNachFortsetzung();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
}