import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean moved = false;

    public Pawn(int c, Tile p){
        super(c, p);
    }

    public boolean wasMoved(){
        return moved;
    }

    @Override
    public boolean move(Tile t){
        boolean b = super.move(t);
        moved = true;
        if((this.getColor() == 1 && this.getPos().getY() == 0) || (this.getColor() == 2 && this.getPos().getY() == 7)){
            this.getPos().promote();
        }
        return b;
    }

    @Override
    public ArrayList<Tile> generateMoves(ChessBoard b){
        ArrayList<Tile> result = new ArrayList<Tile>();

        int x = this.getPos().getX();
        int y = this.getPos().getY();
        int c = this.getColor();

        if(c == 1){
            if(y > 0){
                result.add(b.getBoard()[y - 1][x]);
                if(x > 0){
                    if(b.getBoard()[y - 1][x - 1] != null){
                        if(b.getBoard()[y - 1][x - 1].getPiece().getColor() != c){
                            result.add(b.getBoard()[y - 1][x - 1]);
                        }
                    }
                }
                if(x < 7){
                    if(b.getBoard()[y - 1][x + 1] != null){
                        if(b.getBoard()[y - 1][x + 1].getPiece().getColor() != c){
                            result.add(b.getBoard()[y - 1][x + 1]);
                        }
                    }
                }
            }
            if(y > 1 && !moved){
                result.add(b.getBoard()[y - 2][x]);
            }
        }else if(c == 2){
            if(y < 7){
                result.add(b.getBoard()[y + 1][x]);
                if(x > 0){
                    if(b.getBoard()[y + 1][x - 1] != null){
                        if(b.getBoard()[y + 1][x - 1].getPiece().getColor() != c){
                            result.add(b.getBoard()[y + 1][x - 1]);
                        }
                    }
                }
                if(x < 7){
                    if(b.getBoard()[y + 1][x + 1] != null){
                        if(b.getBoard()[y + 1][x + 1].getPiece().getColor() != c){
                            result.add(b.getBoard()[y + 1][x + 1]);
                        }
                    }
                }
            }
            if(y < 6 && !moved){
                result.add(b.getBoard()[y + 2][x]);
            }
        }

        return result;
    }
}
