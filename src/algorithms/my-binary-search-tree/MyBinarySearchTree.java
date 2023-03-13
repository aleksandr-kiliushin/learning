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

  public boolean isLeaf() {
    return this.leftChildNode == null && this.rightChildNode == null;
  }

  public boolean isRoot() {
    return this.parentNode == null;
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

  public MyBinarySearchTreeNode find(int value, MyBinarySearchTreeNode nodeToFindAt) {
    if (nodeToFindAt       == null ) return null;
    if (nodeToFindAt.value == value) return nodeToFindAt;
    if (nodeToFindAt.value < value ) return this.find(value, nodeToFindAt.rightChildNode);
    if (nodeToFindAt.value > value ) return this.find(value, nodeToFindAt.leftChildNode);
    return null;
  }

  public void delete(int value) {
    MyBinarySearchTreeNode nodeToDelete = this.find(value);
    if (nodeToDelete == null) return;

    if (nodeToDelete.isLeaf() && nodeToDelete.isRoot()) {
      this.rootNode = null;
      return;
    }

    if (nodeToDelete.isLeaf() && !nodeToDelete.isRoot()) {
      MyBinarySearchTreeNode parentOfNodeToDelete = nodeToDelete.parentNode;
      nodeToDelete.parentNode = null;
      if (nodeToDelete.value < parentOfNodeToDelete.value) {
        parentOfNodeToDelete.leftChildNode = null;
      } else {
        parentOfNodeToDelete.rightChildNode = null;
      }
      return;
    }

    MyBinarySearchTreeNode nodeToReplaceWith;

    if (nodeToDelete.leftChildNode != null) {
      nodeToReplaceWith = nodeToDelete.leftChildNode;
      while (nodeToReplaceWith.rightChildNode != null) {
        nodeToReplaceWith = nodeToReplaceWith.rightChildNode;
      }
      nodeToDelete.value = nodeToReplaceWith.value;
      if (nodeToReplaceWith.isLeaf()) {
        nodeToReplaceWith.parentNode.rightChildNode = null;
        nodeToReplaceWith.parentNode = null;
      } else {
        throw new RuntimeException("Deletion with nodes shift up is not implemented.");
      }
      return;
    }
    if (nodeToDelete.rightChildNode != null) {
      nodeToReplaceWith = nodeToDelete.rightChildNode;
      while (nodeToReplaceWith.leftChildNode != null) {
        nodeToReplaceWith = nodeToReplaceWith.leftChildNode;
      }
      nodeToDelete.value = nodeToReplaceWith.value;
      if (nodeToReplaceWith.isLeaf()) {
        nodeToReplaceWith.parentNode.leftChildNode = null;
        nodeToReplaceWith.parentNode = null;
      } else {
        throw new RuntimeException("Deletion with nodes shift up is not implemented.");
      }
      return;
    }
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
        if (this.rootNode == null ) break;
        if (this.rootNode.isLeaf()) break;
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
