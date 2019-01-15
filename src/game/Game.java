package game;

import java.util.*;

public class Game {

    public static Scanner input = new Scanner(System.in);
    public static Shape winner = null;

    public static void main(String[] args) {
        game();
    }

    public static void game(){
        boolean gameIsOn = true;

        while(gameIsOn){
            System.out.println("X, enter coordinates:");
            int x = input.nextInt();
            int y = input.nextInt();
            Board.getInstance().setX(x, y);

            Board.getInstance().printBoard();
            winner = Board.getInstance().checkWinner();
            if(winner != null)
                gameIsOn = false;
            else{
                System.out.println("O, enter coordinates:");
                x = input.nextInt();
                y = input.nextInt();
                Board.getInstance().setX(x, y);

                Board.getInstance().printBoard();
                winner = Board.getInstance().checkWinner();
                if(winner!=null)
                    gameIsOn = false;
            }
        }
    }

    public static void turn(Shape currentPlayer){
        System.out.println(currentPlayer.toString()+", enter coordinates:");
        int x = input.nextInt();
        int y = input.nextInt();

        if(currentPlayer == Shape.X)
            Board.getInstance().setX(x, y);
        else
            Board.getInstance().setO(x, y);

        Board.getInstance().printBoard();
    }
}