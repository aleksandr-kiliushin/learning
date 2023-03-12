import java.text.MessageFormat;

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

    if (value < this.rootNode.value) {
      this.rootNode.leftChildNode = new MyBinarySearchTreeNode(value, this.rootNode, null, null);
    }
    if (value > this.rootNode.value) {
      this.rootNode.rightChildNode = new MyBinarySearchTreeNode(value, this.rootNode, null, null);
    }
  }

  public void add(int value, MyBinarySearchTreeNode nodeToInsertBelow) {
    if (value < nodeToInsertBelow.value && nodeToInsertBelow.leftChildNode == null) {
      MyBinarySearchTreeNode newNode = new MyBinarySearchTreeNode(value, nodeToInsertBelow, null, null);
      nodeToInsertBelow.leftChildNode = newNode;
      return;
    }
    if (value > nodeToInsertBelow.value && nodeToInsertBelow.rightChildNode == null) {
      MyBinarySearchTreeNode newNode = new MyBinarySearchTreeNode(value, nodeToInsertBelow, null, null);
      nodeToInsertBelow.rightChildNode = newNode;
      return;
    }

    if (value < nodeToInsertBelow.value && nodeToInsertBelow.leftChildNode != null) {
      this.add(value, nodeToInsertBelow.leftChildNode);
      return;
    }
    if (value > nodeToInsertBelow.value && nodeToInsertBelow.rightChildNode != null) {
      this.add(value, nodeToInsertBelow.rightChildNode);
      return;
    }
  }

  public String visualize() {
    if (this.rootNode == null) {
      return "empty";
    }
    if (this.rootNode.leftChildNode == null && this.rootNode.rightChildNode == null) {
      return String.valueOf(this.rootNode.value);
    }
    if (this.rootNode.rightChildNode == null) {
      String zeroDepthNodesSubstring = MessageFormat.format("  {0}\n", this.rootNode.value);
      String fromZeroToFirstDepthConnectionSubstring = " /\n";
      String firstDepthNodesSubstring = MessageFormat.format("{0}\n", this.rootNode.leftChildNode.value);
      return zeroDepthNodesSubstring + fromZeroToFirstDepthConnectionSubstring + firstDepthNodesSubstring;
    }
    if (this.rootNode.leftChildNode == null) {
      String zeroDepthNodesSubstring = MessageFormat.format("  {0}\n", this.rootNode.value);
      String fromZeroToFirstDepthConnectionSubstring = "   \\\n";
      String firstDepthNodesSubstring = MessageFormat.format("    {0}\n", this.rootNode.rightChildNode.value);
      return zeroDepthNodesSubstring + fromZeroToFirstDepthConnectionSubstring + firstDepthNodesSubstring;
    }
    String zeroDepthNodesSubstring = MessageFormat.format("  {0}\n", this.rootNode.value);
    String fromZeroToFirstDepthConnectionSubstring = " / \\\n";
    String firstDepthNodesSubstring = MessageFormat.format("{0}   {1}\n", this.rootNode.leftChildNode.value, this.rootNode.rightChildNode.value);
    return zeroDepthNodesSubstring + fromZeroToFirstDepthConnectionSubstring + firstDepthNodesSubstring;
  }
}
