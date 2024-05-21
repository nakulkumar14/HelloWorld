package LLDProblems.LLDTicTacToe.model;

public abstract class PlayingPiece {
  PieceType pieceType;

  public PlayingPiece(PieceType pieceType) {
    this.pieceType = pieceType;
  }

  public PieceType getPieceType() {
    return pieceType;
  }
}
