// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/merge-sort/MergeSort.java ./src/algorithms/merge-sort/MergeSortTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/merge-sort --select-class MergeSortTest && rm ./src/**/*.class

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {
  @Test
  public void doesSplitWorkCase1() {
    Assertions.assertTrue(Arrays.deepEquals(
      MergeSort.split(new int[]{ 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 }),
      new int[][]{
        new int[]{ 2, 5, 7, 9, 10 },
        new int[]{ 1, 3, 4, 6, 8  },
      }
    ));
  }

  @Test
  public void doesSplitWorkCase2() {
    Assertions.assertTrue(Arrays.deepEquals(
      MergeSort.split(new int[]{ 7, 5 }),
      new int[][]{
        new int[]{ 7 },
        new int[]{ 5 },
      }
    ));
  }

  @Test
  public void doesSplitWorkCase3() {
    Assertions.assertTrue(Arrays.deepEquals(
      MergeSort.split(new int[]{ 7, 5, 10 }),
      new int[][]{
        new int[]{ 7     },
        new int[]{ 5, 10 },
      }
    ));
  }

  @Test
  public void doesMergeWorkCase1() {
    Assertions.assertTrue(Arrays.equals(
      MergeSort.merge(
        new int[][]{
          new int[]{ 7, 5, 10, 9, 2 },
          new int[]{ 8, 1, 6 , 4, 3 },
        }
      ),
      new int[]{ 7, 5, 8, 1, 6, 4, 3, 10, 9, 2 }
    ));
  }

  @Test
  public void doesMergeWorkCase2() {
    Assertions.assertTrue(Arrays.equals(
      MergeSort.merge(
        new int[][]{
          new int[]{ 7 },
          new int[]{ 5 },
        }
      ),
      new int[]{ 5, 7 }
    ));
  }

  @Test
  public void doesMergeWorkCase3() {
    Assertions.assertTrue(Arrays.equals(
      MergeSort.merge(
        new int[][]{
          new int[]{ 7     },
          new int[]{ 5, 10 },
        }
      ),
      new int[]{ 5, 7, 10 }
    ));
  }

  @Test
  public void doesSortWork() {
    int[] elements       = { 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 };
    int[] elementsSorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    Assertions.assertTrue(Arrays.equals(MergeSort.sort(elements), elementsSorted));
  }
}
