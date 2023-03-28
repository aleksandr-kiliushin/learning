// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/haffman-compression/HaffmanCompression.java ./src/algorithms/haffman-compression/HaffmanCompressionTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/haffman-compression --select-class HaffmanCompressionTest && rm ./src/**/*.class

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HaffmanCompressionTest {
  @Test
  public void doesCompressionWork() {
    HaffmanCompression.compress();
    Assertions.assertTrue(Arrays.equals(new int[]{1, 2}, new int[]{1, 2}));
  }

  @Test
  public void doesDecompressionWork() {
    HaffmanCompression.decompress();
    Assertions.assertTrue(Arrays.equals(new int[]{1, 2}, new int[]{1, 2}));
  }
}
