package LLDProblems.LLDChess;

import java.util.*;

public class Game {
  Player player1;
  Player player2;
  Board board;
  List<Move> moveList;
  Deque deque;

  Game() {
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    board = new Board();
    moveList = new ArrayList<>();
    deque = new ArrayDeque();
    deque.add(player1);
    deque.add(player2);
  }

  public void playGame() {
    boolean nowinner = true;
    Scanner scanner = new Scanner(System.in);
    while (nowinner) {
      board.printBoard();
      Player player = (Player) deque.removeFirst();
      System.out.println(player.getName() + " please enter details of piece (x,y) to be moved : ");
      Box start = getBox(scanner);
      System.out.println(player.getName() + " please enter details of piece where (x,y) to be moved : ");
      Box end = getBox(scanner);
      Move move = new Move(start, end, player);

      // no piece at start, invalid move.
      if (start.getPiece() == null) {
        System.out.printf(player.getName() + ", selected position is incorrect. Please try again.");
        deque.addFirst(player);
        continue;
      }

      // valid move?
      if (!start.getPiece().canMove(start, end, board)) {
        System.out.printf(player.getName() + ", Invalid move. Please try again.");
        deque.addFirst(player);
        continue;
      }

      // log if piece killed
      Piece destPiece = end.getPiece();
      if (destPiece != null) {
        destPiece.setKilled(true);
        move.setPieceKilled(destPiece);
      }

      moveList.add(move);

      // move piece from start to end.
      end.setPiece(start.getPiece());
      start.setPiece(null);

      // Check if game ended.
      if (destPiece!=null && destPiece instanceof King) {
        System.out.println(player.getName() + " wins the game!!");
        nowinner = false;
      }

      deque.addLast(player);
    }
  }

  private Box getBox(Scanner scanner) {
    String input = scanner.next();
    String[] split = input.split(",");
    int x = Integer.parseInt(split[0]);
    int y = Integer.parseInt(split[1]);
    return board.getBox(x, y);
  }
}
