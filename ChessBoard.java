import java.util.ArrayList;

public class ChessBoard{
    private Tile[][] board = new Tile[8][8];

    public ArrayList<Piece> wPieces = new ArrayList<Piece>();
    public ArrayList<Piece> bPieces = new ArrayList<Piece>();

    private boolean[][] wThreatMap = new boolean[8][8];
    private boolean[][] bThreatMap = new boolean[8][8];

    private int turn = 1;

    public ChessBoard(){
        this("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    public ChessBoard(String fen){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Tile(this, null, j, i); 
            }
        }

        int currX = 0;
        int currY = 0;
        for(char c: fen.toCharArray()){
            switch(c){
                case 'r':
                    board[currY][currX].put(new Rook(2, board[currY][currX]));
                    currX++;
                    break;
                case 'n':
                    board[currY][currX].put(new Knight(2, board[currY][currX]));
                    currX++;
                    break;
                case 'b':
                    board[currY][currX].put(new Bishop(2, board[currY][currX]));
                    currX++;
                    break;
                case 'q':
                    board[currY][currX].put(new Queen(2, board[currY][currX]));
                    currX++;
                    break;
                case 'k':
                    board[currY][currX].put(new King(2, board[currY][currX]));
                    currX++;
                    break;
                case 'p':
                    board[currY][currX].put(new Pawn(2, board[currY][currX]));
                    currX++;
                    break;
                case 'R':
                    board[currY][currX].put(new Rook(1, board[currY][currX]));
                    currX++;
                    break;
                case 'N':
                    board[currY][currX].put(new Knight(1, board[currY][currX]));
                    currX++;
                    break;
                case 'B':
                    board[currY][currX].put(new Bishop(1, board[currY][currX]));
                    currX++;
                    break;
                case 'Q':
                    board[currY][currX].put(new Queen(1, board[currY][currX]));
                    currX++;
                    break;
                case 'K':
                    board[currY][currX].put(new King(1, board[currY][currX]));
                    currX++;
                    break;
                case 'P':
                    board[currY][currX].put(new Pawn(1, board[currY][currX]));
                    currX++;
                    break;
                case '/':
                    currY++;
                    currX = 0;
                    break;
                default:
                    currX += ((int)(c - '0'));
            }
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getPiece() != null){
                    if(board[i][j].getPiece().getColor() == 1){
                        wPieces.add(board[i][j].getPiece());
                    }else if(board[i][j].getPiece().getColor() == 2){
                        bPieces.add(board[i][j].getPiece());
                    }
                }
            }
        }
    }

    public ChessBoard(Tile[][] b){
        board = b;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getPiece() != null){
                    if(board[i][j].getPiece().getColor() == 1){
                        wPieces.add(board[i][j].getPiece());
                    }else if(board[i][j].getPiece().getColor() == 2){
                        bPieces.add(board[i][j].getPiece());
                    }
                }
            }
        }
    }

    public ChessBoard(ChessBoard b){
        this.board = b.getBoard();
        this.wPieces = b.wPieces;
        this.bPieces = b.bPieces;
        this.wThreatMap = b.getWThreatMap();
        this.bThreatMap = b.getBThreatMap();
    }

    public boolean[][] getWThreatMap(){
        return wThreatMap;
    }

    public boolean[][] getBThreatMap(){
        return bThreatMap;
    }

    public Tile[][] getBoard(){
        return board;
    }

    public int colorToPlay(){
        return turn;
    }

    public boolean takeTurn(Tile startTile, Tile endTile){
        boolean validMove = false;
        if(startTile.getPiece() == null){
            return false;
        }
        if(startTile.getPiece().getColor() != turn){
            return false;
        }
        for(Tile t: startTile.getPiece().generateMoves(this)){
            if(endTile.equals(t)){
                validMove = true;
            }
        }
        if(!validMove){
            return false;
        }
        startTile.getPiece().move(endTile);
        turn = 3 - turn;
        return true;
    }

    public void updateWThreatMap(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                wThreatMap[i][j] = false;
            }
        }

        for(Piece p: wPieces){
            for(Tile t: p.generateMoves(this)){
                wThreatMap[t.getY()][t.getX()] = true;
            }
        }
    }

    public void updateBThreatMap(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                bThreatMap[i][j] = false;
            }
        }

        for(Piece p: bPieces){
            for(Tile t: p.generateMoves(this)){
                bThreatMap[t.getY()][t.getX()] = true;
            }
        }
    }

    public boolean[][] generateThreatMap(ArrayList<Piece> pieces){
        boolean[][] result = new boolean[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                result[i][j] = false;
            }
        }
        for(Piece p: pieces){
            for(Tile t: p.generateMoves(this)){
                result[t.getY()][t.getX()] = true;
            }
        }
        return result;
    }

    public Tile findKing(int c){
        if(c == 1){
            for(Piece p: wPieces){
                if(p.isAKing()){
                    return p.getPos();
                }
            }
        }else if(c == 2){
            for(Piece p: bPieces){
                if(p.isAKing()){
                    return p.getPos();
                }
            }
        }
        return null;
    }

    public Tile findKing(ArrayList<Piece> pieces){
        for(Piece p: pieces){
            if(p.isAKing()){
                return p.getPos();
            }
        }
        return null;
    }

    public boolean check(int c){
        if(c == 1){
            return wThreatMap[findKing(c).getY()][findKing(c).getX()];
        }else if(c == 2){
            return bThreatMap[findKing(c).getY()][findKing(c).getX()];
        }
        return true;
    }

    public boolean check(ArrayList<Piece> a, boolean[][] map){
        return map[findKing(a).getY()][findKing(a).getX()];
    }

    public ChessBoard copy(){
        return new ChessBoard(this);
    }
}
