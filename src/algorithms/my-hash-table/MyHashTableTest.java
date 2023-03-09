// To run this test:
// javac -cp ./lib/junit-platform-console-standalone-1.7.0-all.jar ./src/algorithms/my-hash-table/MyHashTable.java ./src/algorithms/my-hash-table/MyHashTableTest.java && java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp ./src/algorithms/my-hash-table --select-class MyHashTableTest && rm ./src/**/*.class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashTableTest {
  @Test
  public void testDoesIsWork() {
    MyHashTable myHashTable = new MyHashTable(5);

    Assertions.assertEquals(null, myHashTable.get("Bob"));
    myHashTable.set("Bob", 200);
    Assertions.assertEquals(200, myHashTable.get("Bob"));

    Assertions.assertEquals(null, myHashTable.get("Mike"));
    myHashTable.set("Mike", 300);
    Assertions.assertEquals(300, myHashTable.get("Mike"));

    Assertions.assertEquals(null, myHashTable.get("Bill"));
    myHashTable.set("Bill", 400);
    Assertions.assertEquals(400, myHashTable.get("Bill"));
    Assertions.assertEquals(300, myHashTable.get("Mike"));

    myHashTable.remove("Bob");
    Assertions.assertEquals(null, myHashTable.get("Bob"));
    Assertions.assertEquals(300, myHashTable.get("Mike"));
    Assertions.assertEquals(400, myHashTable.get("Bill"));

    myHashTable.remove("Mike");
    Assertions.assertEquals(null, myHashTable.get("Mike"));
    Assertions.assertEquals(400, myHashTable.get("Bill"));

    myHashTable.remove("Bill");
    Assertions.assertEquals(null, myHashTable.get("Bill"));
  }
}
