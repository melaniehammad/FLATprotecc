/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc;

//this is:
//main.java.de.frauas.progex.flatprotecc.PasswordBar
import javax.swing.JProgressBar;

/**
 *
 * @author Tarik
 */
public class PasswordBar extends JProgressBar {
    
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 100;

    public PasswordBar() {
        super(MINIMUM, MAXIMUM);      //range [0-100]
        setStringPainted(true);
    }

    public void setSecurityLevel(String password) {
        int score = 0;
        if (password.matches(".*[0-9].*")) {         //password contains a digit
            score += 20;   
        }
        if (password.length() >= 8) {               //password longer than eight
            score += 20;
        }
        if (password.matches(".*[^A-Za-z0-9].*")) { //password contains special chars
            score += 20;
        }
        if (password.matches(".*[A-Z].*")) {        //password contains uppercase letters
            score += 20;
        }
        if (password.matches(".*[a-z].*")) {        //password contains lowercase letters
            score += 20;
        }
        switch(score){
            case 0 -> setString("Horrible");
            case 20 -> setString("Bad");
            case 40 -> setString("Mediocre");
            case 60 -> setString("Decent");
            case 80 -> setString("Good");
            case 100 -> setString("Very Good");
        }
        setValue(score);
    }
}
