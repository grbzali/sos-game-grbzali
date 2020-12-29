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
            System.out.println("Please enter a between 3-7 number!");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a between 3-7 number!");
                scan.next();
            }
            boardSize = scan.nextInt();
        } while (boardSize < 3  || boardSize > 7);
        System.out.println("Board size is " + boardSize + ".");

        Sos game = new Sos(boardSize);

        game.createBoard();
        int rowInput=0;
        int colInput=0;
        while (!game.isBoardFull()) {

            if (game.getCurrentPlayer().equals("human")) {
                do {
                    System.out.println("Please enter a between 1-"+ boardSize +" row number!");
                    while (!scan.hasNextInt()) {
                        System.out.println("Please enter a between 1-"+ boardSize + " row number!");
                        scan.next();
                    }
                    rowInput = scan.nextInt()-1;
                } while (rowInput + 1 < 1  || rowInput + 1 > boardSize);

                do {
                    System.out.println("Please enter a between 1-"+ boardSize + " column number!");
                    while (!scan.hasNextInt()) {
                        System.out.println("Please enter a between 1-"+ boardSize + " column number!");
                        scan.next();
                    }
                    colInput = scan.nextInt()-1;
                } while (colInput + 1 < 1  || colInput + 1 > boardSize);

                game.markBoard(rowInput, colInput);

                game.checkWin();


            }
            else {
                game.markBoardRandom();
                game.checkWin();
            }
            game.changePlayerAndMark();
            game.showBoard();
            System.out.println("Computer played. Your turn...");
        }
        System.out.println("Game Over");
        System.out.println("Computer Score:" + game.getScoreComputer());
        System.out.println("Your Score:" + game.getScoreHuman());
        if(game.getScoreComputer()> game.getScoreHuman()) System.out.println("You lost :(");
        else if (game.getScoreComputer()==game.getScoreHuman()) System.out.println("Draw -_-");
        else System.out.println("Congratulations! You won");
    }
}

