/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coin;

/**
 *
 * @author agatajelen
 */

public class Player{
   int playerScore;
   Player(){
       playerScore = 0;
   }
   int getScore(){
       return playerScore;
   }
   void increaseScore(){
       playerScore++;
   }
   void decreaseScore(){
       playerScore--;
   }
}
