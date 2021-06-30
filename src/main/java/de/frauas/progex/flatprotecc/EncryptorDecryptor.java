package main.java.de.frauas.progex.flatprotecc;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;

/**
 *
 * @author tarik
 */
public class EncryptorDecryptor {

    private Aead aead;
    
    //Main method for testing purposes only.
    public static void main(String[] args) {
        String eee = "Encrypt this!";
        EncryptorDecryptor enc = new EncryptorDecryptor();
        System.out.println(new String(enc.decrypt(enc.encrypt(eee.getBytes()))));
    }

    public EncryptorDecryptor() {
        final String keysetFilename = "keyset.json";
        File keyFile = new File(keysetFilename);
        KeysetHandle keysetHandle = null;
        try {
            AeadConfig.register();

            if (!keyFile.exists()) {
                //generate keyset
                keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("AES128_GCM"));

                // and write it to a file.
                try {
                    CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(keyFile));
                } catch (IOException ex) {
                    System.err.println("Cannot write keyset, got error: " + ex);
                    System.exit(1);
                }

            } else {

                try {
                    keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(keyFile));
                } catch (IOException ex) {
                    System.err.println("Cannot read keyset, got error: " + ex);
                    System.exit(1);
                }
            }

            aead = keysetHandle.getPrimitive(Aead.class);
        } catch (GeneralSecurityException ex) {
            System.err.println("GeneralSecurityException, got error: " + ex);
            System.exit(1);
        }
    }

    public byte[] encrypt(byte[] plaintext) {
        byte[] ciphertext;
        try {
            ciphertext = aead.encrypt(plaintext, null);
            return ciphertext;
        } catch (GeneralSecurityException ex) {
            System.err.println("Encryption failed." + ex);
            return null;
        }
    }

    public byte[] decrypt(byte[] ciphertext) {
        byte[] plaintext;
        try {
            plaintext = aead.decrypt(ciphertext, null);
            return plaintext;
        } catch (GeneralSecurityException ex) {
            System.err.println("Decryption failed." + ex);
            return null;
        }
    }

    public String encryptString(String plaintext) {
        String cipherString = new String(Base64.getEncoder().encode(encrypt(plaintext.getBytes())));
        return cipherString;
    }

    public String decryptString(String ciphertext) {
        byte[] ciphertext_ = Base64.getDecoder().decode(ciphertext.getBytes());
        String plaintext = new String(decrypt(ciphertext_));
        return plaintext;
    }
}
