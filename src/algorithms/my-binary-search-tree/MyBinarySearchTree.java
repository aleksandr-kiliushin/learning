import java.util.HashMap;

class MyBinarySearchTreeNode {
  public int value;
  public MyBinarySearchTreeNode parentNode;
  public MyBinarySearchTreeNode leftChildNode;
  public MyBinarySearchTreeNode rightChildNode;

  public MyBinarySearchTreeNode(
    int value,
    MyBinarySearchTreeNode parentNode,
    MyBinarySearchTreeNode leftChildNode,
    MyBinarySearchTreeNode rightChildNode
  ) {
    this.value = value;
    this.parentNode = parentNode;
    this.leftChildNode = leftChildNode;
    this.rightChildNode = rightChildNode;
  }
}

class MyBinarySearchTree {
  private MyBinarySearchTreeNode rootNode;

  public MyBinarySearchTree() {
    this.rootNode = null;
  }

  public void add(int value) {
    if (this.rootNode == null) {
      this.rootNode = new MyBinarySearchTreeNode(value, null, null, null);
      return;
    }

    this.add(value, this.rootNode);
  }

  public void add(int value, MyBinarySearchTreeNode nodeToInsertAt) {
    if (value < nodeToInsertAt.value && nodeToInsertAt.leftChildNode == null) {
      MyBinarySearchTreeNode newNode = new MyBinarySearchTreeNode(value, nodeToInsertAt, null, null);
      nodeToInsertAt.leftChildNode = newNode;
      return;
    }
    if (value > nodeToInsertAt.value && nodeToInsertAt.rightChildNode == null) {
      MyBinarySearchTreeNode newNode = new MyBinarySearchTreeNode(value, nodeToInsertAt, null, null);
      nodeToInsertAt.rightChildNode = newNode;
      return;
    }

    if (value < nodeToInsertAt.value && nodeToInsertAt.leftChildNode != null) {
      this.add(value, nodeToInsertAt.leftChildNode);
      return;
    }
    if (value > nodeToInsertAt.value && nodeToInsertAt.rightChildNode != null) {
      this.add(value, nodeToInsertAt.rightChildNode);
      return;
    }
  }

  public MyBinarySearchTreeNode find(int value) {
    return this.find(value, this.rootNode);
  }

  public MyBinarySearchTreeNode find(int value, MyBinarySearchTreeNode nodeToSearchAt) {
    if (nodeToSearchAt       == null ) return null;
    if (nodeToSearchAt.value == value) return nodeToSearchAt;
    if (nodeToSearchAt.value < value ) return this.find(value, nodeToSearchAt.rightChildNode);
    if (nodeToSearchAt.value > value ) return this.find(value, nodeToSearchAt.leftChildNode);
    return null;
  }

  public String visualize() {
    HashMap<Integer, MyBinarySearchTreeNode[]> nodesByDepth = new HashMap<Integer, MyBinarySearchTreeNode[]>();

    int depth = 0;
    while (true) {
      int nodesAmountAtCurrentDepth = (int)Math.pow(2, depth);
      MyBinarySearchTreeNode[] nodesAtCurrentDepth = new MyBinarySearchTreeNode[nodesAmountAtCurrentDepth];
      
      if (depth == 0) {
        nodesAtCurrentDepth[0] = this.rootNode;
        nodesByDepth.put(depth, nodesAtCurrentDepth);
        if (this.rootNode == null) break;
        if (this.rootNode.leftChildNode == null && this.rootNode.rightChildNode == null) {
          break;
        }
        depth++;
        continue;
      }
      
      boolean areAllNodesAtCurrentDepthLeafs = true;
      MyBinarySearchTreeNode[] nodesAtPreviousDepth = nodesByDepth.get(depth - 1);
      for (int index = 0; index < nodesAtPreviousDepth.length; index++) {
        if (nodesAtPreviousDepth[index] == null) {
          nodesAtCurrentDepth[index * 2] = null;
          nodesAtCurrentDepth[index * 2 + 1] = null;
        } else {
          nodesAtCurrentDepth[index * 2] = nodesAtPreviousDepth[index].leftChildNode;
          nodesAtCurrentDepth[index * 2 + 1] = nodesAtPreviousDepth[index].rightChildNode;
          if (nodesAtPreviousDepth[index].leftChildNode != null || nodesAtPreviousDepth[index].rightChildNode != null) {
            areAllNodesAtCurrentDepthLeafs = false;
          }
        }
      }
      
      if (areAllNodesAtCurrentDepthLeafs) break;

      nodesByDepth.put(depth, nodesAtCurrentDepth);
      depth++;
    }

    String result = "";
    for (depth = 0; depth < nodesByDepth.size(); depth++) {
      for (int index = 0; index < nodesByDepth.get(depth).length; index++) {
        MyBinarySearchTreeNode node = nodesByDepth.get(depth)[index];
        if (node == null) {
          result += "_";
        } else {
          result += String.valueOf(node.value);
        }
        if (index != nodesByDepth.get(depth).length - 1) {
          result += "|";
        }
      }
      result += "\n";
    }

    return result;
  }
}
