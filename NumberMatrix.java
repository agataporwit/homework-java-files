

import java.util.Scanner;

/*
 * Write a Java method (takes a number n as input) to displays an n-by-n matrix.
 * @author Agata
 */

public class NumberMatrix {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number \n" );
        int n = in.nextInt();
        printMatrix(n);


    }

    public static void printMatrix(int n){

        for (int i=0; i<n; i++ ) {

            for(int j=0; j< n; j++){
                System.out.print((int)(Math.random()*2) + " ");
            }

            System.out.println();
        }
    }
}
