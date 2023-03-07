class QuickSort {
  public static int partition(int[] elements, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return startIndex;
    }

    int i = startIndex - 1;
    int j = startIndex;

    while (j < endIndex) {
      if (elements[j] >= elements[endIndex]) {
        j++;
        continue;
      }

      i++;
      int elementAtIndexI = elements[i];
      int elementAtIndexJ = elements[j];
      elements[i] = elementAtIndexJ;
      elements[j] = elementAtIndexI;
      j++;
    }

    i++;

    int elementAtIndexI = elements[i];
    int elementAtEndIndex = elements[endIndex];
    elements[i] = elementAtEndIndex;
    elements[endIndex] = elementAtIndexI;

    QuickSort.partition(elements, startIndex, i - 1);
    QuickSort.partition(elements, i + 1, endIndex);

    return i;
  }

  public static int[] sort(int[] elements) {
    QuickSort.partition(elements, 0, elements.length - 1);
    return elements;
  }
}
