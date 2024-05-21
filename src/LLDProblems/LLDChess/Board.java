package LLDProblems.LLDChess;

public class Board {
  Box[][] boxes;

  Board() {
    initializeBoard();
  }

  public Box getBox(int x, int y) {
    return boxes[x][y];
  }

  private void initializeBoard() {
    boxes = new Box[8][8];

    // white pieces
    boxes[0][0] = new Box(new Rook(true), 0, 0);
    boxes[0][1] = new Box(new Knight(true), 0, 1);
    boxes[0][2] = new Box(new Bishop(true), 0, 2);
    boxes[0][3] = new Box(new King(true), 0, 3);
    boxes[0][4] = new Box(new Queen(true), 0, 4);
    boxes[0][5] = new Box(new Bishop(true), 0, 5);
    boxes[0][6] = new Box(new Knight(true), 0, 6);
    boxes[0][7] = new Box(new Rook(true), 0, 7);


    for (int i = 0; i < 8; i++) {
      boxes[1][i] = new Box(new Pawn(true), 1, i);
    }

    // Empty boxes
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        boxes[i][j] = new Box(null, i, j);
      }
    }

    // black pieces
    for (int i = 0; i < 8; i++) {
      boxes[6][i] = new Box(new Pawn(false), 6, i);
    }

    boxes[7][0] = new Box(new Rook(false), 7, 0);
    boxes[7][1] = new Box(new Knight(false), 7, 1);
    boxes[7][2] = new Box(new Bishop(false), 7, 2);
    boxes[7][3] = new Box(new Queen(false), 7, 3);
    boxes[7][4] = new Box(new King(false), 7, 4);
    boxes[7][5] = new Box(new Bishop(false), 7, 5);
    boxes[7][6] = new Box(new Knight(false), 7, 6);
    boxes[7][7] = new Box(new Rook(false), 7, 7);
  }

  public void printBoard() {
    System.out.println("===================");
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (boxes[i][j].getPiece()!=null) {
          System.out.printf(boxes[i][j] + "   | ");
        } else {
          System.out.printf("        | ");
        }

      }
      System.out.println();
    }
    System.out.println("===================");
  }
}
