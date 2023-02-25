class InsertionSort {
  public static int[] sort(int[] elements) {
    int sortedPartLength = 0;

    while (sortedPartLength < elements.length) {
      int firstElementAfterSortedPart = elements[sortedPartLength];

      for (int index = sortedPartLength; index > 0; index--) {
        if (elements[index - 1] > firstElementAfterSortedPart) {
          elements[index] = elements[index - 1];
          elements[index - 1] = firstElementAfterSortedPart;
        }
      }

      sortedPartLength++;
    }

    return elements;
  }
}
