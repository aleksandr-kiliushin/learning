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

class MyQueue {
  private int size;
  private MyLinkedListNode headNode;
  private MyLinkedListNode tailNode;

  public MyQueue() {
    this.size = 0;
    this.headNode = null;
    this.tailNode = null;
  }

  public Integer peek() {
    if (this.headNode == null) {
      return null;
    }
    return this.headNode.value;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int enqueue(int value) {
    if (this.size == 0) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, null, null);
      this.headNode = newNode;
      this.tailNode = newNode;
    } else if (this.size == 1) {
      MyLinkedListNode newNode = new MyLinkedListNode(value, this.headNode, null);
      this.headNode.nextNode = newNode;
      this.tailNode = newNode;
    } else {
      MyLinkedListNode newNode = new MyLinkedListNode(value, this.tailNode, null);
      this.tailNode.nextNode = newNode;
      this.tailNode = newNode;
    }

    this.size++;
    return this.size;
  }

  public int dequeue() {
    if (this.size == 0) {
      throw new RuntimeException("Cannot dequeue from an empty queue.");
    }

    if (this.size == 1) {
      MyLinkedListNode oldHeadNode = this.headNode;
      this.headNode = null;
      this.tailNode = null;
      this.size--;
      return oldHeadNode.value;
    }

    MyLinkedListNode oldHeadNode = this.headNode;
    MyLinkedListNode newHeadNode = this.headNode.nextNode;
    oldHeadNode.nextNode = null;
    newHeadNode.previousNode = null;
    this.headNode = newHeadNode;
    this.size--;
    return oldHeadNode.value;
  }
}
