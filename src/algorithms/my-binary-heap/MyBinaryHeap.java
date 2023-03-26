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

    MyBinaryHeapNode addedNode = this.add(value, this.rootNode);
    this.bubbleUp(addedNode);
  }

  private MyBinaryHeapNode add(int value, MyBinaryHeapNode node) {
    if (node.leftChildNode == null) {
      node.leftChildNode = new MyBinaryHeapNode(value, node, null, null);
      return node.leftChildNode;
    }
    if (node.rightChildNode == null) {
      node.rightChildNode = new MyBinaryHeapNode(value, node, null, null);
      return node.rightChildNode;
    }

    int leftSubtreeDepth = this.getDistanceToFirstDescendantWithoutChildren(node.leftChildNode);
    int rightSubtreeDepth = this.getDistanceToFirstDescendantWithoutChildren(node.rightChildNode);

    if (leftSubtreeDepth == rightSubtreeDepth) {
      return this.add(value, node.leftChildNode);
    } else {
      return this.add(value, node.rightChildNode);
    }
  }

  private int getDistanceToFirstDescendantWithoutChildren(MyBinaryHeapNode node) {
    if (node.leftChildNode == null || node.rightChildNode == null) return 0;

    return 1 + Math.min(
      this.getDistanceToFirstDescendantWithoutChildren(node.leftChildNode),
      this.getDistanceToFirstDescendantWithoutChildren(node.rightChildNode)
    );
  }

  private int getDistanceToLastDescendantWithoutChildren(MyBinaryHeapNode node) {
    if (node == null) return 0;
    if (node.leftChildNode == null && node.rightChildNode == null) return 0;
    if (node.leftChildNode == null || node.rightChildNode == null) return 1;

    return 1 + Math.max(
      this.getDistanceToLastDescendantWithoutChildren(node.leftChildNode),
      this.getDistanceToLastDescendantWithoutChildren(node.rightChildNode)
    );
  }

  private void bubbleUp(MyBinaryHeapNode node) {
    if (node.isRoot()) return;
    if (node.value <= node.parentNode.value) return;

    int temp = node.value;
    node.value = node.parentNode.value;
    node.parentNode.value = temp;
    this.bubbleUp(node.parentNode);
  }

  public void delete() {
    MyBinaryHeapNode rightmostNode = this.getRightmostLeaf(this.rootNode);
    if (rightmostNode == this.rootNode) {
      this.rootNode = null;
      return;
    }
    this.rootNode.value = rightmostNode.value;
    if (rightmostNode.parentNode.rightChildNode != null && rightmostNode.parentNode.rightChildNode.value == rightmostNode.value) {
      rightmostNode.parentNode.rightChildNode = null;
    } else {
      rightmostNode.parentNode.leftChildNode = null;
    }
    rightmostNode.parentNode = null;
    this.pushNodeDown(this.rootNode);
  }

  private MyBinaryHeapNode getRightmostLeaf(MyBinaryHeapNode node) {
    if (node.isLeaf()) return node;

    int leftSubtreeDepth = this.getDistanceToLastDescendantWithoutChildren(node.leftChildNode);
    int rightSubtreeDepth = this.getDistanceToLastDescendantWithoutChildren(node.rightChildNode);

    if (leftSubtreeDepth > rightSubtreeDepth || node.rightChildNode == null) {
      return this.getRightmostLeaf(node.leftChildNode);
    } else {
      return this.getRightmostLeaf(node.rightChildNode);
    }
  }

  private void pushNodeDown(MyBinaryHeapNode node) {
    if (node.leftChildNode == null && node.rightChildNode == null) {
      return;
    }

    MyBinaryHeapNode childWithHighestValue;
    if (node.leftChildNode == null && node.rightChildNode != null) {
      childWithHighestValue = node.rightChildNode;
    } else if (node.rightChildNode == null && node.leftChildNode != null) {
      childWithHighestValue = node.leftChildNode;
    } else if (node.leftChildNode.value > node.rightChildNode.value) {
      childWithHighestValue = node.leftChildNode;
    } else {
      childWithHighestValue = node.rightChildNode;
    }

    if (childWithHighestValue.value < node.value) return;

    int temp = node.value;
    node.value = childWithHighestValue.value;
    childWithHighestValue.value = temp;
    this.pushNodeDown(childWithHighestValue);
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
