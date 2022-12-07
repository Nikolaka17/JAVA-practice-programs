import java.util.ArrayList;
import java.util.Random;

public class PolygonDriver {
    public static void main(String[] args){
        Random rng = new Random();
        ArrayList<RegularPolygon> polygons = new ArrayList<RegularPolygon>();

        //Test constructors
        polygons.add(new RegularPolygon());
        //polygons.add(new RegularPolygon(2, 3));
        //polygons.add(new RegularPolygon(6, 0));
        polygons.add(new RegularPolygon(5, 3));
        polygons.add(new RegularPolygon(4, 4, 3, -1));
        polygons.add(new RegularPolygon(4, 4, 3, -1));
        for(int i = 0; i < 6; i++){
            polygons.add(new RegularPolygon(rng.nextInt(5)+3, rng.nextInt(20)+1, rng.nextInt(20)-10, rng.nextInt(20)-10));
        }

        //Test accessors
        for(int i = 0; i < polygons.size(); i++){
            System.out.println("P"+(i+1)+" number sides: "+polygons.get(i).getNumSides());
            System.out.println("P"+(i+1)+" side lengths: "+polygons.get(i).getLength());
            System.out.println("P"+(i+1)+" x: "+polygons.get(i).getX());
            System.out.println("P"+(i+1)+" y: "+polygons.get(i).getY());
        }

        //Test math functions
        for(int i = 0; i < polygons.size(); i++){
            System.out.println("P"+(i+1)+" perimeter: "+polygons.get(i).getPerimeter());
            System.out.println("P"+(i+1)+" area: "+polygons.get(i).getArea());
            System.out.println("P"+(i+1)+" angle: "+polygons.get(i).getCentralAngle());
        }

        //Test equals
        System.out.println("P1 == P2: " + polygons.get(0).equals(polygons.get(1)));
        System.out.println("P3 == P4: "+polygons.get(2).equals(polygons.get(3)));

        //Test mutators
        //polygons.get(0).setNumSides(1);
        //polygons.get(0).setLength(-4);
        for(int i = 0; i < polygons.size(); i++){
            polygons.get(i).setNumSides(rng.nextInt(5)+3);
            polygons.get(i).setLength(rng.nextInt(20)+1);
            polygons.get(i).setX(rng.nextInt(20)-10);
            polygons.get(i).setY(rng.nextInt(20)-10);
            System.out.println("P"+(i+1)+" has been mutated");
        }
    }
}
