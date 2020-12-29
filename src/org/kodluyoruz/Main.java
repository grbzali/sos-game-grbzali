package org.kodluyoruz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome the SOS Game!");
        System.out.println("Board size you want to play?");
        int boardSize = 0;
        do {
            System.out.println("Please enter a between 3-7 number for board size!");
            while (!scan.hasNextInt()) {
                System.out.println("a letter???...Please enter a between 3-7 NUMBER!!!");
                scan.next();
            }
            boardSize = scan.nextInt();
        } while (boardSize < 3 || boardSize > 7);
        System.out.println("Board size is " + boardSize + ".");

        Sos game = new Sos(boardSize);

        game.createBoard();
        game.showBoard();
        int rowInput = 10;
        int colInput = 10;
        while (!game.isBoardFull()) {
            if (game.getCurrentPlayer().equals("human")) {
                System.out.println("Your turn...Your Mark: '" + game.getCurrentPlayerMark() + "'");
                do {
                    System.out.println("Please enter a empty cell for mark!");
                    do {
                        System.out.println("Please enter a between 1-" + boardSize + " row number!");
                        while (!scan.hasNextInt()) {
                            System.out.println("a letter???...Please enter a between 1-" + boardSize + " row NUMBER!!!");
                            scan.next();
                        }
                        rowInput = scan.nextInt() - 1;

                    } while (rowInput + 1 <= 0 || rowInput + 1 > boardSize);

                    do {
                        System.out.println("Please enter a between 1-" + boardSize + " column number!");
                        while (!scan.hasNextInt()) {
                            System.out.println("a letter???...Please enter a between 1-" + boardSize + " column NUMBER!!!");
                            scan.next();
                        }

                        colInput = scan.nextInt() - 1;
                    } while (colInput + 1 <= 0 || colInput + 1 > boardSize);


                }while (!game.markBoard(rowInput,colInput));
                game.markBoard(rowInput, colInput);

                game.checkWin();
            } else {
                game.markBoardRandom();
                game.checkWin();
            }
            game.changePlayerAndMark();
            game.showBoard();

            System.out.println("Computer played");
            System.out.println("");
        }
        System.out.println("------------------------------");
        System.out.println("GAME OVER");
        System.out.println("------------------------------");
        System.out.println("Computer Score:" + game.getScoreComputer());
        System.out.println("Your Score:" + game.getScoreHuman());
        System.out.println("------------------------------");
        if (game.getScoreComputer() > game.getScoreHuman()) {
            System.out.println("------------------------------");
            System.out.println("You lost :(");
            System.out.println("------------------------------");
        }
        else if (game.getScoreComputer() == game.getScoreHuman()){
            System.out.println("------------------------------");
            System.out.println("Draw -_-");
            System.out.println("------------------------------");
        }
        else {
            System.out.println("------------------------------");
            System.out.println("Congratulations! You won");
            System.out.println("------------------------------");
        }
    }
}

