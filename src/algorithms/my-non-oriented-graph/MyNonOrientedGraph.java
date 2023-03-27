import java.util.HashMap;
import java.util.Map;

class MyNonOrientedGraph {
  public HashMap<String, HashMap<String, Integer>> matrix;

  public MyNonOrientedGraph() {
    this.matrix = new HashMap<String, HashMap<String, Integer>>();
  }

  public void addVertex(String newVertexName) {
    for (Map.Entry<String, HashMap<String, Integer>> vector : this.matrix.entrySet()) {
      vector.getValue().put(newVertexName, 0);
    }

    HashMap<String, Integer> newVector = new HashMap<String, Integer>();
    for (Map.Entry<String, HashMap<String, Integer>> vector : this.matrix.entrySet()) {
      newVector.put(vector.getKey(), 0);
    }
    newVector.put(newVertexName, 0);

    this.matrix.put(newVertexName, newVector);
  }

  public void connectVertexes(String vertexAName, String vertexBName) {
    if (vertexAName == vertexBName) return;

    this.matrix.get(vertexAName).put(vertexBName, 1);
    this.matrix.get(vertexBName).put(vertexAName, 1);
  }

  public void disconnectVertexes(String vertexAName, String vertexBName) {
    if (vertexAName == vertexBName) return;

    this.matrix.get(vertexAName).put(vertexBName, 0);
    this.matrix.get(vertexBName).put(vertexAName, 0);
  }

  public String visualize() {
    String result = "x";

    for (Map.Entry<String, HashMap<String, Integer>> vector : this.matrix.entrySet()) {
      result += vector.getKey();
    }
    result += "\n";

    for (Map.Entry<String, HashMap<String, Integer>> vector : this.matrix.entrySet()) {
      result += vector.getKey();
      for (Map.Entry<String, Integer> edgeMark : vector.getValue().entrySet()) {
        if (vector.getKey() == edgeMark.getKey()) {
          result += "x";
        } else {
          result += edgeMark.getValue();
        }
      }
      result += "\n";
    }

    return result;
  }
}
