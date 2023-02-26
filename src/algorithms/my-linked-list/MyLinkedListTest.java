// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-linked-list/MyLinkedList.java ./src/algorithms/my-linked-list/MyLinkedListTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-linked-list --select-class MyLinkedListTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
  @Test
  public void testDoesNegativeInitialSizeThrowAnExeption() {
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      new MyLinkedList(-42);
    });
    Assertions.assertEquals(exception.getMessage(), "Array initial size cannot be negative.");
  }

  @Test
  public void testIsInitialStateCorrect() {
    MyLinkedList myArray = new MyLinkedList(10);
    Assertions.assertEquals(myArray.getSize(), 10);
    Assertions.assertEquals(myArray.getLength(), 0);
  }

  @Test
  public void testDoesItReadElementByIndex() {
    MyLinkedList myArray = new MyLinkedList(10);
    Assertions.assertEquals(myArray.getElementAt(0), null);
    Assertions.assertEquals(myArray.getElementAt(5), null);
    Assertions.assertEquals(myArray.getElementAt(9), null);
  }

  @Test
  public void testDoesGettingByNonexistingIndexThrowsAnException() {
    MyLinkedList myArray = new MyLinkedList(10);
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myArray.getElementAt(100500);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of array size.");
  }

  @Test
  public void testDoesItSetElementAtIndex0() {
    MyLinkedList myArray = new MyLinkedList(10);
    Assertions.assertEquals(myArray.setElementAt(0, 42), 1);
    Assertions.assertEquals(myArray.getElementAt(0), 42);
    Assertions.assertEquals(myArray.getElementAt(1), null);
  }

  @Test
  public void testDoesItSetElementAtIndex9() {
    MyLinkedList myArray = new MyLinkedList(10);
    Assertions.assertEquals(myArray.setElementAt(9, 42), 10);
    Assertions.assertEquals(myArray.getElementAt(0), null);
    Assertions.assertEquals(myArray.getElementAt(9), 42);
  }

  @Test
  public void testDoesItSetElementAtMultipleIndices() {
    MyLinkedList myArray = new MyLinkedList(10);
    Assertions.assertEquals(myArray.setElementAt(0, 42), 1);
    Assertions.assertEquals(myArray.setElementAt(9, 66), 10);
    Assertions.assertEquals(myArray.setElementAt(5, 55), 10);
  }

  @Test
  public void testDoesSettingAtNonexistingIndexThrowsAnException() {
    MyLinkedList myArray = new MyLinkedList(10);
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myArray.setElementAt(100500, 42);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of array size.");
  }

  @Test
  public void testDoesItAddElements() {
    MyLinkedList myArray = new MyLinkedList(5);
    myArray.addElement(11);
    myArray.addElement(22);
    myArray.addElement(33);
    myArray.addElement(44);
    myArray.addElement(55);
    Assertions.assertEquals(myArray.getSize(), 5);
    myArray.addElement(66);
    Assertions.assertEquals(myArray.getElementAt(5), 66);
    Assertions.assertEquals(myArray.getSize(), 10);
  }
}
