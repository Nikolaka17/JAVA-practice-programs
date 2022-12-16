import java.util.ArrayList;
import java.util.Random;

public class RomanNumeralDriver {
    
    public static void main(String[] args){
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
    }
}
