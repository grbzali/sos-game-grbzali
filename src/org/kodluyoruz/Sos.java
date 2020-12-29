package org.kodluyoruz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sos {

    private char[][] board;
    private List<String> scories = new ArrayList<String>();
    private final int boardSize;
    private String currentPlayer;
    private char currentPlayerMark;
    private int scoreComputer;

    public int getScoreComputer() {
        return scoreComputer;
    }

    public int getScoreHuman() {
        return scoreHuman;
    }

    private int scoreHuman;

    Random rand = new Random();

    public int getBoardSize() {
        return boardSize;
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public Sos(int boardSize) {

        this.boardSize = boardSize;

        if (rand.nextInt(2) == 0) this.currentPlayer = "computer";
        else this.currentPlayer = "human";
        //this.currentPlayer = "human";
        if (rand.nextInt(2) == 0) this.currentPlayerMark = 'S';
        else this.currentPlayerMark = 'O';
        //this.currentPlayerMark = 'S';
    }


    public boolean isBoardFull() {

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public void createBoard() {

        board = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void showBoard() {
        System.out.println("");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Computer Score:" + scoreComputer);
        System.out.println("Your Score:" + scoreHuman);
        System.out.println("");
    }

    public void changePlayerAndMark() {

        if (currentPlayer.equals("computer")) currentPlayer = "human";
        else currentPlayer = "computer";

        if (currentPlayerMark == 'S') currentPlayerMark = 'O';
        else currentPlayerMark = 'S';

    }

    public boolean markBoardRandom() {
        int randomRow = rand.nextInt(boardSize);
        int randomCol = rand.nextInt(boardSize);

        if (board[randomRow][randomCol] == '-') {
            board[randomRow][randomCol] = currentPlayerMark;

            return true;
        } else {
            markBoardRandom();
        }
        return false;
    }

    public boolean markBoard(int row, int col) {

        if (!(board[row][col] == '-')) {
            return false;
        } else {
            board[row][col] = currentPlayerMark;
            return true;
        }
    }

    public boolean checkWin() {

        return (checkRowWin() || checkColWin() || checkDiagonalWin());
    }

    private boolean checkColWin() {

        for (int row = 0; row < boardSize - 2; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (board[row][col] == 'S' && board[row + 1][col] == 'O' && board[row + 2][col] == 'S') {
                    String scoreCoord = Integer.toString(row) + Integer.toString(col) + Integer.toString(row + 2) + Integer.toString(col);
                    if (isContainArray(scoreCoord)) ;
                    else {
                        if (currentPlayer.equals("computer")) scoreComputer += 1;
                        else scoreHuman += 1;
                        scories.add(scoreCoord);
                    }
                }
            }
        }
        return false;
    }

    private boolean checkRowWin() {

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize - 2; col++) {
                if (board[row][col] == 'S' && board[row][col + 1] == 'O' && board[row][col + 2] == 'S') {
                    String scoreCoord = Integer.toString(row) + Integer.toString(col) + Integer.toString(row) + Integer.toString(col + 2);
                    if (isContainArray(scoreCoord)) ;
                    else {
                        if (currentPlayer.equals("computer")) scoreComputer += 1;
                        else scoreHuman += 1;
                        scories.add(scoreCoord);
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {

//        for (int row = 0; row < boardSize - 2; row++) {
//            for (int col = 0; col < boardSize - 2; col++) {
//                if (board[row][col] == 'S' && board[row + 1][col + 1] == 'O' && board[row + 2][col + 2] == 'S') {
//                    String scoreCoord = Integer.toString(row) + Integer.toString(col) + Integer.toString(row+2) + Integer.toString(col+2);
//                    if(isContainArray(scoreCoord)) ;
//                    else {
//                        if (currentPlayer.equals("computer")) scoreComputer += 1;
//                        else scoreHuman += 1;
//                        scories.add(scoreCoord);
//                    }
//                }
//            }
//        }

        for (int row = 1; row < boardSize - 1; row++) {
            for (int col = 1; col < boardSize - 1; col++) {
                if (board[row][col] == 'O') {
                    if (board[row - 1][col - 1] == 'S' && board[row + 1][col + 1] == 'S') {
                        String scoreCoord = Integer.toString(row - 1) + Integer.toString(col - 1) + Integer.toString(row + 1) + Integer.toString(col + 1);
                        if (!isContainArray(scoreCoord)) {
                            if (currentPlayer.equals("computer")) scoreComputer += 1;
                            else scoreHuman += 1;
                            scories.add(scoreCoord);
                        }
                    }
                    if (board[row + 1][col] == 'S' && board[row][col + 1] == 'S') {
                        String scoreCoord = Integer.toString(row + 1) + Integer.toString(col) + Integer.toString(row) + Integer.toString(col + 1);
                        if (!isContainArray(scoreCoord)) {
                            if (currentPlayer.equals("computer")) scoreComputer += 1;
                            else scoreHuman += 1;
                            scories.add(scoreCoord);
                        }
                    }
                }
            }
        }

        return false;

    }

    public boolean isContainArray(String scoreCoord) {

        for (String score : scories) {
            if (score.equals(scoreCoord)) return true;
        }

        return false;
    }


}
