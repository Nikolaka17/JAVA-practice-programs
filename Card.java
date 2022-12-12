import javax.swing.ImageIcon;

public class Card {
    public static enum Suit{
        HEART,
        CLUB,
        SPADE,
        DIAMOND,
        NONE
    }

    private Suit suit;
    private String rank;
    private ImageIcon back;
    private ImageIcon front;

    private static final String[] ALLOWED_RANKS = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "Joker"};
    
    public Card(){
        this(Suit.HEART, "A", null, null);
    }

    public Card(Suit s, String r)throws IllegalArgumentException{
        this(s, r, null, null);
    }

    public Card(Suit s, String r, ImageIcon b, ImageIcon f)throws IllegalArgumentException{
        if(r.equals("Joker") && !(s == Suit.NONE)){
            throw new IllegalArgumentException("Joker card must be of suit NONE");
        }
        if(!r.equals("Joker") && s == Suit.NONE){
            throw new IllegalArgumentException("Joker is the only rank that can be of suit none");
        }
        if(isValidRank(r)){
            throw new IllegalArgumentException("Invalid rank. Valid ranks are 2-10, J, Q, K, A, Joker");
        }
        suit = s;
        rank = r;
        back = b;
        front = f;
    }

    private boolean isValidRank(String r){
        for(String s: ALLOWED_RANKS){
            if(s.equals(r)){
                return true;
            }
        }
        return false;
    }

    public Suit getSuit(){
        return suit;
    }

    public String getRank(){
        return rank;
    }

    public ImageIcon getFront(){
        return front;
    }

    public ImageIcon getBack(){
        return back;
    }
}
