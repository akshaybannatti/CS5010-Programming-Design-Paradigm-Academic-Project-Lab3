import org.junit.Test;
import solution.Bishop;
import solution.ChessPiece;
import solution.Color;

/**
 * Tests for Bishop.
 */
public class BishopTest extends ChessPieceTest {

  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Bishop(row, col, color);
  }

  @Override
  protected void setupResults(int row, int col) {
    for (int i = 0; i < 8; i++) {
      if ((row + i) < 8) {
        if ((col + i) < 8) {
          results[row + i][col + i] = true;
        }
        if (col >= i) {
          results[row + i][col - i] = true;
        }
      }
      if (row >= i) {
        if ((col + i) < 8) {
          results[row - i][col + i] = true;
        }
        if (col >= i) {
          results[row - i][col - i] = true;
        }
      }
    }
  }

  /**
   * Test Bishop.
   */
  @Test(timeout = 500)
  public void testBishopMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece testPiece = new Bishop(row, col, Color.BLACK);
        setupResults(row, col);
        verifyMoveResults(testPiece);
      }
    }
  }
}