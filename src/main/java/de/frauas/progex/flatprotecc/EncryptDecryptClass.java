/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;

/**
 *
 * @author tarik
 */
public class EncryptDecryptClass {

    private Aead aead;

    public EncryptDecryptClass() {
        final String keysetFilename = "my_keyset.json";
        File keyFile = new File(keysetFilename);
        KeysetHandle keysetHandle;
        AeadConfig.register();

        if (!keyFile.exists()) {
            //generate keyset
            keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("AES128_GCM"));

            // and write it to a file.
            CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(keyFile)));
            
        } else {
            
            try {
                keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(keyFile));
            } catch (GeneralSecurityException | IOException ex) {
                System.err.println("Cannot read keyset, got error: " + ex);
                System.exit(1);
            }
        }

        Aead aead = null;
        try {
            aead = handle.getPrimitive(Aead.class);
        } catch (GeneralSecurityException ex) {
            System.err.println("Cannot create primitive, got error: " + ex);
            System.exit(1);
        }
    }

    public byte[] encrypt(byte[] plaintext) {
        byte[] ciphertext = aead.encrypt(plaintext);
        return ciphertext;
    }

    public byte[] decrypt(byte[] ciphertext) {
        byte[] plaintext = aead.decrypt(ciphertext);
        return plaintext;
    }
    
    public String encryptString(String plaintext){
        String cipherString = new String(encrypt(plaintext.getBytes()));
        return cipherString;
    }
    
    public String decryptString(String ciphertext){
        String plaintext = new String(decrypt(plaintext.getBytes()));
        return plaintext;
    }

}
