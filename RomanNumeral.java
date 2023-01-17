/**
 * Class that is able to store a roman numeral
 */
public class RomanNumeral implements Comparable{
    private int value;
    /**
     * A roman numeral with the value of 1. The lowest value storable in a roman numeral
     */
    public final static RomanNumeral MIN_NUMERAL = new RomanNumeral();
    /**
     * A roman numeral with the value of 4000. The highest value storable in a roman numeral
     */
    public final static RomanNumeral MAX_NUMERAL = new RomanNumeral(4000);

    /**
     * Creates a roman numeral with a value of 1
     */
    public RomanNumeral(){
        this(1);
    }

    /**
     * Creates a roman numeral with a user defined value
     * @param v The integer value to create a roman numeral of
     * @throws IllegalArgumentException If the given value is less than 1 or greater than 4000
     */
    public RomanNumeral(int v)throws IllegalArgumentException{
        if(v < 1 || v > 4000){
            throw new IllegalArgumentException("Can only store values between 1 and 4000");
        }
        value = v;
    }

    /**
     * Creates a roman numeral with a user defined value
     * @param v The string representation of the value to store in the roman numeral
     * @throws NumberFormatException Thrown if the value given isn't a properly formatted roman numeral
     * @throws IllegalArgumentException Thrown if string represents a value less than 1 or greater than 4000
     */
    public RomanNumeral(String v)throws NumberFormatException, IllegalArgumentException{
        this(toInt(v));
    }

    /**
     * Mutator for the value
     * @param v The integer value to change to
     * @throws IllegalArgumentException If the given value is less than 1 or greater than 4000
     */
    public void setValue(int v)throws IllegalArgumentException{
        if(v < 1 || v > 4000){
            throw new IllegalArgumentException("Can only store values between 1 and 4000");
        }
        value = v;
    }

    /**
     * Mutator for the value
     * @param v The string representation of a value to change to
     * @throws NumberFormatException Thrown if the value given isn't a properly formatted roman numeral
     * @throws IllegalArgumentException Thrown if string represents a value less than 1 or greater than 4000
     */
    public void setValue(String v)throws NumberFormatException, IllegalArgumentException{
        value = toInt(v);
    }

    /**
     * Accessor for the value
     * @return The value stored by the roman numeral
     */
    public int getValue(){
        return value;
    }

    /**
     * Adds two roman numerals
     * @param n The roman numeral to add with
     * @return A roman numeral representing the sum of the two roman numerals
     * @throws ArithmeticException Thrown if the resulting value is greater than 4000
     */
    public RomanNumeral add(RomanNumeral n)throws ArithmeticException{
        if(value + n.value > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral(value + n.value);
    }

    /**
     * Subtracts two roman numerals
     * @param n The roman numeral to subtract with
     * @return A roman numeral representing the difference of the two roman numerals
     * @throws ArithmeticException Thrown if the resulting value is less than 1
     */
    public RomanNumeral subtract(RomanNumeral n)throws ArithmeticException{
        if(value - n.value < 1){
            throw new ArithmeticException("Result is smaller than what can be stored");
        }
        return new RomanNumeral(value + n.value);
    }

    /**
     * Multiplies two roman numerals
     * @param n The roman numeral to multiply with
     * @return A roman numeral representing the product of the two roman numerals
     * @throws ArithmeticException Thrown if the resulting value is greater than 4000
     */
    public RomanNumeral multiply(RomanNumeral n)throws ArithmeticException{
        if(value * n.value > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral(value * n.value);
    }

    /**
     * Divides two roman numerals
     * @param n The roman numeral to divide with
     * @return A roman numeral representing the quotient of the two roman numerals
     */
    public RomanNumeral divide(RomanNumeral n){
        return new RomanNumeral(value / n.value);
    }

    /**
     * Raises a roman numeral to a power
     * @param n The power to raise to
     * @return A roman numeral representing the roman numeral raised to a power
     * @throws ArithmeticException Thrown if the resulting value is greater than 4000
     */
    public RomanNumeral pow(int n)throws ArithmeticException{
        if(Math.pow(value, n) > 4000){
            throw new ArithmeticException("Result is larger than what can be stored");
        }
        return new RomanNumeral((int) Math.pow(value, n));
    }

    /**
     * Takes a roman numeral mod a number
     * @param n The number to mod to
     * @return The value of the roman numeral mod a number
     */
    public int mod(int n){
        return value % n;
    }

    /**
     * Converts a roman numeral string to an integer
     * @param s The string to convert
     * @return The integer value of the string
     * @throws NumberFormatException Thrown if the given string isn't a properly formatted roman numeral
     * @throws IllegalArgumentException Thrown if the strings value is less than 1 or greater than 4000
     */
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

    /**
     * Converts a character to it's numerical counterpart
     * @param c The char to convert
     * @return The numerical representation of the character
     * @throws NumberFormatException Thrown if the character isn't used in roman numerals
     */
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

    /**
     * Overriden toString method, converts the value of the numeral to a string representation
     * @return A string representation of the roman numeral
     */
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

    /**
     * Overriden equals method, tests if the values of two roman numerals are equal
     * @param o The roman numeral to compare to
     * @return A boolean representing if the values are equal
     */
    @Override
    public boolean equals(Object o){
        return value == ((RomanNumeral) o).value;
    }

    /**
     * Overriden compareTo method, compares the value of two roman numerals
     * @param o The roman numeral to compare to
     * @return -1 if value is less than given numeral's, 0 if value is equal to given numeral's, 1 if value is greater than given numeral's
     */
    @Override
    public int compareTo(Object o){
        if(value < ((RomanNumeral) o).value){
            return -1;
        }else if(value > ((RomanNumeral) o).value){
            return 1;
        }
        return 0;
    }
}
