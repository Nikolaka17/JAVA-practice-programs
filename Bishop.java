import java.util.ArrayList;

public class Bishop extends Piece{
    
    public Bishop(int c, Tile p){
        super(c, p);
    }

    @Override
    public ArrayList<Tile> generateMoves(ChessBoard b){
        return this.generateDiagonalMoves(b);
    }
}
