package MySpace.Login.AESVerschlüsselung;



import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import MySpace.DateipfadeErstellen;
import MySpace.Menü;
import MySpace.Login.Loginpage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PasswortEncryptenBzwDecrypten {

    private static final String AES_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    private static String KEY_FILE_PATH = DateipfadeErstellen.create_filepath_aeskey();
    private static String file_Path = null;
    //Verarbeitung der bekommenen Logindaten
    public static void passwort(String passwort, String benutzername){
        try {
            // Generate or load AES key
            SecretKey secretKey = loadOrCreateAESKey();

            // Encrypt and decrypt example password
            String originalPassword = passwort;
            String encryptedPassword = AESVerschlüsselung.encryptPassword(originalPassword, secretKey);
            //System.out.println(encryptedPassword);
            //String decryptedPassword = decryptPassword(encryptedPassword, secretKey);
            if (passwörterVergleichen(encryptedPassword, benutzername) == true) {
                System.out.println("Die Benutzerdaten sind richtig.");

                Menü.menü();
            }else{
                System.out.println("Die Benutzerdaten sind falsch.");
                Loginpage.loginpage();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Laden oder erstellen des Verschlüsselungsschlüssel
    public static SecretKey loadOrCreateAESKey() throws NoSuchAlgorithmException, IOException {
        File keyFile = new File(KEY_FILE_PATH);
        SecretKey secretKey;

        if (keyFile.exists()) {
            byte[] encodedKey = Files.readAllBytes(Paths.get(KEY_FILE_PATH));
            secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, AES_ALGORITHM);
        } else {
            KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
            keyGen.init(KEY_SIZE);
            secretKey = keyGen.generateKey();
            byte[] encodedKey = secretKey.getEncoded();
            try (OutputStream os = new FileOutputStream(KEY_FILE_PATH)) {
                os.write(encodedKey);
            }
        }
        return secretKey;
    }
    //Hier wird das von der Loginpage bekommene Passwort verschlüsselt und mit den Benutzerdaten aus der User.txt verglichen.
    public static boolean passwörterVergleichen(String passwortencryptet, String benutzername){
        boolean status = false;
        String passwort = passwortencryptet;
        int i = 1;
        try {
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_userports());
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            //String readOneLines = Files.readString(filePath, Charset.defaultCharset());
            for (String string : readAllLines) {
                if (string.contains(benutzername)) {
                    if (string.contains(passwort)) {
                        status = true;
                        //file_Path = readAllLines.get(i++); // Nächste Zeile speichern
                        break; // Aus der Schleife ausbrechen, da die Bedingung erfüllt ist
                    }
                }
                i++;
            }

            for (String string : readAllLines) {
                if (string.contains("C:\\\\Users\\\\timob\\\\Timo\\\\Programmierungen\\\\Java-Projekte\\\\MySpace\\\\Benutzer\\\\User" + i / 2)) {
                    file_Path = string;
                    File keyFile = new File(file_Path);
                    if (keyFile.exists()) {
                        System.out.println("Es passt alles.");
                        break;
                    } else {
                        File directory = new File(file_Path);
                        if (!directory.exists()) { // Überprüfen, ob der Ordner bereits vorhanden ist
                            directory.mkdirs(); // Falls nicht, den Ordner erstellen (und alle erforderlichen übergeordneten Verzeichnisse)
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }

        return status;
    }
    /*
     * Getter
     */
    public static String getFile_Path() {
        return file_Path;
    }
}
