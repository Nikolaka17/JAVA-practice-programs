import java.util.ArrayList;

public class Knight extends Piece{
    
    public Knight(int c, Tile p){
        super(c, p);
    }

    @Override
    public ArrayList<Tile> generateMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();
        int[][] offsets = new int[][]{{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-2, -1}, {-2, 1}};

        for(int[] offset: offsets){
            try{
                result.add(b.getBoard()[this.getPos().getY() + offset[1]][this.getPos().getX() + offset[0]]);
            }catch(IndexOutOfBoundsException e){
                continue;
            }
        }

        return result;
    }
}
