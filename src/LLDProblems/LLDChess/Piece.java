package LLDProblems.LLDChess;

public abstract class Piece {
  int x;
  int y;

  boolean isWhite;

  boolean killed;

  public boolean isKilled() {
    return killed;
  }

  public void setKilled(boolean killed) {
    this.killed = killed;
  }

  public Piece(boolean isWhite) {
    this.isWhite = isWhite;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public abstract boolean canMove(Box start, Box end, Board board);

  public abstract String getSymbol();

  public boolean isMovedOverSameColorPiece(Box end) {
    return end.getPiece() != null && this.isWhite() == end.getPiece().isWhite();
  }
}
