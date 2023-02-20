import java.util.ArrayList;

public abstract class Piece {
    private int color;
    private Tile pos;
    private boolean isKing;

    public Piece(int c, Tile p){
        color = c;
        pos = p;
        isKing = false;
    }

    public Piece(int c, Tile p, boolean b){
        color = c;
        pos = p;
        isKing = b;
    }

    public boolean move(Tile t){
        Piece end = t.getPiece();
        if(end != null){
            if(end.getColor() == color){
                return false;
            }
            t.capture(this);
        }
        pos.pop();
        pos = t;
        pos.put(this);
        return true;
    }

    public void setPos(Tile t){
        pos = t;
    }

    public int getColor(){
        return color;
    }

    public Tile getPos(){
        return pos;
    }

    public boolean isAKing(){
        return isKing;
    }

    public ArrayList<Tile> generateDiagonalMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();
        //NW (-1, -1)
        int currX = pos.getX() - 1;
        int currY = pos.getY() - 1;
        while(currY >= 0 && currX >= 0){
            if(b.getBoard()[currY][currX] == null){
                result.add(b.getBoard()[currY][currX]);
            }else if(b.getBoard()[currY][currX].getPiece().getColor() != color){
                result.add(b.getBoard()[currY][currX]);
                break;
            }else{
                break;
            }
            currX--;
            currY--;
        }
        //NE (+1, -1)
        currX = pos.getX() + 1;
        currY = pos.getY() - 1;
        while(currY >= 0 && currX < 8){
            if(b.getBoard()[currY][currX] == null){
                result.add(b.getBoard()[currY][currX]);
            }else if(b.getBoard()[currY][currX].getPiece().getColor() != color){
                result.add(b.getBoard()[currY][currX]);
                break;
            }else{
                break;
            }
            currX++;
            currY--;
        }
        //SE (+1, +1)
        currX = pos.getX() + 1;
        currY = pos.getY() + 1;
        while(currY < 8 && currX < 8){
            if(b.getBoard()[currY][currX] == null){
                result.add(b.getBoard()[currY][currX]);
            }else if(b.getBoard()[currY][currX].getPiece().getColor() != color){
                result.add(b.getBoard()[currY][currX]);
                break;
            }else{
                break;
            }
            currX++;
            currY++;
        }
        //SW (-1, +1)
        currX = pos.getX() - 1;
        currY = pos.getY() + 1;
        while(currX >= 0 && currY < 8){
            if(b.getBoard()[currY][currX] == null){
                result.add(b.getBoard()[currY][currX]);
            }else if(b.getBoard()[currY][currX].getPiece().getColor() != color){
                result.add(b.getBoard()[currY][currX]);
                break;
            }else{
                break;
            }
        }

        return result;
    }

    public ArrayList<Tile> generateLinearMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();
        //Right
        for(int i = pos.getX() + 1; i < 8; i++){
            if(b.getBoard()[pos.getY()][i] == null){
                result.add(b.getBoard()[pos.getY()][i]);
            }else if(b.getBoard()[pos.getY()][i].getPiece().getColor() != color){
                result.add(b.getBoard()[pos.getY()][i]);
                break;
            }else{
                break;
            }
        }
        //Left
        for(int i = pos.getX() - 1; i >= 0; i--){
            if(b.getBoard()[pos.getY()][i] == null){
                result.add(b.getBoard()[pos.getY()][i]);
            }else if(b.getBoard()[pos.getY()][i].getPiece().getColor() != color){
                result.add(b.getBoard()[pos.getY()][i]);
                break;
            }else{
                break;
            }
        }
        //Up
        for(int i = pos.getY() + 1; i < 8; i++){
            if(b.getBoard()[i][pos.getX()] == null){
                result.add(b.getBoard()[i][pos.getX()]);
            }else if(b.getBoard()[i][pos.getX()].getPiece().getColor() != color){
                result.add(b.getBoard()[i][pos.getX()]);
                break;
            }else{
                break;
            }
        }
        //Down
        for(int i = pos.getY() - 1; i >= 0; i--){
            if(b.getBoard()[i][pos.getX()] == null){
                result.add(b.getBoard()[i][pos.getX()]);
            }else if(b.getBoard()[i][pos.getX()].getPiece().getColor() != color){
                result.add(b.getBoard()[i][pos.getX()]);
                break;
            }else{
                break;
            }
        }

        return result;
    }

    public abstract ArrayList<Tile> generateMoves(ChessBoard b);
}
