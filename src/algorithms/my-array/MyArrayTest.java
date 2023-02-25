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
}
