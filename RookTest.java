import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import solution.ChessPiece;
import solution.Color;
import solution.Rook;

/**
 * Test class for Rook chess piece.
 */
public class RookTest extends ChessPieceTest {

  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Rook(row, col, color);
  }

  @Override
  protected void setupResults(int row, int col) {
    for (int i = 0; i < 8; i++) {
      results[i][col] = true;
      results[row][i] = true;
    }
  }

  /**
   * Test Rook moves horizontally and vertically.
   */
  @Test
  public void testCanMoveHorizontallyOrVertically() {
    piece = createPiece(4, 4, Color.BLACK);
    assertTrue(piece.canMove(4, 7));
    assertTrue(piece.canMove(0, 4));
    assertFalse(piece.canMove(5, 5));
  }

  /**
   * Test Rook moves from various positions.
   */
  @Test(timeout = 500)
  public void testRookMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece testPiece = new Rook(row, col, Color.BLACK);
        setupResults(row, col);
        verifyMoveResults(testPiece);
      }
    }
  }
}