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
  public int size;
  public MyLinkedListNode headNode;
  public MyLinkedListNode tailNode;

  public MyLinkedList(int initialSize) {
    this.size = initialSize;
    this.headNode = null;
    this.tailNode = null;
  }
}
