package MySpace.ToDoListe;

import MySpace.BetterScanner;
import MySpace.Farben;

public class ToDoListe_FragenNachFiltern {
    public static void toDoListe_FragenNachFiltern(){
        //Modusabfrage
        System.out.println(Farben.color_white_underlined + "Willkommen bei der ToDo-Liste!" + Farben.reset);
        System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " um alle ToDo's ungefiltert anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " um alle Haushalt-ToDo's anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[3]" + Farben.reset + " um alle Schul-ToDo's anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[4]" + Farben.reset + " um alle Sozialen-ToDo's anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[5]" + Farben.reset + " um alle Sonstigen-ToDo's anzuzeigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[6]" + Farben.reset + " um alle heute fälligen ToDo's anzuzeigen.");
        //Input der Modusabfrage auswerten
        switch (BetterScanner.betterScannerInt("Bitte gib " + Farben.color_green + "[7]" + Farben.reset + " für die Einstellungen.\n")) {
            //Alle ToDo's
            case 1:
                ToDoListe_ToDosabrufen.readString();
                break;
            //Haushalts-ToDo's
            case 2:
                ToDoListe_filtern.toDoListe_filtern_Haushalt();
                break;
            //Schul-ToDo's
            case 3:
                ToDoListe_filtern.toDoListe_filtern_Schule();
                break;
            //Soziale-ToDo's
            case 4:
                ToDoListe_filtern.toDoListe_filtern_Soziales();
                break;

            case 5:
                ToDoListe_filtern.toDoListe_filtern_Sonstiges();
                break;
            //Es werden nur die Angezeigt die an dem heutigen Tag die Deadline gesetzt haben.
            case 6:
                ToDoListe_filtern.toDoListe_filtern_Deadline();
                break;
            case 7:
                break;
            default:
                System.out.println(Farben.color_red + "Diesen Modus gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                toDoListe_FragenNachFiltern();
                break;
        }
    }
}
