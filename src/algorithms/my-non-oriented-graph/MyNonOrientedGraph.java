import java.util.HashMap;

class MyNonOrientedGraphVertex {
  public String name;

  public MyNonOrientedGraphVertex(String name) {
    this.name = name;
  }
}

class MyNonOrientedGraph {
  private HashMap<Integer, MyNonOrientedGraphVertex[]> connectionsByVertexName;

  public MyNonOrientedGraph() {
    this.connectionsByVertexName = new HashMap<Integer, MyNonOrientedGraphVertex[]>();
  }

  public String visualize() {
    return "x\n";
  }
}
