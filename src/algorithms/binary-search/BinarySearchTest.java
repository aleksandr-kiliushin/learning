// To run this code:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/binary-search/BinarySearch.java ./src/algorithms/binary-search/BinarySearchTest.java
// java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/binary-search --select-class BinarySearchTest

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
  @Test
  public void testAreTwoNumbersEqual() {
    System.out.println("Hello from a test.");
    Assertions.assertEquals(42, 42);
  }
}
