package LLDProblems.LLDChess;

public class Pawn extends Piece{
  public Pawn(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public boolean canMove(Box start, Box end, Board board) {
    // end box has piece of same color.
    if (isMovedOverSameColorPiece(end)) {
      return false;
    }

    if(start.getY() != end.getY()) {
      return false;
    }

    return true;
  }

  @Override
  public String getSymbol() {
    return "P";
  }
}
