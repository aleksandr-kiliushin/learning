// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-binary-search-tree/MyBinarySearchTree.java ./src/algorithms/my-binary-search-tree/MyBinarySearchTreeTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-binary-search-tree --select-class MyBinarySearchTreeTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBinarySearchTreeTest {
  @Test
  public void doesItWorkCorrectly() {
    MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

    Assertions.assertEquals("empty", myBinarySearchTree.visualize());
  }
}
