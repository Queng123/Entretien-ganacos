SRC		=	SudokuValidator/SudokuValidator.java \
			main.java

TEST_SRC	=	SudokuValidator/SudokuValidator.java \
				main.java							 \
				tests/SudokuValidatorTest.java

all:
	@javac $(SRC)

run: all
	@java main

test: all
	@java main < tests/valid_sudoku.test
	@java main < tests/invalid_sudoku.test

clean:
	@rm -f *.class
	@rm -f SudokuValidator/*.class

re: clean all
