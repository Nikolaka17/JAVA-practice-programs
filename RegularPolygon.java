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

    public void setNumSides(int n)throws IllegalArgumentException{
        if(n < 3){
            throw new IllegalArgumentException("There must be at least 3 sides");
        }
        numSides = n;
    }

    public void setLength(int l)throws IllegalArgumentException{
        if(!(l > 0)){
            throw new IllegalArgumentException("Side length must be greater than 0");
        }
        length = l;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getNumSides(){
        return numSides;
    }

    public int getLength(){
        return length;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getPerimeter(){
        return numSides * length;
    }

    public double getArea(){
        return (double)(numSides * length * length) / (4 * Math.tan(Math.PI / numSides)); 
    }

    public double getCentralAngle(){
        return (double) 360 / numSides;
    }
}
