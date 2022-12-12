import javax.swing.ImageIcon;
import java.util.ArrayList;

public class CardDriver {
    
    public static void main(String[] args){
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card());
        //cards.add(new Card(Card.Suit.DIAMOND, "1"));
        cards.add(new Card(Card.Suit.SPADE, "A"));
        cards.add(new Card(Card.Suit.CLUB, "3", new ImageIcon(), new ImageIcon()));

        for(int i = 0; i < cards.size(); i++){
            System.out.println("C"+(i+1)+" has a suit of: " + cards.get(i).getSuit());
            System.out.println("C"+(i+1)+" has a rank of: " + cards.get(i).getRank());
            System.out.println("C"+(i+1)+" has a back of: " + cards.get(i).getBack());
            System.out.println("C"+(i+1)+" has a front of: "+ cards.get(i).getFront());
        }
    }
}
