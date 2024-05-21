package LLDProblems.LLDChess;

public class Rook extends Piece {
  public Rook(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public boolean canMove(Box start, Box end, Board board) {
    // end box has piece of same color.
    if (isMovedOverSameColorPiece(end)) {
      return false;
    }

    return start.getX() == end.getX() || start.getY() == end.getY();
  }

  @Override
  public String getSymbol() {
    return "R";
  }
}
