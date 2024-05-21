package LLDProblems.LLDChess;

public class Bishop extends Piece{
  public Bishop(boolean isWhite) {
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

    return x == y;
  }

  @Override
  public String getSymbol() {
    return "B";
  }
}
