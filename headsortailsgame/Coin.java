package headsortailsgame;

import java.util.Random;

/**
 * Coin class that sets the string sideUp value. The method toss generates a
 * random value 0 or 1. If random number is 0, then sideUp value is set to
 * "heads" otherwise the sideUp value is "tails".
 *
 * @author agatajelen Assignment 1, CSD 143 April 13, 2018
 */
public class Coin {
//set coin object sideUp value

    private String sideUp;

    //Default constructor sets initial value to sideUp
    public Coin() {
        //calling toss methid    
        toss();
    }

    // Toss method generates random number and sets the value of sideUp based on random value
    public void toss() {
        //Generate random value    
        Random rand = new Random();
        int value = rand.nextInt(2);
        //Set sideUp value.
        if (value == 0) {
            sideUp = "heads";
        } else if (value == 1) {
            sideUp = "tails";
        }
    }
//getSideUp method, returns sideUp value
    public String getSideUp() {
        return sideUp;
    }
}
