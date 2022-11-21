package Iterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuPart {
    int length;
    List<Integer> values;
    List<Integer> expected;

    public SudokuPart(List<Integer> values) {
        this.values = values;
        this.length = values.size();
        this.expected = IntStream.range(1, length+1).boxed().collect(Collectors.toList());
    }

    public boolean isValid() {
        return expected.size() == values.size()
                && expected.containsAll(values)
                && values.containsAll(expected);
    }
}
