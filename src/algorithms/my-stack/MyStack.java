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

class MyStack {
  private int size;
  private MyLinkedListNode headNode;
  private MyLinkedListNode tailNode;

  public MyStack() {
    this.size = 0;
    this.headNode = null;
    this.tailNode = null;
  }

  public Integer peek() {
    if (this.tailNode == null) {
      return null;
    }
    return this.tailNode.value;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int push(int value) {
    if (this.size == 0) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, null, null);
      this.headNode = newNode;
      this.tailNode = newNode;
    } else if (this.size == 1) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, this.headNode, null);
      this.tailNode = newNode;
      this.headNode.nextNode = newNode;
    } else {
      MyLinkedListNode newNode = new MyLinkedListNode(value, this.tailNode, null);
      this.tailNode.previousNode.nextNode = newNode;
      this.tailNode = newNode;
    }

    this.size++;
    return this.size;
  }

  public int pop() {
    if (this.size == 0) {
      throw new RuntimeException("Stack is empty, nothing to pop.");
    }

    if (this.size == 1) {
      MyLinkedListNode oldTailNode = this.tailNode;
      this.headNode = null;
      this.tailNode = null;
      this.size--;
      
      return oldTailNode.value;
    }
    
    MyLinkedListNode oldTailNode = this.tailNode;
    MyLinkedListNode newTailNode = this.tailNode.previousNode;
    oldTailNode.previousNode = null;
    newTailNode.nextNode = null;
    this.tailNode = newTailNode;
    this.size--;

    return oldTailNode.value;
  }
}