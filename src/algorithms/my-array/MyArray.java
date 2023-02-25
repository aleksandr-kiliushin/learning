/**
 * MyArray has methods for getting, setting, adding and deleting elements.
 * An attempt to access an index outside of current size throws an exception.
 * When array length is about to exceed, allocate two times more memory.
 **/

class MyArray {
  private int size;

  public MyArray(int initialSize) {
    if (initialSize < 0) {
      throw new RuntimeException("Array initial size cannot be negative.");
    }
    this.size = initialSize;
  }

  public int getSize() {
    return this.size;
  }
}
