// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/bubble-sort/BubbleSort.java ./src/algorithms/bubble-sort/BubbleSortTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/bubble-sort --select-class BubbleSortTest && rm ./src/**/*.class

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
  @Test
  public void doesSortWorks() {
    int[] elements       = { 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 };
    int[] elementsSorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    Assertions.assertTrue(Arrays.equals(BubbleSort.sort(elements), elementsSorted));
  }
}
