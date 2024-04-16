package MySpace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import MySpace.Login.AESVerschlüsselung.PasswortEncryptenBzwDecrypten;

public class DateipfadeErstellen {
    /*
     * Statisches Attribut für den Grunddateipfad.
     */
    private static final String filepath = "C:\\Users\\timob\\Timo\\Programmierungen\\Java-Projekte\\MySpace\\Benutzer";



    /*
     * Statisches Attribut für den Grunddateipfad der Benutzer.
     */
    private static String directorypath_user;


    /*
     * Methoden
     */
    //Den Dateipfad für die Benutzerdaten erstellen.
    public static String create_filepath_userports(){
        //Checken ob alle Ordner vom Grunddateipfad vorhanden sind.
        ornderCheck(filepath);
        //Eine Variable definieren um den Dateipfad zwischenzuspeichern.
        String filepath_userports;
        //Der Variable den erstellten Dateipfad zuweisen.
        filepath_userports = filepath + "\\Userports.txt";
        //Den Dateipfad zurückgeben.
        return filepath_userports;
    }
    //Den Dateipfad für den Verschlüsselungsschlüssel erstellen.
    public static String create_filepath_aeskey(){
        //Checken ob alle Ordner vom Grunddateipfad vorhanden sind.
        ornderCheck(filepath);
        //Eine Variable definieren um den Dateipfad zwischenzuspeichern.
        String filepath_aeskey;
        //Der Variable den erstellten Dateipfad zuweisen.
        filepath_aeskey = filepath + "\\aes_key.bin";
        //Den Dateipfad zurückgeben.
        return filepath_aeskey;
    }
    //Den Dateipfad für den Kalender erstellen.
    public static String create_filepath_kalender(){
        //Eine Variable definieren um den Dateipfad zwischenzuspeichern.
        String filepath_kalender;
        //Den Getter für den Grunddateipfad der Benutzer dem filepath_user zuweisen.
        directorypath_user = PasswortEncryptenBzwDecrypten.getFile_Path();
        //Checken ob der Ordner für den Benutzer bereits vorhanden ist.
        ornderCheck(directorypath_user);
        //Der Variable den erstellten Dateipfad zuweisen.
        filepath_kalender = directorypath_user + "\\Kalender.txt";
        //Checken ob die Datei für den Benutzer bereits vorhanden ist.
        dateiCheck(filepath_kalender);
        //Den Dateipfad zurückgeben.
        return filepath_kalender;
    }
        //Den Dateipfad für die ToDo Liste erstellen.
    public static String create_filepath_ToDo_Liste(){
        //Eine Variable definieren um den Dateipfad zwischenzuspeichern.
        String filepath_ToDo_Liste;
        //Den Getter für den Grunddateipfad der Benutzer dem filepath_user zuweisen.
        directorypath_user = PasswortEncryptenBzwDecrypten.getFile_Path();
        //Checken ob der Ordner für den Benutzer bereits vorhanden ist.
        ornderCheck(directorypath_user);
        //Der Variable den erstellten Dateipfad zuweisen.
        filepath_ToDo_Liste = directorypath_user + "\\ToDoDatenbank.txt";
        //Checken ob die Datei für den Benutzer bereits vorhanden ist.
        dateiCheck(filepath_ToDo_Liste);
        //Den Dateipfad zurückgeben.
        return filepath_ToDo_Liste;
    }
    //Den Dateipfad für die ToDo Liste erstellen.
    public static String create_filepath_Moneytracker(){
        //Eine Variable definieren um den Dateipfad zwischenzuspeichern.
        String filepath_Moneytracker;
        //Den Getter für den Grunddateipfad der Benutzer dem filepath_user zuweisen.
        directorypath_user = PasswortEncryptenBzwDecrypten.getFile_Path();
        //Checken ob der Ordner für den Benutzer bereits vorhanden ist.
        ornderCheck(directorypath_user);
        //Der Variable den erstellten Dateipfad zuweisen.
        filepath_Moneytracker = directorypath_user + "\\MoneytrackerDatensatz.txt";
        //Checken ob die Datei für den Benutzer bereits vorhanden ist.
        dateiCheck(filepath_Moneytracker);
        //Den Dateipfad zurückgeben.
        return filepath_Moneytracker;
    }


    /*
     * Methoden um die Dateien und Ordner zu erstellen.
     */
    //Erstellung der Dateien mit angegebenen Filepath.
    public static void dateiCheck(String filepath_bekommen){
        Path filePath = Paths.get(filepath_bekommen);
        if (!Files.exists(filePath)) {
            try {
                //Erstellen der Datei.
                Files.createFile(filePath);
                System.out.println("Neue Datei erstellt: " + filePath);
            } catch (IOException e) {
                System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
            }
        }  
    }
    //Erstellung der Ordner mit angegebenen Directorypath.
    public static void ornderCheck(String direktorypath_bekommen){
        Path direktoryPath = Paths.get(direktorypath_bekommen);
        if (!Files.exists(direktoryPath)) {
            try {
                //Erstellen des Ordners.
                Files.createDirectory(direktoryPath);
            } catch (IOException e) {
                System.err.println("Fehler beim Erstellen der Datei: " + e.getMessage());
            }
        }  
    }
}
