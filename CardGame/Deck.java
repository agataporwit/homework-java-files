package cardgame;

public class Deck {
    final int CardCount = 52;
    private Card[] cards;
    private int top = 0;

    public Deck() {
        this.cards = new Card[CardCount];
        int cardIndex = 0;

        for ( Suit s : EnumSet.allOf(Suit.class) )
            for ( Rank r : EnumSet.allOf(Rank.class) )
                cards[cardIndex++] = new Card(r, s);
        top = 0;
    }

    public void Shuffle() {

    }

    public void Cut() {

    }

    public Card Deal() {
        return cards[top++];
    }
}