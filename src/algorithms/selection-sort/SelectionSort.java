class SelectionSort {
  public static int[] sort(int[] elements) {
    Integer[] elementsCopy = new Integer[elements.length];
    for (int index = 0; index < elements.length; index++) {
      elementsCopy[index] = elements[index];
    }

    int[] sortedElements = new int[elementsCopy.length];

    for (int i = 0; i < elementsCopy.length; i++) {
      int minValueIndex = -1;
      int minValue = Integer.MAX_VALUE;
      for (int j = 0; j < elementsCopy.length; j++) {
        if (elementsCopy[j] != null && elementsCopy[j] < minValue) {
          minValueIndex = j;
          minValue = elementsCopy[j];
        }
      }
      sortedElements[i] = minValue;
      elementsCopy[minValueIndex] = null;
    }

    return sortedElements;
  }
}
