import java.util.ArrayList;
import java.util.List;

class MyNonOrientedGraphVertex {
  public String name;

  public MyNonOrientedGraphVertex(String name) {
    this.name = name;
  }
}

class MyNonOrientedGraph {
  private List<String> vertexesNames;
  private List<List<Integer>> edgesByVertexName;

  public MyNonOrientedGraph() {
    this.vertexesNames = new ArrayList<String>();
    this.edgesByVertexName = new ArrayList<List<Integer>>();
  }

  public void addVertex(String vertexName) {
    for (List<Integer> vertexEdges : this.edgesByVertexName) {
      vertexEdges.add(0);
    }

    this.vertexesNames.add(vertexName);

    List<Integer> newList = new ArrayList<Integer>();
    for (int vertexIndex = 0; vertexIndex < this.vertexesNames.size(); vertexIndex++) {
      newList.add(0);
    }
    
    this.edgesByVertexName.add(newList);
  }

  public String visualize() {
    String result = "x";
    for (String vertexName : this.vertexesNames) {
      result += vertexName;
    }
    result += "\n";
    for (int vertexIndex = 0; vertexIndex < this.vertexesNames.size(); vertexIndex++) {
      result += this.vertexesNames.get(vertexIndex);
      for (int connectedVertexIndex = 0; connectedVertexIndex < this.vertexesNames.size(); connectedVertexIndex++) {
        if (vertexIndex == connectedVertexIndex) {
          result += "x";
        } else {
          result += "0";
        }
      }
      result += "\n";
    }
    return result;
  }
}
