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
        String salt = pwm.getNewSalt();
        System.out.println(pwm.hash(e, salt));
        
        
        System.out.println(pwm.verifyPassword("aaaa", pwm.hash("aaaa", salt), salt));
        
       
    }

    public String getNewSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        System.out.println("New Salt: " + new String(Base64.getEncoder().encode(salt)));
        return new String(Base64.getEncoder().encode(salt));
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
    
    public String hash(String password, String _salt) {
        final int ITERATIONS = 65536;
        byte[] salt = Base64.getDecoder().decode(_salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new String(Base64.getEncoder().encode(hash));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Error hashing password: " + ex);
            return null;
        }
    }

    public boolean verifyPassword(String providedPassword, String hash, String salt) {
        System.out.println("Salt:      " + salt);
        System.out.println("Hash:      " + hash);
        System.out.println("Password:  " + providedPassword);
        System.out.println("Hashed PW: " + hash(providedPassword, salt));
        System.out.println("PASSED:    " + hash(providedPassword, salt).equals(hash));
        return hash(providedPassword, salt).equals(hash);
    }
}
