package MySpace.Login;

import MySpace.BetterScanner;
import MySpace.Farben;
import MySpace.Login.Registration.Benutzeranlegen;

public class ModusWählen {
    public static void modusWählen(){
        //Modusabfrage
        System.out.println(Farben.color_white_underlined + "Willkommen bei MySpace!" + Farben.reset);
        System.out.println("Bitte gib " + Farben.color_green + "[1]" + Farben.reset + " ein um sich anzumelden.");
        System.out.println("Bitte gib " + Farben.color_green + "[2]" + Farben.reset + " ein um sich zu registrieren.");
        System.out.println("Bitte gib " + Farben.color_green + "[3]" + Farben.reset + " für die Einstellungen.");
        //Input der Modusabfrage auswerten
        switch (BetterScanner.betterScannerInt("")) {
            //Anmelden
            case 1:
                Loginpage.loginpage();  
                break;
            //Events abfragen
            case 2:
                Benutzeranlegen.benutzerAnlegen();
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
