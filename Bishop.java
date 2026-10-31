package solution;

/**
 * A Bishop can move diagonally any number of squares.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Constructor for Bishop.
   *
   * @param row row position
   * @param col column position
   * @param color color of the piece (WHITE or BLACK)
   * @throws IllegalArgumentException if position invalid
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Determines if the Bishop can move to the specified position.
   * A Bishop can move diagonally, meaning the absolute difference
   * between rows must equal the absolute difference between columns.
   *
   * @param row the target row
   * @param col the target column
   * @return true if the Bishop can move to (row, col), false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return Math.abs(this.row - row) == Math.abs(this.col - col);
  }
}