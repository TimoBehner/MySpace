package MySpace.Kalender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class NeuesEvent {

    /*
     * Attribute
     */
    private static String ort;
    private static String teilnehmer;
    private static String jahr;
    private static String monat;
    private static String tag;
    private static String datum;
    private static String zeit;
    private static String notizen;
    private static String event;
    private static String ereignis;
    static List<String> intsInStringList = new ArrayList<String>();

    /*
     * Konstruktor
     */
    public NeuesEvent(){
    }

    /*
     * Methoden
     */
    
    public void kalenderCreateNewEvent(){
        
        //Bufferedreaderobjekt erstellen
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            //Den Attributen Daten zuweisen.
            System.out.println(Farben.color_cyan_underlined + "Neues Event erstellen:" + Farben.reset);
            System.out.print("Bitte geben Sie das Jahr ein (ganz, z.B: 2024):  ");
            jahr = s.readLine();
            System.out.print("Bitte geben Sie den Monat ein (ganz, z.B: 03):  ");
            monat = s.readLine();
            System.out.print("Bitte geben Sie den Tag ein (ganz, z.B: 03):  ");
            tag = s.readLine();
            System.out.print("Bitte geben Sie das Event ein:  ");
            ereignis = s.readLine();
            System.out.print("Bitte geben Sie die Teilnehmer ein:  ");
            teilnehmer = s.readLine();
            System.out.print("Bitte geben Sie die Zeit ein:  ");
            zeit = s.readLine();
            System.out.print("Bitte geben Sie den Ort ein:  ");
            ort = s.readLine();
            System.out.print("Hier können sie noch Notizen machen (optional):  ");
            notizen = s.readLine();
            zwischenspeicher();
            Fortsetzung.frageNachFortsetzung();
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    /*
     * Event zusammenbauen
     */
    public static void eventzusammenbauen(){
        event = datum + "  Zeit: " + zeit + "   Ereignis: " + ereignis + "  Ort: " + ort + "  Teilnehmer: " + teilnehmer + "  Notizen: " + notizen;
        intsInStringList.add(event);
        writeString(intsInStringList);  
    }

    /*
     * Datum zusammenbauen
     */
    public static void datumZusammenbauen(){
        datum = tag + "." + monat + "." + jahr;
    }


    public String getEvent() {
        return event;
    }

    /*
     * Read Methode
     */

     public static void zwischenspeicher(){
        List<String> neueListe = new ArrayList<String>();
        try{
            dateiCheck();
            FileReader fr = new FileReader(Paths.get(DateipfadeErstellen.create_filepath_kalender()).toString());
            BufferedReader br = new BufferedReader(fr);
            String zeile = br.readLine();
            while(zeile != null){
                neueListe.add(zeile);
                zeile = br.readLine();
            }
            br.close();
            fr.close();
            intsInStringList = neueListe;
            datumZusammenbauen();
            eventzusammenbauen();
        }catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    /*
     * Write Methode
     */
	public static void writeString(List<String> Test){
        dateiCheck();
	    try {
		    FileWriter mywriter = new FileWriter(DateipfadeErstellen.create_filepath_kalender().toString());
		    for(int i = 0; i < Test.size(); i++){
                 mywriter.write(Test.get(i) + "\n");
            }
            mywriter.close();
		} catch (Exception e) {
		    throw new IllegalArgumentException("Fehler ist passiert"); 
	    }
	}

    public static void dateiCheck(){
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
    }
}