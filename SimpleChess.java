import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

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
        boolean[][] whiteAttack = new boolean[8][8];
        boolean[][] blackAttack = new boolean[8][8];
        generateAttackMap(board, colors, blackAttack, 2);
        generateAttackMap(board, colors, whiteAttack, 1);
        int player = 1;
        boolean check = false;
        boolean over = false;
        Scanner stdin = new Scanner(System.in);
        boolean validInput = false;

        do{
            System.out.println((player == 1)?"White":"Black" + " to play");
            if(check){
                System.out.println("You are in check");
            }
            printBoard(board, player);
            if(inCheckMate(board, colors, player)){
                over = true;
            }else{
                validInput = false;
                int x1 = 0;
                int y1 = 0;
                int x2 = 0;
                int y2 = 0;
                while(!validInput){
                    while(y1 < 1 || y1 > 8){
                        while(!stdin.hasNextInt()){
                            System.out.println("What row is the piece you would like to move? 1-8");
                        }
                        y1 = stdin.nextInt();
                        if(y1 < 1 || y1 > 8){
                            System.out.println("Invalid choice please try again");
                        }
                    }
                    while(x1 < 1 || x1 > 8){
                        while(!stdin.hasNextInt()){
                            System.out.println("What column is the piece you would like to move? 1-8");
                        }
                        x1 = stdin.nextInt();
                        if(x1 < 1 || x1 > 8){
                            System.out.println("Invalid choice please try again");
                        }
                    }
                    while(y2 < 1 || y2 > 8){
                        while(!stdin.hasNextInt()){
                            System.out.println("What row is the position you would like to move it to? 1-8");
                        }
                        y2 = stdin.nextInt();
                        if(y2 < 1 || y2 > 8){
                            System.out.println("Invalid choice please try again");
                        }
                    }
                    while(x2 < 1 || x2 > 8){
                        while(!stdin.hasNextInt()){
                            System.out.println("What column is the position you would like to move it to? 1-8");
                        }
                        x2 = stdin.nextInt();
                        if(x2 < 1 || x2 > 8){
                            System.out.println("Invalid choice please try again");
                        }
                    }
                    if(isValidMove(board, colors, new Point(x1, y1), new Point(x2, y2), check, (player == 1)?whiteAttack:blackAttack)){
                        move(board, colors, new Point(x1, y1), new Point(x2, y2));
                        validInput = true;
                    }
                }
                generateAttackMap(board, colors, whiteAttack, 1);
                generateAttackMap(board, colors, blackAttack, 2);
                player = 3 - player;
                Point kingPos = findKing(board, player);
                if(player == 1){
                    check = whiteAttack[kingPos.y][kingPos.x];
                }else{
                    check = blackAttack[kingPos.y][kingPos.x];
                }
            }
        }while(!over);
    }

    public static boolean inCheckMate(char[][] b, int[][] c, int p){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(c[i][j] == p){
                    if(findMoves(b, c, new Point(j, i)) != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] b, int p){
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
    public static Point[] findMoves(char[][] board, int[][] colors, Point pos){
        return findMoves(board, colors, pos, false, null);
    }

    public static Point[] findMoves(char[][] board, int[][] colors, Point pos, boolean inCheck, boolean[][] map){
        ArrayList<Point> result = new ArrayList<Point>();
        int tempY = pos.y;
        int tempX = pos.x;
        char[][] testBoard = board;
        int[][] testColors = colors;
        boolean[][] testMap = map;
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
        if(inCheck){
            for(int i = result.size()-1; i >= 0; i--){
                move(testBoard, testColors, pos, result.get(i));
                Point king = findKing(testBoard, colors[pos.y][pos.x]);
                generateAttackMap(testBoard, testColors, testMap, colors[pos.y][pos.x]);
                if(testMap[king.y][king.x]){
                    result.remove(i);
                }
            }
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

    public static void move(char[][] board, int[][] colors, Point piece, Point pos){
        colors[pos.y][pos.x] = colors[piece.y][piece.x];
        board[pos.y][pos.x] = board[piece.y][piece.x];
        colors[piece.y][piece.x] = 0;
        board[piece.y][piece.x] = SPACE;
    }

    public static boolean isValidMove(char[][] board, int[][] colors, Point piece, Point pos, boolean inCheck, boolean[][] map){
        for(Point p: findMoves(board, colors, piece, inCheck, map)){
            if(pos.equals(p)){
                return true;
            }
        }
        return false;
    }

    public static void generateAttackMap(char[][] b, int[][] c, boolean[][] map, int p){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                map[i][j] = false;
            }
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(c[i][j] == p){
                    for(Point pos: findMoves(b, c, new Point(j, i))){
                        map[pos.y][pos.x] = true;
                    }
                }
            }
        }
    }

    public static Point findKing(char[][] b, int p){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(p == 1 && b[i][j] == WKING){
                    return new Point(j, i);
                }else if(p == 2 && b[i][j] == BKING){
                    return new Point(j, i);
                }
            }
        }
        return null;
    }
}
