/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averagecalculationuserinput;

import java.util.Scanner;

/**
 *
 * @author agatajelen
 */
public class AverageCalculationUserInput {
     public static void main(String[] args) {

        System.out.println("How many numbers you want to enter?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /* Declaring array of n elements, the value
         * of n is provided by the user
         */
        double[] arr = new double[n];
        double total = 0;

        for(int i=0; i<arr.length; i++){
        	System.out.print("Enter Element No."+(i+1)+": ");
        	arr[i] = scanner.nextDouble();
        }
        scanner.close();
        for(int i=0; i<arr.length; i++){
        	total = total + arr[i];
        }


    
        double average = total / arr.length;
        
        System.out.format("The average is: %.3f \n\n", average);
    }
}
