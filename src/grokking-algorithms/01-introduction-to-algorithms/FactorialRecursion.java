/**
 * How to run the example:
 * javac ./src/grokking-algorithms/01-introduction-to-algorithms/FactorialRecursion.java && java --class-path ./src/grokking-algorithms/01-introduction-to-algorithms FactorialRecursion
 */


class FactorialFinder {
  public static int find(int value) {
    if (value == 1) return value;
    return value * FactorialFinder.find(value - 1);
  }
}

class FactorialRecursion {
  public static void main(String[] args) {
    int result = FactorialFinder.find(5);
    System.out.println(result);
  }
}
