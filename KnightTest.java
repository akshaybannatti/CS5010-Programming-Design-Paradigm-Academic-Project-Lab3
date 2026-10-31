import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import solution.ChessPiece;
import solution.Color;
import solution.Knight;

/**
 * Tests for Knight.
 */
public class KnightTest extends ChessPieceTest {

  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Knight(row, col, color);
  }

  @Override
  protected void setupResults(int row, int col) {
    int[][] knightMoves = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    for (int[] move : knightMoves) {
      int newRow = row + move[0];
      int newCol = col + move[1];
      if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
        results[newRow][newCol] = true;
      }
    }
  }

  /**
   * Test Knight valid moves.
   */
  @Test
  public void testKnightMovesValid() {
    piece = createPiece(4, 4, Color.WHITE);
    assertTrue(piece.canMove(2, 3));
    assertTrue(piece.canMove(2, 5));
    assertTrue(piece.canMove(6, 3));
    assertTrue(piece.canMove(6, 5));
    assertTrue(piece.canMove(3, 2));
    assertTrue(piece.canMove(5, 2));
  }

  /**
   * Test Knight invalid moves.
   */
  @Test
  public void testKnightMovesInvalid() {
    piece = createPiece(4, 4, Color.WHITE);
    assertFalse(piece.canMove(3, 3));
    assertFalse(piece.canMove(4, 5));
    assertFalse(piece.canMove(5, 5));
  }

  /**
   * Test Knight.
   */
  @Test(timeout = 500)
  public void testKnightMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece testPiece = new Knight(row, col, Color.BLACK);
        setupResults(row, col);
        verifyMoveResults(testPiece);
      }
    }
  }
}