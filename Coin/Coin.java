/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coin;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author agatajelen
 */
class Coin {
private static String sideUp;
/*
* Default constructor
*/
public Coin() {
Coin.sideUp = "Heads";
toss();
}
/*
* This method will simulate the tossing of a coin. It should set the
* sideUp field to either "heads" or "tails".
* @return
*/
public final int toss() {
Random rand = new Random();
// Get a random value, 0 or 1.
int value = rand.nextInt(2);
if (value == 0) {
Coin.sideUp = "Heads";
} else {
Coin.sideUp = "Tails";
}
return value;
}
/*
*
* @return The side of the coin facing up.
*/
public static String getSideUp() {
return sideUp;
}

public static void main(String args[]){
       Scanner keyboard = new Scanner(System.in);
       int player1Score = 0,player2Score = 0;
       
       //declaring two players
       Coin firstPlayer = new Coin();
       Coin secondPlayer = new Coin();
       while(true){
       System.out.println("Player 1, enter 1 for tails or 0 for heads ");
       int guess = keyboard.nextInt();
       //checking with player1 guess
       if(guess == firstPlayer.toss()){
       player1Score++;
       System.out.println("Good guess, it was " + Coin.getSideUp());
       System.out.println("Player 1 score: " + player1Score);
       }
       else{
       player1Score--;
       System.out.println("Bad guess, it was " + Coin.getSideUp());
       System.out.println("Player 1 score: " + player1Score);
       }
      
       //checking with player2
       System.out.println("Player 2, enter 1 for tails or 0 for heads ");
       guess = keyboard.nextInt();
       //checking with player1 guess
       if(guess == secondPlayer.toss()){
       player2Score++;
       System.out.println("Good guess, it was " + Coin.getSideUp());
       System.out.println("Player 2 score: " + player2Score);
       }
       else{
       player2Score--;
       System.out.println("Bad guess, it was " + Coin.getSideUp());
       System.out.println("Player 2 score: " + player2Score);
       }
      
       //Checking for winning condition
       if(player1Score == 5){
           System.out.println();
       System.out.println("Player 1 wins");
       break;
       }
       else if(player2Score == 5){
           System.out.println();
       System.out.println("Player 2 wins");
       break;
                   }
      
               }
           }
       }   

