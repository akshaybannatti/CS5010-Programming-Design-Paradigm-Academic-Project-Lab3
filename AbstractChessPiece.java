package solution;

/**
 * Abstract base class for all chess pieces.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  protected int row;
  protected int col;
  protected Color color;

  /**
   * Constructor for AbstractChessPiece..
   *
   * @param row the row position
   * @param col the column position
   * @param color the color of the piece (WHITE or BLACK)
   * @throws IllegalArgumentException if row or col is outside range
   */
  public AbstractChessPiece(int row, int col, Color color) {
    if (row < 0 || col < 0 || row >= 8 || col >= 8) {
      throw new IllegalArgumentException("Illegal position");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.getColor() != piece.getColor())
        && canMove(piece.getRow(), piece.getColumn());
  }

  @Override
  public abstract boolean canMove(int row, int col);
}