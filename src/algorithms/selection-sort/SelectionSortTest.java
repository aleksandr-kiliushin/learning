// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/selection-sort/SelectionSort.java ./src/algorithms/selection-sort/SelectionSortTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/selection-sort --select-class SelectionSortTest && rm ./src/**/*.class

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
  @Test
  public void doesSortWorks() {
    int[] elements       = { 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 };
    int[] elementsSorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Assertions.assertTrue(Arrays.equals(SelectionSort.sort(elements), elementsSorted));
  }
}
