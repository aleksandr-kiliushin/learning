// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-binary-search-tree/MyBinarySearchTree.java ./src/algorithms/my-binary-search-tree/MyBinarySearchTreeTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-binary-search-tree --select-class MyBinarySearchTreeTest && rm ./src/**/*.class

import java.util.ArrayList;
import java.util.Arrays;

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

    myBinarySearchTree.delete(13);
    Assertions.assertEquals("""
    8
    4|12
    2|6|10|14
    1|3|5|7|9|11|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(4);
    Assertions.assertEquals("""
    8
    3|12
    2|6|10|14
    1|_|5|7|9|11|_|15
    """, myBinarySearchTree.visualize());


    myBinarySearchTree.delete(12);
    Assertions.assertEquals("""
    8
    3|11
    2|6|10|14
    1|_|5|7|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(8);
    Assertions.assertEquals("""
    7
    3|11
    2|6|10|14
    1|_|5|_|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(7);
    Assertions.assertEquals("""
    6
    3|11
    2|5|10|14
    1|_|_|_|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(6);
    Assertions.assertEquals("""
    5
    3|11
    2|_|10|14
    1|_|_|_|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(5);
    Assertions.assertEquals("""
    3
    2|11
    1|_|10|14
    _|_|_|_|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(1);
    myBinarySearchTree.delete(3);
    Assertions.assertEquals("""
    2
    _|11
    _|_|10|14
    _|_|_|_|9|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(2);
    myBinarySearchTree.delete(11);
    Assertions.assertEquals("""
    9
    _|10
    _|_|_|14
    _|_|_|_|_|_|_|15
    """, myBinarySearchTree.visualize());

    myBinarySearchTree.delete(9);
    myBinarySearchTree.delete(14);
    myBinarySearchTree.delete(15);
    myBinarySearchTree.delete(10);
    Assertions.assertEquals("""
    _
    """, myBinarySearchTree.visualize());
  }

  @Test
  public void doesGetValuesWorkCorrectly() {
    MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

    myBinarySearchTree.add(8);
    myBinarySearchTree.add(12);
    myBinarySearchTree.add(4);
    myBinarySearchTree.add(2);
    myBinarySearchTree.add(1);
    myBinarySearchTree.add(3);
    myBinarySearchTree.add(6);
    Assertions.assertEquals("""
    8
    4|12
    2|6|_|_
    1|3|_|_|_|_|_|_
    """, myBinarySearchTree.visualize());

    Assertions.assertEquals(
      new ArrayList<Integer>(Arrays.asList(8, 4, 2, 1, 3, 6, 12)),
      myBinarySearchTree.getValues()
    );

    Assertions.assertEquals(
      new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 6, 8, 12)),
      myBinarySearchTree.getValuesSorted()
    );
  }
}


// MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

// myBinarySearchTree.add(8);
// myBinarySearchTree.add(12);
// myBinarySearchTree.add(4);
// myBinarySearchTree.add(2);
// myBinarySearchTree.add(1);
// myBinarySearchTree.add(3);
// myBinarySearchTree.add(6);
// Assertions.assertEquals("""
// 8
// 4|12
// 2|6|_|_
// 1|3|_|_|_|_|_|_
// """, myBinarySearchTree.visualize());
