import java.util.ArrayList;

public class King extends Piece{
    private boolean moved = false;
    
    public King(int c, Tile p){
        super(c, p, true);
    }

    public boolean wasMoved(){
        return moved;
    }

    @Override
    public boolean move(Tile t){
        boolean b = super.move(t);
        moved = true;
        return b;
    }

    @Override
    public ArrayList<Tile> generateMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();
        int[][] offsets = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
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
