// How to run the example:
// javac ./src/algorithms/SelectionSort.java && java --class-path ./src/algorithms SelectionSort && rm ./src/**/*.class

import java.util.Arrays;

class Sorter {
  public static int[] sortByAsc(int[] elements) {
    int[] sortedArray = new int[elements.length];
    for (int sortedArrayIndex = 0; sortedArrayIndex < elements.length; sortedArrayIndex++) {
      int initialArrayLowestValueIndex = 0;
      for (int initialArrayIndex = 0; initialArrayIndex < elements.length; initialArrayIndex++) {
        if (elements[initialArrayIndex] < elements[initialArrayLowestValueIndex]) {
          initialArrayLowestValueIndex = initialArrayIndex;
        }
      }
      sortedArray[sortedArrayIndex] = elements[initialArrayLowestValueIndex];
      elements[initialArrayLowestValueIndex] = 100500;
    }
    return sortedArray;
  }
}

class SelectionSort {
  public static void main(String[] args) {
    int[] elements = { 6, 2, 10, 8, 5, 1, 3, 9, 4, 7 };
    int[] sortedElements = Sorter.sortByAsc(elements);
    System.out.println(Arrays.toString(sortedElements));
  }
}
