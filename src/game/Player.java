package game;

public class Player {
    private final String name;
    private final Hand hand;

    public Player(String name, Hand hand){
        this.name = name;
        this.hand = hand;
    }

    public String getName(){
        return name;
    }

    public Hand getHand() {
        return hand;
    }
    @Override
    public String toString(){
        return name + "'s hand" + hand.getCards();
    }
}
