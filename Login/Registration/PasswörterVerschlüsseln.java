package MySpace.Login.Registration;

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

public class PasswörterVerschlüsseln {
    private static final String AES_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    private static final String KEY_FILE_PATH = DateipfadeErstellen.create_filepath_aeskey();

        public static void passwort(String passwort, String benutzername){
        try {
            // Generate or load AES key
            //SecretKey secretKey = loadOrCreateAESKey();

            // Encrypt and decrypt example password
            //String originalPassword = passwort;
            //String encryptedPassword = encryptPassword(originalPassword, secretKey);
            //System.out.println(encryptedPassword);
            //String decryptedPassword = decryptPassword(encryptedPassword, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
    public static String encryptPassword(String password, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }  
}
