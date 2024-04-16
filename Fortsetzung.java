package MySpace;

import MySpace.Login.ModusWählen;
import MySpace.ToDoListe.ToDoListe_FragenNachFiltern;

public class Fortsetzung {
    /*
     * Hier wird gefragt wie man Fortzsetzen will, also das Programm beenden will oder ins Menü zurückkehren will.
     */
    public static void frageNachFortsetzung(){
        //Input einholen.
        System.out.println("Bitte gib " + Farben.color_purple + "[1]" + Farben.reset + " ein, um ins Menü zurück zukehren.");
        switch (BetterScanner.betterScannerInt("Bitte gib " + Farben.color_purple + "[2]" + Farben.reset + " ein, um das Programm zu beenden.\n")) {    //Den Input auswerten.
            case 1:
                Menü.menü();
                break;
            case 2:
                break;
            default:
                System.out.println(Farben.color_red + "Diese Option gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                frageNachFortsetzung();
                break;
        }
        
    }
    /*
     * Das ist die Methode die nach dem Registrieren bei der Startseite ausgeführt wird um die Möglichkeit zuerhalten sich direkt anzumelden.
     */
    public static void frageNachNeustart(){
        //Input einholen.
        System.out.println("Bitte gib " + Farben.color_purple + "[1]" + Farben.reset + " ein, um ins Menü zurück zukehren.");
        switch (BetterScanner.betterScannerInt("Bitte gib " + Farben.color_purple + "[2]" + Farben.reset + " ein, um das Programm zu beenden.\n")) {    //Den Input auswerten.
            case 1:
                ModusWählen.modusWählen();
                break;
            case 2:
                break;
            default:
                System.out.println(Farben.color_red + "Diese Option gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                frageNachFortsetzung();
                break;
        }
        
    }

    /*
     * Das ist die Methode die nach dem Filtern bei der ToDoListe ausgeführt wird um die Möglichkeit zuerhalten neu zufiltern.
     */
    public static void frageNachFortsetzung_filtern(){
        //Input einholen.
        System.out.println("Bitte gib " + Farben.color_purple + "[1]" + Farben.reset + " ein, um ins Menü zurück zukehren.");
        System.out.println("Bitte gib " + Farben.color_purple + "[2]" + Farben.reset + " ein, neu zu Filtern.");
        switch (BetterScanner.betterScannerInt("Bitte gib " + Farben.color_purple + "[3]" + Farben.reset + " ein, um das Programm zu beenden.\n")) {    //Den Input auswerten.
            case 1:
                Menü.menü();
                break;
            case 2:
                ToDoListe_FragenNachFiltern.toDoListe_FragenNachFiltern();
                break;
            case 3:
                break;
            default:
                System.out.println(Farben.color_red + "Diese Option gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                frageNachFortsetzung();
                break;
        }
        
    }
}