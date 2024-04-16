package MySpace.Login.AESVerschlüsselung;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import MySpace.DateipfadeErstellen;

public class AESVerschlüsselung {
    private static final String FILE_PATH_AESKEY = DateipfadeErstellen.create_filepath_aeskey();
    private static final String AES_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;

    // Passwort verschlüsseln
    public static String encryptPassword(String password, SecretKey secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Passwort entschlüsseln
    public static String decryptPassword(String encryptedPassword, SecretKey secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decryptedBytes);
    }

    // Hier wird der Schlüssel geladen oder erstellt
    public static SecretKey loadOrCreateAESKey() throws NoSuchAlgorithmException, IOException {
        File keyFile = new File(FILE_PATH_AESKEY);
        SecretKey secretKey;
        if (keyFile.exists()) {
            byte[] encodedKey = Files.readAllBytes(Paths.get(FILE_PATH_AESKEY));
            secretKey = new SecretKeySpec(encodedKey, AES_ALGORITHM);
        } else {
            KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
            keyGen.init(KEY_SIZE);
            secretKey = keyGen.generateKey();
            byte[] encodedKey = secretKey.getEncoded();
            try (OutputStream os = new FileOutputStream(FILE_PATH_AESKEY)) {
                os.write(encodedKey);
            }
        }
        return secretKey;
    }
}