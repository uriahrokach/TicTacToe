package game;

import java.util.*;

public class Game {

    public static boolean gameIsOn;
    public static Scanner input = new Scanner(System.in);
    public static Shape winner = null;

    public static void main(String[] args) {
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
                System.out.println("X, enter coordinates:");
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
}
