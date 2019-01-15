package game;

import java.util.Scanner;

public class Game {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Shape winner = game();
        System.out.println("The winner is: " + winner.toString());
    }

    public static Shape game() {
        boolean gameIsOn = true;
        while (gameIsOn) {
            turn(Shape.X);
            if (Board.getInstance().checkWinner() != null)
                return Shape.X;
            turn(Shape.O);
            if (Board.getInstance().checkWinner() != null)
                return Shape.O;
        }
        return null;
    }

    public static void turn(Shape currentPlayer) {
        System.out.println(currentPlayer.toString() + ", enter coordinates:");
        int x = input.nextInt();
        int y = input.nextInt();

        if (currentPlayer == Shape.X)
            Board.getInstance().setX(x, y);
        else
            Board.getInstance().setO(x, y);

        Board.getInstance().printBoard();
    }
}