package MySpace.Login.Registration;

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

import javax.crypto.SecretKey;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;
import MySpace.Login.AESVerschlüsselung.AESVerschlüsselung;

public class Benutzeranlegen {

    static List<String> intsInStringList = new ArrayList<String>();
    private static String benutzer;
    private static String encryptedPasswort;
    private static int i;
    private static String benutzername;
    private static String filePath;
    private static String passwortInput01;
    private static String passwortInput02;
    //Hier werden die Daten eingezogen und anschließend die Methoden zum zusammenbauen und printen aufgerufen, zudem wird auch der Zwischenspeicher aufgerufen.
    public static void benutzerAnlegen(){
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(Farben.color_cyan_underlined + "Registrieren:" + Farben.reset);
            System.out.print("Bitte geben Sie einen Benutzernamen ein:  ");
            String benutzernameinput = s.readLine();
            if (VerfügbarkeitAbfragen.verfügbarkeitAbfragen(benutzernameinput) == true) {
                benutzername = benutzernameinput;
                System.out.print("Bitte geben Sie ein Passwort ein:  ");
                passwortInput01 = s.readLine();
                System.out.print("Bitte wiederholen sie ihr Passwort:  ");
                passwortInput02 = s.readLine();
                if (passwortInput01 != passwortInput02) {
                    System.out.println("Danke für ihre Registrierung.");
                    SecretKey secretKey = AESVerschlüsselung.loadOrCreateAESKey();
                    encryptedPasswort = AESVerschlüsselung.encryptPassword(passwortInput01, secretKey);
                    zwischenspeicher();
                    dateiPfadErstellen();
                    benuterZusammenbauen();
                    Fortsetzung.frageNachNeustart();
                }else{
                    System.out.println("Die Passwörter stimmen nicht überein.");
                    benutzerAnlegen();
                }
            }else{
                System.out.println("Die Passwörter stimmen nicht überein.");
                benutzerAnlegen();
            }         
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }

                   
    }

    //Hier wird der Dateipfad erstellt, auf den immer wieder zugegriffen wird. Der ist bei jedem User individuell.
    public static void dateiPfadErstellen(){
        filePath = "C:\\\\Users\\\\timob\\\\Timo\\\\Programmierungen\\\\Java-Projekte\\\\MySpace\\\\Benutzer\\\\User" + i/2;
    }
    //Das hier ist der oben angeführte Zwischenspeicher, um die txt nichtzuüberschreiben.
    public static void zwischenspeicher(){
        List<String> neueListe = new ArrayList<String>();
        try{
            dateiCheck();
            FileReader fr = new FileReader(Paths.get(DateipfadeErstellen.create_filepath_userports()).toString());
            BufferedReader br = new BufferedReader(fr);
            String zeile = br.readLine();
            i = 1;
            while(zeile != null){
                neueListe.add(zeile);
                zeile = br.readLine();
                i++;
            }
            br.close();
            fr.close();
            intsInStringList = neueListe;
        }catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }
    //Hier wird geschaut, ob die datei Userports.txt vorhanden ist.
    public static void dateiCheck(){
        Path filePath = Paths.get(DateipfadeErstellen.create_filepath_userports());
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
    //Hier wird dann der text wieder in die Txt geprintet.
    public static void writeString(List<String> Test){
        dateiCheck();
	    try {
		    FileWriter mywriter = new FileWriter(Paths.get(DateipfadeErstellen.create_filepath_userports()).toString());
		    for(int i = 0; i < Test.size(); i++){
                 mywriter.write(Test.get(i) + "\n");
            }
            mywriter.close();
		} catch (Exception e) {
		    throw new IllegalArgumentException("Fehler ist passiert"); 
	    }
	}
    //Hier wird der Benutzer zusammengebaut.
    public static void benuterZusammenbauen(){
            filePath.replace("\\", "\\\\");
            benutzer = "User" + i/2 + "   Benutzername: " + benutzername + "  Passwort:" + encryptedPasswort + "\n" + filePath;
            intsInStringList.add(benutzer);
            writeString(intsInStringList);    
    }
}
