package SudokuValidator;

/**
 * A class that checks if a sudoku is valid.
 */
public class SudokuValidator {

    /**
     * Checks if a sudoku is valid.
     * @param sudoku The sudoku to check.
     * @return True if the sudoku is valid, false otherwise.
     */
    public boolean isSudokuValid( int[][] sudoku ) {
        for (int i = 0; i < 9; i++)
            if (!isRowValid(sudoku, i))
                return false;
        for (int i = 0; i < 9; i++)
            if (!isColumnValid(sudoku, i))
                return false;
        for ( int i = 0; i < 9; i += 3 )
            for ( int j = 0; j < 9; j += 3 )
                if (!isSquareValid(sudoku, i, j))
                    return false;
        return true;
    }

    /**
     * Checks if a row is valid.
     * @param row The row to check.
     * @return True if the row is valid, false otherwise.
     */
    private boolean isRowValid( int[][] sudoku, int row ) {
        boolean[] found = new boolean[9];
        for ( int i = 0; i < 9; i++ ) {
            int value = sudoku[row][i];
            if ( value < 1 || value > 9 || found[value - 1] )
                return false;
            found[value - 1] = true;
        }
        return true;
    }

    /**
     * Checks if a column is valid.
     * @param column The column to check.
     * @return True if the column is valid, false otherwise.
     */
    private boolean isColumnValid( int[][] sudoku, int column ) {
        boolean[] found = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int value = sudoku[i][column];
            if (value < 1 || value > 9 || found[value - 1])
                return false;
            found[value - 1] = true;
        }
        return true;
    }

    /**
     * Checks if a square is valid.
     * @param row The row of the square.
     * @param column The column of the square.
     * @return True if the square is valid, false otherwise.
     */
    private boolean isSquareValid( int[][] sudoku, int row, int column ) {
        boolean[] found = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                int value = sudoku[i][j];
                if (value < 1 || value > 9 || found[value - 1])
                    return false;
                found[value - 1] = true;
            }
        }
        return true;
    }
}
