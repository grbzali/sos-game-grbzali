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
            System.out.println("Please enter a between 1-7 number!");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a between 1-7 number!");
                scan.next();
            }
            boardSize = scan.nextInt();
        } while (boardSize <= 0  || boardSize > 7);
        System.out.println("Board size is " + boardSize + ".");

        System.out.println(boardSize);

        Sos game = new Sos(boardSize);

        game.createBoard();
        int rowInput=0;
        int colInput=0;
        while (!game.isBoardFull()) {

            if (game.getCurrentPlayer().equals("human")) {

                try {
                    System.out.println("min:1 max:" + game.getBoardSize() + " rowInput");
                    rowInput = scan.nextInt() - 1;
                    System.out.println("min:1 max:" + game.getBoardSize() + " colInput");
                    colInput = scan.nextInt() - 1;
                    System.out.println("colInput:"+colInput+" rowInput:"+rowInput);
                    if (!(colInput+1 >= 1 && rowInput +1>=1 && rowInput+1 <= game.getBoardSize() && colInput+1 <= game.getBoardSize() )) {
                        System.out.println("Invalid value...Please 1-" + game.getBoardSize());
                        continue;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid value");

                }

                game.markBoard(rowInput, colInput);

                game.checkWin();
                System.out.println("---------------human------------------------");

            }
            else {
                game.markBoardRandom();

                game.checkWin();
                System.out.println("---------------computer-------------------------");
            }
            game.changePlayerAndMark();
            game.showBoard();
            System.out.println("Computer played. Your turn...");
        }

    }
}

