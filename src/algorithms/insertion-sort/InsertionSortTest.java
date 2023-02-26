// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/insertion-sort/InsertionSort.java ./src/algorithms/insertion-sort/InsertionSortTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/insertion-sort --select-class InsertionSortTest && rm ./src/**/*.class

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {
  @Test
  public void doesSortWork() {
    int[] elements       = { 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 };
    int[] elementsSorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Assertions.assertTrue(Arrays.equals(InsertionSort.sort(elements), elementsSorted));
  }
}
