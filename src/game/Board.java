package game;

//The Board is represented by a singleton.
public class Board {

    private static int SIDE_LENGTH = 3;
    private static Board firstInstance;
    private Shape[][] board;

    private Board(int sideLength){
        this.board = new Shape[sideLength][sideLength];
        SIDE_LENGTH = sideLength;
    }

    private Board() {
        this(SIDE_LENGTH);
    }


    public static Board getInstance() {
        if (firstInstance == null) {
            firstInstance = new Board();
        }
        return firstInstance;
    }

    public static int getSideLength(){
        return SIDE_LENGTH;
    }

    public void setX(int x, int y) {
        if (board.length > x && board[0].length > y) {
            if (board[x][y] == null) {
                this.board[x][y] = Shape.X;
            }
        }

    }

    public void setO(int x, int y) {
        if (board.length > x && board[0].length > y) {
            if (board[x][y] == null) {
                this.board[x][y] = Shape.O;
            }
        }
    }

    public Shape[][] getBoard() {
        return this.board;
    }

    public Shape getSquare(int x, int y) {
        if (board.length > x && board[0].length > y) {
            return this.board[x][y];
        } else {
            return null;
        }
    }

    public void printBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == Shape.X) {
                    System.out.print("X");
                } else if (board[x][y] == Shape.O) {
                    System.out.print("O");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("\n");
        }
    }

    public Shape checkWinner() {
        Shape[] results = new Shape[4];

        results[0] = checkHorizontal();
        results[1] = checkVertical();
        results[2] = checkMainDiagonal();
        results[3] = checkSecondaryDiagonal();

        for (Shape res : results) {
            if (res != null)
                return res;
        }

        return null;
    }

    private Shape checkHorizontal() {
        for (Shape[] row : board) {
            for (Shape col : row) {
                if (row[0] != col)
                    break;
                if (col == row[row.length - 1])
                    return col;
            }
        }
        return null;
    }

    private Shape checkVertical() {
        for (int y = 0; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[0][y] != board[x][y])
                    break;
                if (x == (board.length - 1))
                    return board[x][y];
            }
        }
        return null;
    }

    private Shape checkMainDiagonal() {
        for (int p = 0; p < board.length; p++) {
            if (board[p][p] != board[0][0])
                break;
            if (p == (board.length - 1))
                return board[p][p];
        }
        return null;
    }

    private Shape checkSecondaryDiagonal() {
        for (int p = 0; p < board.length; p++) {
            if (board[p][board[p].length - 1 - p] != board[board[p].length - 1][0])
                break;
            if (p == (board.length - 1))
                return board[board.length - 1][p];
        }
        return null;
    }

}