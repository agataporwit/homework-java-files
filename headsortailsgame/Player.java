package headsortailsgame;

/**
 * Player class for Heads Or Tails Game Simulation.
 * Class contains instance variables points, Coin class object.
 * The method play, that calls toss and calls the getSideUp method, to return face up value of the coin.
 * The method increment- increments players points.
 * @author agatajelen Assignment 1, CSD 143 April 13, 2018
 */
public class Player {

    private int points;
//Create an instance of Coin class
    private final Coin coin = new Coin();

//Constructor to set points
    public Player() {
        points = 0;
    }
    public String play() {
        //Call toss method to flip the coin. Returns the face up either "heads" or "tails"
        coin.toss();
        return coin.getSideUp();
    }
//Method to set points

    public void setPoints(int points) {
        this.points = points;
    }
//Returning the number of points of the player

    public int getPoints() {
        return points;
    }

//Adding points 
    public void increment() {
        points++;
    }

}
