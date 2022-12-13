public class Deck {
    private static final String[] ALL_RANKS = new String[]{"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final Card.Suit[] ALL_SUITS = new Card.Suit[]{Card.Suit.HEART, Card.Suit.CLUB, Card.Suit.SPADE, Card.Suit.DIAMOND};

    private Card[] deckCards;

    public Deck(){
        this("REGULAR");
    }

    public Deck(Card[] cards){
        deckCards = cards;
    }

    public Deck(String type){
        int pos = 0;
        switch(type.toUpperCase()){
            case "PINOCHLE":
                deckCards = new Card[48];
                for(int i = 0; i < 6; i++){
                    for(Card.Suit s: ALL_SUITS){
                        deckCards[pos] = new Card(s, ALL_RANKS[i]);
                        pos++;
                        deckCards[pos] = new Card(s, ALL_RANKS[i]);
                        pos++;
                    }
                }
                break;
            case "STANDARD":
                deckCards = new Card[52];
                for(String r: ALL_RANKS){
                    for(Card.Suit s: ALL_SUITS){
                        deckCards[pos] = new Card(s, r);
                        pos++;
                    }
                }
                break;
            case "REGULAR": default:
                deckCards = new Card[54];
                deckCards[0] = new Card(Card.Suit.NONE, "Joker");
                deckCards[1] = new Card(Card.Suit.NONE, "Joker");
                pos = 2;
                for(String r: ALL_RANKS){
                    for(Card.Suit s: ALL_SUITS){
                        deckCards[pos] = new Card(s, r);
                        pos++;
                    }
                }
                break;
        }
    }
}
