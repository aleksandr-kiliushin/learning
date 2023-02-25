// To run this code:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-array/MyArray.java ./src/algorithms/my-array/MyArrayTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-array --select-class MyArrayTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyArrayTest {
  @Test
  public void testDoesNegativeInitialSizeThrowAnExeption() {
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      new MyArray(-42);
    });
    Assertions.assertEquals(exception.getMessage(), "Array initial size cannot be negative.");
  }

  @Test
  public void testIsInitialStateCorrect() {
    MyArray myArray = new MyArray(10);
    Assertions.assertEquals(myArray.getSize(), 10);
    Assertions.assertEquals(myArray.getLength(), 0);
  }

  @Test
  public void testDoesItReadElementByIndex() {
    MyArray myArray = new MyArray(10);
    Assertions.assertEquals(myArray.getElementAt(0), null);
    Assertions.assertEquals(myArray.getElementAt(5), null);
    Assertions.assertEquals(myArray.getElementAt(9), null);
  }

  @Test
  public void testDoesGettingByNonexistingIndexThrowsAnException() {
    MyArray myArray = new MyArray(10);
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myArray.getElementAt(100500);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of array size.");
  }

  @Test
  public void testDoesItSetElementAtIndex0() {
    MyArray myArray = new MyArray(10);
    Assertions.assertEquals(myArray.setElementAt(0, 42), 1);
    Assertions.assertEquals(myArray.getElementAt(0), 42);
    Assertions.assertEquals(myArray.getElementAt(1), null);
  }

  @Test
  public void testDoesItSetElementAtIndex9() {
    MyArray myArray = new MyArray(10);
    Assertions.assertEquals(myArray.setElementAt(9, 42), 10);
    Assertions.assertEquals(myArray.getElementAt(0), null);
    Assertions.assertEquals(myArray.getElementAt(9), 42);
  }

  @Test
  public void testDoesItSetElementAtMultipleIndices() {
    MyArray myArray = new MyArray(10);
    Assertions.assertEquals(myArray.setElementAt(0, 42), 1);
    Assertions.assertEquals(myArray.setElementAt(9, 66), 10);
    Assertions.assertEquals(myArray.setElementAt(5, 55), 10);
  }

  @Test
  public void testDoesSettingAtNonexistingIndexThrowsAnException() {
    MyArray myArray = new MyArray(10);
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myArray.setElementAt(100500, 42);
    });
    Assertions.assertEquals(exception.getMessage(), "Provided index is out of array size.");
  }
}
