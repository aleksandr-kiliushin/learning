// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-non-oriented-graph/MyNonOrientedGraph.java ./src/algorithms/my-non-oriented-graph/MyNonOrientedGraphTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-non-oriented-graph --select-class MyNonOrientedGraphTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNonOrientedGraphTest {
  @Test
  public void doesItWorkCorrectly() {
    MyNonOrientedGraph graph = new MyNonOrientedGraph();

    Assertions.assertEquals("""
    x
    """, graph.visualize());
  }
}
