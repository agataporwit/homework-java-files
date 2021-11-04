package tictactoegame;

import java.util.Scanner;

/**
 * @author agata jelen
 */
//The class TicTacToe is handling user input/output and the
//logistics of the game.
public class TicTacToe {

    private final String[][] board;   //playing board
    private final String[][] blankBoard; //copy of original board to compare
    private String winner; //X for player 1 won, O for player 2 won, T for tie, P for still playing
    private String whoseTurn;//X for Player1, O for player2

    /**
     * NO ARG CONSTRUCTOR
     */
    public TicTacToe() {
        board = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "a", "b", "c"},
            {"d", "e", "f", "g"}
        };
        blankBoard = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "a", "b", "c"},
            {"d", "e", "f", "g"}
        };

        winner = "P";
        whoseTurn = "X";
    }

    /**
     * Method to print game board
     */
    public void printBoard() {
//for loop inside a for loop
        for (int i = 0; i < 4; i++) // i == row
        {
            for (int j = 0; j < 4; j++) // j == columns
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Method gathers user input for game
     */
    public void input() {
        Scanner keyboard = new Scanner(System.in);

        if ("X".equals(whoseTurn)) {
            System.out.println("Player X's turn:");
        } else {
            System.out.println("Player O's turn:");
        }

        boolean validMove = false;

        while (!validMove) {
            printBoard();

            System.out.println("Player " + whoseTurn + ", please enter a character to place your move: ");
            String playerInput = keyboard.nextLine();
            playerInput = playerInput.trim();

            boolean taken = false;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (blankBoard[i][j].equalsIgnoreCase(playerInput)) //if input is on the blank board
                    {

                        if (board[i][j].equals(blankBoard[i][j])) {
                            board[i][j] = whoseTurn;
                            validMove = true;
                        } else {
                            System.out.println("This location has already been played, please enter another location!");
                            taken = true;
                        }
                    }
                }
            }
            System.out.print("\n");

            if (!validMove && !taken) {
                System.out.println("invalid location, please pick a new valid location on the board!");
            }

        }

        if ("X".equals(whoseTurn)) {
            whoseTurn = "O";
        } else {
            whoseTurn = "X";
        }
    }

    /**
     * Method for game simulation to test program
     *
     * @param player X for player 1 and O for player 2
     * @param letter char value on board to represent where to place move
     * @throws IllegalArgumentException
     */
    public void simulateInput(char player, char letter) throws IllegalArgumentException {
        if (!whoseTurn.equalsIgnoreCase(String.valueOf(player))) {
            throw new IllegalArgumentException("Error! Played out of turn!");
        }
        boolean validMove;
        validMove = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (blankBoard[i][j].equalsIgnoreCase(String.valueOf(letter))) {
                    if (board[i][j].equals(blankBoard[i][j])) {
                        board[i][j] = String.valueOf(player);
                        validMove = true;
                    } else {
                        /**System.out.println("This location has already been played, please enter another location!"); throw ^^*/
                        throw new IllegalArgumentException("Error! This location has already been played!");
                    }
                }
            }
        }
        if (!validMove) {
//throw
            throw new IllegalArgumentException("Error! Not a valid move!");
        }
        printBoard();

//player +whoseTurn+ chose: letter
        System.out.println("Player " + whoseTurn + " chose position: " + letter);
        if ("X".equals(whoseTurn)) {
            whoseTurn = "O";
        } else {
            whoseTurn = "X";
        }

    }

    /**
     * Method to check if there is a winning combo on board !setter for winner!
     */
    public void analyzeBoard() {

        String pLetter = "X";

        if (whoseTurn.equals("X")) {
            pLetter = "O";
        }

//ROWS Works!!!
// 0 through 2 in each row
        for (int i = 0; i < 4; i++) // i == row
        {
            boolean allSame = true;
            for (int j = 0; j <= 2; j++) // j == columns
            {
                if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
//found a winning match-3
                winner = pLetter;
            }
        }

// 1 through 3 in each row
        for (int i = 0; i < 4; i++) // i == row
        {
            boolean allSame = true;
            for (int j = 1; j <= 3; j++) // j == columns
            {
                if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
//found a winning match-3
                winner = pLetter;
            }
        }

// 0 through 2 in each column
        for (int j = 0; j <= 3; j++) // i == row
        {
            boolean allSame = true;
            for (int i = 0; i <= 2; i++) // j == columns
            {
                if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
//found a winning match-3
                winner = pLetter;
            }
        }

// 1 through 3 in each column
        for (int j = 0; j <= 3; j++) // i == row
        {
            boolean allSame = true;
            for (int i = 1; i <= 3; i++) // j == columns
            {
                if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
//found a winning match-3
                winner = pLetter;
            }
        }

        /**
         * DIAGONAL Right diagonals 1 row starts at 2, decreases column starts
         * at 0, increases
         */
        int j = 0; // j == column
        boolean allSame = true;
        for (int i = 2; i >= 0; i--) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
                //if not the letter we are looking for
                allSame = false;
                break;
            }

            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }

        /**
         * 2
         * row starts at 3, decreases column starts at 0, increases
         *
         */
        j = 0; // j == column
        allSame = true;
        for (int i = 3; i >= 1; i--) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }

            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }

//3
//row
//starts at 2, decreases
//column
//starts at 1, increases
        j = 1; // j == column
        allSame = true;
        for (int i = 2; i >= 0; i--) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }
//4

//row
//starts at 3, decreases
//column
//starts at 1, increases
        j = 1; // j == column
        allSame = true;
        for (int i = 3; i >= 1; i--) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }

        /**
         * Left Diagonals
         *
         * 1.row starts at 1, increases, column starts at 0, increases
         */
        j = 0;
        allSame = true;
        for (int i = 1; i <= 3; i++) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }

        /**
         * 2
         * row starts at 0, increases column starts at 0, increases
         */
        j = 0; // j == column
        allSame = true;
        for (int i = 0; i <= 2; i++) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }
        /**
         * 3 row starts at 1, increases column starts at 1
         */
        j = 1; // j == column
        allSame = true;
        for (int i = 1; i <= 3; i++) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }
        /**
         * 4; row starts at 0, increases,column starts at 1, increases
         */

        j = 1; // j == column
        allSame = true;
        for (int i = 0; i <= 2; i++) // i == row
        {
            if (!board[i][j].equalsIgnoreCase(pLetter)) {
//if not the letter we are looking for
                allSame = false;
                break;
            }
            j++;
        }

        if (allSame) {
//found a winning match-3
            winner = pLetter;
        }

//check for ties, see if there is something besides an X or O to be played
        boolean openSpace = false;
        for (int i = 0; i < 4; i++) // i == row
        {
            for (j = 0; j < 4; j++) // j == columns
            {
                if (!"X".equals(board[i][j]) && !"O".equals(board[i][j])) {
                    openSpace = true;
                    break;
                }
            }
        }

        if (!openSpace) {
            winner = "T";
        }
        //!!!!is this the problem with the tie
        done();

        if (!"P".equals(winner)) {
            printBoard();
        }
    }

    /**
     * Method !getter! for status when game is won or tied
     *
     * @return winner
     */
    public boolean done() {
        return !"P".equals(winner);
    }

    /**
     * Method !getter! for winner of game
     *
     * @return value in winner
     */
    public String whoWon() {
        return winner;
    }
}
