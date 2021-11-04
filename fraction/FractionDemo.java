/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author agatajelen CSD 143 Winter 2018
 */
public class FractionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Fraction a = new Fraction(1, 3);
            Fraction b = new Fraction(1, 12);

            Fraction result = new Fraction();

            // test addition
            System.out.println("Test addition:");
            result = a.add(b);
            System.out.println("("+a+ ")" + " + " + "("+b+ ")"+ " = " +  "(" +result+ ")");
            System.out.println();

            //test subtract
            System.out.println("Test subtraction:");
            result = a.subtract(b);
            System.out.println("("+a+ ")" + " - " + "("+b+ ")" + " = " +  "(" +result+ ")");
            System.out.println();

            // test multiplication
            System.out.println("Test multiplication:");
            result = a.multiply(b);
            System.out.println("("+a+ ")"+ " * " + "("+b+ ")" + " = " +  "(" +result+ ")");
            System.out.println();

            // test division
            System.out.println("Test division:");
            result = a.divide(b);
            System.out.println("("+a+ ")"+ " : " +"("+b+ ")" + " = " +  "(" +result+ ")");
            System.out.println();

            // test equals
            System.out.println("Test Equals:");
            if (a.equals(b)) {
                System.out.println("Fraction "+ "("+a+ ")"+" equals "+"("+b+ ")");
            } else {
                System.out.println("Fraction "+ "("+a+ ")"+" not equals "+"("+b+ ")");
            }

            // test less
            System.out.println();
            System.out.println("Test Less:");
            if (a.less(b)) {
                System.out.println("Fraction "+ "("+a+ ")"+" less "+"("+b+ ")");
            } else {
                System.out.println("Fractions "+ "("+a+ ")"+" not less " +"("+b+ ")" );
            }
            // test less
            System.out.println();
            System.out.println("Test some more:");
            if (a.more(b)) {
                System.out.println("Fraction "+ "("+a+")"+ " more than "+ "("+b+")");
            } else {
                System.out.println("Fraction "+ "("+a+")"+ " not more than "+ "("+b+")");
            }
        } catch (Exception e) // handle the exception below
        {
            System.out.println(e.getMessage());
            // throws the Exception
        }

    }

}


