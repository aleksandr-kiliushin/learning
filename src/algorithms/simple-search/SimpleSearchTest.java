// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/simple-search/SimpleSearch.java ./src/algorithms/simple-search/SimpleSearchTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/simple-search --select-class SimpleSearchTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleSearchTest {
  private int[] elements = { 7, 5, 10, 9, 2, 8, 1, 6, 4, 3 };

  @Test
  public void testDoesSimpleSearchFind7() {
    Assertions.assertEquals(SimpleSearch.find(this.elements, 7), 0);
  }

  @Test
  public void testDoesSimpleSearchFind9() {
    Assertions.assertEquals(SimpleSearch.find(this.elements, 9), 3);
  }

  @Test
  public void testDoesSimpleSearchFind3() {
    Assertions.assertEquals(SimpleSearch.find(this.elements, 3), 9);
  }

  @Test
  public void testDoesSimpleSearchFind100500() {
    Assertions.assertEquals(SimpleSearch.find(this.elements, 100500), -1);
  }
}
