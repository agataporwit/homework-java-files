/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celsiustofahrenheittable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author agatajelen
 */
public class CelsiusToFahrenheitTable {

    public static void main(String[] args) {

        // Table Header
        System.out.println("                Temperature (Degrees)");
        System.out.println("----------------------------------------------");
        System.out.println("   Celsius " + "                  Fahrenheit");

        // Decimal formatting
        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(2);

        // Counter variable
        int count = 20;
        double fahrenheit;

        // For loop to calculate fahrenheit and display table data
        for (int i = -10; i < 41; i += 5) {
            fahrenheit = 9 / 5.0 * i + 32;
            System.out.println("      " + i + "               " + df.format(fahrenheit));
        }
    }
}
