package cardgame;

import cardgame.Rank;

public class CardGame {
    public static void main(String[] args) {
        // create a deck of cards
        Deck deck = new Deck();

        // shuffle the deck
        deck.Shuffle();

        Card c = deck.Deal();
    }
}
