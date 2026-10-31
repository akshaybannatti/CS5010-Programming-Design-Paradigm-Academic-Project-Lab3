package solution;

/**
 * A Queen can move horizontally, vertically, or diagonally any number of squares.
 */
public class Queen extends AbstractChessPiece {

  /**
   * Constructor for Queen.
   *
   * @param row row position
   * @param col column position
   * @param color color of the piece (WHITE or BLACK)
   * @throws IllegalArgumentException if position invalid
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Determines if the Queen can move to the specified position.
   * A Queen can move horizontally (same row), vertically (same column),
   * or diagonally (absolute row difference equals absolute column difference).
   *
   * @param row the target row
   * @param col the target column
   * @return true if the Queen can move to (row, col), false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return (this.row == row) || (this.col == col)
        || (Math.abs(this.row - row) == Math.abs(this.col - col));
  }
}