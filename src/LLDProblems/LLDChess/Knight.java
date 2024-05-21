package LLDProblems.LLDChess;

public class Knight extends Piece {
  public Knight(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public boolean canMove(Box start, Box end, Board board) {
    // end box has piece of same color.
    if (isMovedOverSameColorPiece(end)) {
      return false;
    }

    int x = Math.abs(start.getX() - end.getX());
    int y = Math.abs(start.getY() - end.getY());
    return x * y == 2;
  }

  @Override
  public String getSymbol() {
    return "KN";
  }
}
