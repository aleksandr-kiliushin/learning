/**
 * MyArray has methods for getting, setting, adding and deleting elements.
 * An attempt to access an index outside of current size throws an exception.
 * When array length is about to exceed, allocate two times more memory.
 **/

 import java.util.HashMap;

class MyArray {
  private int size;
  private int length;
  private HashMap<Integer, Integer> memory;

  public MyArray(int initialSize) {
    if (initialSize < 0) {
      throw new RuntimeException("Array initial size cannot be negative.");
    }
    this.size = initialSize;
    this.length = 0;
    this.allocateMemory(initialSize);
  }

  private void allocateMemory (int size) {
    HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
    for (int index = 0; index < size; index++) {
      memory.put(index, null);
    }
    this.memory = memory;
  }

  private void validateIndex(int index) {
    if (index < 0 || this.size -1 < index) {
      throw new RuntimeException("Provided index is out of array size.");
    }
  }

  public int getSize() {
    return this.size;
  }

  public int getLength() {
    return this.length;
  }

  public Integer getElementAt(int index) {
    this.validateIndex(index);
    return this.memory.get(index);
  }

  public int setElementAt(int index, int value) {
    this.validateIndex(index);
    this.memory.put(index, value);
    return this.length;
  }
}
