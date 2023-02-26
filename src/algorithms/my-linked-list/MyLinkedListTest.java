// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-linked-list/MyLinkedList.java ./src/algorithms/my-linked-list/MyLinkedListTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-linked-list --select-class MyLinkedListTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
  @Test
  public void testIsSizeSetUpCorrectly() {
    MyLinkedList myLinkedList = new MyLinkedList(4);
    Assertions.assertEquals(myLinkedList.size, 4);
    Assertions.assertNull(myLinkedList.headNode);
    Assertions.assertNull(myLinkedList.tailNode);
  }
}
