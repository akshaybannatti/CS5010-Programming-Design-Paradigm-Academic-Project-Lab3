package solution;

/**
 * A Knight moves in an L-shape.
 */
public class Knight extends AbstractChessPiece {

  /**
   * Constructor for Knight.
   *
   * @param row the row position
   * @param col the column position
   * @param color the color of the piece (WHITE or BLACK)
   * @throws IllegalArgumentException if position is invalid
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Determines if the Knight can move to the specified position.
   * A Knight moves in an L-shape: either 2 squares horizontally and 1 vertically,
   * or 2 squares vertically and 1 horizontally.
   *
   * @param row target row
   * @param col target column
   * @return true if the Knight can move to (row, col), false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return (Math.abs(this.row - row) == 2 && Math.abs(this.col - col) == 1)
        || (Math.abs(this.row - row) == 1 && Math.abs(this.col - col) == 2);
  }
}