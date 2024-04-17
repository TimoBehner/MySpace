package MySpace.Kalender;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import MySpace.Farben;

public class Kalender {
    /*
     * Methoden
     */
    public static void kalenderGetInput(){
        //Modusabfrage
        System.out.println(Farben.color_white_underlined + "Willkommen beim Kalender!" + Farben.reset);
        System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " für ein neues Event ein.");
        System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " um eingetragene Events anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[3]" + Farben.reset + " für die Einstellungen.");
        //Input der Modusabfrage auswerten
        switch (betterScanner()) {
            //Neues Event
            case 1:
                NeuesEvent neuesEvent = new NeuesEvent();
                neuesEvent.kalenderCreateNewEvent();
                break;
            //Events abfragen
            case 2:
                Eventsabrufen.readString();
                break;
            //Einstellungen
            case 3:
                
                break;
            default:
                System.out.println(Farben.color_red + "Diesen Modus gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                kalenderGetInput();
                break;
        }
    }

    public static int betterScanner()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int eingabe = 0;
        while(true)
        {
        try
        {
            eingabe = Integer.parseInt(reader.readLine());
            break;
        }
        catch(Exception e)
        {
            System.out.println("Ungültige Eingabe!\n");
        }
        }
        return eingabe;
    }
}