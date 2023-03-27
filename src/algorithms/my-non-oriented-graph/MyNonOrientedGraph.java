import java.util.HashMap;
import java.util.List;

class MyNonOrientedGraphVertex {
  public String name;

  public MyNonOrientedGraphVertex(String name) {
    this.name = name;
  }
}

class MyNonOrientedGraph {
  private HashMap<String, List<MyNonOrientedGraphVertex>> edgesByVertexName;

  public MyNonOrientedGraph() {
    this.edgesByVertexName = new HashMap<String, List<MyNonOrientedGraphVertex>>();
  }

  public String visualize() {
    return "x\n";
  }
}
