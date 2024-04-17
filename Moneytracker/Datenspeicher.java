package MySpace.Moneytracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class Datenspeicher {
    private static String kategorie;
    private static String betrag;
    private static String datum;
    private static String eintrag;
    private static String vorzeichen;
    static List<String> intsInStringList = new ArrayList<String>();
    //Die Daten für den Eintrag abfragen.
    public static void datensatz(){
        
        //Bufferedreaderobjekt erstellen
        try {
            if (RegelmäßigesEinkommen.einkommenCheck() == true) {
                eintrag = getDate() + " Kategorie: Taschengeld" + "\n" + "+" + 30;
                intsInStringList.add(eintrag);
                writeString(intsInStringList);  
            }
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            //Den Attributen Daten zuweisen.
            System.out.println(Farben.color_cyan_underlined + "Neuen Eintrag erstellen:" + Farben.reset);
            System.out.print("Bitte geben Sie das Datum ein:  ");
            datum = s.readLine();
            System.out.println("Wählen sie die Kategorie aus:  ");
            System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " für die Kategorie Schule ein.");
            System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " für die Kategorie Haushalt ein.");
            System.out.println("Bitte gib " + Farben.color_green + "[3]" + Farben.reset + " für die Kategorie Soziales ein.");
            System.out.println("Bitte gib " + Farben.color_green + "[4]" + Farben.reset + " für die Kategorie Taschengeld ein.");
            String input = s.readLine();
            switch (input) {
                case "1":
                    kategorie = "Schule";
                    break;
                case "2":
                    kategorie = "Haushalt";
                    break;
                case "3":
                    kategorie = "Soziales";
                    break;
                case "4":
                    kategorie = "Taschengeld";
                    break;          
                default:
                    break;
            }
            System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " für eine Ausgabe ein.");
            System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " für eine Einnahme ein.");
            vorzeichen = s.readLine();
            System.out.print("Bitte geben Sie den Betrag ein (in Euro):  ");
            betrag = s.readLine();
            zwischenspeicher();
            Fortsetzung.frageNachFortsetzung();
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    public static void eintragZusammenbauen(){
        switch (vorzeichen) {
            case "1":
                vorzeichen = "-";
                break;
            case "2":
                vorzeichen = "+";
                break;
            default:
                break;
        }
        eintrag = datum + " Kategorie: " + kategorie + "\n" + vorzeichen + "\n" + betrag;
        intsInStringList.add(eintrag);
        writeString(intsInStringList);
    }


    public static void zwischenspeicher(){
        List<String> neueListe = new ArrayList<String>();
        try{
            FileReader fr = new FileReader(Paths.get(DateipfadeErstellen.create_filepath_Moneytracker()).toString());
            BufferedReader br = new BufferedReader(fr);
            String zeile = br.readLine();
            while(zeile != null){
                neueListe.add(zeile);
                zeile = br.readLine();
            }
            br.close();
            fr.close();
            intsInStringList = neueListe;
            eintragZusammenbauen();
        }catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    /*
     * Write Methode
     */
	public static void writeString(List<String> Test){
	    try {
		    FileWriter mywriter = new FileWriter(Paths.get(DateipfadeErstellen.create_filepath_Moneytracker()).toString());
		    for(int i = 0; i < Test.size(); i++){
                 mywriter.write(Test.get(i) + "\n");
            }
            mywriter.close();
		} catch (Exception e) {
		    throw new IllegalArgumentException("Fehler ist passiert"); 
	    }
	}

    
    public static String getDate(){

        // Zeitzone für Deutschland (Mitteleuropäische Zeit)
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        // Lokale für Deutschland
        Locale locale = Locale.GERMANY;

        // Aktuelles Datum von Deutschland
        String dateFormatString = getDateFormatString(timeZone, locale);
        
        return dateFormatString;
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
