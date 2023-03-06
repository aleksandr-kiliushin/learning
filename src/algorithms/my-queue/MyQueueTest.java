// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-queue/MyQueue.java ./src/algorithms/my-queue/MyQueueTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-queue --select-class MyQueueTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyQueueTest {
  @Test
  public void testDoesIsWork() {
    MyQueue myQueue = new MyQueue();

    Assertions.assertTrue(myQueue.isEmpty());
    Assertions.assertNull(myQueue.peek());

    Assertions.assertEquals(1, myQueue.enqueue(1));
    Assertions.assertFalse(myQueue.isEmpty());
    Assertions.assertEquals(1, myQueue.peek());

    Assertions.assertEquals(2, myQueue.enqueue(2));
    Assertions.assertFalse(myQueue.isEmpty());
    Assertions.assertEquals(1, myQueue.peek());

    Assertions.assertEquals(3, myQueue.enqueue(3));
    Assertions.assertFalse(myQueue.isEmpty());
    Assertions.assertEquals(1, myQueue.peek());

    Assertions.assertEquals(1, myQueue.dequeue());
    Assertions.assertFalse(myQueue.isEmpty());
    Assertions.assertEquals(2, myQueue.peek());

    Assertions.assertEquals(2, myQueue.dequeue());
    Assertions.assertFalse(myQueue.isEmpty());
    Assertions.assertEquals(3, myQueue.peek());

    Assertions.assertEquals(3, myQueue.dequeue());
    Assertions.assertTrue(myQueue.isEmpty());
    Assertions.assertNull(myQueue.peek());

    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      myQueue.dequeue();
    });
    Assertions.assertEquals(exception.getMessage(), "Cannot dequeue from an empty queue.");
  }
}
