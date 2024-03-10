import game.Card;
import game.Hand;
import game.Player;
import org.junit.Test;

public class PokerGameTest {

    @Test
    public void testEvaluateAndPrintWinner_HighCard() {
        Player player1 = createPlayer("Player 1", new String[]{"5H", "5C", "6S", "7S", "KD"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"2C", "3S", "8S", "8D", "TD"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }
    @Test
    public void testEvaluateAndPrintWinner_OnePair() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "2S", "6D", "8C", "AH"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "3S", "7D", "9C", "KH"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }
    @Test
    public void testEvaluateAndPrintWinner_TwoPairs() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "2S", "4D", "4C", "AH"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "3S", "5D", "5C", "KH"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    @Test
    public void testEvaluateAndPrintWinner_ThreeOfAKind() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "2S", "2D", "8C", "AH"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "3S", "3D", "9C", "KH"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    @Test
    public void testEvaluateAndPrintWinner_Straight() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "3S", "4D", "5C", "6H"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "4S", "5D", "6C", "7H"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
     }

    @Test
    public void testEvaluateAndPrintWinner_Flush() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "4H", "6H", "8H", "AH"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3S", "5S", "7S", "9S", "KS"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    @Test
    public void testEvaluateAndPrintWinner_FullHouse() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "2S", "2D", "8C", "8H"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "3S", "3D", "9C", "9H"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    @Test
    public void testEvaluateAndPrintWinner_FourOfAKind() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "2S", "2D", "2C", "AH"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3H", "3S", "3D", "3C", "KH"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    @Test
    public void testEvaluateAndPrintWinner_StraightFlush() {
        Player player1 = createPlayer("Player 1", new String[]{"2H", "3H", "4H", "5H", "6H"}, 0, 4);
        Player player2 = createPlayer("Player 2", new String[]{"3S", "4S", "5S", "6S", "7S"}, 0, 4);
        PokerGame.evaluateAndPrintWinner(player1, player2);
    }

    private Player createPlayer(String name, String[] cardsArray, int start, int end) {
        Hand hand = new Hand();
        for (int i = start; i <= end; i++) {
            String cardString = cardsArray[i];
            Card card = PokerGame.parseCardFromString(cardString);
            hand.addCard(card);
        }
        return new Player(name, hand);
    }
}
