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
        if(!isValidRank(r)){
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

    public void setSuit(Suit s)throws IllegalArgumentException{
        if(s == Suit.NONE && !rank.equals("Joker")){
            throw new IllegalArgumentException("Joker is the only card that can be suit NONE, to set suit to none change the rank to joker");
        }
        suit = s;
    }

    public void setRank(String r)throws IllegalArgumentException{
        if(!isValidRank(r)){
            throw new IllegalArgumentException("Invalid rank. Valid ranks are 2-10, J, Q, K, A, Joker");
        }
        if(r.equals("Joker")){
            suit = Suit.NONE;
        }
        rank = r;
    }

    public void setBack(ImageIcon b){
        back = b;
    }

    public void setFront(ImageIcon f){
        front = f;
    }

    public int valueOf(){
        switch(rank){
            case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "10":
                return Integer.parseInt(rank);
            case "J": case "Q": case "K":
                return 10;
            case "A":
                return 11;
            default:
                return 0;
        }
    }

    public int valueOf(String m){
        if(m.equals("RUMMY")){
            switch(rank){
                case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
                    return 5;
                case "10": case "J": case "Q": case "K":
                    return 10;
                case "A":
                    return 15;
                default:
                    return 0;
            }
        }
        return valueOf();
    }

    @Override
    public boolean equals(Object o){
        return suit == ((Card) o).suit && rank.equals(((Card) o).rank);
    }
}
