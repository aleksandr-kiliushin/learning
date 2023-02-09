/**
 * How to run the example:
 * javac ./src/grokking-algorithms/01-introduction-to-algorithms/BinarySearch.java && java --class-path ./src/grokking-algorithms/01-introduction-to-algorithms BinarySearch
 */

import java.lang.reflect.Array;
import java.util.Arrays;


class NumberSearcher {
  public static Integer find(int[] elements, int elementToFindIndexOf) {
    int indexToSearchFrom = 0;
    int indexToSearchTo = elements.length - 1;

    while (indexToSearchFrom <= indexToSearchTo) {
      int middleIndex = (indexToSearchTo + indexToSearchFrom) / 2;
      int elementAtMiddleIndex = (int) Array.get(elements, middleIndex);
      if (elementAtMiddleIndex == elementToFindIndexOf) {
        return middleIndex;
      } else if (elementAtMiddleIndex < elementToFindIndexOf) {
        indexToSearchFrom = middleIndex + 1;
      } else if (elementAtMiddleIndex > elementToFindIndexOf) {
        indexToSearchTo = middleIndex - 1;
      }
    }

    return null;
  }
}

class BinarySearch {
  public static void main(String[] args) {
    int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Integer elementIndex = NumberSearcher.find(elements, 10);
    System.out.println(elementIndex);
  }
}
