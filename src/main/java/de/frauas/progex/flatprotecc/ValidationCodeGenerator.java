/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc;

import java.util.Random;
/**
 *
 * @author lucas
 */
public class ValidationCodeGenerator {
    
    private String validationCode;
    
    public String generateNewValidationCode() {
    
        Random generator = new Random();
        validationCode = Integer.toString(generator.nextInt(10000));
        
        return validationCode;
    }
    
    public boolean checkValidationCode(String validationCode_) {
    
        return validationCode_.equals(validationCode);
    }
    
    
    
}
