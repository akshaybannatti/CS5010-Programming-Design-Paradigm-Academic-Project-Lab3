package solution;

/**
 * A Rook can move horizontally or vertically.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Constructor for Rook.
   *
   * @param row row position
   * @param col column position
   * @param color color of the piece (WHITE or BLACK)
   * @throws IllegalArgumentException if position invalid
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Determines if the Rook can move to the specified position.
   * A Rook can move horizontally (same row) or vertically (same column).
   *
   * @param row the row
   * @param col the column
   * @return true if move to (row, col), false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return (this.row == row) || (this.col == col);
  }
}