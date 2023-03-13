// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-binary-search-tree/MyBinarySearchTree.java ./src/algorithms/my-binary-search-tree/MyBinarySearchTreeTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-binary-search-tree --select-class MyBinarySearchTreeTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBinarySearchTreeTest {
  @Test
  public void doesItWorkCorrectly() {
    MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

    Assertions.assertEquals("""
_
""", myBinarySearchTree.visualize());
    
    myBinarySearchTree.add(8);
    Assertions.assertEquals("""
8
""", myBinarySearchTree.visualize());

    myBinarySearchTree.add(12);
    Assertions.assertEquals("""
8
_|12
""", myBinarySearchTree.visualize());

    myBinarySearchTree.add(4);
    Assertions.assertEquals("""
8
4|12
""", myBinarySearchTree.visualize());
  
    myBinarySearchTree.add(14);
    myBinarySearchTree.add(15);
    myBinarySearchTree.add(2);
    myBinarySearchTree.add(1);
    myBinarySearchTree.add(3);
    myBinarySearchTree.add(6);
    Assertions.assertEquals("""
8
4|12
2|6|_|14
1|3|_|_|_|_|_|15
""", myBinarySearchTree.visualize());

    myBinarySearchTree.add(5);
    myBinarySearchTree.add(7);
    myBinarySearchTree.add(10);
    myBinarySearchTree.add(11);
    myBinarySearchTree.add(9);
    myBinarySearchTree.add(13);
    Assertions.assertEquals("""
8
4|12
2|6|10|14
1|3|5|7|9|11|13|15
""", myBinarySearchTree.visualize());

    Assertions.assertEquals(8,    myBinarySearchTree.find(8 ).value);
    Assertions.assertEquals(4,    myBinarySearchTree.find(4 ).value);
    Assertions.assertEquals(10,   myBinarySearchTree.find(10).value);
    Assertions.assertEquals(11,   myBinarySearchTree.find(11).value);
    Assertions.assertEquals(null, myBinarySearchTree.find(100500)  );
  }
}
