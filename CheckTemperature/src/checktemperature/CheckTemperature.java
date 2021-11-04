/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checktemperature;

import java.util.Scanner;

/**
 *
 * @author agatajelen
 */
public class CheckTemperature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double MAX_TEMP =102.5;//max temp
        double temperature; //to hold temp
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the temp in Cel: ");
        temperature = keyboard.nextDouble();
        
        while(temperature>MAX_TEMP)
        {
            System.out.println("Temp. too high");
        System.out.println("wait 5 min");
        System.out.println("Check temp again");
        System.out.print("Enter it here: ");
        temperature = keyboard.nextDouble();
        }
        System.out.println("Tmp is ok");
        System.out.println("Check again in 15 min");
        // TODO code application logic here
    }
    
}
