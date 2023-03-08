class MergeSort {
  public static int[][] split(int[] elements) {
    int indexToSplitBy = elements.length / 2;

    int[] firstArray  = new int[indexToSplitBy];
    for (int index = 0; index < indexToSplitBy; index++) {
      firstArray[index] = elements[index];
    }

    int[] secondArray = new int[elements.length - indexToSplitBy];
    for (int index = 0; index < elements.length - indexToSplitBy; index++) {
      secondArray[index] = elements[indexToSplitBy + index];
    }

    if (firstArray.length > 1) {
      firstArray = MergeSort.merge(MergeSort.split(firstArray));
    }
    if (secondArray.length > 1) {
      secondArray = MergeSort.merge(MergeSort.split(secondArray));
    }

    return new int[][]{ firstArray, secondArray };
  }

  public static int[] merge(int[][] arrays) {
    int[] firstArray  = arrays[0];
    int[] secondArray = arrays[1];
    int firstArrayIndex  = 0;
    int secondArrayIndex = 0;

    int[] result = new int[firstArray.length + secondArray.length];
    while (firstArrayIndex < firstArray.length || secondArrayIndex < secondArray.length) {
      if (firstArrayIndex == firstArray.length) {
        result[firstArrayIndex + secondArrayIndex] = secondArray[secondArrayIndex];
        secondArrayIndex++;
        continue;
      }
      if (secondArrayIndex == secondArray.length) {
        result[firstArrayIndex + secondArrayIndex] = firstArray[firstArrayIndex];
        firstArrayIndex++;
        continue;
      }
      if (secondArray[secondArrayIndex] < firstArray[firstArrayIndex]) {
        result[firstArrayIndex + secondArrayIndex] = secondArray[secondArrayIndex];
        secondArrayIndex++;
        continue;
      }
      if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
        result[firstArrayIndex + secondArrayIndex] = firstArray[firstArrayIndex];
        firstArrayIndex++;
        continue;
      }
    }

    return result;
  }

  public static int[] sort(int[] elements) {
    return MergeSort.merge(MergeSort.split(elements));
  }
}
