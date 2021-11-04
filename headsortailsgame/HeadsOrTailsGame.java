package headsortailsgame;

import java.util.Random;

/**
 * Java program that simulates the Heads or Tails Coin game between two players.
 * The program prints the winner of the game who correctly guessed 5 times.
 * If a player guesses incorrectly, then that player will lose a point.
 * Coin class - face up or face down. 
 * This is a simulation, no user input required.
 *
 * @author agatajelen Assignment 1, CSD 143 April 13, 2018
 */
public class HeadsOrTailsGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create two Objects - Player    
        Player player1 = new Player();
        Player player2 = new Player();
        //instance of random Random class    
        Random rand = new Random();
        //boolean set - repeat true    
        boolean repeat = true;
        //Declare a string variable winner to empty    
        String winner = "";
        String userGuess = "";
        //while loop checking if points of player1 and player 2 are equal to 5    
        while (repeat) {
            //Player One Coin Guess
            //Players guess set up using Random nextInt generator
            
            int randomNumber = rand.nextInt(2);
            //Set userGuess to heads 
            if (randomNumber == 0) {
                userGuess = "heads";
            } else if (randomNumber == 1);
            userGuess = "tails";
            //Check if userGuess is same when player1 call play method
            if (userGuess.equals(player1.play())) {
                player1.increment();
            }
            //Check if player1 got his points
            if (player1.getPoints() == 5) {
                repeat = false;
                winner = "Player One";
            }
            //Player Two Coin Guess
            randomNumber = rand.nextInt(2);
            if (randomNumber == 0) {
                userGuess = "heads";
            } else if (randomNumber == 1);
            userGuess = "tails";
            //Check if userGuess is same when player2 call play method
            if (userGuess.equals(player2.play())) {
                player2.increment();
            }
            //Check if player2 got his points
            if (player2.getPoints() == 5) {
                repeat = false;
                winner = "Player Two";
            }
            //Check if the player1 and player2 points are equal
            if ((player1.getPoints() == 5)
                    && (player2.getPoints() == 5)) {
                repeat = false;
            //Set winner to Tie    
                winner = "Tie";
            }
        }
        //check if the game is Tie

        if (winner.equals("Tie")) {
            System.out.println("Game is" + winner);
        //If not tie print the winner     
        } else {
            System.out.println(winner + "\nwon the \"Heads or Tails\" game!");
        }
    }

}
