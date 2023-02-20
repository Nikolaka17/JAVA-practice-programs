import java.util.ArrayList;

public class Rook extends Piece{
    private boolean moved = false;

    public Rook(int c, Tile p){
        super(c, p);
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
        return this.generateLinearMoves(b);
    }
}
