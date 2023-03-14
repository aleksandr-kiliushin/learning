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
    
    myBinaryHeap.add(8);
    Assertions.assertEquals("""
8
""", myBinaryHeap.visualize());

    myBinaryHeap.add(12);
    Assertions.assertEquals("""
8
_|12
""", myBinaryHeap.visualize());

    myBinaryHeap.add(4);
    Assertions.assertEquals("""
8
4|12
""", myBinaryHeap.visualize());
  
    myBinaryHeap.add(14);
    myBinaryHeap.add(15);
    myBinaryHeap.add(2);
    myBinaryHeap.add(1);
    myBinaryHeap.add(3);
    myBinaryHeap.add(6);
    Assertions.assertEquals("""
8
4|12
2|6|_|14
1|3|_|_|_|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.add(5);
    myBinaryHeap.add(7);
    myBinaryHeap.add(10);
    myBinaryHeap.add(11);
    myBinaryHeap.add(9);
    myBinaryHeap.add(13);
    Assertions.assertEquals("""
8
4|12
2|6|10|14
1|3|5|7|9|11|13|15
""", myBinaryHeap.visualize());

    Assertions.assertEquals(8,    myBinaryHeap.find(8 ).value);
    Assertions.assertEquals(4,    myBinaryHeap.find(4 ).value);
    Assertions.assertEquals(10,   myBinaryHeap.find(10).value);
    Assertions.assertEquals(11,   myBinaryHeap.find(11).value);
    Assertions.assertEquals(null, myBinaryHeap.find(100500)  );

    myBinaryHeap.delete(13);
    Assertions.assertEquals("""
8
4|12
2|6|10|14
1|3|5|7|9|11|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(4);
    Assertions.assertEquals("""
8
3|12
2|6|10|14
1|_|5|7|9|11|_|15
""", myBinaryHeap.visualize());


    myBinaryHeap.delete(12);
    Assertions.assertEquals("""
8
3|11
2|6|10|14
1|_|5|7|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(8);
    Assertions.assertEquals("""
7
3|11
2|6|10|14
1|_|5|_|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(7);
    Assertions.assertEquals("""
6
3|11
2|5|10|14
1|_|_|_|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(6);
    Assertions.assertEquals("""
5
3|11
2|_|10|14
1|_|_|_|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(5);
    Assertions.assertEquals("""
3
2|11
1|_|10|14
_|_|_|_|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(1);
    myBinaryHeap.delete(3);
    Assertions.assertEquals("""
2
_|11
_|_|10|14
_|_|_|_|9|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(2);
    myBinaryHeap.delete(11);
    Assertions.assertEquals("""
9
_|10
_|_|_|14
_|_|_|_|_|_|_|15
""", myBinaryHeap.visualize());

    myBinaryHeap.delete(9);
    myBinaryHeap.delete(14);
    myBinaryHeap.delete(15);
    myBinaryHeap.delete(10);
Assertions.assertEquals("""
_
""", myBinaryHeap.visualize());
  }
}
