import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Random;

public class CardDriver {
    
    public static void main(String[] args){
        Random rng = new Random();
        String[] validRanks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "Joker"};
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card());
        //cards.add(new Card(Card.Suit.DIAMOND, "1"));
        cards.add(new Card(Card.Suit.SPADE, "A"));
        cards.add(new Card(Card.Suit.CLUB, "3", new ImageIcon(), new ImageIcon()));
        cards.add(new Card(Card.Suit.CLUB, "3"));

        System.out.println("C1 == C2: "+ cards.get(1).equals(cards.get(0)));
        System.out.println("C3 == C4: "+ cards.get(2).equals(cards.get(3)));

        for(int i = 0; i < cards.size(); i++){
            System.out.println("C"+(i+1)+" has a suit of: " + cards.get(i).getSuit());
            System.out.println("C"+(i+1)+" has a rank of: " + cards.get(i).getRank());
            System.out.println("C"+(i+1)+" has a back of: " + cards.get(i).getBack());
            System.out.println("C"+(i+1)+" has a front of: "+ cards.get(i).getFront());
        }

        for(int i = 0; i < cards.size(); i++){
            System.out.println("C"+(i+1)+ " has a value of: " + cards.get(i).valueOf());
            System.out.println("C"+(i+1)+ " has a rummy value of: "+cards.get(i).valueOf("RUMMY"));
        }

        for(int i = 0; i < cards.size(); i++){
            int selectedSuit = rng.nextInt(4);
            switch(selectedSuit){
                case 0:
                    cards.get(i).setSuit(Card.Suit.HEART);
                    break;
                case 1:
                    cards.get(i).setSuit(Card.Suit.CLUB);
                    break;
                case 2:
                    cards.get(i).setSuit(Card.Suit.SPADE);
                    break;
                case 3:
                    cards.get(i).setSuit(Card.Suit.DIAMOND);
                    break;
            }
            cards.get(i).setRank(validRanks[rng.nextInt(13)]);
            cards.get(i).setBack(null);
            cards.get(i).setFront(null);
            System.out.println("C"+(i+1)+" has been mutated");
        }

        for(int i = 0; i < cards.size(); i++){
            System.out.println("C"+(i+1)+": "+cards.get(i));
        }
    }
}
