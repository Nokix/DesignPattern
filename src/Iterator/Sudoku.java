package Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Sudoku implements Iterable<Integer>{
    private int size;
    private int[][] board;

    public Sudoku(int[][] board) {
        this.size = board.length;
        this.board = board;
        if (!Arrays.stream(board).allMatch(row -> row.length == this.size)) throw new IllegalArgumentException();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            int j = 0;

            @Override
            public boolean hasNext() {
                return i < size || j < size;
            }

            @Override
            public Integer next() {
                int result = board[this.i][this.j];
                this.j++;
                if (this.j >= size) {
                    this.j = 0;
                    this.i++;
                }
                return result;
            }
        };
    }

    public Iterable<SudokuPart> getRows() {
        return new Iterable<SudokuPart>() {
            @Override
            public Iterator<SudokuPart> iterator() {
                return new Iterator<SudokuPart>() {
                    int i = 0;

                    @Override
                    public boolean hasNext() {
                        return i < size;
                    }

                    @Override
                    public SudokuPart next() {
                        return new SudokuPart(Arrays.stream(board[i++]).boxed().collect(Collectors.toList()));
                    }
                };
            }
        };
    }

    public Iterable<SudokuPart> getColumns() {
        return () -> new Iterator<>() {
            int j = 0;

            @Override
            public boolean hasNext() {
                return j < size;
            }

            @Override
            public SudokuPart next() {
                List<Integer> result = Arrays.stream(board).map(ints -> ints[j]).collect(Collectors.toList());
                j++;
                return new SudokuPart(result);
            }
        };
    }

    public boolean checkSudoku() {
        return StreamSupport.stream(this.getRows().spliterator(), true).allMatch(SudokuPart::isValid)
                && StreamSupport.stream(this.getColumns().spliterator(), true).allMatch(SudokuPart::isValid);
    }
}
