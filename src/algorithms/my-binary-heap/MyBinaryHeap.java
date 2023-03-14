import java.util.HashMap;

class MyBinaryHeapNode {
  public int value;
  public MyBinaryHeapNode parentNode;
  public MyBinaryHeapNode leftChildNode;
  public MyBinaryHeapNode rightChildNode;

  public MyBinaryHeapNode(
    int value,
    MyBinaryHeapNode parentNode,
    MyBinaryHeapNode leftChildNode,
    MyBinaryHeapNode rightChildNode
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

class MyBinaryHeap {
  private MyBinaryHeapNode rootNode;

  public MyBinaryHeap() {
    this.rootNode = null;
  }

  public void add(int value) {
    if (this.rootNode == null) {
      this.rootNode = new MyBinaryHeapNode(value, null, null, null);
      return;
    }

    this.add(value, this.rootNode);
  }

  public void add(int value, MyBinaryHeapNode nodeToInsertAt) {
    if (value < nodeToInsertAt.value && nodeToInsertAt.leftChildNode == null) {
      MyBinaryHeapNode newNode = new MyBinaryHeapNode(value, nodeToInsertAt, null, null);
      nodeToInsertAt.leftChildNode = newNode;
      return;
    }
    if (value > nodeToInsertAt.value && nodeToInsertAt.rightChildNode == null) {
      MyBinaryHeapNode newNode = new MyBinaryHeapNode(value, nodeToInsertAt, null, null);
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

  public MyBinaryHeapNode find(int value) {
    return this.find(value, this.rootNode);
  }

  public MyBinaryHeapNode find(int value, MyBinaryHeapNode nodeToFindAt) {
    if (nodeToFindAt       == null ) return null;
    if (nodeToFindAt.value == value) return nodeToFindAt;
    if (nodeToFindAt.value < value ) return this.find(value, nodeToFindAt.rightChildNode);
    if (nodeToFindAt.value > value ) return this.find(value, nodeToFindAt.leftChildNode);
    return null;
  }

  public void delete(int value) {
    MyBinaryHeapNode nodeToDelete = this.find(value);
    if (nodeToDelete == null) return;

    if (nodeToDelete.isLeaf() && nodeToDelete.isRoot()) {
      this.rootNode = null;
      return;
    }

    if (nodeToDelete.isLeaf() && !nodeToDelete.isRoot()) {
      MyBinaryHeapNode parentOfNodeToDelete = nodeToDelete.parentNode;
      nodeToDelete.parentNode = null;
      if (nodeToDelete.value < parentOfNodeToDelete.value) {
        parentOfNodeToDelete.leftChildNode = null;
      } else {
        parentOfNodeToDelete.rightChildNode = null;
      }
      return;
    }

    MyBinaryHeapNode nodeToReplaceWith;

    if (nodeToDelete.leftChildNode != null) {
      nodeToReplaceWith = nodeToDelete.leftChildNode;
      while (nodeToReplaceWith.rightChildNode != null) {
        nodeToReplaceWith = nodeToReplaceWith.rightChildNode;
      }
      int valueToPutInDeletedNode = nodeToReplaceWith.value;
      this.delete(nodeToReplaceWith.value);
      nodeToDelete.value = valueToPutInDeletedNode;
      return;
    }
    if (nodeToDelete.rightChildNode != null) {
      nodeToReplaceWith = nodeToDelete.rightChildNode;
      while (nodeToReplaceWith.leftChildNode != null) {
        nodeToReplaceWith = nodeToReplaceWith.leftChildNode;
      }
      int valueToPutInDeletedNode = nodeToReplaceWith.value;
      this.delete(nodeToReplaceWith.value);
      nodeToDelete.value = valueToPutInDeletedNode;
      return;
    }
  }

  public String visualize() {
    HashMap<Integer, MyBinaryHeapNode[]> nodesByDepth = new HashMap<Integer, MyBinaryHeapNode[]>();

    int depth = 0;
    while (true) {
      int nodesAmountAtCurrentDepth = (int)Math.pow(2, depth);
      MyBinaryHeapNode[] nodesAtCurrentDepth = new MyBinaryHeapNode[nodesAmountAtCurrentDepth];
      
      if (depth == 0) {
        nodesAtCurrentDepth[0] = this.rootNode;
        nodesByDepth.put(depth, nodesAtCurrentDepth);
        if (this.rootNode == null ) break;
        if (this.rootNode.isLeaf()) break;
        depth++;
        continue;
      }
      
      boolean areAllNodesAtCurrentDepthLeafs = true;
      MyBinaryHeapNode[] nodesAtPreviousDepth = nodesByDepth.get(depth - 1);
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
        MyBinaryHeapNode node = nodesByDepth.get(depth)[index];
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
