/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Tarik
 */
public class PasswordManager {
    public static void main(String[] args){
        PasswordManager pwm = new PasswordManager();
        final String e = "EAEAEAEA";
        byte[] salt = pwm.getNewSalt();
        System.out.println(pwm.hash(e, salt));
        
        
        System.out.println(pwm.verifyPassword("aaaa", pwm.hash("aaaa", salt), salt));
        
       
    }

    public byte[] getNewSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    /*public byte[] hash(String password, byte[] salt) {
        final int ITERATIONS = 65536;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return hash;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Error hashing password: " + ex);
            return null;
        }
    }*/
    
    public String hash(String password, byte[] salt) {
        final int ITERATIONS = 65536;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new String(Base64.getEncoder().encode(salt));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Error hashing password: " + ex);
            return null;
        }
    }

    public boolean verifyPassword(String providedPassword, byte[] hash, byte[] salt) {
        return hash(providedPassword, salt).equals(hash);
    }
}
