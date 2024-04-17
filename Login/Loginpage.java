package MySpace.Login;

import MySpace.BetterScanner;
import MySpace.Farben;
import MySpace.Login.AESVerschlüsselung.PasswortEncryptenBzwDecrypten;

public class Loginpage {
    public static void loginpage(){
        //Die Abfrage der Logindaten.
        String benutznamegegeben = BetterScanner.betterScannerString(Farben.color_green_underlined + "Bitte Geben sie ihren Benutzernamen ein: \n" + Farben.reset );
        String passwortgegeben = BetterScanner.betterScannerString(Farben.color_green_underlined + "Bitte Geben sie ihr Passwort ein: \n" + Farben.reset );
        PasswortEncryptenBzwDecrypten.passwort(passwortgegeben, benutznamegegeben);
    }
}
