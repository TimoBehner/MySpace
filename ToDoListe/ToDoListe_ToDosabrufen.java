package MySpace.ToDoListe;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class ToDoListe_ToDosabrufen {
    //Hierbei werden die ToDo's ausgelesen und geprintet.
    public static void readString(){
        try {
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_ToDo_Liste());
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            int number = 1;
            for (String string : readAllLines) {
                System.out.println(Farben.color_green + "ToDo: " + number + " " + Farben.reset + string);
                number++;
            }
            Fortsetzung.frageNachFortsetzung_filtern();
        } catch (Exception e) {
                throw new IllegalArgumentException("Fehler ist passiert");
        }
    }    
}
