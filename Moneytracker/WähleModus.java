package MySpace.Moneytracker;

import MySpace.BetterScanner;
import MySpace.Farben;

public class WähleModus {
    public static void modusWählen(){
        //Modusabfrage
        System.out.println(Farben.color_white_underlined + "Willkommen beim Moneytracker!" + Farben.reset);
        System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " um einen Eintrag zu tätigen.");
        System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " um eine Auswertung der Finanzen zu erhalten.");
        System.out.println("Bitte gib " + Farben.color_green + "[3]" + Farben.reset + " für die Einstellungen.");
        //Input der Modusabfrage auswerten
        switch (BetterScanner.betterScannerInt("")) {
            //Anmelden
            case 1:
                Datenspeicher.datensatz(); 
                break;
            //Events abfragen
            case 2:
                Auswertung.auswertung();
                break;
            //Einstellungen
            case 3:
                
                break;
            default:
                System.out.println(Farben.color_red + "Diesen Modus gibt es leider nicht. Bitte wiederhole deine Eingabe." + Farben.reset);
                modusWählen();
                break;
        }
    }  
}
