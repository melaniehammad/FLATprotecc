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
    private long validationCodeAge;
    private final int TEN_MINUTES_IN_MILLIS = 600000;

    public void generateNewValidationCode() {

        Random generator = new Random();
        validationCode = String.format("%04d", generator.nextInt(10000));   //number between 0000 and 9999 as String
        validationCodeAge = System.currentTimeMillis();
    }

    public boolean checkValidationCode(String validationCode_) {
        if (System.currentTimeMillis() > validationCodeAge + TEN_MINUTES_IN_MILLIS) {
            return false;
        } else {
            return validationCode_.equals(validationCode);
        }
    }

    public String getValidationCode() {
        return validationCode;
    }

}
