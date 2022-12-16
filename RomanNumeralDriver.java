import java.util.ArrayList;
import java.util.Random;

public class RomanNumeralDriver {
    
    public static void main(String[] args){
        Random rng = new Random();
        ArrayList<RomanNumeral> numerals = new ArrayList<RomanNumeral>();
        numerals.add(new RomanNumeral());
        numerals.add(new RomanNumeral(632));
        //numerals.add(new RomanNumeral(0));
        //numerals.add(new RomanNumeral(10000));
        //numerals.add(new RomanNumeral("IIII"));
        numerals.add(new RomanNumeral("LXVI"));
        numerals.add(new RomanNumeral("CDIX"));
        numerals.add(RomanNumeral.MIN_NUMERAL);
        numerals.add(RomanNumeral.MAX_NUMERAL);

        //Equals tests
        System.out.println("C3 == C4: "+numerals.get(2).equals(numerals.get(3)));
        System.out.println("C1 == C5: "+numerals.get(0).equals(numerals.get(4)));

        //Accessor tests
        for(int i = 0; i < numerals.size(); i++){
            System.out.println("N"+(i+1)+" has a value of: " + numerals.get(i).getValue());
        }

        //Mutator tests
        numerals.get(1).setValue("IX");
        for(int i = 0; i < numerals.size(); i++){
            numerals.get(i).setValue(rng.nextInt(4000)+1);
            System.out.println("N"+(i+1)+" has been mutated");
        }
    }
}
