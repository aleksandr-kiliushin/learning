// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-binary-heap/MyBinaryHeap.java ./src/algorithms/my-binary-heap/MyBinaryHeapTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-binary-heap --select-class MyBinaryHeapTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBinaryHeapTest {
  @Test
  public void doesItWorkCorrectly() {
    MyBinaryHeap myBinaryHeap = new MyBinaryHeap();

    Assertions.assertEquals("""
    _
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(14);
    Assertions.assertEquals("""
    14
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(13);
    Assertions.assertEquals("""
    14
    13|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(12);
    Assertions.assertEquals("""
    14
    13|12
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(2);
    Assertions.assertEquals("""
    14
    13|12
    2|_|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(1);
    Assertions.assertEquals("""
    14
    13|12
    2|1|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(3);
    Assertions.assertEquals("""
    14
    13|12
    2|1|3|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(6);
    Assertions.assertEquals("""
    14
    13|12
    2|1|3|6
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(5);
    Assertions.assertEquals("""
    14
    13|12
    5|1|3|6
    2|_|_|_|_|_|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(7);
    myBinaryHeap.add(10);
    myBinaryHeap.add(11);
    myBinaryHeap.add(9);
    Assertions.assertEquals("""
    14
    13|12
    7|11|9|6
    2|5|1|10|3|_|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.add(8);
    myBinaryHeap.add(4);
    myBinaryHeap.add(15);
    Assertions.assertEquals("""
    15
    13|14
    7|11|9|12
    2|5|1|10|3|8|4|6
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    Assertions.assertEquals("""
    14
    13|12
    7|11|9|6
    2|5|1|10|3|8|4|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    Assertions.assertEquals("""
    13
    11|12
    7|10|9|6
    2|5|1|4|3|8|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    Assertions.assertEquals("""
    12
    11|9
    7|10|8|6
    2|5|1|4|3|_|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    Assertions.assertEquals("""
    8
    7|6
    5|4|1|3
    2|_|_|_|_|_|_|_
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    Assertions.assertEquals("""
    7
    5|6
    2|4|1|3
    """, myBinaryHeap.visualize());

    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    myBinaryHeap.delete();
    Assertions.assertEquals("""
    _
    """, myBinaryHeap.visualize());
  }
}
