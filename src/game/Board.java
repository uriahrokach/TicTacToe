package game;

//The Board is represented by a singleton.
public class Board {

    private static Board firstInstance;
    private Shape[][] board;

    private Board() {
        this.board = new Shape[3][3];
    }

    public static Board getInstance() {
        if (firstInstance == null) {
            firstInstance = new Board();
        }
        return firstInstance;
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

    public Shape checkWinner(){
        for(Shape[] row : board){
            if(row[0] == row[1] &&  row[1] == row[2])
                return row[0];
        }
        for (int y = 0; y<board[0].length;y++){
            if(board[0][y] == board[1][y]&& board[1][y] == board[2][y])
                return board[0][y];
        }

        if(board[0][0] == board[1][1]&& board[1][1] == board[2][2]){
            return board[0][0];
        }

        if(board[0][2] == board[1][1]&& board[1][1] == board[2][0]){
            return board[0][0];
        }

        return null;
    }

}