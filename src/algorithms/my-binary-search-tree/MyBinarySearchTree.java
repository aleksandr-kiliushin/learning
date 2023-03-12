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
    return String.valueOf(this.rootNode.value);
  }
}
