import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import solution.ChessPiece;
import solution.Color;

/**
 * Tests for Abstract base class.
 */
public abstract class ChessPieceTest {
  protected ChessPiece piece;
  protected boolean[][] results;

  /**
   * Factory method to create a specific chess piece.
   *
   * @param row row position
   * @param col column position
   * @param color color of the piece
   * @return created chess piece
   */
  protected abstract ChessPiece createPiece(int row, int col, Color color);

  /**
   * Set up the test environment before each test.
   */
  @Before
  public void setup() {
    results = new boolean[8][8];
  }

  /**
   * Verify that canMove returns the expected results for all board positions.
   *
   * @param piece the piece to test
   */
  protected void verifyMoveResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        assertEquals("Piece at :" + piece.getRow() + "," + piece.getColumn()
                + ", Unexpected canMove result for "
                + "i=" + i + " j=" + j + "",
            results[i][j], piece.canMove(i, j));
      }
    }
  }

  /**
   * Verify that canKill returns the expected results for all board positions.
   *
   * @param piece the piece to test
   */
  protected void verifyKillResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        ChessPiece another = createPiece(i, j,
            Color.values()[(piece.getColor().ordinal() + 1)
                % Color.values().length]);
        assertEquals("Unexpected canKill result for "
                + "i=" + i + " j=" + j + "",
            results[i][j], piece.canKill(another));
      }
    }
  }

  /**
   * Initialize the results array to all false.
   */
  protected void initializeResults() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        results[row][col] = false;
      }
    }
  }

  /**
   * Set up the expected results array for movement tests.
   * Subclasses must implement this based on their piece's movement rules.
   *
   * @param row the piece's row position
   * @param col the piece's column position
   */
  protected abstract void setupResults(int row, int col);

  /**
   * Test that getters return correct values.
   */
  @Test(timeout = 500)
  public void testGetters() {
    ChessPiece testPiece;
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        for (Color c : Color.values()) {
          testPiece = createPiece(row, col, c);
          assertEquals("Row number does not match what was initialized", row,
              testPiece.getRow());
          assertEquals("Column number does not match what was initialized",
              col, testPiece.getColumn());
          assertEquals("Color does not match what was initialized",
              c, testPiece.getColor());
        }
      }
    }
  }

  /**
   * Test that invalid constructions throw IllegalArgumentException.
   */
  @Test(timeout = 500)
  public void testInvalidConstructions() {
    ChessPiece testPiece;
    for (Color c : Color.values()) {
      for (int i = 0; i < 8; i++) {
        try {
          testPiece = createPiece(i, -1, c);
          fail("Did not throw an exception when piece is created with invalid column");
        } catch (IllegalArgumentException e) {
          e.getMessage();
        }
        try {
          testPiece = createPiece(-1, i, c);
          fail("Did not throw an exception when piece is created with invalid row");
        } catch (IllegalArgumentException e) {
          e.getMessage();
        }
        try {
          testPiece = createPiece(i, 8, c);
          fail("Did not throw an exception when piece is created with column >= 8");
        } catch (IllegalArgumentException e) {
          e.getMessage();
        }
        try {
          testPiece = createPiece(8, i, c);
          fail("Did not throw an exception when piece is created with row >= 8");
        } catch (IllegalArgumentException e) {
          e.getMessage();
        }
      }
    }
  }

  /**
   * Test that canKill works correctly for all positions and colors.
   */
  @Test(timeout = 500)
  public void testCanKill() {
    for (Color c : Color.values()) {
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          initializeResults();
          ChessPiece testPiece = createPiece(row, col, c);
          setupResults(row, col);
          verifyKillResults(testPiece);
        }
      }
    }
  }
}