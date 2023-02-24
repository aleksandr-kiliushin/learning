// To run this code:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/binary-search/BinarySearch.java ./src/algorithms/binary-search/BinarySearchTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/binary-search --select-class BinarySearchTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
  private int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

  @Test
  public void testDoesBinarySearchFind1() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 1), 0);
  }

  @Test
  public void testDoesBinarySearchFind2() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 2), 1);
  }

  @Test
  public void testDoesBinarySearchFind3() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 3), 2);
  }

  @Test
  public void testDoesBinarySearchFind4() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 4), 3);
  }

  @Test
  public void testDoesBinarySearchFind5() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 5), 4);
  }

  @Test
  public void testDoesBinarySearchFind6() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 6), 5);
  }

  @Test
  public void testDoesBinarySearchFind7() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 7), 6);
  }

  @Test
  public void testDoesBinarySearchFind8() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 8), 7);
  }

  @Test
  public void testDoesBinarySearchFind9() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 9), 8);
  }

  @Test
  public void testDoesBinarySearchFind10() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 10), 9);
  }

  @Test
  public void testDoesBinarySearchFind100500() {
    Assertions.assertEquals(BinarySearch.find(this.elements, 100500), -1);
  }
}
