package LLDProblems.LLDTicTacToe;

import LLDProblems.LLDTicTacToe.model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {

  private Player player1;
  private Player player2;

  Deque turns;

  PlayingBoard playingBoard;

  int size = 3;

  public Game() {
    initGame();
  }

  private void initGame() {
    player1 = new Player("Player1", new PlayingPieceO());
    player2 = new Player("Player2", new PlayingPieceX());

    playingBoard = new PlayingBoard(size);

    turns = new ArrayDeque();
    turns.add(player1);
    turns.add(player2);
    System.out.println("Starting game...");
  }

  public String startGame() {
    boolean nowinner = true;
    while (nowinner) {
      List<List<Integer>> freecells = playingBoard.freeCells();
      if (freecells.isEmpty()) {
       nowinner = false;
       continue;
      }

      playingBoard.printBoard();

      Player player = (Player) turns.removeFirst();
      System.out.println(player.getName() + ", please enter row, col to proceed : ");
      Scanner scanner = new Scanner(System.in);
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      if (!playingBoard.addPiece(row, col, player.getPlayingPiece().getPieceType())) {
        turns.addFirst(player);
        System.out.println("Position already filled, please try again!!");
        continue;
      }
      if (isThereWinner(row, col, player.getPlayingPiece().getPieceType())) {
        nowinner = false;
        return player.getName() + " is winner!!";
      }
      turns.addLast(player);
    }

    return "Draw";
  }

  private boolean isThereWinner(int row, int col, PieceType pieceType) {
    // check rows
    boolean rowMatch = true;
    for (int i = 0; i < size; i++) {
      if (playingBoard.getBoard()[row][i] == null || playingBoard.getBoard()[row][i] != pieceType) {
        rowMatch = false;
        break;
      }
    }

    // check columns
    boolean colMatch = true;
    for (int i = 0; i < size; i++) {
      if (playingBoard.getBoard()[i][col] == null || playingBoard.getBoard()[i][col] != pieceType) {
        colMatch = false;
        break;
      }
    }

    // check left diagonal
    boolean leftdiagonal = true;
    for (int i = 0; i < size; i++) {
      if (playingBoard.getBoard()[i][i] == null || playingBoard.getBoard()[i][i] != pieceType) {
        leftdiagonal = false;
        break;
      }
    }

    // check right diagonal
    boolean rightdiagonal = true;
    for (int i = 0; i < size; i++) {
      if (playingBoard.getBoard()[i][size-i-1] == null || playingBoard.getBoard()[i][size-i-1] != pieceType) {
        rightdiagonal = false;
        break;
      }
    }

    return rowMatch || colMatch || leftdiagonal || rightdiagonal;
  }
}
