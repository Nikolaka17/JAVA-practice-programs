public class Tile {
    private int x;
    private int y;
    private Piece currentPiece;
    private ChessBoard b;

    public Tile(ChessBoard b, Piece p, int x, int y){
        this.b = b;
        currentPiece = p;
        this.x = x;
        this.y = y;
    }

    public Piece pop(){
        Piece p = currentPiece;
        currentPiece = null;
        return p;
    }

    public void put(Piece p){
        currentPiece = p;
        p.setPos(this);
    }

    public void capture(Piece p){
        Piece p2 = getPiece();
        if(p2.getColor() == 1){
            b.wPieces.remove(p2);
        }
        if(p2.getColor() == 2){
            b.bPieces.remove(p2);
        }
        currentPiece = p;
    }

    public void promote(){
        currentPiece = new Queen(currentPiece.getColor(), this);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Piece getPiece(){
        return currentPiece;
    }

    @Override
    public boolean equals(Object o){
        return x == ((Tile) o).getX() && y == ((Tile) o).getY();
    }
}
