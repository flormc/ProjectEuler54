import game.Card;
import game.Hand;
import game.Player;

import java.io.IOException;
import java.util.List;

public class PokerGame{
    public static void main(String[] args) throws IOException {
        String filePath = "src/poker.txt";

        PokerFileReader fileReader = new PokerFileReader(filePath);
        List<String> lines = fileReader.readLines();

        for (String line : lines){
            String[] cardsArray = line.split(" ");

            Player player1 = createPlayer("Player 1", cardsArray, 0, 4);
            Player player2 = createPlayer("Player 2", cardsArray, 5, 9);
            System.out.println(player1);
            System.out.println(player2);
            evaluateAndPrintWinner(player1, player2);
        }
    }
    private static Player createPlayer(String name, String[] cardsArray, int start, int end){
            Hand hand = new Hand();
            for (int i = start; i <= end; i++){
                String cardString = cardsArray[i];
                Card card = parseCardFromString(cardString);
                hand.addCard(card);
            }
            return new Player(name, hand);
    }

    private static Card parseCardFromString(String cardString){
        String rankString = cardString.substring(0, cardString.length() - 1);
        char suitChar = cardString.charAt(cardString.length() - 1);
        String suitString = String.valueOf(suitChar);

        Card.Rank rank;
        if (rankString.equals("T")) {
            rank = Card.Rank.TEN;
        } else if (rankString.equals("K")) {
            rank = Card.Rank.KING;
        } else if (rankString.equals("A")) {
            rank = Card.Rank.ACE;
        } else if (rankString.equals("J")) {
            rank = Card.Rank.JACK;
        } else if (rankString.equals("Q")) {
            rank = Card.Rank.QUEEN;
        } else if (rankString.equals("2") || rankString.equals("3") || rankString.equals("4") ||
                rankString.equals("5") || rankString.equals("6") || rankString.equals("7") ||
                rankString.equals("8") || rankString.equals("9")) {
            rank = Card.Rank.values()[Integer.parseInt(rankString) - 2];
        } else {
            rank = Card.Rank.valueOf(rankString);
        }
        Card.Suit suit;
        switch (suitChar) {
            case 'H':
                suit = Card.Suit.HEARTS;
                break;
            case 'S':
                suit = Card.Suit.SPADES;
                break;
            case 'C':
                suit = Card.Suit.CLUBS;
                break;
            case 'D':
                suit = Card.Suit.DIAMONDS;
                break;
            default:
                throw new IllegalArgumentException("Invalid suit character: " + suitChar);
        }

        return new Card(rank, suit);
    }

    private static void evaluateAndPrintWinner(Player player1, Player player2){
        Hand hand1 = player1.getHand();
        Hand hand2 = player2.getHand();
        int result = hand1.compareTo(hand2);

        if (result > 0){
            System.out.println(player1.getName() + "wins!");
        } else if (result < 0){
            System.out.println(player2.getName() + "wins");
        } else {
            System.out.println("It's a tie!");
        }
    }
}