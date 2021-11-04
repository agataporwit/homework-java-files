package Assignment4_Agata_Jelen_CSD143;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        TestScores scores;
        do {
        Scanner input = new Scanner(System.in);
        scores = null;

            try {
                int array[] = new int[5];
                System.out.println("Enter your test scores please: ");
                try {
                    for ( int i = 0; i < 5; i++ )
                        array[i] = input.nextInt();
                } catch(InputMismatchException e) {
                    System.out.println("Only enter integers, please!");
                    continue;

                }
               scores = new TestScores(array);
            } catch (InvalidTestScores e) {
                System.out.println(e.getMessage());
            }
        } while(scores == null);
        System.out.println("\nGood Bye <(._.)>");
        System.exit(0);


    }
}
