/**
 * Class representation of a regular polygon
 */
public class RegularPolygon {
    private int numSides;
    private int length;
    private int x;
    private int y;

    /**
     * Default constructor, creates a triangle with sides of length 1 centered at (0, 0)
     */
    public RegularPolygon(){
        this(3, 1, 0, 0);
    }

    /**
     * Constructor that takes a number of sides and the length of those sides, defaults the center to (0, 0)
     * @param n The number of sides for the polygon to have
     * @param l The length of each side
     * @throws IllegalArgumentException Thrown if the number of sides is less than 3
     * @throws IllegalArgumentException Thrown if the length is less than 1
     */
    public RegularPolygon(int n, int l)throws IllegalArgumentException{
        this(n, l, 0, 0);
    }

    /**
     * Constructor that takes the number of sides and length of the sides along with an x and y coordinate
     * @param n The number of sides for the polygon to have
     * @param l The length of each side
     * @param x The x coordinate of the center of the polygon
     * @param y The y coordinate of the center of the polygon
     * @throws IllegalArgumentException Thrown if the number of sides is less than 3
     * @throws IllegalArgumentException Thrown if the length is less than 1
     */
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

    /**
     * Mutator for the instance variable numSides
     * @param n The new value to set numSides to
     * @throws IllegalArgumentException Thrown if given value is less than 3
     */
    public void setNumSides(int n)throws IllegalArgumentException{
        if(n < 3){
            throw new IllegalArgumentException("There must be at least 3 sides");
        }
        numSides = n;
    }

    /**
     * Mutator for the instance variable length
     * @param l The new value to set length to
     * @throws IllegalArgumentException Thrown if given value is less than 1
     */
    public void setLength(int l)throws IllegalArgumentException{
        if(!(l > 0)){
            throw new IllegalArgumentException("Side length must be greater than 0");
        }
        length = l;
    }

    /**
     * Mutator for the instance variable x
     * @param x The new value to set x to
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Mutator for the instance variable y
     * @param y The new value to set y to
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Accessor for the instance variable numSides
     * @return The value stored in numSides
     */
    public int getNumSides(){
        return numSides;
    }

    /**
     * Accessor for the instance variable length
     * @return The value stored in length
     */
    public int getLength(){
        return length;
    }

    /**
     * Accessor for the instance variable x
     * @return The value stored in x
     */
    public int getX(){
        return x;
    }

    /**
     * Accessor for the instance variable y
     * @return The value stored in y
     */
    public int getY(){
        return y;
    }

    /**
     * Calculates the perimeter of the polygon
     * @return The integer representation of the perimeter of the polygon
     */
    public int getPerimeter(){
        return numSides * length;
    }

    /**
     * Calculates the area of the polygon
     * @return The double representation of the area of the polygon
     */
    public double getArea(){
        return (double)(numSides * length * length) / (4 * Math.tan(Math.PI / numSides)); 
    }

    /**
     * Calculates the central angle of the polygon
     * @return The double representation of the central angle of the polygon
     */
    public double getCentralAngle(){
        return (double) 360 / numSides;
    }

    /**
     * Tests if the polygon is equal to the given object
     * @param o The polygon to test to
     * @return A boolean representing if the polygons are equal
     */
    @Override
    public boolean equals(Object o){
        return numSides == ((RegularPolygon) o).numSides && length == ((RegularPolygon) o).length;
    }
}
