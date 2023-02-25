class BubbleSort {
  public static Integer find(int[] elements, int elementToFindIndexOf) {
    for (int index = 0; index < elements.length; index++) {
      if (elements[index] == elementToFindIndexOf) {
        return index;
      }
    }

    return -1;
  }
}
