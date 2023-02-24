// How to run the example:
// javac ./src/algorithms/SumRecursion.java && java --class-path ./src/algorithms SumRecursion && rm ./src/**/*.class

import java.util.Arrays;

class SumCalculator {
  public static int sum(int[] inputArray) {
    if (inputArray.length == 1) return inputArray[0];

    int[] newArray = new int[inputArray.length - 1];
    for (int index = 0; index < newArray.length; index++) {
      newArray[index] = inputArray[index];
    }

    return inputArray[inputArray.length - 1] + SumCalculator.sum(newArray);
  }
}

class SumRecursion {
  public static void main(String[] args) {
    int[] inputArray = { 1, 2, 3, 4, 5 };
    int result = SumCalculator.sum(inputArray);
    System.out.println(result);
  }
}
