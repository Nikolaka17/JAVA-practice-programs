public class F91Algorithm {
    public static void main(String[] args){
    }

    public static int f91(int n){
        if(n > 100){
            return n - 10;
        }
        return f91(f91(n+11));
    }
}
