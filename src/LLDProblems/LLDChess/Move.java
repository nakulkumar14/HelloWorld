package LLDProblems.LLDChess;

public class Move {
  Box start;
  Box end;
  Player player;
  Piece movedPiece;
  Piece pieceKilled;

  public Move(Box start, Box end, Player player) {
    this.start = start;
    this.end = end;
    this.player = player;
  }

  public Box getStart() {
    return start;
  }

  public void setStart(Box start) {
    this.start = start;
  }

  public Box getEnd() {
    return end;
  }

  public void setEnd(Box end) {
    this.end = end;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Piece getMovedPiece() {
    return movedPiece;
  }

  public void setMovedPiece(Piece movedPiece) {
    this.movedPiece = movedPiece;
  }

  public Piece getPieceKilled() {
    return pieceKilled;
  }

  public void setPieceKilled(Piece pieceKilled) {
    this.pieceKilled = pieceKilled;
  }
}
