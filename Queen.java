import java.util.ArrayList;

public class Queen extends Piece{
    
    public Queen(int c, Tile p){
        super(c, p);
    }

    @Override
    public ArrayList<Tile> generateMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();
        result.addAll(this.generateDiagonalMoves(b));
        result.addAll(this.generateLinearMoves(b));
        return result;
    }
}
