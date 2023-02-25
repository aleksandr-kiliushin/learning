/**
 * MyArray has methods for getting, setting, adding and deleting elements.
 * An attempt to access an index outside of current size throws an exception.
 * When array length is about to exceed, allocate two times more memory.
 **/

class MyArray {
  private int size;
  private int length;

  public MyArray(int initialSize) {
    if (initialSize < 0) {
      throw new RuntimeException("Array initial size cannot be negative.");
    }
    this.size = initialSize;
    this.length = 0;
  }

  public int getSize() {
    return this.size;
  }

  public int getLength() {
    return this.length;
  }
}
