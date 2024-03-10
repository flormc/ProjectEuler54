package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    public void addCard(Card card){
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
    @Override
    public int compareTo(Hand otherHand){
        List<Card> thisSorted = new ArrayList<>(cards);
        List<Card> otherSorted = new ArrayList<>(otherHand.getCards());

        Collections.sort(thisSorted, Collections.reverseOrder());
        Collections.sort(otherSorted, Collections.reverseOrder());

        for (int i = 0; i < Math.min(cards.size(), otherHand.getCards().size()); i++) {
            int result = thisSorted.get(i).getRank().ordinal() - otherSorted.get(i).getRank().ordinal();
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(thisSorted.size(), otherSorted.size());
    }
    @Override
    public String toString() {
        return cards.toString();
    }
}
