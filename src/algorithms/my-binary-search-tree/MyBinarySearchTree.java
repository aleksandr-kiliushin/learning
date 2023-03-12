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

    MyBinarySearchTreeNode newNode = new MyBinarySearchTreeNode(value, this.rootNode, null, null);

    if (value < this.rootNode.value) {
      this.rootNode.leftChildNode = newNode;
    }
    if (value > this.rootNode.value) {
      this.rootNode.rightChildNode = newNode;
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
