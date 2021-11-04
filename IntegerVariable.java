/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integervariable;

/**
 *
 * @author agatajelen
 */
public class IntegerVariable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int checking;
        byte miles;
        short minutes;
        long days; //declare a long day variable
        
        checking =-20;
        miles = 105;
        minutes = 120;
        days = 189000;
        
        System.out.println("We drove " +miles+ " miles");
        System.out.println("Took us " +minutes+ " minutes.");
        System.out.println("Our acconut balance is " +checking);
        System.out.println("About "+ days +" days Columbus" +"stood on this spot.");
        // TODO code application logic here
    }
    
}
