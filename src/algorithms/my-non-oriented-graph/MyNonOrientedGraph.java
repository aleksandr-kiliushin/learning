import java.util.ArrayList;
import java.util.List;

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

  public void connectVertexes(String vertexAName, String vertexBName) {
    if (vertexAName == vertexBName) return;

    for (int vertexAIndex = 0; vertexAIndex < this.vertexesNames.size(); vertexAIndex++) {
      for (int vertexBIndex = 0; vertexBIndex < this.vertexesNames.size(); vertexBIndex++) {
        if (this.vertexesNames.get(vertexAIndex) != vertexAName) continue;
        if (this.vertexesNames.get(vertexBIndex) != vertexBName) continue;

        this.edgesByVertexName.get(vertexAIndex).set(vertexBIndex, 1);
        this.edgesByVertexName.get(vertexBIndex).set(vertexAIndex, 1);
      }
    }
  }

  public void disconnectVertexes(String vertexAName, String vertexBName) {
    if (vertexAName == vertexBName) return;

    for (int vertexAIndex = 0; vertexAIndex < this.vertexesNames.size(); vertexAIndex++) {
      for (int vertexBIndex = 0; vertexBIndex < this.vertexesNames.size(); vertexBIndex++) {
        if (this.vertexesNames.get(vertexAIndex) != vertexAName) continue;
        if (this.vertexesNames.get(vertexBIndex) != vertexBName) continue;

        this.edgesByVertexName.get(vertexAIndex).set(vertexBIndex, 0);
        this.edgesByVertexName.get(vertexBIndex).set(vertexAIndex, 0);
      }
    }
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
          result += this.edgesByVertexName.get(vertexIndex).get(connectedVertexIndex);
        }
      }
      result += "\n";
    }
    return result;
  }
}
