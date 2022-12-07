public class RegularPolygon {
    private int numSides;
    private int length;
    private int x;
    private int y;

    public RegularPolygon(){
        this(3, 1, 0, 0);
    }

    public RegularPolygon(int n, int l)throws IllegalArgumentException{
        this(n, l, 0, 0);
    }

    public RegularPolygon(int n, int l, int x, int y)throws IllegalArgumentException{
        if(n < 3){
            throw new IllegalArgumentException("There must be at least 3 sides");
        }
        if(!(l > 0)){
            throw new IllegalArgumentException("Side length must be greater than 0");
        }
        numSides = n;
        length = l;
        this.x = x;
        this.y = y;
    }
}
