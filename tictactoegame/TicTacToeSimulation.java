/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author agatajelen
 */
public class TicTacToeSimulation 
{
	public static void main(String[] args) {
		
		//creating an object from the TicTacToe class
		TicTacToe game = new TicTacToe();
		//printing the board
		game.printBoard();
		
		/**
		 * in this simulation i am emulating a tie.
		 * i wanted to make sure that this mechanic of this program works properly
		 * the only way to get a tie in tic-tac_toe is if there is no winner, that should be evident
		 *check to see if there is locations of the board that has not been played
		 * if is true we set 'tie' to false - meaning there is no winner
		 * if the condition is false - meaning if all locations have been played - there is then a tie
		 */
		System.out.println();
		game.simulateInput('X', '1');
		game.simulateInput('O', '3');
		game.simulateInput('X', '2');
		game.simulateInput('O', '4');
		game.simulateInput('X', '7');
		game.simulateInput('O', '5');
		game.simulateInput('X', '8');
		game.simulateInput('O', '6');
		game.simulateInput('X', '9');
		game.simulateInput('O', 'b');
		game.simulateInput('X', 'a');
		game.simulateInput('O', 'c');
		game.simulateInput('X', 'f');
		game.simulateInput('O', 'd');
		game.simulateInput('X', 'g');
		game.simulateInput('O', 'e');
		game.analyzeBoard();
		System.out.println("\nPlayer" +game.whoWon());
		
		

	}

}
