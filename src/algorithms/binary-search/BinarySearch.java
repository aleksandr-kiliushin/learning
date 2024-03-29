import java.lang.reflect.Array;

class BinarySearch {
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

    return -1;
  }
}
