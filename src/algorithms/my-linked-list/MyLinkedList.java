class MyLinkedListNode {
  public int value;
  public MyLinkedListNode previousNode;
  public MyLinkedListNode nextNode;

  public MyLinkedListNode(int value, MyLinkedListNode previousNode, MyLinkedListNode nextNode) {
    this.value = value;
    this.previousNode = previousNode;
    this.nextNode = nextNode;
  }
}

class MyLinkedList {
  private int size;
  private MyLinkedListNode headNode;
  private MyLinkedListNode tailNode;

  public MyLinkedList() {
    this.size = 0;
    this.headNode = null;
    this.tailNode = null;
  }

  private void validateIndex(int index) {
    if (index < 0 || this.size - 1 < index) {
      throw new RuntimeException("Provided index is out of list size.");
    }
  }

  public int getSize() {
    return this.size;
  }

  public Integer getFirstElement() {
    if (this.headNode == null) return null;
    return this.headNode.value;
  }

  public Integer getLastElement() {
    if (this.tailNode == null) return null;
    return this.tailNode.value;
  }

  public Integer getElementAtIndex(int index) {
    this.validateIndex(index);

    MyLinkedListNode node = this.headNode;
    if (node == null) return null;

    for (int i = 0; i < index; i++) {
      node = node.nextNode;
      if (node == null) return null;
    }

    return node.value;
  }

  public void append(int value) {
    this.size++;

    if (this.tailNode == null) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, null, null);
      this.headNode = newNode;
      this.tailNode = newNode;
      return;
    }

    if (this.headNode == this.tailNode) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, this.headNode, null);
      this.headNode.nextNode = newNode;
      this.tailNode = newNode;
      return;
    }
    
    MyLinkedListNode newNode = new MyLinkedListNode(value, this.tailNode, null);
    this.tailNode.nextNode = newNode;
    this.tailNode = newNode;
  }

  public void prepend(int value) {
    this.size++;

    if (this.headNode == null) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, null, null);
      this.headNode = newNode;
      this.tailNode = newNode;
      return;
    }

    if (this.headNode == this.tailNode) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, null, this.tailNode);
      this.tailNode.previousNode = newNode;
      this.headNode = newNode;
      return;
    }
    
    MyLinkedListNode newNode = new MyLinkedListNode(value, null, this.headNode);
    this.headNode.previousNode = newNode;
    this.headNode = newNode;
  }

  public Integer findElementByValue(int value) {
    MyLinkedListNode node = this.headNode;
    if (node == null) return null;
    if (node.value == value) return 0;
    
    for (int index = 0; index < this.size; index++) {
      if (node.value == value) return index;
      node = node.nextNode;
      if (node == null) return null;
    }

    return null;
  }

  public void insertElementAtIndex(int index, int value) {
    this.validateIndex(index);

    if (index == 0) {
      this.prepend(value);
    }

    MyLinkedListNode node = this.headNode;
    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        MyLinkedListNode newNode = new MyLinkedListNode(value, node.previousNode, node);
        node.previousNode.nextNode = newNode;
        node.previousNode = newNode;
        this.size++;
        return;
      }
      node = node.nextNode;
      if (node == null) return;
    }
  }

  public void removeElementByIndex(int index) {
    this.validateIndex(index);

    MyLinkedListNode node = this.headNode;
    if (node == null) return;

    size--;

    for (int i = 0; i < index; i++) {
      node = node.nextNode;
    }

    if (node == this.headNode && node == this.tailNode) {
      this.headNode = null;
      this.headNode = null;
      return;
    }

    if (node == this.headNode) {
      this.headNode = this.headNode.nextNode;
      node.nextNode = null;
      return;
    }
    
    if (node == this.tailNode) {
      this.tailNode = this.tailNode.previousNode;
      node.previousNode = null;
      return;
    }

    node.previousNode.nextNode = node.nextNode;
    node.nextNode.previousNode = node.previousNode;
    node.nextNode = null;
    node.previousNode = null;
  }

  public void removeElementByValue(int value) {
    MyLinkedListNode node = this.headNode;
    
    for (int index = 0; index < this.size; index++) {
      if (node == null) return;
      if (node.value == value) {
        this.removeElementByIndex(index);
      }
      node = node.nextNode;
    }
  }
}
