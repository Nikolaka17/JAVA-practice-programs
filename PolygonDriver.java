import java.util.ArrayList;
import java.util.Random;

public class PolygonDriver {
    public static void main(String[] args){
        Random rng = new Random();
        ArrayList<RegularPolygon> polygons = new ArrayList<RegularPolygon>();
        polygons.add(new RegularPolygon());
        //polygons.add(new RegularPolygon(2, 3));
        //polygons.add(new RegularPolygon(6, 0));
        polygons.add(new RegularPolygon(5, 3));
        polygons.add(new RegularPolygon(4, 4, 3, -1));
        for(int i = 0; i < 7; i++){
            polygons.add(new RegularPolygon(rng.nextInt(5)+3, rng.nextInt(20)+1, rng.nextInt(20)-10, rng.nextInt(20)-10));
        }

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
