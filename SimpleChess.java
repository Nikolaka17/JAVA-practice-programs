import java.awt.Point;
import java.util.ArrayList;

public class SimpleChess {
    public static final char WKING = 'K';
    public static final char WQUEEN = 'Q';
    public static final char WKNIGHT = 'N';
    public static final char WBISHOP = 'B';
    public static final char WROOK = 'R';
    public static final char WPAWN = 'P';
    public static final char BKING = 'k';
    public static final char BQUEEN = 'q';
    public static final char BKNIGHT = 'n';
    public static final char BBISHOP = 'b';
    public static final char BROOK = 'r';
    public static final char BPAWN = 'p';
    public static final char SPACE = ' ';

    public static void main(String[] args){
        char[][] board = new char[][]{{BROOK, BKNIGHT, BBISHOP, BQUEEN, BKING, BBISHOP, BKNIGHT, BROOK},{BPAWN, BPAWN, BPAWN, BPAWN, BPAWN, BPAWN, BPAWN, BPAWN},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE},{WPAWN, WPAWN, WPAWN, WPAWN, WPAWN, WPAWN, WPAWN, WPAWN},{WROOK, WKNIGHT, WBISHOP, WQUEEN, WKING, WBISHOP, WKNIGHT, WROOK}};
        int[][] colors = new int[][]{{2, 2, 2, 2, 2, 2, 2, 2},{2, 2, 2, 2, 2, 2, 2, 2},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1}};
        int player = 1;
        boolean check = false;
    }

    public void printBoard(char[][] b, char[][] c, int p){
        if(p == 1){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    System.out.print(b[i][j]);
                }
                System.out.println();
            }
        }else{
            for(int i = 7; i <= 0; i--){
                for(int j = 0; j < 8; j++){
                    System.out.print(b[j][i]);
                }
                System.out.println();
            }
        }
    }

    public Point[] findMoves(char[][] board, int[][] colors, Point pos){
        ArrayList<Point> result = new ArrayList<Point>();
        int tempY = pos.y;
        int tempX = pos.x;
        switch(Character.toUpperCase(board[pos.y][pos.x])){
            case WPAWN:
                if(colors[pos.y][pos.x] == 1){
                    if(pos.y != 0){
                        if(board[pos.y + 1][pos.x] == SPACE){
                            result.add(new Point(pos.x, pos.y + 1));
                        }
                        if(board[pos.y + 1][pos.x - 1] != SPACE && colors[pos.y + 1][pos.x - 1] != colors[pos.y][pos.x]){
                            result.add(new Point(pos.x - 1, pos.y + 1));
                        }
                        if(board[pos.y + 1][pos.x + 1] != SPACE && colors[pos.y + 1][pos.x + 1] != colors[pos.y][pos.x]){
                            result.add(new Point(pos.x + 1, pos.y + 1));
                        }
                    }
                }else{
                    if(pos.y != 7){
                        if(board[pos.y - 1][pos.x] == SPACE){
                            result.add(new Point(pos.x, pos.y - 1));
                        }
                        if(board[pos.y - 1][pos.x - 1] != SPACE && colors[pos.y - 1][pos.x - 1] != colors[pos.y][pos.x]){
                            result.add(new Point(pos.x - 1, pos.y - 1));
                        }
                        if(board[pos.y - 1][pos.x + 1] != SPACE && colors[pos.y - 1][pos.x + 1] != colors[pos.y][pos.x]){
                            result.add(new Point(pos.x + 1, pos.y - 1));
                        }
                    }
                }
                break;
            case WKNIGHT:
                //Q1 tests
                if(pos.y - 2 >= 0 && pos.x + 1 < 8){
                    if(colors[pos.y - 2][pos.x + 1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 1, pos.y - 2));
                    }
                }
                if(pos.y - 1 >= 0 && pos.x + 2 < 8){
                    if(colors[pos.y - 1][pos.x + 2] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 2, pos.y - 1));
                    }
                }
                //Q2 tests
                if(pos.y - 2 >= 0 && pos.x - 1 >= 0){
                    if(colors[pos.y - 2][pos.x - 1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 1, pos.y - 2));
                    }
                }
                if(pos.y - 1 >= 0 && pos.x - 2 >= 0){
                    if(colors[pos.y - 1][pos.x - 2] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 2, pos.y - 1));
                    }
                }
                //Q3 tests
                if(pos.y + 2 < 8 && pos.x - 1 >= 0){
                    if(colors[pos.y + 2][pos.x - 1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 1, pos.y + 2));
                    }
                }
                if(pos.y + 1 < 8 && pos.x - 2 >= 0){
                    if(colors[pos.y + 1][pos.x - 2] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 2, pos.y + 1));
                    }
                }
                //Q4 tests
                if(pos.y + 2 < 8 && pos.x + 1 < 8){
                    if(colors[pos.y + 2][pos.x + 1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 1, pos.y + 2));
                    }
                }
                if(pos.y + 1 < 8 && pos.x + 2 < 8){
                    if(colors[pos.y + 1][pos.x + 2] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 2, pos.y + 1));
                    }
                }
                break;
            case WBISHOP:
                //Q1 tests
                tempY = pos.y - 1;
                tempX = pos.x + 1;
                while(tempY >= 0 && tempX < 8 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY--;
                    tempX++;
                }
                //Q2 tests
                tempY = pos.y - 1;
                tempX = pos.x - 1;
                while(tempY >= 0 && tempX >= 0 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY--;
                    tempX--;
                }
                //Q3 tests
                tempY = pos.y + 1;
                tempX = pos.x - 1;
                while(tempY < 8 && tempX >= 0 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY++;
                    tempX--;
                }
                //Q4 tests
                tempY = pos.y + 1;
                tempX = pos.x + 1;
                while(tempY < 8 && tempX < 8 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY++;
                    tempX++;
                }
                break;
            case WROOK:
                //South tests
                tempY = pos.y + 1;
                while(tempY < 8 && colors[tempY][pos.x] != colors[pos.y][pos.x]){
                    result.add(new Point(pos.x, tempY));
                    if(colors[tempY][pos.x] != 0){
                        break;
                    }
                    tempY++;
                }
                //North tests
                tempY = pos.y - 1;
                while(tempY >= 0 && colors[tempY][pos.x] != colors[pos.y][pos.x]){
                    result.add(new Point(pos.x, tempY));
                    if(colors[tempY][pos.x] != 0){
                        break;
                    }
                    tempY--;
                }
                //West tests
                tempX = pos.x - 1;
                while(tempX >= 0 && colors[pos.y][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, pos.y));
                    if(colors[pos.y][tempX] != 0){
                        break;
                    }
                    tempX--;
                }
                //East tests
                tempX = pos.x + 1;
                while(tempX < 8 && colors[pos.y][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, pos.y));
                    if(colors[pos.y][tempX] != 0){
                        break;
                    }
                    tempX++;
                }
                break;
            case WQUEEN:
                //South tests
                tempY = pos.y + 1;
                while(tempY < 8 && colors[tempY][pos.x] != colors[pos.y][pos.x]){
                    result.add(new Point(pos.x, tempY));
                    if(colors[tempY][pos.x] != 0){
                        break;
                    }
                    tempY++;
                }
                //North tests
                tempY = pos.y - 1;
                while(tempY >= 0 && colors[tempY][pos.x] != colors[pos.y][pos.x]){
                    result.add(new Point(pos.x, tempY));
                    if(colors[tempY][pos.x] != 0){
                        break;
                    }
                    tempY--;
                }
                //West tests
                tempX = pos.x - 1;
                while(tempX >= 0 && colors[pos.y][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, pos.y));
                    if(colors[pos.y][tempX] != 0){
                        break;
                    }
                    tempX--;
                }
                //East tests
                tempX = pos.x + 1;
                while(tempX < 8 && colors[pos.y][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, pos.y));
                    if(colors[pos.y][tempX] != 0){
                        break;
                    }
                    tempX++;
                }
                //Q1 tests
                tempY = pos.y - 1;
                tempX = pos.x + 1;
                while(tempY >= 0 && tempX < 8 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY--;
                    tempX++;
                }
                //Q2 tests
                tempY = pos.y - 1;
                tempX = pos.x - 1;
                while(tempY >= 0 && tempX >= 0 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY--;
                    tempX--;
                }
                //Q3 tests
                tempY = pos.y + 1;
                tempX = pos.x - 1;
                while(tempY < 8 && tempX >= 0 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY++;
                    tempX--;
                }
                //Q4 tests
                tempY = pos.y + 1;
                tempX = pos.x + 1;
                while(tempY < 8 && tempX < 8 && colors[tempY][tempX] != colors[pos.y][pos.x]){
                    result.add(new Point(tempX, tempY));
                    if(colors[tempY][tempX] != 0){
                        break;
                    }
                    tempY++;
                    tempX++;
                }
                break;
            case WKING:
                if(pos.x != 0){
                    if(colors[pos.y][pos.x-1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 1, pos.y));
                    }
                }
                if(pos.x != 7){
                    if(colors[pos.y][pos.x+1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 1, pos.y));
                    }
                }
                if(pos.y != 0){
                    if(colors[pos.y-1][pos.x] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x, pos.y - 1));
                    }
                }
                if(pos.y != 7){
                    if(colors[pos.y+1][pos.x] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x, pos.y + 1));
                    }
                }
                if(pos.y != 0 && pos.x != 0){
                    if(colors[pos.y-1][pos.x-1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 1, pos.y - 1));
                    }
                }
                if(pos.y != 0 && pos.x != 7){
                    if(colors[pos.y-1][pos.x+1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 1, pos.y - 1));
                    }
                }
                if(pos.y != 7 && pos.x != 0){
                    if(colors[pos.y+1][pos.x-1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x - 1, pos.y + 1));
                    }
                }
                if(pos.y != 7 && pos.x != 7){
                    if(colors[pos.y+1][pos.x+1] != colors[pos.y][pos.x]){
                        result.add(new Point(pos.x + 1, pos.y + 1));
                    }
                }
                break;
        }

        if(result.size() == 0){
            return null;
        }
        Point[] end = new Point[result.size()];
        for(int i = 0; i < result.size(); i++){
            end[i] = result.get(i);
        }
        return end;
    }

    public boolean isValidMove(char[][] board, int[][] colors, Point piece, Point pos){
        for(Point p: findMoves(board, colors, piece)){
            if(pos.equals(p)){
                return true;
            }
        }
        return false;
    }
}
