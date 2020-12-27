package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome the SOS Game!");
        System.out.println("Board size you want to play?");

        Sos game = new Sos(4);

        game.createBoard();
        int row;
        int col;
        while (!game.isBoardFull()) {
            if (game.getCurrentPlayer().equals("human")) {
                System.out.println("min:1 max:" + game.getBoardSize() + " row");
                row = scan.nextInt() - 1;
                System.out.println("min:1 max:" + game.getBoardSize() + " col");
                col = scan.nextInt() - 1;
                game.markBoard(row, col);

            } else {
                game.markBoardRandom();

            }
            game.changePlayerAndMark();
            game.showBoard();
        }

    }
}

