package MySpace.ToDoListe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class ToDoListe_NeueToDo {
    private static String deadline;
    private static String jahr;
    private static String monat;
    private static String tag;
    private static String kategorie;
    private static String aufgabe;
    private static String personen;
    private static String notizen;
    private static String number;
    private static String toDo;
    static List<String> intsInStringList = new ArrayList<String>();

    /*
     * Neue ToDo erstellen
     */
    public static void neueToDo(){
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            //Den Attributen Daten zuweisen.
            System.out.println(Farben.color_cyan_underlined + "Neue ToDo erstellen:" + Farben.reset);
            System.out.print("Bitte geben Sie das Jahr für die Deadline ein (ganz, z.B: 2024):  ");
            jahr = s.readLine();
            System.out.print("Bitte geben Sie den Monat für die Deadline ein (ganz, z.B: 03):  ");
            monat = s.readLine();
            System.out.print("Bitte geben Sie den Tag für die Deadline ein (ganz, z.B: 03):  ");
            tag = s.readLine();
            kategorieWählen();
            System.out.print("Bitte geben Sie die Aufgabe ein:  ");
            aufgabe = s.readLine();            
            System.out.print("Bitte geben Sie die betreffenden Personen ein:  ");
            personen = s.readLine();
            System.out.print("Hier können sie noch Notizen machen (optional):  ");
            notizen = s.readLine();
            zwischenspeicher();
            Fortsetzung.frageNachFortsetzung();
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    /*
     * ToDo zusammenbauen
     */
    public static void toDozusammenbauen(){
        toDo = deadline + "  Aufgabe: " + aufgabe + "  Kategorie: " + kategorie + "  Personen: " + personen + "  Notizen: " + notizen;
        intsInStringList.add(toDo);
        writeString(intsInStringList);  
    }
    /*
     * Kategorie wählen
     */
    public static void kategorieWählen(){
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Bitte wählen Sie die Kategorie:  ");
            System.out.println(Farben.color_yellow + "[1]" + Farben.reset + " Schule");
            System.out.println(Farben.color_yellow + "[2]" + Farben.reset + " Haushalt");
            System.out.println(Farben.color_yellow + "[3]" + Farben.reset + " Soziales");
            System.out.println(Farben.color_yellow + "[4]" + Farben.reset + " Sonstiges");
            number = s.readLine();
    
            switch (number) {
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
                    kategorie = "Sonstiges";
                    break;
    
                default:
                    System.out.println("Diese Kategorie gibt es leider nicht.");
                    break;
            }           
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }

    }
    /*
     * Datum zusammenbauen
     */
    public static void datumZusammenbauen(){
        deadline = jahr + "-" + monat + "-" + tag;
    }

         public static void zwischenspeicher(){
        List<String> neueListe = new ArrayList<String>();
        try{
            FileReader fr = new FileReader(DateipfadeErstellen.create_filepath_ToDo_Liste());
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
            toDozusammenbauen();
        }catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    
    /*
     * Write Methode
     */
	public static void writeString(List<String> Test){
	    try {
		    FileWriter mywriter = new FileWriter(DateipfadeErstellen.create_filepath_ToDo_Liste());
		    for(int i = 0; i < Test.size(); i++){
                 mywriter.write(Test.get(i) + "\n");
            }
            mywriter.close();
		} catch (Exception e) {
		    throw new IllegalArgumentException("Fehler ist passiert"); 
	    }
	}
}
