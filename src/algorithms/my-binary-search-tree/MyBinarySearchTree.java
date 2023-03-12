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
  private int height;
  private MyBinarySearchTreeNode rootNode;

  public MyBinarySearchTree() {
    this.height = 0;
    this.rootNode = null;
  }

  public String visualize() {
    if (this.rootNode == null) {
      return "empty";
    }
    throw new RuntimeException("Error during visualization.");
  }
}
