public class main {
    public static void main(String[] args) {
        SudokuValidator.SudokuValidator sudokuValidator = new SudokuValidator.SudokuValidator();
        int[][] sudoku = new int[9][9];
        if (sudokuValidator.isSudokuValid(sudoku)) {
            System.out.println("Sudoku is valid");
        } else {
            System.out.println("Sudoku is invalid");
        }
    }
}
