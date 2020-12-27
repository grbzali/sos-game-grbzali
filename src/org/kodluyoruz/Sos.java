package org.kodluyoruz;

import java.util.Random;

public class Sos {

    private char[][] board;
    private final int boardSize;
    private String currentPlayer;
    private char currentPlayerMark;
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

        if (rand.nextInt(2) == 0) this.currentPlayerMark = 'S';
        else this.currentPlayerMark = 'O';

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
            for (int j = 0; j <= boardSize; j++) {
                System.out.println();
                System.out.print(board[i][j + 1] + " | ");
            }
            System.out.println("");
        }
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
            System.out.println("Computer played. Your turn...");
            return true;
        } else {
            markBoardRandom();
        }
        return false;
    }

    public boolean markBoard(int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayerMark;
            return true;
        } else return false;

    }

    public boolean checkWin() {
        return (checkRowWin() || checkColWin() || checkDiagonalWin());
    }

    private boolean checkColWin() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize - 2; j++) {
                if (board[j][i] == 'S' && board[j + 1][i] == 'O' && board[j + 2][i] == 'S') return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        for (int i = 0; i < boardSize - 2; i++) {
            for (int j = 0; j < boardSize - 2; j++) {
                if (board[i][j] == 'S' && board[i + 1][j + 1] == 'O' && board[i + 2][j + 2] == 'S') return true;
            }
        }

        //add reverse dioganal****

        return false;

    }

    private boolean checkRowWin() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize - 2; j++) {
                if (board[i][j] == 'S' && board[i][j + 1] == 'O' && board[i][j + 2] == 'S') return true;
            }
        }
        return false;
    }
}
