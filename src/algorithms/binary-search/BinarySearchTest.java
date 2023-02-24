// To run this code:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/binary-search/BinarySearch.java ./src/algorithms/binary-search/BinarySearchTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/binary-search --select-class BinarySearchTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
  private int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

  @Test
  public void testDoesBinarySearchFind1() {
    Integer elementIndex = BinarySearch.find(this.elements, 1);
    Assertions.assertEquals(elementIndex, 0);
  }

  @Test
  public void testDoesBinarySearchFind2() {
    Integer elementIndex = BinarySearch.find(this.elements, 2);
    Assertions.assertEquals(elementIndex, 1);
  }

  @Test
  public void testDoesBinarySearchFind3() {
    Integer elementIndex = BinarySearch.find(this.elements, 3);
    Assertions.assertEquals(elementIndex, 2);
  }

  @Test
  public void testDoesBinarySearchFind4() {
    Integer elementIndex = BinarySearch.find(this.elements, 4);
    Assertions.assertEquals(elementIndex, 3);
  }

  @Test
  public void testDoesBinarySearchFind5() {
    Integer elementIndex = BinarySearch.find(this.elements, 5);
    Assertions.assertEquals(elementIndex, 4);
  }

  @Test
  public void testDoesBinarySearchFind6() {
    Integer elementIndex = BinarySearch.find(this.elements, 6);
    Assertions.assertEquals(elementIndex, 5);
  }

  @Test
  public void testDoesBinarySearchFind7() {
    Integer elementIndex = BinarySearch.find(this.elements, 7);
    Assertions.assertEquals(elementIndex, 6);
  }

  @Test
  public void testDoesBinarySearchFind8() {
    Integer elementIndex = BinarySearch.find(this.elements, 8);
    Assertions.assertEquals(elementIndex, 7);
  }

  @Test
  public void testDoesBinarySearchFind9() {
    Integer elementIndex = BinarySearch.find(this.elements, 9);
    Assertions.assertEquals(elementIndex, 8);
  }

  @Test
  public void testDoesBinarySearchFind10() {
    Integer elementIndex = BinarySearch.find(this.elements, 10);
    Assertions.assertEquals(elementIndex, 9);
  }

  @Test
  public void testDoesBinarySearchFind100500() {
    Integer elementIndex = BinarySearch.find(this.elements, 100500);
    Assertions.assertEquals(elementIndex, -1);
  }
}
