package MySpace;

import MySpace.Moneytracker.WähleModus;
import MySpace.ToDoListe.ToDoListe;
import MySpace.ToDoListe.ToDoListe_filtern;

public class Menü {


    /*
     * Methoden
     */
    public static void menü(){
        //Modusabfrage
        System.out.println(Farben.color_white_underlined + "Willkommen bei MySpace!" + Farben.reset);
        System.out.println("Drücken sie die " + Farben.color_yellow + "[1]" + Farben.reset + " für den Kalender.");
        System.out.println("Drücken sie die " + Farben.color_yellow + "[2]" + Farben.reset + " für die ToDo-Liste.");
        //Input der Modusabfrage auswerten
        switch(BetterScanner.betterScannerInt("Drücken sie die " + Farben.color_yellow + "[3]" + Farben.reset + " für den Moneytracker.\n")){
            //Kalender
            case 1:
                MySpace.Kalender.Erinnerung.checkErinnerung02();
                MySpace.Kalender.Kalender.kalenderGetInput();
                break;
            //ToDo-Liste
            case 2:
                ToDoListe_filtern.toDoListe_filtern_Deadline_anfang();
                ToDoListe.ToDoListeGetInput();
                break;
            //Moneytracker
            case 3:
                WähleModus.modusWählen();
                break;
            //Alternativ falls nichts zutrifft.
            default:
                System.out.println(Farben.color_red + "Diesen Modus gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                menü();
                break;
        }
    }
}