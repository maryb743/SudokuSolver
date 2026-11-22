package ie.tudublin

class Sudoku(private val board: Array<IntArray>) {

    private var iterations = 0
    private val maxIterations = 2_000_000

    fun solve(): Boolean {

        if (!isValidBoard()) return false
        return solveBoard()

    }

    private fun solveBoard(): Boolean {

        iterations++

        if (iterations > maxIterations) {

            return false

        }

        for (row in 0..8) {

            for (col in 0..8) {

                if (board[row][col] == 0) {

                    for (number in 1..9) {

                        if (isValid(row, col, number)) {

                            board[row][col] = number

                            if (solveBoard()) return true

                            board[row][col] = 0

                        }
                    }

                    return false

                }
            }
        }
        return true
    }

    private fun isValid(row: Int, col: Int, number: Int): Boolean {

        for (i in 0..8) {

            if (board[row][i] == number) return false
            if (board[i][col] == number) return false

        }

        val boxRow = row - row % 3
        val boxCol = col - col % 3

        for (r in boxRow until boxRow + 3) {

            for (c in boxCol until boxCol + 3) {

                if (board[r][c] == number) return false
            }
        }

        return true

    }

    private fun isValidBoard(): Boolean {

        if (board.size != 9 || board.any { it.size != 9 }) return false

        for (row in 0..8) {

            for (col in 0..8) {

                val number = board[row][col]

                if (number !in 0..9) return false

                if (number != 0) {
                    board[row][col] = 0
                    val valid = isValid(row, col, number)
                    board[row][col] = number

                    if (!valid) return false

                }
            }
        }

        return true
    }
}
