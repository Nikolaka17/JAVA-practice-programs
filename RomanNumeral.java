import java.util.HashMap;

public class RomanNumeral {
    private int value;
    public final static RomanNumeral MIN_NUMERAL = new RomanNumeral();
    public final static RomanNumeral MAX_NUMERAL = new RomanNumeral(4000);

    public RomanNumeral(){
        this(1);
    }

    public RomanNumeral(int v)throws IllegalArgumentException{
        if(v < 1 || v > 4000){
            throw new IllegalArgumentException("Can only store values between 1 and 4000");
        }
        value = v;
    }

    public RomanNumeral(String v)throws NumberFormatException{
        value = toInt(v); 
    }

    private int toInt(String s)throws NumberFormatException{
        HashMap<Character, Integer> conversion = new HashMap<Character, Integer>();
        conversion.put('I', 5);
        conversion.put('V', 5);
        conversion.put('X', 10);
        conversion.put('L', 50);
        conversion.put('C', 100);
        conversion.put('D', 500);
        conversion.put('M', 1000);
        int total = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(i != s.length() - 1){
                if(conversion.get(Character.toUpperCase(s.charAt(i))) < conversion.get(Character.toUpperCase(s.charAt(i)))){
                    total -= conversion.get(Character.toUpperCase(s.charAt(i)));
                }else{
                    total += conversion.get(Character.toUpperCase(s.charAt(i)));
                }
            }else{
                total += conversion.get(Character.toUpperCase(s.charAt(i)));
            }
        }
        if(!(new RomanNumeral(total)).toString().equals(s.toUpperCase())){
            throw new NumberFormatException("Invalid roman numeral");
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int curValue = value;
        do{
            if(curValue >= 1000){
                result = result.append("M");
                curValue -= 1000;
            }else if(curValue >= 900){
                result = result.append("CM");
                curValue -= 900;
            }else if(curValue >= 500){
                result = result.append("D");
                curValue -= 500;
            }else if(curValue >= 400){
                result = result.append("CD");
                curValue -= 400;
            }else if(curValue >= 100){
                result = result.append("C");
                curValue -= 100;
            }else if(curValue >= 90){
                result = result.append("XC");
                curValue -= 90;
            }else if(curValue >= 50){
                result = result.append("L");
                curValue -= 50;
            }else if(curValue >= 40){
                result = result.append("XL");
                curValue -= 40;
            }else if(curValue >= 10){
                result = result.append("X");
                curValue -= 10;
            }else if(curValue >= 9){
                result = result.append("IX");
                curValue -= 9;
            }else if(curValue >= 5){
                result = result.append("V");
                curValue -= 5;
            }else if(curValue >= 4){
                result = result.append("IV");
                curValue -= 4;
            }else if(curValue >= 1){
                result = result.append("I");
                curValue--;
            }
        }while(curValue > 0);
        return result.toString();
    }
}
