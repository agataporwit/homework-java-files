/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

/**
 *
 * @author agatajelen
 */
public class Pyramids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
for (int i = 1; i <= 5; i++) {
            for (int s = 5; s > i; s--) {
                System.out.print(" ");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 1; i <= 5; i++) {
            for (int s = 1; s < i; s++) {
                System.out.print(" ");
            }
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
