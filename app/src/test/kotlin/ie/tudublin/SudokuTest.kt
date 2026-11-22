/*
 * Tests
 */
package ie.tudublin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SudokuTest {

    @Test
    fun testValidSudoku() {
        val board = arrayOf(
            intArrayOf(5,3,0,0,7,0,0,0,0),
            intArrayOf(6,0,0,1,9,5,0,0,0),
            intArrayOf(0,9,8,0,0,0,0,6,0),
            intArrayOf(8,0,0,0,6,0,0,0,3),
            intArrayOf(4,0,0,8,0,3,0,0,1),
            intArrayOf(7,0,0,0,2,0,0,0,6),
            intArrayOf(0,6,0,0,0,0,2,8,0),
            intArrayOf(0,0,0,4,1,9,0,0,5),
            intArrayOf(0,0,0,0,8,0,0,7,9)
        )

        assertTrue(Sudoku(board).solve())
        assertTrue(board.all { row -> row.all { it in 1..9 } })
    }

    @Test
    fun testSolvedSudoku() {
        val board = arrayOf(
            intArrayOf(5,3,4,6,7,8,9,1,2),
            intArrayOf(6,7,2,1,9,5,3,4,8),
            intArrayOf(1,9,8,3,4,2,5,6,7),
            intArrayOf(8,5,9,7,6,1,4,2,3),
            intArrayOf(4,2,6,8,5,3,7,9,1),
            intArrayOf(7,1,3,9,2,4,8,5,6),
            intArrayOf(9,6,1,5,3,7,2,8,4),
            intArrayOf(2,8,7,4,1,9,6,3,5),
            intArrayOf(3,4,5,2,8,6,1,7,9)
        )

        assertTrue(Sudoku(board).solve())
    }

    @Test
    fun testInvalidSudoku() {
        val board = Array(9) { IntArray(9) }
        board[0][0] = 5
        board[0][1] = 5

        assertFalse(Sudoku(board).solve())
    }
}
