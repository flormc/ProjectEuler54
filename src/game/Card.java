package game;

public class Card {
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public enum Rank{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        HEARTS, SPADES, CLUBS, DIAMONDS
    }

    private final Rank rank;
    private final Suit suit;

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    @Override
    public String toString(){
        return rank + "of" + suit;
    }
}
