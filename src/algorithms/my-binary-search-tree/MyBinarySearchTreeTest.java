// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-binary-search-tree/MyBinarySearchTree.java ./src/algorithms/my-binary-search-tree/MyBinarySearchTreeTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-binary-search-tree --select-class MyBinarySearchTreeTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBinarySearchTreeTest {
  @Test
  public void testIsSizeSetUpCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    Assertions.assertEquals(myLinkedList.getSize(), 0);
    Assertions.assertNull(myLinkedList.getFirstElement());
    Assertions.assertNull(myLinkedList.getLastElement());
  }

  @Test
  public void testDoesAccessingNonexistentIndexThrowAnExeption() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myLinkedList.getElementAtIndex(-42);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of list size.");
  }

  @Test
  public void testDoesItAppendElementsCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();

    Assertions.assertEquals(0, myLinkedList.getSize());

    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(3, myLinkedList.getElementAtIndex(2));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(3));

    Assertions.assertEquals(1, myLinkedList.getFirstElement());
    Assertions.assertEquals(4, myLinkedList.getLastElement());
    Assertions.assertEquals(4, myLinkedList.getSize());
  }

  @Test
  public void testDoesItPrependElementsCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();

    Assertions.assertEquals(0, myLinkedList.getSize());

    myLinkedList.prepend(1);
    myLinkedList.prepend(2);
    myLinkedList.prepend(3);
    myLinkedList.prepend(4);

    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(3, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(2));
    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(3));

    Assertions.assertEquals(4, myLinkedList.getFirstElement());
    Assertions.assertEquals(1, myLinkedList.getLastElement());
    Assertions.assertEquals(4, myLinkedList.getSize());
  }

  @Test
  public void testDoesItFindElementsByValueCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();

    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    Assertions.assertEquals(0, myLinkedList.findElementByValue(1));
    Assertions.assertEquals(1, myLinkedList.findElementByValue(2));
    Assertions.assertEquals(2, myLinkedList.findElementByValue(3));
    Assertions.assertEquals(3, myLinkedList.findElementByValue(4));
  }

  @Test
  public void testDoesInsertionAtIndexWorkCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    myLinkedList.insertElementAtIndex(2, 22);

    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(22, myLinkedList.getElementAtIndex(2));
    Assertions.assertEquals(3, myLinkedList.getElementAtIndex(3));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(4));

    Assertions.assertEquals(5, myLinkedList.getSize());
  }

  @Test
  public void testDoesRemovingByIndexWorkCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    myLinkedList.removeElementByIndex(2);
    Assertions.assertEquals(3, myLinkedList.getSize());
    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(2));

    myLinkedList.removeElementByIndex(0);
    Assertions.assertEquals(2, myLinkedList.getSize());
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(2, myLinkedList.getFirstElement());
    Assertions.assertEquals(4, myLinkedList.getLastElement());

    myLinkedList.removeElementByIndex(1);
    Assertions.assertEquals(1, myLinkedList.getSize());
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getFirstElement());
    Assertions.assertEquals(2, myLinkedList.getLastElement());
    
    myLinkedList.removeElementByIndex(0);
    Assertions.assertEquals(0, myLinkedList.getSize());
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myLinkedList.getElementAtIndex(0);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of list size.");
  }

  @Test
  public void testDoesRemovingByValueWorkCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    myLinkedList.removeElementByValue(42);
    Assertions.assertEquals(4, myLinkedList.getSize());
    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(3, myLinkedList.getElementAtIndex(2));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(3));

    myLinkedList.removeElementByValue(3);
    Assertions.assertEquals(3, myLinkedList.getSize());
    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(2));

    myLinkedList.removeElementByValue(1);
    Assertions.assertEquals(2, myLinkedList.getSize());
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(2, myLinkedList.getFirstElement());
    Assertions.assertEquals(4, myLinkedList.getLastElement());

    myLinkedList.removeElementByValue(4);
    Assertions.assertEquals(1, myLinkedList.getSize());
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getFirstElement());
    Assertions.assertEquals(2, myLinkedList.getLastElement());

    myLinkedList.removeElementByValue(2);
    Assertions.assertEquals(0, myLinkedList.getSize());
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myLinkedList.getElementAtIndex(0);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of list size.");
  }

  @Test
  public void testDoesEditingAtIndexWorkCorrectly() {
    MyBinarySearchTree myLinkedList = new MyBinarySearchTree();
    myLinkedList.append(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);

    myLinkedList.editElementAtIndex(2, 42);
    Assertions.assertEquals(4, myLinkedList.getSize());
    Assertions.assertEquals(1, myLinkedList.getElementAtIndex(0));
    Assertions.assertEquals(2, myLinkedList.getElementAtIndex(1));
    Assertions.assertEquals(42, myLinkedList.getElementAtIndex(2));
    Assertions.assertEquals(4, myLinkedList.getElementAtIndex(3));
  }
}
