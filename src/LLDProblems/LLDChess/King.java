package LLDProblems.LLDChess;

public class King extends Piece{
  public King(boolean iswhite) {
    super(iswhite);
  }

  @Override
  public boolean canMove(Box start, Box end, Board board) {
    // end box has piece of same color.
    if (isMovedOverSameColorPiece(end)) {
      return false;
    }

    int x = Math.abs(this.getX() - end.getX());
    int y = Math.abs(this.getY() - end.getY());

    // King can move only one box.
    if (x + y == 1) {
      // Check if checkmate etc.
      return true;
    }

    return false;
  }

  @Override
  public String getSymbol() {
    return "K";
  }
}
