import javax.swing.ImageIcon;
import java.util.ArrayList;

public class CardDriver {
    
    public static void main(String[] args){
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card());
        //cards.add(new Card(Card.Suit.DIAMOND, "1"));
        cards.add(new Card(Card.Suit.SPADE, "A"));
        cards.add(new Card(Card.Suit.CLUB, "3", new ImageIcon(), new ImageIcon()));
    }
}
