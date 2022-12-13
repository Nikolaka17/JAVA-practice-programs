import javax.swing.ImageIcon;

/**
 * Class that represents a playing card
 */
public class Card {
    /**
     * Suits that a card can be
     * {@link #HEART}
     * {@link #CLUB}
     * {@link #SPADE}
     * {@link #DIAMOND}
     * {@link #NONE}
     */
    public static enum Suit{
        /**
         * A representation of the hearts suit
         */
        HEART,
        /**
         * A representation of the clubs suit
         */
        CLUB,
        /**
         * A representation of the spades suit
         */
        SPADE,
        /**
         * A represenation fo the diamonds suit
         */
        DIAMOND,
        /**
         * A value for jokers, a card that has no suit
         */
        NONE
    }

    private Suit suit;
    private String rank;
    private ImageIcon back;
    private ImageIcon front;

    private static final String[] ALLOWED_RANKS = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "Joker"};
    
    /**
     * Default constructor, creates an ace of hearts
     */
    public Card(){
        this(Suit.HEART, "A", null, null);
    }

    /**
     * Constructor that creates a specified card without graphics
     * @param s The suit of the card to create
     * @param r The rank of the card to create
     * @throws IllegalArgumentException Thrown if joker and a suit other than none is given
     * @throws IllegalArgumentException Thrown if the none suit is given for a card other than joker
     * @throws IllegalArgumentException Thrown if the rank given isn't a valid card type
     */
    public Card(Suit s, String r)throws IllegalArgumentException{
        this(s, r, null, null);
    }

    /**
     * Constructor that creates a specified number card
     * @param s The suit of the card to create
     * @param r The number of the card to create
     * @throws IllegalArgumentException Thrown if joker and a suit other than none is given
     * @throws IllegalArgumentException Thrown if the none suit is given for a card other than joker
     * @throws IllegalArgumentException Thrown if the rank given isn't between 2 and 10
     */
    public Card(Suit s, int r)throws IllegalArgumentException{
        this(s, Integer.toString(r), null, null);
    }

    /**
     * Constructor that creates a specified card with graphics
     * @param s The suit of the card to create
     * @param r The rank of the card to create
     * @param b The back graphic for the card
     * @param f The front graphic for the card
     * @throws IllegalArgumentException Thrown if joker and a suit other than none is given
     * @throws IllegalArgumentException Thrown if the none suit is given for a card other than joker
     * @throws IllegalArgumentException Thrown if the rank given isn't a valid card type
     */
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
        if(rank.equals("Joker")){
            rank = r;
        }else{
            rank = r.toUpperCase();
        }
        suit = s;
        back = b;
        front = f;
    }

    /**
     * Tests if rank given is valid
     * @param r The rank to test
     * @return A boolean representing if the rank is valid
     */
    private boolean isValidRank(String r){
        for(String s: ALLOWED_RANKS){
            if(s.equals(r)){
                return true;
            }
        }
        return false;
    }

    /**
     * Accessor for the card's suit
     * @return The suit of the card
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * Accessor for the card's rank
     * @return The rank of the card
     */
    public String getRank(){
        return rank;
    }

    /**
     * Accessor for the card's front graphic
     * @return The front graphic of the card
     */
    public ImageIcon getFront(){
        return front;
    }

    /**
     * Accessor for the card's back graphic
     * @return The back graphic of the card
     */
    public ImageIcon getBack(){
        return back;
    }

    /**
     * Mutator for the card's suit
     * @param s Suit to change to
     * @throws IllegalArgumentException Thrown if suit is changed to NONE without the card being joker
     */
    public void setSuit(Suit s)throws IllegalArgumentException{
        if(s == Suit.NONE && !rank.equals("Joker")){
            throw new IllegalArgumentException("Joker is the only card that can be suit NONE, to set suit to none change the rank to joker");
        }
        suit = s;
    }

    /**
     * Mutator for the card's rank
     * @param r The rank to change to
     * @throws IllegalArgumentException Thrown if rank given is invalid
     */
    public void setRank(String r)throws IllegalArgumentException{
        if(r.equals("Joker")){
            suit = Suit.NONE;
        }else if(!isValidRank(r.toUpperCase())){
            throw new IllegalArgumentException("Invalid rank. Valid ranks are 2-10, J, Q, K, A, Joker");
        }
        rank = r.toUpperCase();
    }

    /**
     * Mutator for the card's back graphic
     * @param b The image to change to
     */
    public void setBack(ImageIcon b){
        back = b;
    }

    /**
     * Mutator for the card's front graphic
     * @param f The image to change to
     */
    public void setFront(ImageIcon f){
        front = f;
    }

    /**
     * Method to find the default value of the card
     * @return The numerical value of the card
     */
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

    /**
     * Method to find the value of the card through different modes
     * @param m The mode of calculation to be used
     * @return The numerical value of the card
     */
    public int valueOf(String m){
        if(m.toUpperCase().equals("RUMMY")){
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

    /**
     * Overriden method to tell if cards are equal
     * @param o The card to compare to
     * @return A boolean representing if the suits and ranks of the cards are the same
     */
    @Override
    public boolean equals(Object o){
        return suit == ((Card) o).suit && rank.equals(((Card) o).rank);
    }

    /**
     * Overriden method to create a string representation of the card
     * @return A string saying the suit and rank of the card
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        switch(rank){
            case "Joker":
                return "Joker";
            case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "10":
                result = result.append(rank);
                break;
            case "J":
                result = result.append("Jack");
                break;
            case "Q":
                result = result.append("Queen");
                break;
            case "K":
                result = result.append("King");
                break;
            case "A":
                result = result.append("Ace");
                break;
        }
        result = result.append(" of ");
        switch(suit){
            case SPADE:
                result = result.append("spades");
                break;
            case CLUB:
                result = result.append("clubs");
                break;
            case DIAMOND:
                result = result.append("diamonds");
                break;
            case HEART:
                result =result.append("hearts");
                break;
            case NONE:
                break;
        }
        return result.toString();
    }
}
