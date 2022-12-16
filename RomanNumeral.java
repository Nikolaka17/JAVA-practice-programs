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

    public RomanNumeral(String v)throws NumberFormatException, IllegalArgumentException{
        value = toInt(v); 
    }

    public void setValue(int v)throws IllegalArgumentException{
        if(v < 1 || v > 4000){
            throw new IllegalArgumentException("Can only store values between 1 and 4000");
        }
        value = v;
    }

    public void setValue(String v)throws NumberFormatException, IllegalArgumentException{
        value = toInt(v);
    }

    public int getValue(){
        return value;
    }

    public RomanNumeral add(RomanNumeral n)throws ArithmeticException{
        if(value + n.value > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral(value + n.value);
    }

    public RomanNumeral subtract(RomanNumeral n)throws ArithmeticException{
        if(value - n.value < 1){
            throw new ArithmeticException("Result is smaller than what can be stored");
        }
        return new RomanNumeral(value + n.value);
    }

    public RomanNumeral multiply(RomanNumeral n)throws ArithmeticException{
        if(value * n.value > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral(value * n.value);
    }

    public RomanNumeral divide(RomanNumeral n){
        return new RomanNumeral(value / n.value);
    }

    public RomanNumeral pow(int n)throws ArithmeticException{
        if(Math.pow(value, n) > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral((int) Math.pow(value, n));
    }

    public int mod(int n){
        return value % n;
    }

    private int toInt(String s)throws NumberFormatException, IllegalArgumentException{
        int total = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(i != s.length() - 1){
                if(valueOf(s.charAt(i)) < valueOf(s.charAt(i+1))){
                    total -= valueOf(s.charAt(i));
                }else{
                    total += valueOf(s.charAt(i));
                }
            }else{
                total += valueOf(s.charAt(i));
            }
        }
        if(!(new RomanNumeral(total)).toString().equals(s.toUpperCase())){
            throw new NumberFormatException("Invalid roman numeral");
        }
        if(total < 1 || total > 4000){
            throw new IllegalArgumentException("Can only store values between 1 and 4000");
        }
        return total;
    }

    private int valueOf(char c)throws NumberFormatException{
        switch(Character.toUpperCase(c)){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new NumberFormatException("Invalid roman numeral");
        }
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

    @Override
    public boolean equals(Object o){
        return value == ((RomanNumeral) o).value;
    }
}
