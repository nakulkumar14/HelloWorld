package LLDProblems.LLDTicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class PlayingBoard {
  private int size;
  private PieceType[][] board;

  public PlayingBoard(int size) {
    this.size = size;
    this.board = new PieceType[size][size];
  }

  public PieceType[][] getBoard() {
    return board;
  }

  public boolean addPiece(int row, int column, PieceType pieceType) {
    if (board[row][column] != null) {
      return false;
    }
    board[row][column] = pieceType;
    return true;
  }

  public List<List<Integer>> freeCells() {
    List<List<Integer>> cells = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == null) {
          cells.add(List.of(i,j));
        }
      }
    }
    return cells;
  }

  public void printBoard() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == null) {
          System.out.print("    ");
        } else {
          System.out.print(board[i][j] + "   ");
        }
        System.out.print(" | ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    PlayingBoard b = new PlayingBoard(3);
    b.printBoard();

  }
}
