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

        int player1Wins = 0;
        int player2Wins = 0;

        for (String line : lines){
            String[] cardsArray = line.split(" ");

            Player player1 = createPlayer("Player 1", cardsArray, 0, 4);
            Player player2 = createPlayer("Player 2", cardsArray, 5, 9);

            System.out.println(player1);
            System.out.println(player2);

            int result = evaluateAndPrintWinner(player1, player2);

            if (result > 0){
                System.out.println("\u001B[32m" + player1.getName() + " wins!\u001B[0m");
                player1Wins++;
            } else if (result < 0){
                System.out.println("\u001B[34m" + player2.getName() + " wins!\u001B[0m");
                player2Wins++;
            } else {
                System.out.println("It's a tie!");
            }
            System.out.println();
        }
        System.out.println("\u001B[33m\u001B[1mTotal Player 1 wins: " + player1Wins + "\u001B[0m"); // Yellow color, bold
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

    public static Card parseCardFromString(String cardString) {
        String rankString = cardString.substring(0, cardString.length() - 1);
        char suitChar = cardString.charAt(cardString.length() - 1);

        Card.Rank rank;
        switch (rankString) {
            case "T":
                rank = Card.Rank.TEN;
                break;
            case "K":
                rank = Card.Rank.KING;
                break;
            case "A":
                rank = Card.Rank.ACE;
                break;
            case "J":
                rank = Card.Rank.JACK;
                break;
            case "Q":
                rank = Card.Rank.QUEEN;
                break;
            default:
                try {
                    int rankValue = Integer.parseInt(rankString);
                    if (rankValue >= 2 && rankValue <= 9) {
                        rank = Card.Rank.values()[rankValue - 2];
                    } else {
                        throw new IllegalArgumentException("Invalid rank: " + rankString);
                    }
                } catch (NumberFormatException ignored) {
                    throw new IllegalArgumentException("Invalid rank: " + rankString);
                }
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

    static int evaluateAndPrintWinner(Player player1, Player player2){
        Hand hand1 = player1.getHand();
        Hand hand2 = player2.getHand();
        int result = hand1.compareTo(hand2);

        return result;
    }
}