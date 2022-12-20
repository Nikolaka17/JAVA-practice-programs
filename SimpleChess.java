public class SimpleChess {
    public static final char KING = 'K';
    public static final char QUEEN = 'Q';
    public static final char KNIGHT = 'N';
    public static final char BISHOP = 'B';
    public static final char ROOK = 'R';
    public static final char PAWN = 'P';
    public static final char SPACE = ' ';

    public static void main(String[] args){
        char[][] board = new char[][]{{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK},{PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN},{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK}};
        int player = 1;
        boolean check = false;
    }

    public void printBoard(char[][] b, int p){
        if(p == 1){
            for(char[] a: b){
                for(char c: a){
                    System.out.print(c);
                }
                System.out.println();
            }
        }else{
            for(int i = 7; i <= 0; i--){
                for(int j = 0; j < 8; j++){
                    System.out.print(b[i][j]);
                }
                System.out.println();
            }
        }
    }
}
