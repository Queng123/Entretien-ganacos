import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class main {
    public static int[][] loadSudoku(String filepath) {
        int[][] sudoku = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                if (sudoku == null) {
                    int size = line.length();
                    sudoku = new int[size][size];
                }
                for (int col = 0; col < line.length(); col++) {
                    sudoku[row][col] = Character.getNumericValue(line.charAt(col));
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sudoku;
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("-h")) {
            System.out.println("Usage: java main <sudoku_filepath>");
            System.exit(0);
        }
        if (args.length == 1) {
            int[][] sudoku = loadSudoku(args[0]);
            SudokuValidator.SudokuValidator sudokuValidator = new SudokuValidator.SudokuValidator();
            if (sudokuValidator.isSudokuValid(sudoku)) {
                System.out.println("Sudoku is valid");
            } else {
                System.out.println("Sudoku is not valid");
            }
        } else {
            System.exit(1);
        }
    }
}
