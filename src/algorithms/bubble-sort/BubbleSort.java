class BubbleSort {
  public static int[] sort(int[] elements) {
    int[] elementsCopy = new int[elements.length];
    for (int index = 0; index < elements.length; index++) {
      elementsCopy[index] = elements[index];
    }

    boolean isSwapped = true;

    while (isSwapped) {
      isSwapped = false;
      for (int index = 0; index < elementsCopy.length; index++) {
        int currentIndex = index;
        int nextIndex = index + 1;

        if (nextIndex == elementsCopy.length) {
          continue;
        }

        int elementAtCurrentIndex = elementsCopy[currentIndex];
        int elementAtNextIndex = elementsCopy[nextIndex];

        if (elementAtCurrentIndex > elementAtNextIndex) {
          elementsCopy[currentIndex] = elementAtNextIndex;
          elementsCopy[nextIndex] = elementAtCurrentIndex;
          isSwapped = true;
          continue;
        }
      }
    }

    return elementsCopy;
  }
}
