package tictactoegame;

/**
 *
 * @author agata jelen
 */
public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe userGame = new TicTacToe();
        try {
            boolean keepPlaying = true;
            while (keepPlaying) {
                userGame.input();
                userGame.analyzeBoard();
                if (userGame.done()) {
                    String gameWinner = userGame.whoWon();
                    System.out.println("Winner: " + gameWinner);
                    keepPlaying = false;
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}