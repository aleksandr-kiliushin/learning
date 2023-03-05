// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-stack/MyStack.java ./src/algorithms/my-stack/MyStackTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-stack --select-class MyStackTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {
  @Test
  public void testDoesIsWork() {
    MyStack myStack = new MyStack();

    Assertions.assertTrue(myStack.isEmpty());
    Assertions.assertNull(myStack.peek());

    myStack.push(1);
    Assertions.assertFalse(myStack.isEmpty());
    Assertions.assertEquals(1, myStack.peek());

    myStack.push(2);
    Assertions.assertFalse(myStack.isEmpty());
    Assertions.assertEquals(2, myStack.peek());
    
    myStack.push(3);
    Assertions.assertFalse(myStack.isEmpty());
    Assertions.assertEquals(3, myStack.peek());
    
    Assertions.assertEquals(3, myStack.pop());
    Assertions.assertFalse(myStack.isEmpty());
    Assertions.assertEquals(2, myStack.peek());
    
    Assertions.assertEquals(2, myStack.pop());
    Assertions.assertFalse(myStack.isEmpty());
    Assertions.assertEquals(1, myStack.peek());
    
    Assertions.assertEquals(1, myStack.pop());
    Assertions.assertTrue(myStack.isEmpty());
    Assertions.assertNull(myStack.peek());
  }
}
