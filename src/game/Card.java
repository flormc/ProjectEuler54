package game;

public class Card implements Comparable<Card>{
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public int compareTo(Card otherCard) {
        int rankComparison = this.rank.compareTo(otherCard.rank);
        if (rankComparison != 0) {
            return rankComparison;
        } else {
            return this.suit.compareTo(otherCard.suit);
        }
    }

    public enum Rank{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        HEARTS, SPADES, CLUBS, DIAMONDS,
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
